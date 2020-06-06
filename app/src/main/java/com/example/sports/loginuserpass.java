package com.example.sports;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import static android.database.sqlite.SQLiteDatabase.openDatabase;


public class loginuserpass  extends Activity implements OnClickListener
{
    
        EditText uname,pass;
        Button player,organiser,trainer;
        SQLiteDatabase db;

        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_loginuserpass);


            pass=(EditText)findViewById(R.id.pass);
            uname=(EditText)findViewById(R.id.name);

            player=(Button)findViewById(R.id.loginasplayer);
            trainer=(Button)findViewById(R.id.loginastrainer);
            organiser=(Button)findViewById(R.id.loginasorganiser);


            player.setOnClickListener(this);
            trainer.setOnClickListener(this);
            organiser.setOnClickListener(this);

            // Creating database and table
           db=openOrCreateDatabase("sportDB", Context.MODE_PRIVATE, null);

          //  db=openDatabase("sportDB", SQLiteDatabase.CursorFactory factory,Readable);

        }
        public void onClick(View view) {

            // Display a record from the Student table
            if (view == player) {
                // Checking for empty roll number
                if (uname.getText().toString().trim().length() == 0 ||
                        pass.getText().toString().trim().length() == 0) {
                    showMessage("Error", "enter username and password");
                    return;
                }
               // String name = name.getText().toString();
                Cursor c = db.rawQuery("SELECT password FROM player WHERE name='"+uname.getText()+"'", null);
                if (c == pass) {
                    showMessage("login", "You have successfully logined");
                    player.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v)
                        { Intent intent = new Intent(loginuserpass.this,home.class);
                            startActivity(intent);
                        }
                    });

                } else {
                    showMessage("Error", "Invalid usename and password");
                    clearText();
                }
            }



            if (view == organiser) {
                // Checking for empty roll number
                if (uname.getText().toString().trim().length() == 0 ||
                        pass.getText().toString().trim().length() == 0) {
                    showMessage("Error", "enter username and password");
                    return;
                }
                Cursor c = db.rawQuery("SELECT password FROM organiser WHERE name='"+uname.getText()+"'", null);

                if (c == pass) {
                    showMessage("login", "You have successfully logined");
                    organiser.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v)
                        { Intent intent = new Intent(loginuserpass.this,homeorganiser.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    showMessage("Error", "Invalid usename and password");
                    clearText();
                }
            }
            if (view == trainer) {
                // Checking for empty roll number
                if (uname.getText().toString().trim().length() == 0 ||
                        pass.getText().toString().trim().length() == 0) {
                    showMessage("Error", "enter username and password");
                    return;
                }
                Cursor c = db.rawQuery("SELECT password FROM trainer WHERE name='"+uname.getText()+"'", null);

                if (c == pass) {
                    showMessage("login", "You have successfully logined");
                    trainer.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v)
                        { Intent intent = new Intent(loginuserpass.this, homeorganiser.class);
                            startActivity(intent);
                        }
                    });
                } else {
                    showMessage("Error", "Invalid usename and password");
                    clearText();
                }
            }
        }
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
        uname.setText("");
        pass.setText("");
        
        //Rollno.requestFocus();
    }
}