package com.example.sports;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    // define the global variable


    // Add button Move to Activity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button trainer,organiser,player,skip;

        trainer = (Button)findViewById(R.id.trainer);
        player = (Button)findViewById(R.id.player);
        organiser = (Button)findViewById(R.id.organiser);
        skip = (Button)findViewById(R.id.skip);

        organiser.setOnClickListener(new View.OnClickListener() {

           public void onClick(View v)
           { Intent intent = new Intent(login.this, registerorganiser.class);
                startActivity(intent);
            }
        });
        trainer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(login.this, registertrainer.class);
                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {


                Intent intent = new Intent(login.this,loginuserpass.class);
                //intent.putExtra("text_key",db);
                startActivity(intent);
            }
        });

        player.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                Intent intent = new Intent(login.this, registerplayer.class);
                startActivity(intent);
            }
        });



    }}
