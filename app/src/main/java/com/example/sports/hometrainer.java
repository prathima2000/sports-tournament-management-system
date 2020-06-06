
package com.example.sports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class hometrainer extends Activity {

    private Spinner spinner1;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometrainer);


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
                }

                else if (String.valueOf(spinner1.getSelectedItem()) == "Logout") {
                    openNewActivity2();
                }
            }});
    }
    public void openNewActivity1()
    {
        Intent intent = new Intent(hometrainer.this, viewprofile.class);
        startActivity(intent);
    }
    public void openNewActivity2()
    {
        Intent intent = new Intent(hometrainer.this, logout.class);
        startActivity(intent);
    }
}



