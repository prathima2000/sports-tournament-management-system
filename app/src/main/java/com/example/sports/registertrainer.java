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

public class registertrainer  extends Activity implements OnClickListener {

    EditText name,password,dob,exper,phoneno,academy;
    Button submit;
    SQLiteDatabase db;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registertrainer);

        name=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        dob=(EditText)findViewById(R.id.dob);
        exper=(EditText)findViewById(R.id.experience);
        phoneno=(EditText)findViewById(R.id.phoneno);
        academy=(EditText)findViewById(R.id.academy);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener((OnClickListener) this);

        // Creating database and table
        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS trainer(name VARCHAR,passwordVARCHAR,dob VARCHAR,experVARCHAR,phonenoVARCHAR,academy VARCHAR);");
    }
    public void onClick(View view)
    {
        // Inserting a record to the Student table
        if(view==submit)
        {
            // Checking for empty fields
            if(name.getText().toString().trim().length()==0||
                    password.getText().toString().trim().length()==0||
                    dob.getText().toString().trim().length()==0||
            exper.getText().toString().trim().length()==0||
                    phoneno.getText().toString().trim().length()==0||
                    academy.getText().toString().trim().length()==0)

            {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO trainer VALUES('"+name.getText()+"','"+password.getText()+
                    "','"+dob.getText()+"','"+exper.getText()+"','"+phoneno.getText()+
                    "','"+academy.getText()+"');");

            clearText();
            submit.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v)
                { Intent intent = new Intent(registertrainer.this, loginuserpass.class);
                    startActivity(intent);
                }
            });

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
        name.setText("");
        password.setText("");
        dob.setText("");
        exper.setText("");
        phoneno.setText("");
        academy.setText("");

//Rollno.requestFocus();
    }
}




