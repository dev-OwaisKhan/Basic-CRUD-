package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import data.DataHandler;
import modle.Contact;

public class List_show extends AppCompatActivity {

    /* Object of DataHandler class*/
    DataHandler handler = new DataHandler(List_show.this);

    /* ArrayList to store all the contacts as String*/
    ArrayList<String> contacts = new ArrayList<>();

    /* ListView */
    ListView ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_show);

        /* Initializing the listView*/
        ls = findViewById(R.id.list);

        List<Contact> all_contact = handler.all_contacts();
        for (Contact contact : all_contact)
        {
           contacts.add(contact.getName()+"   "+contact.getPhone());
        }

        /* Setting the array adapter*/
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        ls.setAdapter(arrayAdapter);
    }
}