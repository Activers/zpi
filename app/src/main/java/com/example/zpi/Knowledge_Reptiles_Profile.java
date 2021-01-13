package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Knowledge_Reptiles_Profile extends AppCompatActivity {

    TextView textViewDesc;
    TextView textViewLive;
    TextView textViewSize;
    TextView textViewWeight;
    TextView textViewName;
    TextView textViewTemp;
    TextView textViewLight;

    ImageView imageViewImage, Back;

    FrameLayout Weight, Temp, Light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__reptiles__profile);

        textViewDesc = findViewById(R.id.TextViewDesc);
        textViewLive = findViewById(R.id.TextViewLive);
        textViewSize = findViewById(R.id.TextViewSize);
        textViewWeight = findViewById(R.id.TextViewWeight);
        textViewName = findViewById(R.id.TextViewAnimalName);
        textViewTemp = findViewById(R.id.TextViewTemp);
        textViewLight = findViewById(R.id.TextViewLight);

        imageViewImage = findViewById(R.id.ImageViewImage);
        Back = findViewById(R.id.ImageViewIconBack);

        Weight = findViewById(R.id.FrameWeight);
        Temp = findViewById(R.id.FrameTemp);
        Light = findViewById(R.id.FrameLight);


        String animalType = getIntent().getStringExtra("animalType");

        switch (animalType)
        {
            case "ANAKONDA" :
                Weight.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Anakonda Zielona zwana także anakondą olbrzymią, zamieszkuje dorzecze Amazonki i Orinoko. Jest jednym z największych dusicieli na świecie, pod względem długości dłuższy bywa tylko Pyton Siatkowy. Jest to gad długowieczny. Nominalne ubarwienie jest koloru oliwkowo-zielonego. Ciało pokrywają liczne, ciemnobrązowe lub czarne duże owalne plamy, a na bokach jasnoszarej głowy widnieją dwa czarne pasy."));
                textViewLive.setText(Html.fromHtml("10 - 30 lat"));
                textViewSize.setText(Html.fromHtml("2,5 - 4,5m"));
                textViewTemp.setText(Html.fromHtml("26 - 32°C"));
                textViewLight.setText(Html.fromHtml("12h"));
                break;

            case "WĄŻ BOA" :
                Weight.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Stosunkowo duży dusiciel o krępej budowie. Ciało osiąga największy obwód w okolicy połowy długości. Głowa niewielka, wyraźnie wyodrębniona, o trójkątnym kształcie, oczy niewielkie, charakterystyczna pionowa źrenica, tęczówka jasnożółta. Ubarwienie różni się nieco w zależności od podgatunku."));
                textViewLive.setText(Html.fromHtml("20 - 30 lat"));
                textViewSize.setText(Html.fromHtml("3 - 4,5m"));
                textViewTemp.setText(Html.fromHtml("24-35 °C"));
                textViewLight.setText(Html.fromHtml("12h"));
                break;

            case "ZÓŁW WODNY" :
                Temp.setVisibility(View.GONE);
                Light.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Pochodzą one z łagodnego i tropikalnego obszaru Ameryki, Azji i południowo-wschodniej Europy. W sklepach zoologicznych najczęściej spotkamy żółwia ozdobnego, kaspijskiego, chińskiego, sundajskiego lub terapenę ozdobną. Należy przede wszystkim pamiętać o tym, aby nie kupować żółwi zimą na bazarach i w innych punktach sprzedaży znajdujących się na dworze. Bezpieczniej kupić je u hodowcy lub w sklepie zoologicznym. Niedługo po zakupie należy żółwika umyć w ciepłej wodzie z dodatkiem soli kuchennej w proporcji 9g na jeden litr wody. Ciepła woda z solą ułatwi ogrzanie pancerza, umożliwi właściwą ocenę kondycji oraz uzupełni niedobory soli w organizmie zwierzęcia. Jeśli mamy już okazy żółwi pamiętajmy, że nie można trzymać żółwi różnej wielkości w jednym terrarium. Osobniki duże i silniejsze mogą zamęczyć małego i słabego współtowarzysza."));
                textViewLive.setText(Html.fromHtml("75 lat"));
                textViewSize.setText(Html.fromHtml("60 cm"));
                textViewWeight.setText(Html.fromHtml("Około 240g"));
                break;

            case "ZÓŁW LĄDOWY" :
                Temp.setVisibility(View.GONE);
                Light.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Żółw lądowy to w rzeczywistości żaden konkretny żółw. Żółw lądowy to zbiorcza nazwa obszernej rodziny żółwi, obejmującej około 40 gatunków, zamieszkujących stepy, sawanny, busz oraz tereny półpustynne na wszystkich kontynentach, za wyjątkiem Australii. Żółw lądowy jest gadem charakteryzującym się skostniałą, wysklepioną skorupą pokrywającą ciało. Skorupa ta, czyli tak zwany karapaks, pokryta jest łuskami przypominającymi pancerz."));
                textViewLive.setText(Html.fromHtml("70 - 300 lat"));
                textViewSize.setText(Html.fromHtml("6/7cm do nawet 1,9m"));
                textViewWeight.setText(Html.fromHtml("Od kilkuset gram do kilkuset kilogramów"));
                break;

            case "GEKON LAMPARCI" :
                Temp.setVisibility(View.GONE);
                Light.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.gekon);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Gekon lamparci to najpopularniejszy z gekonów hodowanych w warunkach domowych. Jego spokojna, ciekawska natura sprawia, że gad ten uchodzi za zwierzę łatwe do oswojenia przez człowieka. Dlatego też dla początkującego terrarysty zakup właśnie gekona lamparciego jest jedną z najlepszych opcji."));
                textViewLive.setText(Html.fromHtml("15 lat"));
                textViewSize.setText(Html.fromHtml("25 - 30cm"));
                textViewWeight.setText(Html.fromHtml("Około 100g"));
                break;

            case "KAMELEON JEMEŃSKI" :
                Temp.setVisibility(View.GONE);
                Light.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.kameleon);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Kameleon jemeński pochodzi z Afryki – na wolności żyje w okolicach Jemenu oraz w Arabii Saudyjskiej oraz na Madagaskarze. Zamieszkuje tereny tropikalne i zwykle znaleźć go można na drzewach i zaroślach. Posiada długi i lepki język, który służy do polowania. Samiec jest zawsze bardziej kolorowy – w jego ubarwieniu przeważa zieleń z akcentami żółci, czerwieni, pomarańczu, brązu i niebieskiego. U samicy także przeważa zieleń i pojawiają się plamki w kolorze żółtym, rudym i białym."));
                textViewLive.setText(Html.fromHtml("5 - 7 lat"));
                textViewSize.setText(Html.fromHtml("35 - 45cm"));
                textViewWeight.setText(Html.fromHtml("Około 90 - 180g"));
                break;

            case "LEGWAN ZIELONY" :
                Temp.setVisibility(View.GONE);
                Light.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.legwan);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Legwan zielony jest piękną, dużą jaszczurką żyjącą na konarach i gałęziach drzew. Wywodzi się z Ameryki Środkowej i Południowej, zamieszkuje tereny od Meksyku po Paragwaj. Występuje też na Wyspach Karaibskich. Legwana zielonego spotkać można również w południowych stanach USA – na Florydzie czy w Teksasie, a także na Hawajach."));
                textViewLive.setText(Html.fromHtml("Około 30 lat"));
                textViewSize.setText(Html.fromHtml("30 - 42cm"));
                textViewWeight.setText(Html.fromHtml("1,2 - 4kg"));
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