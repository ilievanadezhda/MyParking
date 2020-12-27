package com.example.myparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class QRCode extends AppCompatActivity {
    String name;
    String username;
    String selectedDate;
    String selectedTimeSlot;
    String selectedParking;
    String text;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_code);
        Intent intent = getIntent();
        name = intent.getStringExtra("Ime");
        username = intent.getStringExtra("KorisnichkoIme");
        selectedDate = intent.getStringExtra("SelectedDate");
        selectedTimeSlot = intent.getStringExtra("SelectedTimeSlot");
        selectedParking = intent.getStringExtra("SelectedParking");
        text = username + "|" + selectedParking + "|" + selectedDate + "|" + selectedTimeSlot;
        imageView = (ImageView) findViewById(R.id.qr_image);
        Bitmap bitmap;
        QRGEncoder qrgEncoder = new QRGEncoder(text, null, QRGContents.Type.TEXT, 1000);
        bitmap = qrgEncoder.getBitmap();
        imageView.setImageBitmap(bitmap);
    }
}