package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {
    SQLiteDatabase database;
    TextView reservationMessage;
    Spinner timeSlots;
    DatePicker datePicker;

    String selectedCity;
    String selectedTimeSlot;
    String selectedDate;
    int selectedDay;
    int selectedMonth;
    int selectedYear;
    String name;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Fragment frag1 =  getFragmentManager().findFragmentById(R.id.fragment1);
        Fragment frag2 =  getFragmentManager().findFragmentById(R.id.fragment2);

        database = openOrCreateDatabase("Reservations", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS Reservations(username VARCHAR, city VARCHAR, date VARCHAR, time VARCHAR);");

        Intent intent = getIntent();
        selectedCity = intent.getStringExtra("ImeGrad");
        name = Cities.getName();
        username = Cities.getUsername();

        timeSlots = (Spinner) findViewById(R.id.timeslots);
        reservationMessage = (TextView) findViewById(R.id.reservationmessage);
        datePicker = (DatePicker) findViewById(R.id.datePicker);

        reservationMessage.setText("Добар избор " + name +"! Ајде да резервираме паркинг во " + selectedCity + "!");
    }

    public void placeReservation(View view) {
        selectedTimeSlot = timeSlots.getSelectedItem().toString();
        selectedDay = datePicker.getDayOfMonth();
        selectedMonth = datePicker.getMonth() + 1;
        selectedYear = datePicker.getYear();
        selectedDate = selectedDay + "/" + selectedMonth + "/" + selectedYear;
        database.execSQL("INSERT INTO Reservations VALUES('" + username + "', '" + selectedCity + "', '" + selectedDay + "', '" + selectedTimeSlot + "' );");
        Toast.makeText(this, "Успешно додадена резервација!", Toast.LENGTH_LONG).show();
    }
}