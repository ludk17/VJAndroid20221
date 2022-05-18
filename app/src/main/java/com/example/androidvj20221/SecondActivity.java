package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = findViewById(R.id.btnRun);
        EditText etMessage = findViewById(R.id.etMessage);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = etMessage.getText().toString();

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);

                intent.putExtra("MESSAGE", message);

                startActivity(intent);
            }
        });
    }
}