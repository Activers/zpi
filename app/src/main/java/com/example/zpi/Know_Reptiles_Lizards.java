package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Know_Reptiles_Lizards extends AppCompatActivity {

    Button Gekon,Kameleon,Legwan,Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know__reptiles__lizards);

        Gekon = findViewById(R.id.buttonLizardGekon);
        Kameleon = findViewById(R.id.buttonLizardKameleon);
        Legwan = findViewById(R.id.buttonLizardLegwan);

        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Gekon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Reptiles_Profile.class);
                intent.putExtra("animalType", "GEKON LAMPARCI");
                startActivity(intent);
            }
        });

        Kameleon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Reptiles_Profile.class);
                intent.putExtra("animalType", "KAMELEON JEMEŃSKI");
                startActivity(intent);
            }
        });

        Legwan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Reptiles_Profile.class);
                intent.putExtra("animalType", "LEGWAN ZIELONY");
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