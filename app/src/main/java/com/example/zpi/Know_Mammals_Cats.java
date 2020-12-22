package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

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