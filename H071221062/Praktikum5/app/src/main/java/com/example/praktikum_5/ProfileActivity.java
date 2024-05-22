package com.example.praktikum_5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loadingProgressBar = findViewById(R.id.loading_progress);
        loadingProgressBar.setVisibility(View.VISIBLE);
        loadData();
    }

    private void loadData() {
        new Handler().postDelayed(() -> {
            loadingProgressBar.setVisibility(View.GONE);
            showProfileContent();
        }, 500);
    }

    private void showProfileContent() {
        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvUsername = findViewById(R.id.tv_username);

        Intent intent = getIntent();
        Instagram instagram = intent.getParcelableExtra("instagram");

        ivProfile.setImageResource(instagram.getFotoProfile());
        tvName.setText(instagram.getName());
        tvUsername.setText(instagram.getUsername());
    }
}
