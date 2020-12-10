package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddBirds extends AppCompatActivity {

    Spinner Birds;
    Button Cancel, BirdsAdd;
    Animation AnimPull;
    EditText BirdsName, BirdsWeight, BirdsDate, BirdsBio;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_birds);

        Birds = findViewById(R.id.spinnerChooseBird);
        Cancel = findViewById(R.id.ButtonBirdCancel);
        BirdsAdd = findViewById(R.id.ButtonBirdAdd);

        BirdsName = findViewById(R.id.editTextBirdName);
        BirdsWeight = findViewById(R.id.editTextBirdWage);
        BirdsDate = findViewById(R.id.editTextBirdDate);
        BirdsBio = findViewById(R.id.editTextBirdBio);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);


        final ArrayAdapter adapterBirds =  ArrayAdapter.createFromResource(this,R.array.ArrayBirds,R.layout.spinner_item);
        adapterBirds.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Birds.setAdapter(adapterBirds);

        BirdsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(BirdsName.getText().toString())) { BirdsName.setError("To pole jest wymagane"); return; }
                InsertIntoDatabase();
            }
        });

        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    startActivity(new Intent(getApplicationContext(),MyProfile.class));
                    overridePendingTransition(R.anim.slide_in_left,
                            R.anim.slide_out_right);}
                return true;
            }
        });
    }

    private void InsertIntoDatabase() {
        DocumentReference usersDocRef = fStore.collection("users").document(fAuth.getCurrentUser().getUid());

        Map<String, Object> BirdData = new HashMap<>();
        BirdData.put("name", BirdsName.getText().toString());
        BirdData.put("type", Birds.getSelectedItem().toString());
        BirdData.put("weight", BirdsWeight.getText().toString());
        BirdData.put("date", BirdsDate.getText().toString());
        BirdData.put("bio", BirdsBio.getText().toString());


        usersDocRef.update("animals", FieldValue.arrayUnion(BirdData)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }

}