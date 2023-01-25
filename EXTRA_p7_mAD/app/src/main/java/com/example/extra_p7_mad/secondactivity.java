package com.example.extra_p7_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {
  TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

        String username=getIntent().getStringExtra("username");
        String password=getIntent().getStringExtra("password");

        tv1.setText(username);
        tv2.setText(password);



    }
}