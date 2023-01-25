package com.example.a40_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4;
    EditText input1,input2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.ADD);
        b2=findViewById(R.id.SUB);
        b3=findViewById(R.id.multiply);
        b4=findViewById(R.id.division);

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);

        result=findViewById(R.id.result);

        Double n1=Double.parseDouble(input1.getText().toString());
        Double n2=Double.parseDouble(input2.getText().toString());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double sum;
                sum=n1+n2;
                result.setText(Double.toString(sum));
                Toast.makeText(getApplicationContext(), "sum is " + sum, Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            double sub;
            @Override
            public void onClick(View view) {


                sub=n1-n2;
                result.setText(Double.toString(sub));

                Toast.makeText(getApplicationContext(), "subtraction is:" + sub, Toast.LENGTH_SHORT).show();



            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double mul=n1*n2;
                result.setText(Double.toString(mul));

                Toast.makeText(getApplicationContext(), "multiplication is:" + mul, Toast.LENGTH_SHORT).show();



            }
        });

        b4.setOnClickListener(new View.OnClickListener() {

            double div;
            @Override
            public void onClick(View view) {


               double div=n1/n2;
                result.setText(Double.toString(div));

                Toast.makeText(getApplicationContext(), "division is:" + div, Toast.LENGTH_SHORT).show();



            }
        });






    }
}