package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinner);


        //set adapter and arguments getlayout
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.language, android.R.layout.simple_spinner_item);

        //setdropdown
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

       //show data in adapter in spinner
       spinner.setAdapter(adapter);


//       when click value that value fetch
//        and show toast

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

//            when item select
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                take value and covert into string
               String data=parent.getItemAtPosition(position).toString();
               Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}