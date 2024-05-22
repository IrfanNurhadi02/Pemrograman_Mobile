package com.example.tugas2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    TextView ambilNama;
    TextView ambilUsn;
    TextView ambilTitle;
    TextView ambilContent;
    ImageView ambilFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ambilNama = findViewById(R.id.ambilNama);
        ambilUsn = findViewById(R.id.ambilUsn);
        ambilTitle = findViewById(R.id.ambilTitle);
        ambilContent = findViewById(R.id.ambilContent);
        ambilFoto = findViewById(R.id.ambilfoto);

        String nama = getIntent().getStringExtra("editNama");
        String usn = getIntent().getStringExtra("editUsn");
        String title = getIntent().getStringExtra("editTitle");
        String content = getIntent().getStringExtra("editContent");
        String imageUriString = getIntent().getStringExtra("imageUri");

        ambilNama.setText(nama);
        ambilUsn.setText(usn);
        ambilTitle.setText(title);
        ambilContent.setText(content);
        Uri imageUri = Uri.parse(imageUriString);
        ambilFoto.setImageURI(imageUri);
    }
}