package com.example.androidvj20221.factories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static Retrofit build() {

        return new Retrofit.Builder()
                .baseUrl("https://6284e8e6a48bd3c40b77c234.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
