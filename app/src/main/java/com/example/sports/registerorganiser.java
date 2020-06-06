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

public class registerorganiser  extends Activity implements OnClickListener
        {
            EditText sport,pass,organiser,organisation,address,phone,academy;
            Button submit;
            SQLiteDatabase db;
            /** Called when the activity is first created. */
            @Override
            public void onCreate(Bundle savedInstanceState)
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_registerorganiser);

                sport=(EditText)findViewById(R.id.sport);
                organiser=(EditText)findViewById(R.id.organiser);
                organisation=(EditText)findViewById(R.id.organisation);
                address=(EditText)findViewById(R.id.address);
                phone=(EditText)findViewById(R.id.phoneno);
                academy=(EditText)findViewById(R.id.academy);
                pass=(EditText)findViewById(R.id.pass);

                submit=(Button)findViewById(R.id.submit);


                submit.setOnClickListener(this);


                // Creating database and table
                db=openOrCreateDatabase("SportsDB", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS organiser(organiser VARCHAR,organisation VARCHAR,password VARCHAR,address VARCHAR,sport VHARCHAR,academy VERCHAR,phone VARCHAR);");
            }
            public void onClick(View view)
            {
                // Inserting a record to the Student table
                if(view==submit)
                {
                    // Checking for empty fields
                    if(organiser.getText().toString().trim().length()==0||
                            organisation.getText().toString().trim().length()==0||
                            pass.getText().toString().trim().length()==0||
                            address.getText().toString().trim().length()==0 ||
                            sport.getText().toString().trim().length()==0||
                            academy.getText().toString().trim().length()==0||
                            phone.getText().toString().trim().length()==0)
                    {
                        showMessage("Error", "Please enter all values");
                        return;
                    }
                    db.execSQL("INSERT INTO organiser VALUES('"+organiser.getText()+"','"+organisation.getText()+
                                    "','"+pass.getText()+"','"+address.getText()+"','"+sport.getText()+"'," +
                                    "'"+academy.getText()+"','"+phone.getText()+"');");
                            clearText();
                    submit.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v)
                        { Intent intent = new Intent(registerorganiser.this, loginuserpass.class);
                            startActivity(intent);
                        }
                    });
                }
                // Deleting a record from the Student table

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
                sport.setText("");
                organiser.setText("");
                organisation.setText("");
                address.setText("");
                phone.setText("");
                academy.setText("");
                pass.setText("");

                //Rollno.requestFocus();
            }
        }

