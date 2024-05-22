package com.example.tugasprak4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private ClickListener clickListener;
    private final ArrayList<Post> posts;

    public interface ClickListener {
        void onDeleteButtonClicked(Post post);
    }

    public PostAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_post, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post singlePost = posts.get(position);
        holder.imgProfileIv.setImageResource(singlePost.getUser().getProfileImg());
        holder.usernameTv.setText(singlePost.getUser().getUsername());
        holder.nameTv.setText(singlePost.getUser().getName());
        holder.descriptionTv.setText(singlePost.getDescription());
        holder.imgPostIv.setImageURI(singlePost.getImg());

        // Set onClickListeners utk delete
        holder.deleteBtn.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onDeleteButtonClicked(singlePost);
            }
        });

        holder.imgProfileIv.setOnClickListener(v -> {
            if (position != RecyclerView.NO_POSITION && posts != null && position < posts.size()) {
                Post post = posts.get(position);
                User user = post.getUser();
                if (user != null) {
                    Intent intent = new Intent(holder.context, ProfileActivity.class);
                    intent.putExtra("user", user);
                    holder.context.startActivity(intent);
                }
            }
        });

        holder.usernameTv.setOnClickListener(v -> {
            if (position != RecyclerView.NO_POSITION && posts != null && position < posts.size()) {
                Post post = posts.get(position);
                User user = post.getUser();
                if (user != null) {
                    Intent intent = new Intent(holder.context, ProfileActivity.class);
                    intent.putExtra("user", user);
                    holder.context.startActivity(intent);
                }
            }
        });

        holder.nameTv.setOnClickListener(v -> {
            if (position != RecyclerView.NO_POSITION && posts != null && position < posts.size()) {
                Post post = posts.get(position);
                User user = post.getUser();
                if (user != null) {
                    Intent intent = new Intent(holder.context, ProfileActivity.class);
                    intent.putExtra("user", user);
                    holder.context.startActivity(intent);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context context;
        ImageButton deleteBtn;
        TextView descriptionTv;
        ImageView imgPostIv;
        ImageView imgProfileIv;
        TextView nameTv;
        LinearLayout profileContainer;
        TextView usernameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProfileIv = itemView.findViewById(R.id.image_view);
            imgPostIv = itemView.findViewById(R.id.image_view2);
            usernameTv = itemView.findViewById(R.id.text_view1);
            nameTv = itemView.findViewById(R.id.text_view2);
            descriptionTv = itemView.findViewById(R.id.text_view3);
            deleteBtn = itemView.findViewById(R.id.image_button_trash);
            profileContainer = itemView.findViewById(R.id.linear_layout1);
            context = itemView.getContext();
        }
    }
}
