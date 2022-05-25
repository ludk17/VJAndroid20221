package com.example.androidvj20221.adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidvj20221.ContactActivity;
import com.example.androidvj20221.R;
import com.example.androidvj20221.entities.Contact;
import com.example.androidvj20221.factories.RetrofitFactory;
import com.example.androidvj20221.services.ContactService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<Contact> contacts;
    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder vh, int position) {

        View itemView = vh.itemView;

        Contact contact = contacts.get(position);
        TextView tvContactName = itemView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = itemView.findViewById(R.id.tvContactNumber);
        ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar );

        tvContactName.setText(contact.name);
        tvContactNumber.setText(contact.number);
        Picasso.get().load("https://loremflickr.com/cache/resized/5238_30052482366_fc6e9350d5_b_640_480_nofilter.jpg").into(ivAvatar);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), ContactActivity.class);

                String contactJSON = new Gson().toJson(contact);
                intent.putExtra("CONTACT", contactJSON);

                itemView.getContext().startActivity(intent);
            }
        });

    }

    private void removeItem(int position) {
        Contact contact = contacts.get(position);

        Retrofit retrofit = RetrofitFactory.build();
        ContactService service = retrofit.create(ContactService.class);

        Call<Contact> call = service.delete(contact.id);

        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                if (response.isSuccessful()) {
                    Log.i("APP_VJ20202", "Se elimino correctamente al contacto " + contact.id);
                    contacts.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, contacts.size());

                } else {
                    Log.e("APP_VJ20202", "No se pudo eliminar el contacto");
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.e("APP_VJ20202", "No nos podemos conectar al servicio web");
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Contact contact = contacts.get(i);
            Log.i("APP_VJ20202", "click en el elemento" + contact.id);
        }
    }
}
