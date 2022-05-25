package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidvj20221.entities.Contact;
import com.example.androidvj20221.factories.RetrofitFactory;
import com.example.androidvj20221.services.ContactService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        String contactJson = getIntent().getStringExtra("CONTACT");
        Contact contact = new Gson().fromJson(contactJson, Contact.class);

        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvContactName);
        TextView tvNumber = findViewById(R.id.tvContactNumber);

        Picasso.get().load("https://loremflickr.com/cache/resized/5238_30052482366_fc6e9350d5_b_640_480_nofilter.jpg").into(ivAvatar);
        tvName.setText(contact.name);
        tvNumber.setText(contact.number);

    }
}