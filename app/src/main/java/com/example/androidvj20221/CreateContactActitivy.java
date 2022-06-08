package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidvj20221.dao.ContactDAO;
import com.example.androidvj20221.database.AppDatabase;
import com.example.androidvj20221.entities.Contact;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import java.util.List;

public class CreateContactActitivy extends AppCompatActivity {

    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_actitivy);

        db = AppDatabase.getDatabase(getApplicationContext());
        ContactDAO dao = db.contactDAO();

//        Contact contact = new Contact();
//        contact.name = "Luis Mendoza";
//        contact.number = "99999";
//
//        dao.create(contact);


        List<Contact> contacts = dao.getAll();
        Log.i("APP_VJ20202", new Gson().toJson(contacts));

    }
}