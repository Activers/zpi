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