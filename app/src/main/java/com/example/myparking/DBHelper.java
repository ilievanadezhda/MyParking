package com.example.myparking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "MyDatabase", null, 9);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ParkingPlaces(name VARCHAR, city VARCHAR, totalSpaces INTEGER, lat FLOAT, long FLOAT);");
        db.execSQL("CREATE TABLE Reservations(username VARCHAR, parkingname VARCHAR, date VARCHAR, timeslot VARCHAR);");
        db.execSQL("CREATE TABLE ParkingPlaces(name VARCHAR, city VARCHAR, totalSpaces INTEGER, lat FLOAT, long FLOAT);");
        db.execSQL("CREATE TABLE Reservations(username VARCHAR, parkingname VARCHAR, date VARCHAR, timeslot VARCHAR);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Разловечко востание', 'Скопје', 517, 41.99367, 21.43615);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Филип Втори Македонски', 'Скопје', 275, 41.99762, 21.44000);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Кресненско востание', 'Скопје', 500, 41.99693, 21.43687);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Солунски конгрес', 'Скопје', 80, 41.99833,21.43022);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Судска палата', 'Скопје', 502, 41.99832, 21.44353);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Беко', 'Скопје', 605, 41.99337, 21.42852);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Македонска фаланга', 'Скопје', 445, 41.98950, 21.43218);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Зебра', 'Скопје', 300, 41.99303, 21.41884);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Тодор Александров', 'Скопје', 605, 41.99354, 21.42842);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Мало мовче', 'Велес', 50, 41.714146, 21.785847);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Суд', 'Велес', 50, 41.716807, 21.783128);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Автобуска станица', 'Велес', 50, 41.716267, 21.786507);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Супер Кит-Го', 'Велес', 50, 41.718539, 21.761252);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Паркинг Кампус 4', 'Штип', 30 , 41.763611, 22.164062);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Автобуска станица', 'Штип', 50, 41.742604, 22.189981);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ParkingPlaces");
        db.execSQL("DROP TABLE IF EXISTS Reservations");
        db.execSQL("CREATE TABLE ParkingPlaces(name VARCHAR, city VARCHAR, totalSpaces INTEGER, lat FLOAT, long FLOAT);");
        db.execSQL("CREATE TABLE Reservations(username VARCHAR, parkingname VARCHAR, date VARCHAR, timeslot VARCHAR);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Разловечко востание', 'Скопје', 517, 41.99367, 21.43615);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Филип Втори Македонски', 'Скопје', 275, 41.99762, 21.44000);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Кресненско востание', 'Скопје', 500, 41.99693, 21.43687);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Солунски конгрес', 'Скопје', 80, 41.99833,21.43022);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Судска палата', 'Скопје', 502, 41.99832, 21.44353);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Беко', 'Скопје', 605, 41.99337, 21.42852);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Македонска фаланга', 'Скопје', 445, 41.98950, 21.43218);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Зебра', 'Скопје', 300, 41.99303, 21.41884);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Тодор Александров', 'Скопје', 605, 41.99354, 21.42842);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Мало мовче', 'Велес', 50, 41.714146, 21.785847);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Суд', 'Велес', 50, 41.716807, 21.783128);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Автобуска станица', 'Велес', 50, 41.716267, 21.786507);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Супер Кит-Го', 'Велес', 50, 41.718539, 21.761252);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Паркинг Кампус 4', 'Штип', 30 , 41.763611, 22.164062);");
        db.execSQL("INSERT INTO ParkingPlaces VALUES ('Автобуска станица', 'Штип', 50, 41.742604, 22.189981);");
    }

    public void insertIntoReservations(String username, String parkingname, String date, String timeslot) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("parkingname", parkingname);
        contentValues.put("username", username);
        contentValues.put("date", date);
        contentValues.put("timeslot", timeslot);
        database.insert("Reservations", null, contentValues);
    }

    public List<String> getParkings(String city) {
        List<String> parkingNames = new ArrayList();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM ParkingPlaces WHERE city LIKE '" + city + "'", null);
        while (c1.moveToNext()) {
            parkingNames.add(c1.getString(0));
        }
        c1.close();
        return parkingNames;
    }

    public int getTotalSpaces(String name) {
        int total = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM ParkingPlaces WHERE name LIKE '" + name + "'", null);
        if (c1.moveToFirst()) {
            total = c1.getInt(2);
            c1.close();
            return total;
        } else {
            return 0;
        }
    }

    public int getNumberOfReservations(String date, String time, String parkingname) {
        int count = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM Reservations WHERE date = '" + date + "' AND timeslot = '" + time + "' AND parkingname = '" + parkingname + "'", null);
        if (c1.moveToFirst()) {
            count = c1.getCount();
            c1.close();
            return count;
        } else {
            return 0;
        }
    }

    public boolean existingReservation(String username, String date, String timeslot) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM Reservations WHERE date = '" + date + "' AND timeslot = '" + timeslot + "' AND username = '" + username + "'", null);
        if (c1.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }

    public float getLat(String parkingname) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM ParkingPlaces WHERE name LIKE '" + parkingname + "'", null);
        if (c1.moveToFirst()) {
            return c1.getFloat(3);
        } else {
            return 0;
        }
    }

    public float getLong(String parkingname) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM ParkingPlaces WHERE name LIKE '" + parkingname + "'", null);
        if (c1.moveToFirst()) {
            return c1.getFloat(4);
        } else {
            return 0;
        }
    }

    public String getCity(String parkingname) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM ParkingPlaces WHERE name LIKE '" + parkingname + "'", null);
        if (c1.moveToFirst()) {
            return c1.getString(1);
        } else {
            return "";
        }
    }

    public boolean hasThreeActiveReservations(String username) {
        SQLiteDatabase database = this.getReadableDatabase();
        int counter = 0;
        Cursor c1 = database.rawQuery("SELECT * FROM Reservations WHERE username = '" + username + "'", null);
        while (c1.moveToNext()) {
            String date = c1.getString(2);
            String time = c1.getString(3);
            if (isActive(date, time)) {
                counter++;
            }
        }
        c1.close();
        if (counter < 3) {
            return false;
        } else {
            return true;
        }

    }

    public boolean isActive(String datum, String vreme) {
        String[] date = datum.split("/");
        int rDay = Integer.parseInt(date[0]);
        int rMonth = Integer.parseInt(date[1]);
        int rYear = Integer.parseInt(date[2]);
        String time = vreme.substring(0, 2);
        int rHour = Integer.parseInt(time);

        Calendar rightNow = Calendar.getInstance();
        int day = rightNow.get(Calendar.DAY_OF_MONTH);
        int month = rightNow.get(Calendar.MONTH) + 1;
        int year = rightNow.get(Calendar.YEAR);
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);

        if (year > rYear) {
            return false;
        } else if (year < rYear) {
            return true;
        } else {
            if (month > rMonth) {
                return false;
            } else if (month < rMonth) {
                return true;
            } else {
                if (day > rDay) {
                    return false;
                } else if (day < rDay) {
                    return true;
                } else {
                    if (hour > rHour) {
                        return false;
                    } else if (hour < rHour) {
                        return true;
                    } else {
                        return true; //Ako se celosno isti neka e aktivna, mozhe korisnikot kje kasni na parkingot
                    }
                }
            }
        }
    }

    public List<List<String>> getReservations(String username) {
        List<List<String>> reservations = new ArrayList<List<String>>();

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor c1 = database.rawQuery("SELECT * FROM Reservations WHERE username LIKE '" + username + "'", null);
        while (c1.moveToNext()) {
            List<String> row = new ArrayList();
            String date = c1.getString(2);
            String time = c1.getString(3);
            if (this.isActive(date, time)) {
                row.add(c1.getString(1)); //parkingname
                row.add(date); //date
                row.add(time); //time
                reservations.add(row);
            }
        }
        c1.close();
        return reservations;
    }
}
