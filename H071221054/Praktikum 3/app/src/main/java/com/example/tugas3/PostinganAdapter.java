package com.example.tugas3;

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

public class PostinganAdapter extends RecyclerView.Adapter<PostinganAdapter.ViewHolder> {

    private ArrayList<Instagram> instagrams;

    public PostinganAdapter(ArrayList<Instagram> instagrams) {
        this.instagrams = instagrams;
    }

    @NonNull
    @Override
    public PostinganAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostinganAdapter.ViewHolder holder, int position) {
        Instagram instagram = instagrams.get(position);

        holder.imageProfile.setImageResource(instagram.getFotoProfile());
        holder.usnFeed.setText(instagram.getUsername());
        holder.imgFeed.setImageResource(instagram.getFotoPostingan());
        holder.likes.setText(instagram.getLikes());
        holder.usnFeed2.setText(instagram.getUsername());
        holder.caption.setText(instagram.getCaption());

        holder.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, StoryActivity.class);
                intent.putExtra("instagram", instagram);
                holder.context.startActivity(intent);
            }
        });

        holder.usnFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, ProfileActivity.class);
                intent.putExtra("instagram", instagram);
                holder.context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return instagrams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         ImageView imageProfile;
         TextView usnFeed;
         ImageView imgFeed;
         TextView likes;
         TextView usnFeed2;
         TextView caption;
         Context context;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             imageProfile = itemView.findViewById(R.id.profile);
             usnFeed = itemView.findViewById(R.id.usnFeed);
             imgFeed = itemView.findViewById(R.id.imageFeed);
             likes = itemView.findViewById(R.id.likes);
             usnFeed2 = itemView.findViewById(R.id.usnFeed2);
             caption = itemView.findViewById(R.id.caption);
             context = itemView.getContext();
         }
    }

}
