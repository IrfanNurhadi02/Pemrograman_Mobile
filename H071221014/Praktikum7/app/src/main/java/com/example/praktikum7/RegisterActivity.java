package com.example.praktikum7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.praktikum7.R;

public class RegisterActivity extends AppCompatActivity {

    EditText et_nim, et_password;
    TextView cta_login;
    Button btn_register, btn_setting;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_nim = findViewById(R.id.et_nimRegister);
        et_password = findViewById(R.id.et_passwordResgister);
        btn_register = findViewById(R.id.btn_register2);
        btn_setting = findViewById(R.id.btn_setting);
        cta_login = findViewById(R.id.cta_login);

        btn_register.setOnClickListener(view -> {
            String nim = String.valueOf(et_nim.getText());
            String password = String.valueOf(et_password.getText());

            if (!nim.isEmpty() && !password.isEmpty()) {
                // Menghapus semua data registrasi yang ada
                sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear(); // Menghapus semua data
                editor.apply();

                // Menyimpan data registrasi baru
                editor.putString("nim", nim);
                editor.putString("password", password);
                editor.apply();

                Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(RegisterActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        cta_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}