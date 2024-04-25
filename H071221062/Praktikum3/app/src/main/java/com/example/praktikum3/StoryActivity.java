package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StoryActivity extends AppCompatActivity {

    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        int imageResource = getIntent().getIntExtra("imageResource", R.drawable.zan);
        String nameStory = getIntent().getStringExtra("nameStory");
        int profileImageResource = getIntent().getIntExtra("profileImageResource", R.drawable.zan);
        int position = getIntent().getIntExtra("position", 0); // Ambil posisi dari Intent

        ImageView imageView = findViewById(R.id.imageView);
        TextView usernameUser = findViewById(R.id.Username_User);
        ImageView profileImageView = findViewById(R.id.imageView_profile);

        imageView.setImageResource(imageResource);
        usernameUser.setText(nameStory);
        profileImageView.setImageResource(profileImageResource);

        UserData userData = DataSource.users.get(position);

        usernameUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userData.getUsernameUser();
                int followingCount = userData.getFollowingCount();
                int followerCount = userData.getFollowerCount();
                int profileImage = userData.getProfilUser();
                int feedPostId = userData.getFeedImage();

                Intent intent = new Intent(StoryActivity.this, ProfileActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("followingCount", followingCount);
                intent.putExtra("followerCount", followerCount);
                intent.putExtra("profileImage", profileImage);
                intent.putExtra("feedPostId", feedPostId);
                startActivity(intent);
            }
        });
    }
}
