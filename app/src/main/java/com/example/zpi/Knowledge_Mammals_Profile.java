package com.example.zpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Knowledge_Mammals_Profile extends AppCompatActivity {

    TextView textViewDesc;
    TextView textViewLive;
    TextView textViewNature;
    TextView textViewSize;
    TextView textViewFur;
    TextView textViewWeight;
    TextView textViewName;


    FrameLayout FrameSize;
    ImageView imageViewImage,Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge__mammals__profile);

        textViewDesc = findViewById(R.id.TextViewDesc);
        textViewLive = findViewById(R.id.TextViewLive);
        textViewNature = findViewById(R.id.TextViewNature);
        textViewSize = findViewById(R.id.TextViewSize);
        textViewFur = findViewById(R.id.TextViewFur);
        textViewWeight = findViewById(R.id.TextViewWeight);
        textViewName = findViewById(R.id.TextViewAnimalName);

        FrameSize = findViewById(R.id.FrameSize);

        Back = findViewById(R.id.ImageViewIconBack);
        imageViewImage = findViewById(R.id.ImageViewImage);


        String animalType = getIntent().getStringExtra("animalType");

        switch (animalType)
        {
            case "ALASKAN MALAMUTE" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Alaskan malamute to jedna z najstarszych ras arktycznych. Ten pies zaprzęgowy używany był niegdyś do ciągnięcia ładunków. Obecnie funkcja ta nie ma już zastosowania, a współczesne zawody psów zaprzęgowych wymagają dużej szybkości, biorą w nich zatem udział bardziej zwinne i smukłe rasy (takie jak husky). Z tego powodu malamut to dzisiaj głównie pies do towarzystwa i wystawowy. Malamut jest wyjątkowo łagodny i czuły wobec swoich bliskich."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 14 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny, Łowca"));
                textViewSize.setText(Html.fromHtml("Duży"));
                textViewFur.setText(Html.fromHtml("Długa"));
                textViewWeight.setText(Html.fromHtml("Około 30 - 38kg"));
                break;

            case "BERNEŃSKI PIES PASTERSKI" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Pochodzący ze Szwajcarii berneńczyk to duży pies o imponującym wyglądzie. Jest równie silny, co łagodny, więc sprawi radość każdemu właścicielowi. Ma słaby instynkt łowiecki i doskonale sprawdza się jako stróż. Świetnie nadaje się do życia na wsi, o ile zadbamy o zaspokojenie jego zapotrzebowania na aktywność fizyczną i umysłową."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 8 i 10 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Inteligentny"));
                textViewSize.setText(Html.fromHtml("Duży"));
                textViewFur.setText(Html.fromHtml("Długa, Kręcona"));
                textViewWeight.setText(Html.fromHtml("Około 40 - 60kg"));
                break;

            case "BERNARDYN" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Bernardyn jest molosem w typie górskim, charakteryzuje się masywną budową ciała. Z uwagi na swoje pochodzenie i predyspozycje jest świetnym stróżem. Na co dzień to bardzo spokojny czworonóg, który doskonale czuje się towarzystwie innych psów. Akceptuje także koty."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 8 i 10 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny, Inteligentny"));
                textViewSize.setText(Html.fromHtml("Duży"));
                textViewFur.setText(Html.fromHtml("Krótka, Długa"));
                textViewWeight.setText(Html.fromHtml("Około 50 - 90kg"));
                break;

            case "BICHON FRISE" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Bichon frise to typowy pies do towarzystwa. Niewielki, żywiołowy o przyjaznym usposobieniu świetnie sprawdza się w charakterze pupila całej rodziny. Bichon frise jest bardzo czuły. Uwielbia pieszczoty i wspólne zabawy. Bardzo dobrze dogaduje się zarówno z dziećmi, jak i osobami starszymi. Nie jest też konfliktowy w stosunku do innych zwierząt zamieszkujących wspólne gospodarstwo. Choć bywa uparty, bardzo szybko się uczy i jest posłuszny."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 14 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę"));
                textViewSize.setText(Html.fromHtml("Mały"));
                textViewFur.setText(Html.fromHtml("Długa"));
                textViewWeight.setText(Html.fromHtml("Około 4 - 7kg"));
                break;

            case "BULTERIER" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Ten kompaktowy, umięśniony i pełen energii pies, wbrew powszechnym opiniom, wcale nie jest niebezpieczny. Jego reakcje mogą czasem nie przystawać do sytuacji, ale bulterier to uroczy, skory do zabawy i niezwykle przywiązany do swoich bliskich pies. Współczesna selekcja dodatkowo umożliwiła złagodzenie awanturniczej natury bulteriera. Mimo wszystko, ta kula niespożytej energii potrzebuje właściciela doświadczonego, aktywnego i mającego dużo czasu."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 10 i 14 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę"));
                textViewSize.setText(Html.fromHtml("Średni"));
                textViewFur.setText(Html.fromHtml("Bardzo krótka"));
                textViewWeight.setText(Html.fromHtml("Około 20 - 40kg"));
                break;

            case "CHOW CHOW" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Chow chow to pies o wyjątkowym usposobieniu. Ten niezależny samotnik oddany swojemu panu nigdy lub prawie nigdy nie okazuje czułości. Z natury jest podejrzliwy wobec obcych, sprawdzi się więc jako pies stróżujący. Dyskretny, cichy, niezbyt skory do zabaw czy sportu, zdecydowanie preferuje spokojny tryb życia. Posiada silny temperament, w związku z czym nie jest zalecany dla nowicjuszy – wyszkolenie go może być trudne."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 9 i 12 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny"));
                textViewSize.setText(Html.fromHtml("Średni"));
                textViewFur.setText(Html.fromHtml("Krótka, Długa"));
                textViewWeight.setText(Html.fromHtml("Około 20 - 40kg"));
                break;

            case "DALMATYŃCZYK" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Dalmatyńczyk to pies o bardzo charakterystycznym ubarwieniu, przez które ciężko pomylić go z inną rasą. Niezwykle energiczny, silny, szybki i ruchliwy, zdecydowanie jest typem sportowca. Jest inteligentny, czujny, szybko się uczy. Potrafi jednak być też uparty i samodzielny, dlatego wymaga opieki konsekwentnego i stanowczego trenera. Właściwie wychowywany i wcześnie socjalizowany, staje się wiernym i czułym towarzyszem swojego pana, któremu jest posłuszny."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 10 i 12 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę, Inteligentny, Łowca"));
                textViewSize.setText(Html.fromHtml("Średni"));
                textViewFur.setText(Html.fromHtml("Krótkie, Szorstkowłosy"));
                textViewWeight.setText(Html.fromHtml("Około 24 - 32kg"));
                break;

            case "OWCZAREK MAREMMA" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Maremmano-Abruzzese to pies pasterski wykorzystywany głównie do pilnowania stad owiec i ludzkich gospodarstw. Jest ostrożny, czujny i opiekuńczy w stosunku do swojej rodziny. Nazwa rasy pochodzi od nazw regionów Maremmy i Abruzji, gdzie psy te strzegły owiec już setki lat temu. Opisy psów podobnych do owczarka z Maremmy można znaleźć już w literaturze starożytnego Rzymu."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 11 - 13 lat"));
                textViewNature.setText(Html.fromHtml("Inteligentny"));
                textViewSize.setText(Html.fromHtml("Duży"));
                textViewFur.setText(Html.fromHtml("Długa, Szorstkowłosy"));
                textViewWeight.setText(Html.fromHtml("Około 30 - 45kg"));
                break;

            case "HUSKY SYBERYJSKI" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Husky syberyjski tradycyjnie jest wykorzystywany w wyścigach psich zaprzęgów, jednak przede wszystkim pełni rolę psa do towarzystwa. To piękny i łagodny pies, idealny dla miłośników ras pierwotnych, jak najbardziej zbliżonych do wilka. Jest całkowicie niegroźny, bo zaprzyjaźnia się z każdym (nie nadaje się zatem na psa stróżującego). To jednak bardzo niezależny pies."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 14 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Łowca"));
                textViewSize.setText(Html.fromHtml("Średni"));
                textViewFur.setText(Html.fromHtml("Długa"));
                textViewWeight.setText(Html.fromHtml("Około 15 - 28kg"));
                break;

            case "GOLDEN RETRIEVER" :
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Nadaje się do wielu zadań, jest czuły i przyjazny dla wszystkich. To doskonały towarzysz, zarówno w pracy jak i w domu."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 14 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę, Inteligentny"));
                textViewSize.setText(Html.fromHtml("Średni"));
                textViewFur.setText(Html.fromHtml("Długie, Kręcone"));
                textViewWeight.setText(Html.fromHtml("Około 24 - 32kg"));
                break;

            case "DACHOWIEC" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Jest to najpopularniejsza „rasa” kota. Dachowce są najbardziej odporne na choroby. Koty te są najbardziej różnorodne, co daje im wyjątkowy urok."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 13 - 17 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę, Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie, Długie"));
                textViewWeight.setText(Html.fromHtml("Około 2 - 5kg"));
                break;

            case "BRYTYJSKI KROTKOWŁOSY" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Ten kot jest ulubieńcem Anglików. Urocza okrągła mordka, pluszowe futerko i wygląd „misia” bez wątpienia mogą oczarować każdego. Gdy jeszcze w starożytności pojawił się na angielskich ziemiach, miał za zadanie tępić szczury. Jego wyjątkowa uroda, a także niebieski kolor futra u najpopularniejszej odmiany sprawiają, że często mylony jest z kartuzem. Kot brytyjski krótkowłosy to niezmiennie bardzo popularna rasa."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 14 - 18 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 3 - 4kg"));
                break;

            case "CORNISH REX" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Cornish rex to kot o wydłużonej i smukłej sylwetce charta, obdarzony charakterystycznymi dużymi uszami.  Jego sierść jest również wyjątkowa - futerko reksa przypomina delikatny falisty meszek. Skręcone są nawet jego wąsy. To wyjątkowo łagodny i czuły kot - wspaniały towarzysz rodziny."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 15 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę, Inteligentny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 3 - 5kg"));
                break;

            case "DOŃSKI SFINKS" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Pierwszą reakcją ludzi na widok dońskiego sfinksa często jest okrzyk „A cóż to ma być?!”. Rzeczywiście, jego wygląd jest jak najbardziej niezwykły. Tymczasem, przy bliższym poznaniu, nie pozostaje nam nic innego, niż go pokochać. Doński sfinks jest kotem ujmującym zarówno swoim szczególnym wyglądem, jak i charakterem. Bardzo dużo zyskuje, gdy się go lepiej pozna. Oczy w kształcie migdału, szczególna faktura skóry i jej fałdki mogą oczarować albo być odpychające. Jedno jest pewne - wobec takiej oryginalności nikt nie pozostanie obojętny."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 15 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch"));
                textViewFur.setText(Html.fromHtml("Bezwłosy"));
                textViewWeight.setText(Html.fromHtml("Około 2 - 5kg"));
                break;

            case "JAPOŃSKI BOBTAIL" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Słowo „bobtail” pochodzi od angielskiego „bobbed tail” i znaczy „skrócony ogonek”. Japoński bobtail jest więc dokładnie taki, jak wskazuje nazwa tej rasy - to kot, który pochodzi z Japonii i ma, w naturalny sposób, ogon znacznie krótszy, niż przeciętny domowy kot. Rzeczywiście, ogonek bobtaila jest nie tylko krótki, ale w dodatku skręcony, przez co tworzy swoisty pomponik u dołu grzbietu, wyjątkowy i niepowtarzalny niczym odcisk palca. Jest to rasa mało rozpowszechniona w Europie, a warto ją bliżej poznać. Japoński bobtail jest kotem wyjątkowo radosnym, energicznym i ujmującym, nie powinno więc dziwić, że w Kraju Kwitnącej Wiśni symbolizuje szczęście."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 14 i 16 lat"));
                textViewNature.setText(Html.fromHtml("Lubiący zabawę, Inteligentny"));
                textViewFur.setText(Html.fromHtml("Krótkie, Długie"));
                textViewWeight.setText(Html.fromHtml("Około 2 - 4kg"));
                break;

            case "KORAT" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Korat, w Tajlandii nazywany „Si-Sawat” (kolor pomyślności), fascynuje pełnymi blasku zielonymi oczami oraz niebieską, lekko posrebrzaną szatą, która według tajskich wierzeń ludowych, przynosi szczęście i symbolizuje bogactwo."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 15 i 20 lat"));
                textViewNature.setText(Html.fromHtml("Nieufny wobec obcych, Czuły, Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 2 - 5kg"));
                break;

            case "EGIPSKI MAU" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Jest to jedna z najstarszych odnotowanych ras kota domowego. Ma on lekko zmartwioną minę oraz spokojny i uległy temperament. Bardzo lubi ludzi i nie jest agresywny w stosunku do człowieka."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 14 i 18 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Lubiący zabawę, Spokojny, Inteligentny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 3 - 6kg"));
                break;

            case "HIMALAJSKI" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Jego nazwa wywodzi się od rasy domowego królika o identycznej szacie. Kot himalajski jest jednak po prostu persem ze znaczeniami typu syjamskiego. Jest szczególnie ceniony po drugiej stronie Atlantyku, gdzie uważa się go za odrębną rasę. Kraje europejskie natomiast od lat osiemdziesiątych klasyfikują go jako odmianę kota perskiego."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 10 i 15 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny, Inteligentny"));
                textViewFur.setText(Html.fromHtml("Długie"));
                textViewWeight.setText(Html.fromHtml("Około 3 - 5kg"));
                break;

            case "TIFFANIE" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Tiffanie jest dosyć rzadko spotykaną rasą pochodzącą z Wielkiej Brytanii. To długowłosa odmiana kota burmskiego w typie europejskim."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 15 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch"));
                textViewFur.setText(Html.fromHtml("Długie"));
                textViewWeight.setText(Html.fromHtml("Około 6 - 12kg"));
                break;

            case "ŚWIĘTY BIRMAŃSKI" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Pochodzenie tej rasy jest dość niejasne, ale możliwe, że święty kot birmański wywodzi się z Francji. Jego półdługie, jedwabiste futro ma tę wielką zaletę, że się nie plącze. Birmańczyk większość swojego czasu poświęca na pieszczoty z opiekunem, za którym chodzi jak cień. Jest bardzo towarzyski i ma dobry kontakt z ludźmi i zwierzętami w każdym wieku."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 12 i 15 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny"));
                textViewFur.setText(Html.fromHtml("Długie"));
                textViewWeight.setText(Html.fromHtml("Około 2 - 6kg"));
                break;

            case "KRÓLIK" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.krolik);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Króliki domowe zaliczane są do jednych z najbardziej popularnych i lubianych zwierząt domowych na całym świecie. Trudno się temu dziwić, biorąc pod uwagę, jak uroczo wyglądają ze swoimi miękkimi futerkami, długimi uszkami i łagodnym spojrzeniem. Poza tym uchodzą za towarzyskie, łatwe w pielęgnacji i niedrogie w utrzymaniu."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 1 - 2 lata"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Energiczny"));
                textViewFur.setText(Html.fromHtml("Krótkie, Długie"));
                textViewWeight.setText(Html.fromHtml("Około 1 - 3kg"));
                break;

            case "CHOMIK" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.chomik);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Sympatyczny i niedrogi w utrzymaniu chomik to świetny kandydat na domowego pupila. Szybko się oswaja, jest przyjazny oraz nie wymaga dużego zaangażowania. Chomiki to dobrze znane nam gryzonie. Dalekimi krewnymi chomików są np. różne gatunki myszowatych, w tym mysz domowa."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 1 - 3 lata"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 20 - 25g"));
                break;

            case "SZYNSZYLA" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.szynszyla);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Szynszyla to popularne zwierzątko domowe, które swoim wyglądem przypomina nieco wiewiórkę. Jest jednak o wiele większa i inaczej umaszczona. Jest stosunkowo tania w utrzymaniu i bardzo towarzyska. Szynszyle to zwierzęta stadne, dlatego najlepiej czują się kiedy mają towarzystwo. Należy im również zapewnić odpowiednie warunki do ruchu, jak również należy pamiętać że najbardziej aktywne są w godzinach nocnych. Są to również jedne z najczystszych zwierząt domowych. Jednak nie są one zwierzętami, które może mieć każdy- nie przepadają one za dziećmi, lubią swoją wolność, nie lubią być przymuszane do czegokolwiek, to czy szynszyla pozwoli się swojemu właścicielowi pogłaskać, podrapać, wziąć na ręce zależy tylko i wyłącznie od jej humoru i charakteru, nie wolno ich do niczego zmuszać siłą. Hodowla szynszyli również jest trudna i wymaga ogromnego doświadczenia."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 10 - 20 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny, Energiczny, Wymaga dużo atencji"));
                textViewFur.setText(Html.fromHtml("Długie i puchate"));
                textViewWeight.setText(Html.fromHtml("Około 350 - 600g"));
                break;

            case "SZCZUR" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.szczur2);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Szczur domowy to wspaniały towarzysz zarówno dla dzieci, jak i dla dorosłych. Gryzonie te nie są bardzo wymagające, zajmują niewiele miejsca, a w dodatku są bardzo przyjazne, inteligentne i łatwe do oswojenia."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 1 - 3 lat"));
                textViewNature.setText(Html.fromHtml("Pieszczoch, Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 175 - 300g"));
                break;

            case "MYSZ" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.mysz);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Mysz domowa to zwierzę, które Polacy dość często wybierają w sklepach zoologicznych, by później sprawować nad nim opiekę. Gryzonie, które hoduje się w domach są udomowioną formą myszy domowej (forma laboratoryjna). Jak sama nazwa wskazuje, zanim myszy zaczęto traktować jako domowe pupile, hodowano w laboratoriach na potrzeby badań."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 1 - 4 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny"));
                textViewFur.setText(Html.fromHtml("Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 15 - 25g"));
                break;

            case "ŚWINKA MORSKA" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Świnka morska (kawia domowa) pochodzi z Ameryki Południowej. Zanim świnka morska stała się zwierzątkiem domowym, Istnieje wiele ras kawii domowej. Występują one w najróżniejszych odmianach kolorystycznych. Mogą różnić się zarówno ubarwieniem, jak i strukturą i długością włosa."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 4 - 8 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny"));
                textViewFur.setText(Html.fromHtml("Długie, Krótkie"));
                textViewWeight.setText(Html.fromHtml("Około 0,7 - 1,2kg"));
                break;

            case "JEŻ" :
                FrameSize.setVisibility(View.GONE);
                imageViewImage.setImageResource(R.drawable.patyczak);
                textViewName.setText(animalType);
                textViewDesc.setText(Html.fromHtml("Afrykański jeż pigmejski, zwany też jeżem karłowatym, to najmniejszy z dziko żyjących gatunków jeży na świecie. Jest też zwierzątkiem domowym coraz popularniejszym w hodowli, choć nie jest ona łatwa. Selektywna hodowla i krzyżówki tego gatunku dają szereg odmiennych, niespotykanych dotąd wzorów i kolorów, jak sól i pieprz, biel, cynamon itp. Jeże hodowlane są rejestrowane w Klubie Jeża Pigmejskiego w Wielkiej Brytanii. Każdy osobnik ma swój indywidualny numer hodowlany i rodowód, który nadaje i wystawia Klub. Potwierdza to pochodzenie jeżyka. Zwierzęta bez tych dokumentów i numeru są z dzikich hodowli i mogą być słabe i chore."));
                textViewLive.setText(Html.fromHtml("Pomiędzy 3 - 11 lat"));
                textViewNature.setText(Html.fromHtml("Spokojny"));
                textViewFur.setText(Html.fromHtml("Igły"));
                textViewWeight.setText(Html.fromHtml("Około 220 - 700g"));
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