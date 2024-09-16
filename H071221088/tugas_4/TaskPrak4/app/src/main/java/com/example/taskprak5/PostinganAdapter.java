package com.example.taskprak5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Instagram instagram1 = instagrams.get(position);

        holder.TV_Username.setText(instagram1.getUsername());
        holder.TV_Name.setText(instagram1.getName());
        holder.TV_Desc.setText(instagram1.getDesc());
        holder.IV_FotoProfile.setImageResource(instagram1.getFotoProfile());
        holder.IV_FotoPostingan.setImageResource(instagram1.getFotoPostingan());
        holder.IV_Feed.setImageURI(instagram1.getSelectedImageUri());

        holder.IV_FotoProfile.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("instagram", instagram1);
            holder.context.startActivity(intent);
        });

        holder.TV_Name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("instagram", instagram1);
            holder.context.startActivity(intent);
        });
        holder.TV_Username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("instagram", instagram1);
            holder.context.startActivity(intent);
        });
        holder.IV_Delete.setOnClickListener(v ->
                showDeleteConfirmationDialog(holder.context, position));
    }

    private void showDeleteConfirmationDialog(Context context, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Konfirmasi");
        builder.setMessage("Apakah Anda yakin ingin menghapus postingan ini?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Instagram.deleteInstagram(instagrams, position);
                notifyItemRemoved(position);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return instagrams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TV_Username, TV_Name, TV_Desc;
        ImageView IV_FotoProfile, IV_FotoPostingan, IV_Feed, IV_Delete;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_Username = itemView.findViewById(R.id.TV_Username);
            TV_Name = itemView.findViewById(R.id.TV_Name);
            TV_Desc = itemView.findViewById(R.id.TV_Desc);
            IV_FotoProfile = itemView.findViewById(R.id.IV_Profile);
            IV_FotoPostingan = itemView.findViewById(R.id.IV_Postingan);
            IV_Feed = itemView.findViewById(R.id.IV_Postingan);
            IV_Delete = itemView.findViewById(R.id.IV_Delete);
            context = itemView.getContext();
        }
    }
}
