package com.example.roomdatabase.data.source.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.data.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("select * from Contact")
    List<Contact> getContacts();

    @Insert
    long addContact(Contact contact);



}
