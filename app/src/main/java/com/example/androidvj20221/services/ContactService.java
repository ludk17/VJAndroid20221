package com.example.androidvj20221.services;

import com.example.androidvj20221.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContactService {
    @GET("contacts")
    Call<List<Contact>> getContacts();

    // contacts/:id
    @GET("contacts/{id}")
    Call<Contact> findContact(@Path("id") int id);
}
