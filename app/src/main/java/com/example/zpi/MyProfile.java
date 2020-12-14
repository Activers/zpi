package com.example.zpi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfile extends AppCompatActivity {

    final String TAG = "MyProfile";

    ImageView IconBack;
    CircleImageView Avatar,AddAvatar;
    TextView Username,Mail,CountAnimal;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private ArrayList<AnimalModel> animalModelList;
    private RecyclerAdapter recyclerAdapter;
    LinearLayout AddAnimal;
    FirebaseAuth fAuth;
    StorageReference fStorage;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);


        IconBack = findViewById(R.id.ImageViewIconBack);
        Avatar = findViewById(R.id.ImageViewAvatar);
        AddAvatar = findViewById(R.id.ImageViewAddAvatar);
        AddAnimal = findViewById(R.id.AddAnimal);
        Username = findViewById(R.id.TextViewUsername);
        Mail = findViewById(R.id.TextViewMail);
        CountAnimal = findViewById(R.id.TextViewCountAnimal);
        recyclerView = findViewById(R.id.recyclerViewMyProfile);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        try {
            fStorage = FirebaseStorage.getInstance().getReference();
            StorageReference profileRef = fStorage.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
            profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).resize(250, 300).noFade().rotate(270).into(Avatar);
                }
            });
        } catch (Exception e) {}

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        animalModelList = new ArrayList<>();


        recyclerAdapter = new RecyclerAdapter(getApplicationContext(), animalModelList);
        recyclerView.setAdapter(recyclerAdapter);

        GetProfileDataFromFirebase();

        try {
            recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickedListener() {
                @Override
                public void onItemClick(int position) {
                    Intent intent = new Intent(getApplicationContext(),AnimalProfile.class);
                    intent.putExtra("animalName",animalModelList.get(position).getAnimalName());
                    intent.putExtra("animalType",animalModelList.get(position).getAnimalType());
                    intent.putExtra("animalBreed",animalModelList.get(position).getAnimalBreed());
                    intent.putExtra("animalWeight",animalModelList.get(position).getAnimalWeight());
                    intent.putExtra("animalDate",animalModelList.get(position).getAnimalDate());
                    intent.putExtra("animalBio",animalModelList.get(position).getAnimalBio());
                    startActivity(intent);
                }
            });

        } catch (Exception e) { Log.d(TAG, "RECYCLER LISTENER ERROR: " + e); }


        AddAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent openGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGallery, 1000);
            }
        });


        IconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
                overridePendingTransition(R.anim.slide_in_left,
                        R.anim.slide_out_right);
            }
        });

        AddAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddAnimal.class));
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            if(resultCode == Activity.RESULT_OK){
                Uri imageUri = data.getData();

                uploadImageToFirebase(imageUri);

            }
        }

    }

    private void uploadImageToFirebase(Uri imageUri) {


        final StorageReference fileRef = fStorage.child("users/"+fAuth.getCurrentUser().getUid()+"/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Log.d(TAG, "Awatar został dodany"); // zmienic na log w konsoli
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).resize(250, 300).noFade().rotate(270).into(Avatar);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "Awatar nie został dodany"); // zmienic na log
            }
        });

    }

    private void GetProfileDataFromFirebase() {
        // sciaganie i ustawianie danych profilowych z bazy
        DocumentReference usersDocRef = fStore.collection("users").document(fAuth.getCurrentUser().getUid());
        usersDocRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    Username.setText(document.getString("name"));
                    Mail.setText(document.getString("e-mail"));


                    ArrayList<Map<String,String>> animalsArray = (ArrayList<Map<String,String>>) document.get("animals");


                    for (int i=0; i < animalsArray.size(); i++) {
                        Map<String,String> animalsMap = animalsArray.get(i);
                        //Toast.makeText(getApplicationContext(), animalsMap.size()+"", Toast.LENGTH_SHORT).show();
                        if (animalsMap.containsKey("breed"))
                            animalModelList.add(new AnimalModel(animalsMap.get("name"),animalsMap.get("type"),animalsMap.get("breed"),animalsMap.get("weight"),animalsMap.get("date"),animalsMap.get("bio")));
                        else {
                            animalModelList.add(new AnimalModel(animalsMap.get("name"),animalsMap.get("type"),animalsMap.get("weight"),animalsMap.get("date"),animalsMap.get("bio")));
                        }
                    }

                    CountAnimal.setText(CountAnimal.getText() + "" + animalsArray.size());


                } else {
                    Log.i(TAG, "Document onComplete failure - Niepowodzenie spowodowane: ", task.getException());
                }

                recyclerView.setAdapter(recyclerAdapter); // wlozenie listy do recyclerView

                //recyclerAdapter.notifyDataSetChanged();

            }
        });
        // koniec rzeczy zwiazanych z baza
    }


    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}