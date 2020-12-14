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

public class Knowledge extends AppCompatActivity {

    Button Cancel;
    Animation AnimPull;
    ImageView Mammals, Reptiles, Birds, Amphibians, Invertebrates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);

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
                startActivity(new Intent(getApplicationContext(),Knowledge_Mammals.class));
            }
        });

        Reptiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Knowledge_Reptiles.class));
            }
        });

        Birds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Knowledge_Birds.class));
            }
        });

        Amphibians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Knowledge_Amphibians.class));
            }
        });

        Invertebrates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Knowledge_Invertebrates.class));
            }
        });

        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    startActivity(new Intent(getApplicationContext(),Dashboard.class));
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