package com.example.sports;

import android.app.AlertDialog.Builder;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class viewprofile extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        Cursor c = db.rawQuery("SELECT * FROM player", null);
        if (c.getCount() == 0) {
            showMessage("Error", "No records found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext()) {
            buffer.append("Name: " + c.getString(0) + "\n");
            buffer.append("DOB: " + c.getString(2) + "\n");
            buffer.append("Address: " + c.getString(3) + "\n\n");
            buffer.append("Phone: " + c.getString(4) + "\n\n");
            buffer.append("Qualification: " + c.getString(4) + "\n\n");
            buffer.append("sport: " + c.getString(5) + "\n\n");
        }

        showMessage("Student Details", buffer.toString());


        Cursor c1 = db.rawQuery("SELECT * FROM organiser", null);
        if (c1.getCount() == 0) {
            showMessage("Error", "No records found");
            return;
        }
        StringBuffer buffer1 = new StringBuffer();
        while (c.moveToNext()) {
            buffer1.append("Name: " + c.getString(0) + "\n");
            buffer1.append("DOB: " + c.getString(2) + "\n");
            buffer1.append("Address: " + c.getString(3) + "\n\n");
            buffer1.append("Phone: " + c.getString(4) + "\n\n");
            buffer1.append("Qualification: " + c.getString(4) + "\n\n");
            buffer1.append("sport: " + c.getString(5) + "\n\n");
        }


        Cursor c2 = db.rawQuery("SELECT * FROM trainer", null);

        if (c2.getCount() == 0) {
            showMessage("Error", "No records found");
            return;
        }
        StringBuffer buffer2 = new StringBuffer();
        while (c.moveToNext()) {
            buffer2.append("Name: " + c.getString(0) + "\n");
            buffer2.append("DOB: " + c.getString(2) + "\n");
            buffer2.append("Address: " + c.getString(3) + "\n\n");
            buffer2.append("Phone: " + c.getString(4) + "\n\n");
            buffer2.append("Qualification: " + c.getString(4) + "\n\n");
            buffer2.append("sport: " + c.getString(3) + "\n\n");
        }

        showMessage("Student Details", buffer.toString());
    }

    public void showMessage(String title, String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    }


