package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    final String TAG = "Dashboard";

    Button MyProfile,Knowledge,Settings,Logout;
    Animation AnimPull, AnimPush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        MyProfile = findViewById(R.id.buttonMyProfile);
        Knowledge = findViewById(R.id.buttonKnowledge);
        Settings = findViewById(R.id.buttonVet);
        Logout = findViewById(R.id.buttonLogout);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);
        AnimPush = AnimationUtils.loadAnimation(this,R.anim.push_anim);


        MyProfile.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    MyProfile.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                startActivity(new Intent(getApplicationContext(),MyProfile.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);}

                return true;
            }
        });

        Knowledge.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Knowledge.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                startActivity(new Intent(getApplicationContext(),Knowledge.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);}
                return true;
            }
        });

        Settings.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Settings.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                startActivity(new Intent(getApplicationContext(), Vet.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);}
                return true;
            }
        });

        Logout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    Logout.startAnimation(AnimPull);
                }else if(event.getAction()==MotionEvent.ACTION_UP)

                {
                String AUTO_LOGIN_PREF_NAME = getString(R.string.autoLoginPreferenceName); // nazwa preferencji / pliku gdzie skladowane beda klucz-wartosc
                SharedPreferences preferences = getSharedPreferences(AUTO_LOGIN_PREF_NAME, MODE_PRIVATE);
                preferences.edit().clear().apply(); //usuwa autologowanie po wylogowaniu sie
                Log.i(TAG, "Usunieto autologowanie");
                startActivity(new Intent(getApplicationContext(),Login.class));}
                return true;
            }
        });

    }

    boolean singleBack = false;

    @Override
    public void onBackPressed() {
        if (singleBack) {
            finishAffinity();
            return;
        }

        this.singleBack = true;
        Toast.makeText(this, "Naciśnij ponownie WSTECZ, aby wyjść", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                singleBack=false;
            }
        }, 2000);
    }

}