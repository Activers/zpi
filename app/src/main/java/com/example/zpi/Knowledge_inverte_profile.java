package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Knowledge_inverte_profile extends AppCompatActivity {


    TextView textViewDesc;
    TextView textViewLive;
    TextView textViewSize;
    TextView textViewWeight;
    TextView textViewName;

    ImageView imageViewImage,Back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_inverte_profile);


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
            case "PATYCZAK" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Patyczak rogaty, nazywany też patyczakiem annamskim, igielnikiem albo indochińskim, to owad, który swoim wyglądem do złudzenia przypomina gałęzie lub patyki, skąd wzięła się jego nazwa. Jego hodowla nie sprawia większych problemów, ponieważ owad nie ma dużych wymagań dotyczących pożywienia ani terrarium. Patyczaki rogate są najbardziej aktywne w zacienionych miejscach, późnymi wieczorami albo w nocy oraz w warunkach wysokiej wilgotności. W ciągu dnia owady praktycznie wcale się nie poruszają, nawet, jeśli się je dotknie."));
                textViewLive.setText(Html.fromHtml("Około 1 roku"));
                textViewSize.setText(Html.fromHtml("10 - 16cm"));
                textViewWeight.setText(Html.fromHtml("Około 25g"));
                break;

            case "MODLISZKA" :
                imageViewImage.setImageResource(R.drawable.modliszka);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Hodowla modliszek wymaga separacji podrośniętych osobników z uwagi na duże skłonności kanibalistyczne. Wspólnie można trzymać młode do 3-4 wylinki (oczywiście pod warunkiem zapewnienia obfitości pokarmu) oraz samce większości gatunków."));
                textViewLive.setText(Html.fromHtml("Około 1 roku"));
                textViewSize.setText(Html.fromHtml("4,5 - 6cm"));
                textViewWeight.setText(Html.fromHtml("Około 25g"));
                break;

            case "PAJĄK" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Istnieje wiele ras pająków, każdy z nich odmienny, każdy o innych wymaganiach co do hodowli, innych upodobaniach żywieniowych innym klimacie występowania. Jednym z nich jest ptasznik- Król pająków. Ptaszniki są wielkie, kosmate, a przede wszystkim przerażające – ptaszniki. Mgławica tarantula wzięła swoją nazwę właśnie od tego pająka. Wszędzie tam gdzie żyją nadajemy ptasznikom różne nazwy – ptasznik gwiaździsty, pawiani, tygrys ziemny. Ale co sprawia, że ptasznik jest ptasznikiem? Przede wszystkim należą do najstarszych pająków na ziem i dysponują hakami jadowymi, dorównując pod tym względem wielu jadowitym wężom. Dla naukowców są prymitywnymi pająkami należącymi do rodziny theraphosidae."));
                textViewLive.setText(Html.fromHtml("15 - 25 lat"));
                textViewSize.setText(Html.fromHtml("10 - 30cm"));
                textViewWeight.setText(Html.fromHtml("Około 250g"));
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