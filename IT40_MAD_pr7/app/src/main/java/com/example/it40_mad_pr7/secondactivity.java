package com.example.it40_mad_pr7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {

    TextView displayresult;
    TextView firstname,lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        displayresult=findViewById(R.id.displayresult);


        String s=getIntent().getStringExtra("concatstring");
        displayresult.setText(s);

        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);

        String fname=getIntent().getStringExtra("firstname");
        String lname=getIntent().getStringExtra("lastname");

        firstname.setText(fname);
        lastname.setText(lname);


    }
}