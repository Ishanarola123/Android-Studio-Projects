package com.example.it40_mad_pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        tv1=findViewById(R.id.tv1);
        String username=getIntent().getStringExtra("username");
        tv1.setText(username);



    }
}