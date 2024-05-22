package com.example.praktikum3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String username = getIntent().getStringExtra("username");
        int followingCount = getIntent().getIntExtra("followingCount", 0);
        int followerCount = getIntent().getIntExtra("followerCount", 0);
        int profileImageResource = getIntent().getIntExtra("profileImage", R.drawable.zan); // Gunakan gambar profil default jika tidak ada yang diteruskan
        int feedPostId = getIntent().getIntExtra("feedPostId", R.drawable.zan);

        ImageView profileImageView = findViewById(R.id.image_profile);
        TextView usernameTextView = findViewById(R.id.profile_username);
        TextView followingCountTextView = findViewById(R.id.textView_following_count);
        TextView followerCountTextView = findViewById(R.id.textView_follower_count);
        ImageView feedPostIdImageView = findViewById(R.id.feed_post_id);

        profileImageView.setImageResource(profileImageResource);
        usernameTextView.setText(username);
        followingCountTextView.setText(String.valueOf(followingCount));
        followerCountTextView.setText(String.valueOf(followerCount));
        feedPostIdImageView.setImageResource(feedPostId);

        final int position = getIntent().getIntExtra("position", -1);

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageInNewActivity(position);
            }
        });
    }

    private void showImageInNewActivity(int position) {
            UserData userData = DataSource.users.get(position);

            int imagePostStory = userData.getImagePostStory();
            String usernameUser = userData.getUsernameUser();

            int ProfileUser = userData.getProfilUser();

            Intent intent = new Intent(ProfileActivity.this, StoryActivity.class);

            intent.putExtra("imageResource", imagePostStory);
            intent.putExtra("nameStory", usernameUser);
            intent.putExtra("profileImageResource", ProfileUser);

            startActivity(intent);
        }
    }

