package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AddAnimal extends AppCompatActivity {

    Button Cancel;
    Animation AnimPull;
    ImageView Mammals, Reptiles, Birds, Amphibians, Invertebrates;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);

        Cancel = findViewById(R.id.ButtonCancel);
        Mammals = findViewById(R.id.ImageViewMammals);
        Reptiles = findViewById(R.id.ImageViewReptiles);
        Birds = findViewById(R.id.ImageViewBirds);
        Amphibians = findViewById(R.id.ImageViewAmphibians);
        Invertebrates = findViewById(R.id.ImageViewInvertebrates);


        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Mammals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddMammals.class));
            }
        });

        Reptiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddReptiles.class));
            }
        });

        Birds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddBirds.class));
            }
        });

        Amphibians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddAmphibians.class));
            }
        });

        Invertebrates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddInvertebrates.class));
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