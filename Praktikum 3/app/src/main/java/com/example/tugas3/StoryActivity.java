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

public class StoryActivity extends AppCompatActivity {
    private ImageView storyProfile;
    private TextView storyUsn;
    private ImageView imageStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();

        Instagram instagram = intent.getParcelableExtra("instagram");

        storyProfile = findViewById(R.id.storyProfile);
        storyUsn = findViewById(R.id.storyUsn);
        imageStory = findViewById(R.id.imageStory);

        storyProfile.setImageResource(instagram.getFotoProfile());
        storyUsn.setText(instagram.getUsername());
        imageStory.setImageResource(instagram.getFotoStory());

        storyUsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this, ProfileActivity.class);
                intent.putExtra("instagram", instagram);
                startActivity(intent);
            }
        });
    }
}