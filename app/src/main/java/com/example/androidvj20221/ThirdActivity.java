package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");

        TextView tvMessage = findViewById(R.id.tvMessage);
        tvMessage.setText(message);

    }
}