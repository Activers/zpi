package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.firestore.WriteBatch;

import java.util.HashMap;
import java.util.Map;

public class AddMammals extends AppCompatActivity {

    EditText MammalName,MammalWeight,MammalDate,MammalBio;
    Spinner Mammals, MammalsBreed;
    Button MammalsAdd,Cancel;

    Boolean BreedBool = false;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mammals);

        MammalName = findViewById(R.id.editTextMammalName);
        MammalWeight = findViewById(R.id.editTextMammalWage);
        MammalDate = findViewById(R.id.editTextMammalDate);
        MammalBio = findViewById(R.id.editTextMammalBio);
        Mammals = findViewById(R.id.spinnerChooseMammal);
        MammalsBreed = findViewById(R.id.spinnerChooseMammalRase);
        MammalsAdd = findViewById(R.id.ButtonMammalAdd);
        Cancel = findViewById(R.id.ButtonMammalCancel);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        MammalsBreed.setVisibility(View.GONE);

        final ArrayAdapter adapterMammals =  ArrayAdapter.createFromResource(this,R.array.ArrayMammals,R.layout.spinner_item);
        adapterMammals.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Mammals.setAdapter(adapterMammals);

        final ArrayAdapter adapterDogs =  ArrayAdapter.createFromResource(this,R.array.ArrayDogs,R.layout.spinner_item);
        adapterDogs.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final ArrayAdapter adapterCats =  ArrayAdapter.createFromResource(this,R.array.ArrayCats,R.layout.spinner_item);
        adapterCats.setDropDownViewResource(R.layout.spinner_dropdown_item);





        Mammals.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    MammalsBreed.setVisibility(View.VISIBLE);
                    MammalsBreed.setAdapter(adapterDogs);
                    BreedBool = true;
                }
                if(position == 2){
                    MammalsBreed.setVisibility(View.VISIBLE);
                    MammalsBreed.setAdapter(adapterCats);
                    BreedBool = true;
                }
                if(position == 3){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 4){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 5){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 6){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 7){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 8){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }
                if(position == 9){
                    MammalsBreed.setVisibility(View.GONE);
                    BreedBool = false;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        MammalsAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(MammalName.getText().toString())) { MammalName.setError("To pole jest wymagane"); return; }
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

        Map<String, Object> mammalsData = new HashMap<>();
        mammalsData.put("name", MammalName.getText().toString());
        mammalsData.put("type", Mammals.getSelectedItem().toString());
        if (BreedBool) {
            mammalsData.put("breed", MammalsBreed.getSelectedItem().toString());
        }
        mammalsData.put("weight", MammalWeight.getText().toString());
        mammalsData.put("date", MammalDate.getText().toString());
        mammalsData.put("bio", MammalBio.getText().toString());


        usersDocRef.update("animals", FieldValue.arrayUnion(mammalsData)).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(getApplicationContext(), MyProfile.class));
            }
        });
    }


}