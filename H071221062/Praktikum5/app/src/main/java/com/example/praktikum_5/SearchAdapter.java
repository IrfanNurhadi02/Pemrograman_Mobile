package com.example.praktikum_5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.praktikum_5.fragment.ProfileFragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private final ArrayList<Instagram> searchs;

    public SearchAdapter(ArrayList<Instagram> searchs) {
        this.searchs = searchs;
    }


    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_result, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        Instagram search = searchs.get(position);

        holder.fullname.setText(search.getName());
        holder.username.setText(search.getUsername());
        holder.profile.setImageResource(search.getFotoProfile());

        // Menambahkan OnClickListener untuk item hasil pencarian
        holder.itemView.setOnClickListener(v -> {
            // Membuat instance dari profil fragment dan mengirimkan data yang diperlukan (jika ada)
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("instagram", search);
            holder.context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return searchs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullname, username;
        ImageView profile;

        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            fullname = itemView.findViewById(R.id.user_fullname);
            username = itemView.findViewById(R.id.user_username);
            profile = itemView.findViewById(R.id.userprofile);
 }
}
}