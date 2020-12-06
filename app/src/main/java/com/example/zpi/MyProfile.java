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
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyProfile extends AppCompatActivity {

    ImageView IconBack;
    CircleImageView Avatar,AddAvatar;
    TextView Username,Mail,CountAnimal;
    RecyclerView recyclerView;
    ImageButton AddAnimal;
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
        Username = findViewById(R.id.TextViewUsername);
        Mail = findViewById(R.id.TextViewMail);
        CountAnimal = findViewById(R.id.TextViewCountAnimal);
        AddAnimal = findViewById(R.id.ImageButtonAddAnimal);
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

        final String TAG = "MyProfile";
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

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Dashboard.class));
        overridePendingTransition(R.anim.slide_in_left,
                R.anim.slide_out_right);
    }
}