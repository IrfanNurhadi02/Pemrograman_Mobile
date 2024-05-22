package com.example.prak07;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class RegisterActivity extends AppCompatActivity {

    EditText et_nim, et_password;
    Button btn_register;
    SharedPreferences sharedPreferences;


    private void saveUser(String nim, String password) {
        sharedPreferences = getSharedPreferences("user_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simpan akun pengguna dalam SharedPreferences
        editor.putString("nim", nim);
        editor.putString("password", password);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();

        Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
        finish();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_nim = findViewById(R.id.nim);
        et_password = findViewById(R.id.password);
        btn_register = findViewById(R.id.btn_register);



        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = et_nim.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                if (!nim.isEmpty() && !password.isEmpty()) {
                    saveUser(nim, password);
                } else {
                    Toast.makeText(RegisterActivity.this, "Please enter NIM and password", Toast.LENGTH_SHORT).show();
                }
            }
        });




//        sharedPreferences = getSharedPreferences("theme_pref", MODE_PRIVATE);
//        boolean isDarkTheme = sharedPreferences.getBoolean("is_dark_theme", false);
//        if (isDarkTheme) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }
    }



}
