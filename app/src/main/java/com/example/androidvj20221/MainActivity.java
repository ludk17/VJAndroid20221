package com.example.androidvj20221;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.example.androidvj20221.adapters.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("APP_VJ20202", "onCreate");
        setContentView(R.layout.activity_main);

        List<String> contacts = getContacts();
        StringAdapter adapter = new StringAdapter(contacts);

        RecyclerView rv = findViewById(R.id.rvContacts);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
    }

    private List<String> getContacts() {
        List<String> contacts = new ArrayList<>();
        contacts.add("Luis Mendoza");
        contacts.add("Lionel Messi");
        contacts.add("Cristiano Ronaldo");
        return contacts;
    }
}