package com.example.tugasprak4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class HomeFragment extends Fragment implements PostAdapter.ClickListener {
    public static String EXTRA_POST = "extra_post";
    private TextView noDataTv;
    PostAdapter postAdapter;
    private RecyclerView postRecyclerView;
    private ArrayList<Post> posts = new ArrayList<>();



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!(getActivity() == null || ((AppCompatActivity) getActivity()).getSupportActionBar() == null)) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");
        }

        this.postRecyclerView = view.findViewById(R.id.recyclerView);
        this.noDataTv = view.findViewById(R.id.textViewNoPosts);
        this.posts = DataSource.posts;
        this.postAdapter = new PostAdapter(this.posts, getActivity());
        this.postAdapter.setOnClickListener(this);
        if (getArguments() != null) {
            this.posts.add(0, getArguments().getParcelable(EXTRA_POST));
            Toast.makeText(getActivity(), "Post Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                mainActivity.isActiveHomeMenu(true);
                mainActivity.isActivePostMenu(false);
                mainActivity.isActiveProfileMenu(false);
            }
        }
        checkDataEmpty();
        this.postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.postRecyclerView.setHasFixedSize(true);
        this.postRecyclerView.setAdapter(this.postAdapter);
    }

    // Method dialog konfirmasi
    private void confirmDelete(Post post) {
        ConfirmDialogFragment confirmDialogFragment = new ConfirmDialogFragment();
        confirmDialogFragment.show(getChildFragmentManager(), ConfirmDialogFragment.class.getSimpleName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("post", post);
        confirmDialogFragment.setArguments(bundle);
        confirmDialogFragment.setOnClickDeleteButtonListener(new ConfirmDialogFragment.DialogListener() {
            @Override
            public void setOnClickDeleteButton() {
                deletePost(post);
            }
        });
    }

    // Method utk hapus post
    private void deletePost(Post post) {
        posts.remove(post);
        postAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(), "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
        checkDataEmpty();
    }

    // Method utk cek jika datanya itu kosong dan kemudian di update
    private void checkDataEmpty() {
        if (posts.isEmpty()) {
            noDataTv.setVisibility(View.VISIBLE);
        } else {
            noDataTv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDeleteButtonClicked(Post post) {
        confirmDelete(post);
    }
}

