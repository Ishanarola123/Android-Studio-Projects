package com.example.practical8_mad_40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Username,password;
    Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username=findViewById(R.id.Username);
        password=findViewById(R.id.password);
        loginbutton=findViewById(R.id.loginbutton);


       
    }
}