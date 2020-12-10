package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnimalProfile extends AppCompatActivity {

    TextView Name, Breed, Weight, Date, Bio; //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_profile);

        Name = findViewById(R.id.TextViewAnimalName);
        Breed = findViewById(R.id.TextViewBreed);
        Weight = findViewById(R.id.TextViewWeight);
        Date = findViewById(R.id.TextViewDate);
        Bio = findViewById(R.id.TextViewBio);


        String animalName = getIntent().getStringExtra("animalName");
        String animalType = getIntent().getStringExtra("animalType");
        String animalBreed = getIntent().getStringExtra("animalBreed");
        String animalWeight = getIntent().getStringExtra("animalWeight");
        String animalDate = getIntent().getStringExtra("animalDate");
        String animalBio = getIntent().getStringExtra("animalBio");

        Name.setText(animalName);
        if (animalBreed == null) {
            Breed.setText(animalType);
        } else {
            Breed.setText(animalType + " - " + animalBreed);
        }
        Weight.setText(animalWeight);
        Date.setText(animalDate);
        Bio.setText(animalBio);

    }
}