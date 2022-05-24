package com.example.androidvj20221;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidvj20221.entities.Contact;
import com.example.androidvj20221.factories.RetrofitFactory;
import com.example.androidvj20221.services.ContactService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

//                String message = etMessage.getText().toString();
//                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
//                intent.putExtra("MESSAGE", message);
//                startActivity(intent);

                Retrofit retrofit = RetrofitFactory.build();
                ContactService service = retrofit.create(ContactService.class);

                Contact contact = new Contact();
                contact.name = String.valueOf(etMessage.getText());
                contact.number = "4-576-993-3443";

                Call<Contact> call = service.create(contact);

                call.enqueue(new Callback<Contact>() {
                    @Override
                    public void onResponse(Call<Contact> call, Response<Contact> response) {
                        if (response.isSuccessful()) {
                            Log.i("APP_VJ20202", new Gson().toJson(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<Contact> call, Throwable t) {
                        Log.e("APP_VJ20202", "No nos podemos conectar al servicio web");
                    }
                });

            }
        });
    }
}