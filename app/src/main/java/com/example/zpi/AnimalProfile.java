package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class AnimalProfile extends AppCompatActivity {

    CircleImageView Avatar;
    TextView Name, Breed, Weight, Date, Bio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_profile);

        Avatar = findViewById(R.id.ImageViewAvatar);
        Name = findViewById(R.id.TextViewAnimalName);
        Breed = findViewById(R.id.TextViewBreed);
        Weight = findViewById(R.id.TextViewWeight);
        Date = findViewById(R.id.TextViewDate);
        Bio = findViewById(R.id.TextViewBio);

        Integer animalAvatar = getIntent().getIntExtra("animalAvatar", R.drawable.ssaki2);
        String animalName = getIntent().getStringExtra("animalName");
        String animalType = getIntent().getStringExtra("animalType");
        String animalBreed = getIntent().getStringExtra("animalBreed");
        String animalWeight = getIntent().getStringExtra("animalWeight");
        String animalDate = getIntent().getStringExtra("animalDate");
        String animalBio = getIntent().getStringExtra("animalBio");

        Avatar.setImageResource(animalAvatar);
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