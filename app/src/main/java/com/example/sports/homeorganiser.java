
package com.example.sports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class homeorganiser extends Activity {

    private Spinner spinner1;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeorganiser);


        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

// add items into spinner dynamically

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
//spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnSubmit= (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {



            @Override
            public void onClick(View v) {
                if (String.valueOf(spinner1.getSelectedItem()) == "View Profile") {
                    openNewActivity1();
                }/*
                else if (String.valueOf(spinner1.getSelectedItem()) == "Add Tournament") {
                    openNewActivity2();
                }
                else if (String.valueOf(spinner1.getSelectedItem()) == "View Participants") {
                    openNewActivity3();
                }
                else if (String.valueOf(spinner1.getSelectedItem()) == "Update Score") {
                    openNewActivity4();
                }
                else if (String.valueOf(spinner1.getSelectedItem()) == "Update Schedule") {
                    openNewActivity5();
                }
*/
                else if (String.valueOf(spinner1.getSelectedItem()) == "Logout") {
                    openNewActivity6();
                }
            }});
    }
    public void openNewActivity1()
    {
        Intent intent = new Intent(homeorganiser.this, viewprofile.class);
        startActivity(intent);
    }
    /*public void openNewActivity2()
    {
        Intent intent = new Intent(homeOrganiser.this, addtournament.class);
        startActivity(intent);
    }public void openNewActivity3()
    {
        Intent intent = new Intent(homeOrganiser.this, viewparticipant.class);
        startActivity(intent);
    }public void openNewActivity4()
    {
        Intent intent = new Intent(homeOrganiser.this,updatescore.class);
        startActivity(intent);
    }
    public void openNewActivity5()
    {
        Intent intent = new Intent(homeOrganiser.this,updateschedule.class);
        startActivity(intent);
    }
*/
    public void openNewActivity6()
    {
        Intent intent = new Intent(homeorganiser.this, logout.class);
        startActivity(intent);
    }

}



