package com.example.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Button buttonSave;
    EditText title;
    EditText content;

    String editTitle;
    String editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonSave = findViewById(R.id.buttonSave);
        title = findViewById(R.id.title);
        content = findViewById(R.id.Content);

        buttonSave.setOnClickListener(view -> {
            editTitle = title.getText().toString().trim();
            editContent = content.getText().toString().trim();

            if (editTitle.isEmpty() || editContent.isEmpty()) {
                Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else {
                Intent activity3 = new Intent(MainActivity2.this, MainActivity3.class);
                activity3.putExtra("editNama", getIntent().getStringExtra("editNama"));
                activity3.putExtra("editUsn", getIntent().getStringExtra("editUsn"));
                activity3.putExtra("editTitle", editTitle);
                activity3.putExtra("editContent", editContent);
                /* untuk data gambar dari activity main 1 */
                activity3.putExtra("imageUri", getIntent().getStringExtra("imageUri"));
                startActivity(activity3);
            }
        });
    }

    public String getEditTitle() {
        return editTitle;
    }
    public String getEditContent() {
        return editContent;
    }
}