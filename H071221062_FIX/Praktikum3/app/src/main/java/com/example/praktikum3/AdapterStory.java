package com.example.praktikum3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView; // tambahkan impor untuk TextView
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Intent;
import android.content.Context;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {

    private ArrayList<UserData> storyList;
    private Context context;

    public AdapterStory(Context context, ArrayList<UserData> storyList){
        this.context = context;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public AdapterStory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final UserData story = storyList.get(position);
        holder.usernameUser.setText(story.getUsernameUser());
        holder.imageViewStory.setImageResource(story.getProfilUser());
        holder.imageViewStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageInNewActivity(position);
            }
        });
    }

    private void showImageInNewActivity(int position) {

        UserData userData = storyList.get(position);

        int imagePostStory = userData.getImagePostStory();
        String usernameUser = userData.getUsernameUser();

        int ProfileUser = userData.getProfilUser();

        Intent intent = new Intent(context, StoryActivity.class);

        intent.putExtra("imageResource", imagePostStory);
        intent.putExtra("nameStory", usernameUser);
        intent.putExtra("profileImageResource",ProfileUser);

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewStory;
        private TextView usernameUser; // Ganti ini

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewStory = itemView.findViewById(R.id.imageView_story);
            usernameUser = itemView.findViewById(R.id.Username_User); // Ganti ini
        }
    }

}
