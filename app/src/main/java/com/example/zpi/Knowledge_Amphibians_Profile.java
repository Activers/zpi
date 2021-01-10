package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Knowledge_Amphibians_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_amphibians_profile);

        TextView textViewDesc;
        TextView textViewLive;
        TextView textViewSize;
        TextView textViewWeight;

        textViewDesc = findViewById(R.id.TextViewDesc);
        textViewLive = findViewById(R.id.TextViewLive);
        textViewSize = findViewById(R.id.TextViewSize);
        textViewWeight = findViewById(R.id.TextViewWeight);

        textViewDesc.setText(Html.fromHtml("Choć jak większość płazów powinien prowadzić tryb wodno-lądowy, aksolotl meksykański zatrzymuje się w fazie larwalnej i na ląd nie wychodzi. Ma to zapewne związek z wadą tarczycy u wszystkich przedstawicieli tego gatunku. Udaje się ją obejść jedynie w laboratorium, gdzie za sprawą terapii hormonalnej aksolotl zrzuca płetwę i przeobraża się w czteronożną ambystomę. Salamandra ma zresztą jeszcze kilka innych tajemnic, jak choćby ta, dlaczego w hodowli zamiast naturalnego, ciemnoszarego lub brązowego prążkowanego ubarwienia staje się zwykle albinosem z intensywnie różowymi skrzelami. Wkrótce może się okazać, że ludzkości zabraknie czasu na zrozumienie tego niezwykłego płaza, będącego według wierzeń Azteków wcieleniem boga, który skrył się w jego ciele, by uniknąć kary. Ten endemiczny gatunek żyje wyłącznie w jeziorze Xochimilco niedaleko stolicy Meksyku i otaczających je kanałach."));

        textViewLive.setText(Html.fromHtml("Około 10 - 15 lat"));

        textViewSize.setText(Html.fromHtml("Około 23cm"));

        textViewWeight.setText(Html.fromHtml("Około 60 - 226g"));

    }
}