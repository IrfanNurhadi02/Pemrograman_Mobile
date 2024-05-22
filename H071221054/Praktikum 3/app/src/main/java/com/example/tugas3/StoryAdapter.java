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

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {

    private ArrayList<Instagram> instagrams;

    public StoryAdapter(ArrayList<Instagram> instagrams) {
        this.instagrams = instagrams;
    }

    @NonNull
    @Override
    public StoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.ViewHolder holder, int position) {
        Instagram instagram = instagrams.get(position);

        holder.imageStoryProfile.setImageResource(instagram.getFotoProfile());
        holder.usn.setText(instagram.getUsername());

        holder.imageStoryProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, StoryActivity.class);
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

        ImageView imageStoryProfile;
        TextView usn;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageStoryProfile = itemView.findViewById(R.id.imageStoryProfile);
            usn = itemView.findViewById(R.id.usn);
            context = itemView.getContext();

        }
    }
}

