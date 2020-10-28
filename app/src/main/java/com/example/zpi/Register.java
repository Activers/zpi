package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText Username,Email,Password,RepeatPass;
    Button Register;
    ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Username = findViewById(R.id.editTextUsername);
        Email = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
        RepeatPass = findViewById(R.id.editTextRepPassword);
        Register = findViewById(R.id.buttonRegister);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String repeatpass = RepeatPass.getText().toString().trim();
                final String login = Username.getText().toString();

                if (TextUtils.isEmpty(login)){
                    Username.setError("To pole jest wymagane!");
                    return;
                }
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
                if (!password.equals(repeatpass)){
                    RepeatPass.setError("Hasła nie są takie same!!");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Map<String,Object> user = new HashMap<>();
                            user.put("login",login);
                            user.put("e-mail",email);
                            String uid = fAuth.getCurrentUser().getUid();
                            fStore.collection("users").document(uid).set(user);
                            Toast.makeText(Register.this, "Zostałeś pomyślnie zarejestrowany!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                            overridePendingTransition(R.anim.slide_in_left,
                                    R.anim.slide_out_right);

                        }
                        //else {
                        //   Toast.makeText(Register.this, "Błąd rejestracji! Spróbuj ponownie później.", Toast.LENGTH_SHORT).show();
                        //}
                        if(fAuth.getCurrentUser() != null){
                            Toast.makeText(Register.this, "Takie konto już istnieje!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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