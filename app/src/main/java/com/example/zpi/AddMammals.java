package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddMammals extends AppCompatActivity {

    EditText MammalName,MammalWage,MammalDate,MammalBio;
    Spinner Mammals, MammalsRase;
    Button Add,Cancel;

    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mammals);

        MammalName = findViewById(R.id.editTextMammalName);
        MammalWage = findViewById(R.id.editTextMammalWage);
        MammalDate = findViewById(R.id.editTextMammalDate);
        MammalBio = findViewById(R.id.editTextMammalBio);
        Mammals = findViewById(R.id.spinnerChooseMammal);
        MammalsRase = findViewById(R.id.spinnerChooseMammalRase);
        Add = findViewById(R.id.ButtonMammalAdd);
        Cancel = findViewById(R.id.ButtonMammalCancel);

        fStore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        MammalsRase.setVisibility(View.GONE);

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
                    MammalsRase.setVisibility(View.VISIBLE);
                    MammalsRase.setAdapter(adapterDogs);
                }
                if(position == 2){
                    MammalsRase.setVisibility(View.VISIBLE);
                    MammalsRase.setAdapter(adapterCats);
                }
                if(position == 3){
                    MammalsRase.setVisibility(View.GONE);

                }
                if(position == 4){
                    MammalsRase.setVisibility(View.GONE);
                }
                if(position == 5){
                    MammalsRase.setVisibility(View.GONE);
                }
                if(position == 6){
                    MammalsRase.setVisibility(View.GONE);
                }
                if(position == 7){
                    MammalsRase.setVisibility(View.GONE);
                }
                if(position == 8){
                    MammalsRase.setVisibility(View.GONE);
                }
                if(position == 9){
                    MammalsRase.setVisibility(View.GONE);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

    


}