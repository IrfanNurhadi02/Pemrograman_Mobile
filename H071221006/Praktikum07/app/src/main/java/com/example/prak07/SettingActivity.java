package com.example.prak07;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
public class SettingActivity extends AppCompatActivity {

    Switch themeSwitch;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        themeSwitch = findViewById(R.id.theme);

        // Mendapatkan status tema yang tersimpan di SharedPreferences
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);

        // Menyesuaikan posisi switch sesuai dengan status tema yang tersimpan
        themeSwitch.setChecked(isDarkTheme);

        // Menambahkan listener untuk switch
        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Menyimpan status tema yang dipilih ke SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("is_dark_theme", isChecked);
                editor.apply();

                // Mengatur tema aplikasi sesuai dengan pilihan pengguna
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }
}
