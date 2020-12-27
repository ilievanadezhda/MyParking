package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyReservations extends AppCompatActivity {
    String username;
    String name;
    RecyclerView mRecyclerView;
    myAdapterReservations mAdapter;
    DBHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);
        Intent intent = getIntent();
        username = intent.getStringExtra("Username");
        name = intent.getStringExtra("Name");
        database = new DBHelper(this);
        List<List<String>> values = database.getReservations(username);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewreservations);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new myAdapterReservations(values, R.layout.myrowreservations, username, name, database, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}