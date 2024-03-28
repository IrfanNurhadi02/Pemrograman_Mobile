package com.example.praktikum2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;


public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textViewFromActivity1 = findViewById(R.id.textViewFromActivity1);
        TextView textViewFromActivity2 = findViewById(R.id.textViewFromActivity2);

        String nama = getIntent().getStringExtra("nama");
        String username = getIntent().getStringExtra("username");
        String imageUri = getIntent().getStringExtra("imageUri");
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        imageView.setImageURI(Uri.parse(imageUri));
        textViewFromActivity1.setText("Nama: " + nama + "\nUsername: " + username);
        textViewFromActivity2.setText("Title: " + title + "\nContent: " + content);
    }
}
