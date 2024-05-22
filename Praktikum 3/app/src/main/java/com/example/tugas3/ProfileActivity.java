package com.example.tugas3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView imageProfile;
        TextView usnProfile;
        TextView followersCount;
        TextView followingCount;
        ImageView imagePosts;

        Intent intent = getIntent();

        Instagram instagram = intent.getParcelableExtra("instagram");

        imageProfile = findViewById(R.id.imageProfile);
        usnProfile = findViewById(R.id.usnProfile);
        followersCount = findViewById(R.id.followersCount);
        followingCount = findViewById(R.id.followingCount);
        imagePosts = findViewById(R.id.imagePosts);

        imageProfile.setImageResource(instagram.getFotoProfile());
        usnProfile.setText(instagram.getUsername());
        followersCount.setText(String.valueOf(instagram.getFollowers()));
        followingCount.setText(String.valueOf(instagram.getFollowing()));
        imagePosts.setImageResource(instagram.getFotoPostingan());


        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, StoryActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });

        imagePosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, PostinganActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });
    }
}