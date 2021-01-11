package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Know_Mammals_Dogs extends AppCompatActivity {

    Button Alaskan,Pasterski,Bernardyn,Bichon,Bulterier,ChowChow,Dalmatynczyk,Maremma,Husky,Golden,Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know__mammals__dogs);

        Alaskan = findViewById(R.id.buttonDogAlaskan);
        Pasterski = findViewById(R.id.buttonDogPasterski);
        Bernardyn = findViewById(R.id.buttonDogBernardyn);
        Bichon = findViewById(R.id.buttonDogBichon);
        Bulterier = findViewById(R.id.buttonDogBulterier);
        ChowChow = findViewById(R.id.buttonDogChowChow);
        Dalmatynczyk = findViewById(R.id.buttonDogDalmatynczyk);
        Maremma = findViewById(R.id.buttonDogMaremma);
        Husky = findViewById(R.id.buttonDogHusky);
        Golden = findViewById(R.id.buttonDogGolden);

        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Alaskan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "ALASKAN MALAMUTE");
                startActivity(intent);
            }
        });

        Pasterski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "BERNEŃSKI PIES PASTERSKI");
                startActivity(intent);
            }
        });

        Bernardyn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "BERNARDYN");
                startActivity(intent);
            }
        });

        Bichon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "BICHON FRISE");
                startActivity(intent);
            }
        });

        Bulterier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "BULTERIER");
                startActivity(intent);
            }
        });

        ChowChow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "CHOW CHOW");
                startActivity(intent);
            }
        });

        Dalmatynczyk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "DALMATYŃCZYK");
                startActivity(intent);
            }
        });

        Maremma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "OWCZAREK MAREMMA");
                startActivity(intent);
            }
        });

        Husky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "HUSKY SYBERYJSKI");
                startActivity(intent);
            }
        });

        Golden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "GOLDEN RETRIEVER");
                startActivity(intent);
            }
        });

        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    onBackPressed();
                    overridePendingTransition(R.anim.slide_in_left,
                            R.anim.slide_out_right);}
                return true;
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}