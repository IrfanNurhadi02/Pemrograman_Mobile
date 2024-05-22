package com.example.praktikum3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFeed extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> dataList;
    private Context context;

    public AdapterFeed(Context context, ArrayList<Object> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public AdapterFeed.FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Object item = dataList.get(position);
        if (holder instanceof StoryViewHolder && item instanceof UserData) {
            UserData story = (UserData) item;
            ((StoryViewHolder) holder).imageViewStory.setImageResource(story.getProfilUser());
            ((StoryViewHolder) holder).usernameUser.setText(story.getUsernameUser());
        } else if (holder instanceof FeedViewHolder && item instanceof UserData) {
            UserData feed = (UserData) item;
            ((FeedViewHolder) holder).profilUser.setImageResource(feed.getProfilUser());
            ((FeedViewHolder) holder).feedImage.setImageResource(feed.getFeedImage());
            ((FeedViewHolder) holder).usernameUser.setText(feed.getUsernameUser());
            ((FeedViewHolder) holder).feedCaption.setText(feed.getCaption());
            ((FeedViewHolder) holder).usernameUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showProfile(position);
                }
            });
        }
    }

    private void showProfile(int position) {
        UserData userData = DataSource.users.get(position);
        String username = userData.getUsernameUser();
        int followingCount = userData.getFollowingCount();
        int followerCount = userData.getFollowerCount();
        int profileImage = userData.getProfilUser();
        int feedPostId = userData.getFeedImage();
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("followingCount", followingCount);
        intent.putExtra("followerCount", followerCount);
        intent.putExtra("profileImage", profileImage);
        intent.putExtra("feedPostId", feedPostId);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class StoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewStory;
        private TextView usernameUser;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewStory = itemView.findViewById(R.id.imageView_story);
            usernameUser = itemView.findViewById(R.id.Username_User);
        }
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView profilUser;
        private TextView usernameUser;
        private ImageView feedImage;
        private TextView feedCaption;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            profilUser = itemView.findViewById(R.id.Profil_feed);
            usernameUser = itemView.findViewById(R.id.Username_Feed);
            feedImage = itemView.findViewById(R.id.feedImage);
            feedCaption = itemView.findViewById(R.id.caption_Feed);
        }
    }
}
