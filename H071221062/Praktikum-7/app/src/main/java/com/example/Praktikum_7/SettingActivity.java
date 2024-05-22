package com.example.Praktikum_7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SettingActivity extends AppCompatActivity {

    Switch sw_tema;
    SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sw_tema = findViewById(R.id.sw_tema);
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        sw_tema.setChecked(isDarkTheme);

        sw_tema.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                setDarkTheme();
            } else {
                setLightTheme();
            }
            editor.putBoolean("is_dark_theme", isChecked);
            editor.apply();
        });

        if (!isDarkTheme) {
            setLightTheme();
        }
    }

    private void setDarkTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        sw_tema.setText("Light Mode");
    }

    private void setLightTheme() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        sw_tema.setText("Light Mode");
    }
}
