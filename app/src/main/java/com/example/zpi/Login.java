package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    final String TAG = "Login";

    EditText Email;
    EditText Password;
    Button Login;
    ProgressBar Progress;
    Button GoRegister;
    TextView Forgot;
    CheckBox RememberMe;
    SharedPreferences preferences;
    Intent intent;

    Animation AnimPull, AnimPush;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
        Login = findViewById(R.id.buttonLogin);
        Progress = findViewById(R.id.progressBar);
        GoRegister = findViewById(R.id.buttonGoRegister);
        Forgot = findViewById(R.id.textViewForgot);
        RememberMe = findViewById(R.id.checkBoxRememberMe);

        AnimPull = AnimationUtils.loadAnimation(this,R.anim.pull_anim);
        AnimPush = AnimationUtils.loadAnimation(this,R.anim.push_anim);

        String AUTO_LOGIN_PREF_NAME = getString(R.string.autoLoginPreferenceName); // nazwa preferencji / pliku gdzie skladowane beda klucz-wartosc
        preferences = getSharedPreferences(AUTO_LOGIN_PREF_NAME, MODE_PRIVATE);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                final String password = Password.getText().toString().trim();
                final String TAG = "Login";



                if (TextUtils.isEmpty(email)) {
                    Email.setError("To pole jest wymagane!");
                    return;
                }
                 if (TextUtils.isEmpty(password)){
                    Password.setError("To pole jest wymagane!");
                    return;
                }
                 if (password.length() <= 6){
                    Password.setError("Hasło musi zawierać minimum 6 znaków");
                    return;
                }

                Progress.setVisibility(View.VISIBLE);

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Progress.setVisibility(View.INVISIBLE);
                            DocumentReference usersDocRef = fStore.collection("users").document(fAuth.getCurrentUser().getUid());
                            usersDocRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) { //
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Zostałeś pomyślnie zalogowany!", Toast.LENGTH_SHORT).show();
                                        DocumentSnapshot document = task.getResult();
                                        if (document.exists()) {
                                            Log.i(TAG, "Document Snapshot data: " + document.getData());
                                            String name = document.getString("name");

                                            if (RememberMe.isChecked()) { // jezeli zaznaczony checkbox - zapisz preferencje autologowania

                                                Boolean isChecked = RememberMe.isChecked();
                                                SharedPreferences.Editor editor = preferences.edit();
                                                editor.putString("pref_email", email);
                                                editor.putString("pref_password", password);
                                                editor.putBoolean("pref_automaticLogin", isChecked);
                                                editor.apply();
                                                Log.i(TAG, "Ustawiono autologowanie - zapisano email, password, check");
                                                //Toast.makeText(getApplicationContext(),"Autologowanie ustawione",Toast.LENGTH_SHORT).show();
                                            } else { // jezeli odznaczony checkbox - wyczysc preferencje autologowania
                                                preferences.edit().clear().apply();
                                                Log.i(TAG, "Usunieto autologowanie");
                                            }
                                        } else {
                                            Log.i(TAG, "Nie znaleziono dokumentu");
                                        }
                                    } else {
                                        Log.i(TAG, "niepowodzenie spowodowane: ", task.getException());
                                    }
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Dashboard.class));
                            overridePendingTransition(R.anim.slide_in_right,
                                    R.anim.slide_out_left);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Niepoprawny E-mail lub hasło!", Toast.LENGTH_SHORT).show();
                            Progress.setVisibility(View.INVISIBLE);
                        }
                    }
                });

            }

        });


        GoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

        Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Forgot.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
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