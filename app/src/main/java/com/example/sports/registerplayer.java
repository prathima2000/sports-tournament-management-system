package com.example.sports;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
public class registerplayer  extends Activity implements OnClickListener
{
    EditText name,dob,addr,quali,sport,phoneno,password;
    Button submit;
    SQLiteDatabase db;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerplayer);

        phoneno=(EditText)findViewById(R.id.phoneno);
        password=(EditText)findViewById(R.id.password);
        addr=(EditText)findViewById(R.id.address);
        sport=(EditText)findViewById(R.id.sport);
        name=(EditText)findViewById(R.id.name);
        dob=(EditText)findViewById(R.id.dob);
         quali=(EditText)findViewById(R.id.qualification);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);



        db=openOrCreateDatabase("SportsDB", Context.MODE_WORLD_READABLE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS player(name VARCHAR,password VARCHAR,dob VARCHAR,addr VARCHAR,phoneno VARCHAR,quali VARCHAR,sport VARCHAR);");


        // Creating database and table

        //SQLiteDatabase mydatabase = openOrCreateDatabase("your database name",MODE_PRIVATE,null);

       // mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TutorialsPoint(Username VARCHAR,Password VARCHAR);");
       // db.execSQL("CREATE TABLE player (" + name + " TEXT, " + password + " VARCHAR, " + dob + " VARCHAR, " + addr +  " VARCHAR, " + phoneno + " INTEGER, " + quali + " VARCHAR, " + sport + " VARCHAR) " );

           }
    public void onClick(View view)
    {
        // Inserting a record to the Student table
        if(view==submit) {
            // Checking for empty fields
            if (name.getText().toString().trim().length() == 0 ||
                    password.getText().toString().trim().length() == 0 ||
                    dob.getText().toString().trim().length() == 0 ||
                    addr.getText().toString().trim().length() == 0 ||
                    phoneno.getText().toString().trim().length() == 0 ||
                    quali.getText().toString().trim().length() == 0 ||
                    sport.getText().toString().trim().length() == 0) {
                showMessage("Error", "Please enter all values");
                return;
            }

            db.execSQL("INSERT INTO player VALUES('" + name.getText() + "','" + password.getText() + "','" + dob.getText() +
                    "','" + addr.getText() + "','" + phoneno.getText() + "','" + quali.getText() + "','" + sport.getText() + "');");
            showMessage("register", "You have successfully registered");
            //  clearText();
            Cursor c = db.rawQuery("SELECT name,password FROM player", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            Intent intent = new Intent(registerplayer.this,loginuserpass.class);
            //intent.putExtra("text_key",db);
            startActivity(intent);

        }
            }
        // Deleting a record from the Student table



    public void showMessage(String title, String message)
    {
        Builder builder=new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        name.setText("");
        password.setText("");
        dob.setText("");
        addr.setText("");
        phoneno.setText("");
        quali.setText("");
        sport.setText("");
        //Rollno.requestFocus();
    }
}