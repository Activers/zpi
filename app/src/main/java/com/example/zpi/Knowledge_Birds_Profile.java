package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Knowledge_Birds_Profile extends AppCompatActivity {

    TextView textViewDesc;
    TextView textViewLive;
    TextView textViewSize;
    TextView textViewWeight;
    TextView textViewName;

    ImageView imageViewImage,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__birds__profile);

        textViewDesc = findViewById(R.id.TextViewDesc);
        textViewLive = findViewById(R.id.TextViewLive);
        textViewSize = findViewById(R.id.TextViewSize);
        textViewWeight = findViewById(R.id.TextViewWeight);
        textViewName = findViewById(R.id.TextViewAnimalName);

        imageViewImage = findViewById(R.id.ImageViewImage);
        Back = findViewById(R.id.ImageViewIconBack);

        String animalType = getIntent().getStringExtra("animalType");

        switch (animalType)
        {
            case "PAPUGA ARA" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Ary pochodzą z Ameryki Południowej. Ara ararauna to gatunek, który łatwo oswoić. Dobrze żyją z innymi osobnikami, a kupując swojego, dobrze wybrać takiego, który wychował się w stadzie – łatwiej będzie go oswoić."));
                textViewLive.setText(Html.fromHtml("Około 50 lat"));
                textViewSize.setText(Html.fromHtml("46 - 95cm"));
                textViewWeight.setText(Html.fromHtml("Około 340g - 1,3kg"));
                break;

            case "KANAREK" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Kanarki uchodzą za łatwe w pielęgnacji, ponieważ w zasadzie potrafią zadbać o siebie same, jeśli tylko zapewnisz im odpowiednie wyposażenie w klatce, takie jak wanienka lub basen, różnej grubości drążki czy minerały i witaminy w postaci np. kości mineralnych."));
                textViewLive.setText(Html.fromHtml("Około 10 lat"));
                textViewSize.setText(Html.fromHtml("10 - 12 cm"));
                textViewWeight.setText(Html.fromHtml("Około 8,4 - 24g"));
                break;

        }

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in_left,
                        R.anim.slide_out_right);
            }
        });

    }
}