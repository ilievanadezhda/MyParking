package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class Cities extends AppCompatActivity {
    public static String name;
    public static String username;
    TextView message;

    RecyclerView mRecyclerView;
    myAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        Intent intent = getIntent();
        name = intent.getStringExtra("Ime");
        username = intent.getStringExtra("KorisnichkoIme");
        message = (TextView) findViewById(R.id.welcomeuser);
        message.setText("Добредојде " + name + "! Каде ќе паркираме денес?");

        List<String> values = Arrays.asList("Скопје", "Велес", "Куманово",
                "Прилеп", "Битола", "Штип", "Тетово", "Гостивар",
                "Струмица", "Охрид");

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new myAdapter(values, R.layout.myrow, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static String getName() {
        return name;
    }
    public static String getUsername() {
        return username;
    }
}