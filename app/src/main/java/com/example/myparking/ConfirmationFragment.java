package com.example.myparking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmationFragment extends Fragment {
    TextView confirmationMessage;
    Button home;
    Button navigate;
    Button qr;

    String selectedParking;
    String selectedTimeSlot;
    String selectedDate;
    String username;
    String name;
    DBHelper database;
    float lat;
    float lng;

    public ConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Intent intent = getActivity().getIntent();
        selectedParking = intent.getStringExtra("Ime");
        selectedTimeSlot = intent.getStringExtra("Vreme");
        selectedDate = intent.getStringExtra("Datum");
        username = intent.getStringExtra("Korisnichko");
        name = intent.getStringExtra("Name");
        lat = intent.getFloatExtra("Lat", 0);
        lng = intent.getFloatExtra("Long", 0);

        confirmationMessage = (TextView) getActivity().findViewById(R.id.confirmation_message);
        home = (Button) getActivity().findViewById(R.id.home_button);
        navigate = (Button) getActivity().findViewById(R.id.navigation_button);
        qr = (Button) getActivity().findViewById(R.id.qr_button);
        database = new DBHelper(getContext());

        confirmationMessage.setText("Успешно резервиравте паркинг во " + selectedParking + " на " + selectedDate + " во периодот " + selectedTimeSlot + ".");

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Cities.class);
                intent.putExtra("Ime", name);
                intent.putExtra("KorisnichkoIme", username);
                startActivity(intent);
            }
        });
        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    NavigationFragment frag = (NavigationFragment) getParentFragmentManager().findFragmentById(R.id.fragment2);
                } else {
                    Intent intent = new Intent(getActivity(), NavigationActivity.class);
                    intent.putExtra("Lat", lat);
                    intent.putExtra("Long", lng);
                    intent.putExtra("parkingName", selectedParking);
                    startActivityForResult(intent, 1234);
                }
            }
        });
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRCode.class);
                intent.putExtra("Ime", name);
                intent.putExtra("KorisnichkoIme", username);
                intent.putExtra("SelectedParking", selectedParking);
                intent.putExtra("SelectedTimeSlot", selectedTimeSlot);
                intent.putExtra("SelectedDate", selectedDate);
                startActivity(intent);
            }
        });
    }
}