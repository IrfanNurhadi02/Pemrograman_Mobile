package com.example.tugasprak4;

import static com.example.tugasprak4.DataSource.user;

import android.content.Intent;
import android.os.Bundle;
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

        ImageView profile = findViewById(R.id.image_profile);
        TextView fullname = findViewById(R.id.text_fullname);
        TextView username = findViewById(R.id.text_username);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra("user");

        if (user != null) {
            profile.setImageResource(user.getProfileImg());
            fullname.setText(user.getUsername());
            username.setText(user.getName());
        }
    }
}