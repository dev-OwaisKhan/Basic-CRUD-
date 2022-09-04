package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import data.DataHandler;
import modle.Contact;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;
    String name_text, phone_text;
    Button add,show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHandler handler = new DataHandler(MainActivity.this);


        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        add = findViewById(R.id.add_button);
        show = findViewById(R.id.get_contact);

        Contact obj = new Contact();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_text = name.getText().toString();
                phone_text = phone.getText().toString();
                obj.setName(name_text);
                obj.setPhone(phone_text);
                handler.addcontact(obj);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Contact> allcontant = handler.allcontacts();
                for (Contact contact : allcontant)
                {
                    Log.d("owais","id" +contact.getId()+"\n"+
                            "name" +contact.getName()+ "\n"+
                            "phone" +contact.getPhone());
                }
            }
        });
    }

}