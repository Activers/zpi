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
import android.widget.AdapterView;
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

public class AddReptiles extends AppCompatActivity {

    Spinner Reptiles,ReptilesBreed;
    Animation AnimPull;
    Button Cancel, ReptilesAdd;
    EditText ReptilesName, ReptilesWeight, ReptilesDate, ReptilesBio;

    Boolean BreedBool = false;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reptiles);

        ReptilesName = findViewById(R.id.editTextReptileName);
        ReptilesWeight = findViewById(R.id.editTextReptileWage);
        ReptilesDate = findViewById(R.id.editTextReptileDate);
        ReptilesBio = findViewById(R.id.editTextReptileBio);

        Reptiles = findViewById(R.id.spinnerChooseReptile);
        ReptilesBreed = findViewById(R.id.spinnerChooseReptileRase);
        Cancel = findViewById(R.id.ButtonReptileCancel);
        ReptilesAdd = findViewById(R.id.ButtonReptileAdd);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        ReptilesBreed.setVisibility(View.GONE);

        final ArrayAdapter adapterReptiles =  ArrayAdapter.createFromResource(this,R.array.ArrayReptiles,R.layout.spinner_item);
        adapterReptiles.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Reptiles.setAdapter(adapterReptiles);

        final ArrayAdapter adapterSnakes =  ArrayAdapter.createFromResource(this,R.array.ArraySnakes,R.layout.spinner_item);
        adapterSnakes.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final ArrayAdapter adapterTurtles =  ArrayAdapter.createFromResource(this,R.array.ArrayTurtles,R.layout.spinner_item);
        adapterTurtles.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final ArrayAdapter adapterLizards =  ArrayAdapter.createFromResource(this,R.array.ArrayLizards,R.layout.spinner_item);
        adapterLizards.setDropDownViewResource(R.layout.spinner_dropdown_item);

        Reptiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    ReptilesBreed.setVisibility(View.VISIBLE);
                    ReptilesBreed.setAdapter(adapterSnakes);
                    BreedBool = true;
                }
                if(position == 2){
                    ReptilesBreed.setVisibility(View.VISIBLE);
                    ReptilesBreed.setAdapter(adapterTurtles);
                    BreedBool = true;
                }
                if(position == 3){
                    ReptilesBreed.setVisibility(View.VISIBLE);
                    ReptilesBreed.setAdapter(adapterLizards);
                    BreedBool = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ReptilesAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(ReptilesName.getText().toString())) { ReptilesName.setError("To pole jest wymagane"); return; }
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

        Map<String, Object> reptilesData = new HashMap<>();
        reptilesData.put("name", ReptilesName.getText().toString());
        reptilesData.put("type", Reptiles.getSelectedItem().toString());
        if (BreedBool) {
            reptilesData.put("breed", ReptilesBreed.getSelectedItem().toString());
        }
        reptilesData.put("weight", ReptilesWeight.getText().toString());
        reptilesData.put("date", ReptilesDate.getText().toString());
        reptilesData.put("bio", ReptilesBio.getText().toString());


        usersDocRef.update("animals", FieldValue.arrayUnion(reptilesData)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }



}