package com.example.prak08;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabAdd;
    private RecyclerView rvSearch;
    private TextView tvNoData;
    private SearchView searchView;
    private DBConfig dbConfig;
    private List<Note> notes;
    private NoteAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fabAdd = findViewById(R.id.fab_add);
        rvSearch = findViewById(R.id.rv_search);
        tvNoData = findViewById(R.id.tv_no_data);
        searchView = findViewById(R.id.search);

        dbConfig = new DBConfig(this);

        notes = new ArrayList<>();
        notesAdapter = new NoteAdapter(this, notes);
        rvSearch.setAdapter(notesAdapter);
        rvSearch.setLayoutManager(new GridLayoutManager(this, 1));

        loadData("");

        fabAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateActivity.class);
            startActivity(intent);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                loadData(newText);
                return true;
            }
        });
    }


    // memuat data catatan dari database
    private void loadData(String query) {
        notes.clear();
        Cursor cursor;
        // jika query kosong, maka panggil getAllRecords untuk mendapatkan semua catatan.
        if (query.isEmpty()) {
            cursor = dbConfig.getAllRecords();
        // kalau query ada, memanggil searchByTitle untuk mencari catatan berdasarkan judul.
        } else {
            cursor = dbConfig.searchByTitle(query);
        }

        // mengisi daftar catatan (notes) dengan data dari cursor.
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(dbConfig.getColumnId()));
                String judul = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnJudul()));
                String deskripsi = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnDeskripsi()));
                String createdAt = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnCreatedAt()));
                String updatedAt = cursor.getString(cursor.getColumnIndexOrThrow(dbConfig.getColumnUpdatedAt()));
                notes.add(new Note(id, judul, deskripsi, createdAt, updatedAt));
            } while (cursor.moveToNext());
            cursor.close();
        }

        if (notes.isEmpty()) {
            tvNoData.setVisibility(View.VISIBLE);
            rvSearch.setVisibility(View.GONE);
        } else {
            tvNoData.setVisibility(View.GONE);
            rvSearch.setVisibility(View.VISIBLE);
        }

        notesAdapter.notifyDataSetChanged();
    }

    @Override
    // memuat ulang data catatan
    protected void onResume() {
        super.onResume();
        loadData("");
    }
}