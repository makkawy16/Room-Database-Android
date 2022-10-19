package com.example.roomdatabase.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomdatabase.data.model.Contact;
import com.example.roomdatabase.data.source.local.ContactDatabase;
import com.example.roomdatabase.databinding.ActivityAddContactBinding;


public class AddContact extends AppCompatActivity {
    ActivityAddContactBinding binding;
    private String name , phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addContact(binding.name.getText().toString().trim()
                        ,binding.number.getText().toString().trim());
            }
        });

    }

    private void addContact(String name , String phone){
        if(!name.isEmpty() && !phone.isEmpty()){
            long num = ContactDatabase.getContactDatabase(this)
                    .getContactDao().addContact(new Contact(name, phone));

            if(num != -1 )
                startActivity(new Intent(this,MainActivity.class)); // dh msh sah al mafrod astkhkdm live data w akhleh y3rdha
                //lw y3ny hasl ay update ysm3 3andy 3la tol
                finish();

        }

        else
            alertDialog("Error Message","all fields require");

    }
    private void alertDialog(String title ,String msg){

        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(msg);
        dialog.setTitle(title);
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();


    }

}