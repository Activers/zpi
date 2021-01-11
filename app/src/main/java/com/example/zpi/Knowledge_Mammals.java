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

public class Knowledge_Mammals extends AppCompatActivity {

    ImageView Dog,Cat,Rabbit,Hamster,Chinchilla,Rat,Mous,GuineaPig,Hedgehog;
    Button Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__mammals);

        Cancel = findViewById(R.id.ButtonCancel);
        Dog = findViewById(R.id.ImageViewDog);
        Cat = findViewById(R.id.ImageViewCat);
        Rabbit = findViewById(R.id.ImageViewRabbit);
        Hamster = findViewById(R.id.ImageViewHamster);
        Chinchilla = findViewById(R.id.ImageViewChinchilla);
        Rat = findViewById(R.id.ImageViewRat);
        Mous = findViewById(R.id.ImageViewMous);
        GuineaPig = findViewById(R.id.ImageViewGuineaPig);
        Hedgehog = findViewById(R.id.ImageViewHedgehog);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        Dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Know_Mammals_Dogs.class));
            }
        });

        Cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Know_Mammals_Cats.class));
            }
        });

        Rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "KRÓLIK");
                startActivity(intent);
            }
        });

        Hamster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "CHOMIK");
                startActivity(intent);
            }
        });

        Chinchilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "SZYNSZYLA");
                startActivity(intent);
            }
        });

        Rat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "SZCZUR");
                startActivity(intent);
            }
        });

        Mous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "MYSZ");
                startActivity(intent);
            }
        });

        GuineaPig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "ŚWINKA MORSKA");
                startActivity(intent);
            }
        });

        Hedgehog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Knowledge_Mammals_Profile.class);
                intent.putExtra("animalType", "JEŻ");
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