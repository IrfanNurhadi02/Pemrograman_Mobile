package com.example.tugas3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PostinganActivity extends AppCompatActivity {

    private ImageView imageProfile;
    private TextView usnFeed;
    private ImageView imgFeed;
    private TextView likes;
    private TextView usnFeed2;
    private TextView caption;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_postingan);

       Intent intent = getIntent();

       Instagram instagram = intent.getParcelableExtra("instagram");

       imageProfile = findViewById(R.id.profile);
       usnFeed = findViewById(R.id.usnFeed);
       imgFeed = findViewById(R.id.imageFeed);
       likes = findViewById(R.id.likes);
       usnFeed2 = findViewById(R.id.usnFeed2);
       caption = findViewById(R.id.caption);

       imageProfile.setImageResource(instagram.getFotoProfile());
       usnFeed.setText(instagram.getUsername());
       imgFeed.setImageResource(instagram.getFotoPostingan());
       likes.setText(instagram.getLikes());
       usnFeed2.setText(instagram.getUsername());
       caption.setText(String.valueOf(instagram.getCaption()));

   }
}
