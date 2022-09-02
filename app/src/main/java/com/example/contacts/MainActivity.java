package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import data.DataHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataHandler handler = new DataHandler(MainActivity.this);
    }
}