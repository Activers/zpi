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

public class AddBirds extends AppCompatActivity {

    Spinner Birds;
    Button Cancel;
    Animation AnimPull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_birds);

        Birds = findViewById(R.id.spinnerChooseBird);
        Cancel = findViewById(R.id.ButtonBirdCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);


        final ArrayAdapter adapterBirds =  ArrayAdapter.createFromResource(this,R.array.ArrayBirds,R.layout.spinner_item);
        adapterBirds.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Birds.setAdapter(adapterBirds);


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