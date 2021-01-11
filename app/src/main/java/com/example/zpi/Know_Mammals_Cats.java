package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Know_Mammals_Cats extends AppCompatActivity {

    Button Dachowiec,Brytyjski,Cornish,Sfinks,Bobtail,Korat,Mau,Himalajski,Tiffanie,Birmanski,Cancel;
    Animation AnimPull;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know__mammals__cats);

        Dachowiec = findViewById(R.id.buttonCatDachowiec);
        Brytyjski = findViewById(R.id.buttonCatBrytyjski);
        Cornish = findViewById(R.id.buttonCatCornish);
        Sfinks = findViewById(R.id.buttonCatSfinks);
        Bobtail = findViewById(R.id.buttonCatBobtail);
        Korat = findViewById(R.id.buttonCatKorat);
        Mau = findViewById(R.id.buttonCatMau);
        Himalajski = findViewById(R.id.buttonCatHimalajski);
        Tiffanie = findViewById(R.id.buttonCatTiffanie);
        Birmanski = findViewById(R.id.buttonCatBirmanski);

        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Dachowiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "DACHOWIEC");
                startActivity(intent);
            }
        });

        Brytyjski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "BRYTYJSKI KROTKOWŁOSY");
                startActivity(intent);
            }
        });

        Cornish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "CORNISH REX");
                startActivity(intent);
            }
        });

        Sfinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "DOŃSKI SFINKS");
                startActivity(intent);
            }
        });

        Bobtail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "JAPOŃSKI BOBTAIL");
                startActivity(intent);
            }
        });

        Korat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "KORAT");
                startActivity(intent);
            }
        });

        Mau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "EGIPSKI MAU");
                startActivity(intent);
            }
        });

        Himalajski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "HIMALAJSKI");
                startActivity(intent);
            }
        });

        Tiffanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "TIFFANIE");
                startActivity(intent);
            }
        });

        Birmanski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "ŚWIĘTY BIRMAŃSKI");
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