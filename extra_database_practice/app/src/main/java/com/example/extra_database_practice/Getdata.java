package com.example.extra_database_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Getdata extends AppCompatActivity {
    Button getdata;
    Button getadata;
    EditText id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);
        getdata=findViewById(R.id.buttongetdata);
        getadata=findViewById(R.id.getsingledata);
        id=findViewById(R.id.empid);
        employeedbhelper employeedbhelper=new employeedbhelper(this);
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c=employeedbhelper.retrivealldata();
                if (c.moveToFirst()){
                     do {
                         Toast.makeText(getApplicationContext(), "Empid is: " + c.getString(0)
                                 +"Empname is: " + c.getString(1) +
                                 "Empsalary is" + c.getString(2)

                                 , Toast.LENGTH_SHORT).show();
                     }
                     while (c.moveToNext());
                }
                else {
                    Toast.makeText(getApplicationContext(), "no record has been found !", Toast.LENGTH_SHORT).show();
                }

            }
        });

        getadata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int eid=Integer.parseInt(id.getText().toString());
                Cursor c=employeedbhelper.retriveadata(eid);
                  if(c.moveToFirst()){
                      Toast.makeText(getApplicationContext(), "empid" + c.getString(0)
                              + "empname" + c.getString(1)+
                              "empsalary" + c.getString(2)
                              , Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      Toast.makeText(getApplicationContext(), "no record has been found ", Toast.LENGTH_SHORT).show();
                  }
            }
        });
    }
}