package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class Knowledge_inverte_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_inverte_profile);

        TextView textViewDesc;
        TextView textViewLive;
        TextView textViewSize;
        TextView textViewWeight;

        textViewDesc = findViewById(R.id.TextViewDesc);
        textViewLive = findViewById(R.id.TextViewLive);
        textViewSize = findViewById(R.id.TextViewSize);
        textViewWeight = findViewById(R.id.TextViewWeight);

        textViewDesc.setText(Html.fromHtml("Patyczak rogaty, nazywany też patyczakiem annamskim, igielnikiem albo indochińskim, to owad, który swoim wyglądem do złudzenia przypomina gałęzie lub patyki, skąd wzięła się jego nazwa. Jego hodowla nie sprawia większych problemów, ponieważ owad nie ma dużych wymagań dotyczących pożywienia ani terrarium. Patyczaki rogate są najbardziej aktywne w zacienionych miejscach, późnymi wieczorami albo w nocy oraz w warunkach wysokiej wilgotności. W ciągu dnia owady praktycznie wcale się nie poruszają, nawet, jeśli się je dotknie."));

        textViewLive.setText(Html.fromHtml("Około 1 roku"));

        textViewSize.setText(Html.fromHtml("10 - 16cm"));

        textViewWeight.setText(Html.fromHtml("Około 25g"));

    }


}