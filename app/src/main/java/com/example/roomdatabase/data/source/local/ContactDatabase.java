package com.example.roomdatabase.data.source.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.data.model.Contact;

@Database(entities = {Contact.class}, version = 1, exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {

    private static final String CONTACT_DB = "contact_DB";

    public abstract ContactDao getContactDao();

    private static ContactDatabase contactDatabase;

    public static ContactDatabase getContactDatabase(Context context) {
        if (contactDatabase == null)
            contactDatabase = Room.databaseBuilder(context, ContactDatabase.class, CONTACT_DB)
                    .allowMainThreadQueries()  //3shan yshtghl fl main thread  default byshtghl f backgrond thread
                    .build();
        return contactDatabase;
    }


}
