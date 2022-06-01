package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BasicLoginActivity extends AppCompatActivity {

    SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_login);

        mSharedPref = getSharedPreferences("com.example.androidvj20221.SHARED_PREFERENCES", Context.MODE_PRIVATE);

        String token = mSharedPref.getString("com.example.androidvj20221.TOKEN", "");

        if (!token.equals("")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }


        EditText editUsername = findViewById(R.id.editUsername);
        EditText editPassword = findViewById(R.id.editPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // verifircar si el usuario y contraseña es correcta
                String token = "ABCDBLADLASLALSJAADKJJDHKSJDHKS";
                // guardar un valor en shared preferences

                SharedPreferences.Editor prefEditor = mSharedPref.edit();
                prefEditor.putString("com.example.androidvj20221.TOKEN", token);
                prefEditor.apply();

                Log.i("APP_VJ20202", "preferencias guardada correctamente");

            }
        });

    }
}