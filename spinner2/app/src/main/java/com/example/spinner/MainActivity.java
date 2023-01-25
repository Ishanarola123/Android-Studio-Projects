package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] colors={"blue","red" , "yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);



        spinner.setOnItemSelectedListener(this);

        //arrayadpter create first with two parameters simple spinner
        //and after tha call the method setdropdownViewResources
     ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_spinner_item,colors);
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(getApplicationContext(), "selected item" + colors[i], Toast.LENGTH_SHORT).show();

//        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
//        startActivity(intent);

       String item= adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), "selected iteam is there    " + item, Toast.LENGTH_SHORT).show();
//anyaction want to do here to selected iteam

        if (adapterView.getItemAtPosition(i).toString().equals("red")){
            Intent intent=new Intent(MainActivity.this,secondactivity.class);
            startActivity(intent);
            
        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}