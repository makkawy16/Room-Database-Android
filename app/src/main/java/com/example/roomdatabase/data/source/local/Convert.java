package com.example.roomdatabase.data.source.local;

import androidx.room.TypeConverter;

import com.example.roomdatabase.data.model.Department;
import com.google.gson.Gson;

public class Convert {

    @TypeConverter
    public String toGson(Department department){
        Gson gson = new Gson();
        return gson.toJson(department);
    }

    @TypeConverter
    public Department fromGson(String json){
        Gson gson = new Gson();
        return  gson.fromJson(json ,Department.class );
    }

}
