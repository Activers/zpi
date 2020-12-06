package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddReptiles extends AppCompatActivity {

    Spinner Reptiles,ReptilesRase;
    Animation AnimPull;
    Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reptiles);

        Reptiles = findViewById(R.id.spinnerChooseReptile);
        ReptilesRase = findViewById(R.id.spinnerChooseReptileRase);
        Cancel = findViewById(R.id.ButtonReptileCancel);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);

        ReptilesRase.setVisibility(View.GONE);

        final ArrayAdapter adapterReptiles =  ArrayAdapter.createFromResource(this,R.array.ArrayReptiles,R.layout.spinner_item);
        adapterReptiles.setDropDownViewResource(R.layout.spinner_dropdown_item);
        Reptiles.setAdapter(adapterReptiles);

        final ArrayAdapter adapterSnakes =  ArrayAdapter.createFromResource(this,R.array.ArraySnakes,R.layout.spinner_item);
        adapterSnakes.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final ArrayAdapter adapterTurtles =  ArrayAdapter.createFromResource(this,R.array.ArrayTurtles,R.layout.spinner_item);
        adapterTurtles.setDropDownViewResource(R.layout.spinner_dropdown_item);

        final ArrayAdapter adapterLizards =  ArrayAdapter.createFromResource(this,R.array.ArrayLizards,R.layout.spinner_item);
        adapterLizards.setDropDownViewResource(R.layout.spinner_dropdown_item);

        Reptiles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    ReptilesRase.setVisibility(View.VISIBLE);
                    ReptilesRase.setAdapter(adapterSnakes);
                }
                if(position == 2){
                    ReptilesRase.setVisibility(View.VISIBLE);
                    ReptilesRase.setAdapter(adapterTurtles);
                }
                if(position == 3){
                    ReptilesRase.setVisibility(View.VISIBLE);
                    ReptilesRase.setAdapter(adapterLizards);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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