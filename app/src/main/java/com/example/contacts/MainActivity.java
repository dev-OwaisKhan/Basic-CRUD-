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

    /** declaring all the variables*/
    EditText name, phone,id;
    String name_text, phone_text;
    int id_text,rows;
    Button add,show,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**An object of the DataHandler class to perform all the Database Operations*/
        DataHandler handler = new DataHandler(MainActivity.this);

        /** Object of Contact type to Store the relative data*/
        Contact obj = new Contact();

        /** Initialising all the variables */
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        id = findViewById(R.id.id);
        add = findViewById(R.id.add_button);
        show = findViewById(R.id.get_contact);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        /** Button to add data to the database */
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

        /**Button to retrieve the stored data*/
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Contact> allcontant = handler.allcontacts();
                for (Contact contact : allcontant)
                {
                    // Log Message
                    Log.d("owais","id" +contact.getId()+"\n"+
                            "Name " +contact.getName()+ "\n"+
                            "Phone Number " +contact.getPhone());
                }
            }
        });

        /** Button to update the data (using primary key)
        primary key is something that is unique for every entry in the base*/
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_text = name.getText().toString();
                phone_text = phone.getText().toString();
                id_text = Integer.parseInt(id.getText().toString());
                obj.setName(name_text);
                obj.setPhone(phone_text);
                obj.setId(id_text);
                rows = handler.updatecontact(obj);
                //Log Message
                Log.d("Owais ", "Updated rows = "+rows);

            }
        });

        /** Button to delete the data (using primary key)*/
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_text = Integer.parseInt(id.getText().toString());
                handler.deletecontact(id_text);

            }
        });


    }

}