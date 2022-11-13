package com.example.roomdatabase.data.source.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomdatabase.data.model.Contact;
import com.example.roomdatabase.data.model.Department;

@Database(entities = {Contact.class}, version = 5  , exportSchema = false )
@TypeConverters(Convert.class)

public abstract class ContactDatabase extends RoomDatabase {

    private static final String CONTACT_DB = "contact_DB";

    public abstract ContactDao getContactDao();

    private static ContactDatabase contactDatabase;

    public static ContactDatabase getContactDatabase(Context context) {
        if (contactDatabase == null)
            contactDatabase = Room.databaseBuilder(context, ContactDatabase.class, CONTACT_DB)
                    .allowMainThreadQueries()  //3shan yshtghl fl main thread  default byshtghl f backgrond thread
                    .addMigrations(new Migration(4,5) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {

                        }
                    })
                    .build();
        return contactDatabase;
    }


}
