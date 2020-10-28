package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

    EditText Email;
    EditText Password;
    Button Login;
    ProgressBar Progress;
    Button GoRegister;
    TextView Forgot;

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

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
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
                            Toast.makeText(Login.this, "Zostałeś pomyślnie zalogowany!", Toast.LENGTH_SHORT).show();
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
}