package com.example.extra_database_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddData extends AppCompatActivity {

    EditText ename,esalary;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        ename=findViewById(R.id.ename);
        esalary=findViewById(R.id.esalary);
        add=findViewById(R.id.add);

        employeedbhelper employeedbhelper=new employeedbhelper(this);

      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              try {
                  String name;
                  int salary;
                  name=ename.getText().toString();
                  salary=Integer.parseInt(esalary.getText().toString());
    
                  employeedbhelper.insertemployeedata(name,salary);
                  Toast.makeText(getApplicationContext(), "your record has been added!", Toast.LENGTH_SHORT).show();

              }
              catch (SQLException e){
                  e.printStackTrace();
              }
          }
      });
    }
}