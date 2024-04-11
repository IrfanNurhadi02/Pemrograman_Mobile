package com.example.praktikum3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterFeed adapterFeed;
    private AdapterStory adapterStory;
    private ArrayList<Object> combinedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_story);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapterStory = new AdapterStory(this, DataSource.users);
        recyclerView.setAdapter(adapterStory);

        recyclerView.setHasFixedSize(false);

        RecyclerView recyclerViewFeed = findViewById(R.id.recycler_view_feed);
        LinearLayoutManager layoutManagerFeed = new LinearLayoutManager(this);
        recyclerViewFeed.setLayoutManager(layoutManagerFeed);

        combinedList = new ArrayList<>(DataSource.users);

        adapterFeed = new AdapterFeed(this, combinedList);
        recyclerViewFeed.setAdapter(adapterFeed);
    }
}

