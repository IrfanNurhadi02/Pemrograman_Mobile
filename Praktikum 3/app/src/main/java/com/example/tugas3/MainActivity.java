package com.example.tugas3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView feeds = findViewById(R.id.feeds);
        feeds.setHasFixedSize(true);

        PostinganAdapter postinganAdapter = new PostinganAdapter(DataSource.instagrams);
        feeds.setAdapter(postinganAdapter);

        RecyclerView storiesBar = findViewById(R.id.storiesBar);
        storiesBar.setHasFixedSize(true);

        StoryAdapter storyAdapter = new StoryAdapter(DataSource.instagrams);
        storiesBar.setAdapter(storyAdapter);

    }
}