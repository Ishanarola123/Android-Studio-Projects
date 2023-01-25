package com.example.mad_practical_database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adddata extends AppCompatActivity {
    Button adddatabtn;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);

        adddatabtn=findViewById(R.id.adddatabtn);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        employeedbhelper employeedbhelper=new employeedbhelper(this);

        adddatabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtusername=username.getText().toString();
                String txtpassword=password.getText().toString();

                employeedbhelper.insertdata(txtusername,txtpassword);



                Toast.makeText(getApplicationContext(), "your record has been record!", Toast.LENGTH_SHORT).show();

            }
        });




    }
}