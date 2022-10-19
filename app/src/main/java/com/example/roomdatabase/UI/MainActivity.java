package com.example.roomdatabase.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.UI.adapter.ContactAdapter;
import com.example.roomdatabase.data.model.Contact;
import com.example.roomdatabase.data.source.local.ContactDatabase;
import com.example.roomdatabase.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddContact.class));
                finish();
            }
        });
        initRecycler();
        fetchContacts();


    }

    private void fetchContacts() {
        List<Contact> contacts = ContactDatabase.getContactDatabase(this)
                .getContactDao()
                .getContacts();
        if (contacts != null)
            contactAdapter.addcontacts(contacts);

    }

    private void initRecycler() {
        contactAdapter = new ContactAdapter();
        binding.contactRecycler.setAdapter(contactAdapter);
        binding.contactRecycler.setLayoutManager(new LinearLayoutManager(this));

    }
}