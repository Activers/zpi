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

public class AddAmphibians extends AppCompatActivity {

    Spinner Amphibians;
    Animation AnimPull;
    Button Cancel, AmphibiansAdd;
    EditText AmphibiansName, AmphibiansWeight, AmphibiansDate, AmphibiansBio;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amphibians);

        Amphibians = findViewById(R.id.spinnerChooseAmphibian);
        AmphibiansAdd = findViewById(R.id.ButtonAmphibianAdd);
        Cancel = findViewById(R.id.ButtonAmphibianCancel);

        AmphibiansName = findViewById(R.id.editTextAmphibianName);
        AmphibiansWeight = findViewById(R.id.editTextAmphibianWage);
        AmphibiansDate = findViewById(R.id.editTextAmphibianDate);
        AmphibiansBio = findViewById(R.id.editTextAmphibianBio);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        final ArrayAdapter adapterAmphibians =  ArrayAdapter.createFromResource(this,R.array.ArrayAmphibians,R.layout.spinner_item);
        adapterAmphibians.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Amphibians.setAdapter(adapterAmphibians);


        AmphibiansAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(AmphibiansName.getText().toString())) { AmphibiansName.setError("To pole jest wymagane"); return; }
                InsertIntoDatabase();
            }
        });



        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    startActivity(new Intent(getApplicationContext(),AddAnimal.class));
                    overridePendingTransition(R.anim.slide_in_left,
                            R.anim.slide_out_right);}
                return true;
            }
        });
    }

    private void InsertIntoDatabase() {
        DocumentReference usersDocRef = fStore.collection("users").document(fAuth.getCurrentUser().getUid());

        Map<String, Object> AmphibiansData = new HashMap<>();
        AmphibiansData.put("name", AmphibiansName.getText().toString());
        AmphibiansData.put("type", Amphibians.getSelectedItem().toString());
        AmphibiansData.put("weight", AmphibiansWeight.getText().toString());
        AmphibiansData.put("date", AmphibiansDate.getText().toString());
        AmphibiansData.put("bio", AmphibiansBio.getText().toString());


        usersDocRef.update("animals", FieldValue.arrayUnion(AmphibiansData)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }

}