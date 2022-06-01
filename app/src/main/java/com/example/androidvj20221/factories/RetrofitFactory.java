package com.example.androidvj20221.factories;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static Retrofit build(Context context) {

        SharedPreferences mSharedPref = context.getSharedPreferences("com.example.androidvj20221.SHARED_PREFERENCES", Context.MODE_PRIVATE);
        String token = mSharedPref.getString("com.example.androidvj20221.TOKEN", "");

        return new Retrofit.Builder()
//                .baseUrl("https://6284e8e6a48bd3c40b77c234.mockapi.io/api/v1/")
                .baseUrl("https://webhook.site/")
                .client(getClient(token))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    private static OkHttpClient getClient(String token) {
        OkHttpClient httpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.header("Content-Type", "application/json");
                requestBuilder.header("Authorization", "Bearer " + token);
//                requestBuilder.header("X-Amz-Content-Sha256", "");
                return chain.proceed(requestBuilder.build());
            }
        }).build();


        return httpClient;
    }
}
