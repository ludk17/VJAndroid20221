package com.example.androidvj20221.services;

import com.example.androidvj20221.entities.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactService {
    @GET("/v3/2a80c7b5-f304-40de-8640-f06ce308331f")
    Call<List<Contact>> GetContacts();
}
