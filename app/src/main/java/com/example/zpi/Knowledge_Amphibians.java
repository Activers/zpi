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

public class Knowledge_Amphibians extends AppCompatActivity {

    ImageView Aksolotl;

    Button Cancel;

    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__amphibians);

        Aksolotl = findViewById(R.id.ImageViewAmphibiansAksolot);

        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Aksolotl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Knowledge_Amphibians_Profile.class));
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