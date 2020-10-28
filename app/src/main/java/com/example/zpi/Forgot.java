package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot extends AppCompatActivity {

    EditText Email;
    Button Reset;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        Email = findViewById(R.id.editTextEmail);
        Reset = findViewById(R.id.buttonReset);
        fAuth = FirebaseAuth.getInstance();


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Email.setError("To pole jest wymagane!");
                    return;
                }

                fAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Forgot.this, "Wiadomość została wysłana na podany adres E-mail", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Forgot.this, "Błąd! Podany adres E-mail nie znajduje się w bazie danych!", Toast.LENGTH_SHORT).show();
                    }
                }) ;

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }


}