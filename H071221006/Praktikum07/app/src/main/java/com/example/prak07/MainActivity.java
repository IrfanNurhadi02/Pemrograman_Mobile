package com.example.prak07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nimEditText, passwordEditText;
    private Button btn_login, btn_register;
    SharedPreferences sharedPreferences;

    private boolean isValidLogin(String nim, String password) {
        sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        String storedPassword = sharedPreferences.getString("password", "");
        String storedNim = sharedPreferences.getString("nim", "");

        boolean isValid = storedNim.equals(nim) && storedPassword.equals(password);
        if (isValid) {
            saveLoginStatus(true); // Menyimpan status login jika login berhasil
        }
        return isValid;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimEditText = findViewById(R.id.nim);
        passwordEditText = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        checkLoginStatus();



        btn_login.setOnClickListener(view -> {
            String nim = nimEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!nim.isEmpty() && !password.isEmpty()) {
                boolean isValid = isValidLogin(nim, password);
                if (isValid) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Masukkan NIM dan Password dengan benar", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Masukkan NIM dan password", Toast.LENGTH_SHORT).show();
            }
        });




        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


//
        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }


    private void checkLoginStatus() {
        sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void saveLoginStatus(boolean isLoggedIn) {
        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }
}

