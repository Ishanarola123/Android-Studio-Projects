package com.example.it40_mad_pr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                {
                    if (Username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "please enter the value", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent i=new Intent(MainActivity.this,secondactivity.class);
                        i.putExtra("username" ,Username.getText().toString());
//                i.putExtra("Password",password.getText().toString());
                        startActivity(i);
                    }
                }


            }


        });


    }
}