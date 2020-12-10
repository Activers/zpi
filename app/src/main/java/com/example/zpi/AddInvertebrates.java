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

public class AddInvertebrates extends AppCompatActivity {

    Spinner Invertebrates;
    Button Cancel, InvertebratesAdd;
    Animation AnimPull;
    EditText InvertebratesName, InvertebratesWeight, InvertebratesDate, InvertebratesBio;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invertebrates);

        Invertebrates = findViewById(R.id.spinnerChooseInverte);
        Cancel = findViewById(R.id.ButtonInverteCancel);
        InvertebratesAdd = findViewById(R.id.ButtonInverteAdd);

        InvertebratesName = findViewById(R.id.editTextInverteName);
        InvertebratesWeight = findViewById(R.id.editTextInverteWage);
        InvertebratesDate = findViewById(R.id.editTextInverteDate);
        InvertebratesBio = findViewById(R.id.editTextInverteBio);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        final ArrayAdapter adapterInverte =  ArrayAdapter.createFromResource(this,R.array.ArrayInvertebrates,R.layout.spinner_item);
        adapterInverte.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Invertebrates.setAdapter(adapterInverte);


        InvertebratesAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(InvertebratesName.getText().toString())) { InvertebratesName.setError("To pole jest wymagane"); return; }
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

        Map<String, Object> InvertebrateData = new HashMap<>();
        InvertebrateData.put("name", InvertebratesName.getText().toString());
        InvertebrateData.put("type", Invertebrates.getSelectedItem().toString());
        InvertebrateData.put("weight", InvertebratesWeight.getText().toString());
        InvertebrateData.put("date", InvertebratesDate.getText().toString());
        InvertebrateData.put("bio", InvertebratesBio.getText().toString());


        usersDocRef.update("animals", FieldValue.arrayUnion(InvertebrateData)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }

}