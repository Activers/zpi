package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddAmphibians extends AppCompatActivity {

    Spinner Amphibians;
    Animation AnimPull;
    Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amphibians);

        Amphibians = findViewById(R.id.spinnerChooseAmphibian);
        Cancel = findViewById(R.id.ButtonAmphibianCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        final ArrayAdapter adapterAmphibians =  ArrayAdapter.createFromResource(this,R.array.ArrayAmphibians,R.layout.spinner_item);
        adapterAmphibians.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Amphibians.setAdapter(adapterAmphibians);




        Cancel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Cancel.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    startActivity(new Intent(getApplicationContext(),AddAnimal.class));
                    overridePendingTransition(R.anim.slide_in_left,
                            R.anim.slide_out_right);}
                return true;
            }
        });
    }
}