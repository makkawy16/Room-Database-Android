package com.example.roomdatabase.UI.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.data.model.Contact;
import com.example.roomdatabase.databinding.ItemContactLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.viewHolder> {

    private List<Contact> contactList;

    public void addcontacts(List<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    private void insertContact(Contact contact) {
        if(contactList==null)
            contactList =new ArrayList<>();
        contactList.add(contact);
        notifyItemInserted(contactList.size());

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContactLayoutBinding binding =
                ItemContactLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.binding.contactName.setText(contact.getName());
        holder.binding.contactNumber.setText(contact.getPhone());

    }

    @Override
    public int getItemCount() {
        return contactList == null ? 0 : contactList.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {

        ItemContactLayoutBinding binding;

        public viewHolder(@NonNull ItemContactLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
