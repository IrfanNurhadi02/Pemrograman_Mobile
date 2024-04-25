package com.example.praktikum2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextContent;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextContent = findViewById(R.id.edit_text_content);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString().trim();
                String content = editTextContent.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Harap isi semua bidang teks", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    intent.putExtra("nama", getIntent().getStringExtra("nama"));
                    intent.putExtra("username", getIntent().getStringExtra("username"));
                    intent.putExtra("imageUri", getIntent().getStringExtra("imageUri"));
                    intent.putExtra("title", title);
                    intent.putExtra("content", content);
                    startActivity(intent);
                }
            }
        });
    }
}
