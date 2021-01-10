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

public class Knowledge_Invertebrates extends AppCompatActivity {

    ImageView Patyczak,Modliszka,Pajak;

    Button Cancel;

    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__invertebrates);

        Patyczak = findViewById(R.id.ImageViewInvertePatyczak);
        Modliszka = findViewById(R.id.ImageViewInverteModliczka);
        Pajak = findViewById(R.id.ImageViewInvertePajak);

        Cancel = findViewById(R.id.ButtonCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);


        Patyczak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_inverte_profile.class);
                intent.putExtra("animalType", "PATYCZAK");
                startActivity(intent);
            }
        });

        Modliszka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_inverte_profile.class);
                intent.putExtra("animalType", "MODLISZKA");
                startActivity(intent);
            }
        });

        Pajak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_inverte_profile.class);
                intent.putExtra("animalType", "PAJĄK");
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