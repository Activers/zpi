package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Know_Reptiles_Snakes extends AppCompatActivity {

    Button Anakonda,Boa,Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know__reptiles__snakes);

        Anakonda = findViewById(R.id.buttonSnakeAnakonda);
        Boa = findViewById(R.id.buttonSnakeBoa);
        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Anakonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Reptiles_Profile.class);
                intent.putExtra("animalType", "ANAKONDA");
                startActivity(intent);
            }
        });

        Boa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Reptiles_Profile.class);
                intent.putExtra("animalType", "WĄŻ BOA");
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