package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.DataHandler;
import modle.Contact;

public class MainActivity extends AppCompatActivity {

    EditText name, phone;
    String name_text, phone_text;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataHandler handler = new DataHandler(MainActivity.this);
        Contact obj = new Contact();

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        add = findViewById(R.id.add_button);

        name_text = name.getText().toString();
        phone_text = phone.getText().toString();


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obj.setName(name_text);
                obj.setPhone(phone_text);
                handler.addcontact(obj);
            }
        });
    }
}