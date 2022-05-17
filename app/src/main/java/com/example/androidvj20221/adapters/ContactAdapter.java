package com.example.androidvj20221.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidvj20221.R;
import com.example.androidvj20221.entities.Contact;

import java.util.List;

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
        Contact contact = contacts.get(position);
        TextView tvContactName = vh.itemView.findViewById(R.id.tvContactName);
        TextView tvContactNumber = vh.itemView.findViewById(R.id.tvContactNumber);

        tvContactName.setText(contact.name);
        tvContactNumber.setText(contact.number);

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
