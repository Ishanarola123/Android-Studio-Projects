package com.example.practical12_mad_40;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
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


    b1=findViewById(R.id.add);
    b2=findViewById(R.id.sub);
    b3=findViewById(R.id.mul);
    b4=findViewById(R.id.div);

    input1=findViewById(R.id.input1);
    input2=findViewById(R.id.input2);
    result=findViewById(R.id.result);


    b1.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("ResourceType")
        @Override
        public void onClick(View view) {

            int sum;
            int n1,n2;

            n1=Integer.parseInt(input1.getText().toString());
            n2=Integer.parseInt(input2.getText().toString());
            sum=n1+n2;
            result.setText(Integer.toString(sum));
            Toast.makeText(getApplication(), "sum is:"  + sum, Toast.LENGTH_SHORT).show();
        }
    });


    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int sub;
            int n1,n2;

            n1=Integer.parseInt(input1.getText().toString());
            n2=Integer.parseInt(input2.getText().toString());

            sub=n1-n2;
            result.setText(Integer.toString(sub));
            Toast.makeText(getApplication(), "sub is:"  + sub, Toast.LENGTH_SHORT).show();
        }
    });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mul;
                int n1,n2;

                n1=Integer.parseInt(input1.getText().toString());
                n2=Integer.parseInt(input2.getText().toString());
                mul=n1*n2;
                result.setText(Integer.toString(mul));
                Toast.makeText(getApplication(), "multiplication is:"  + mul, Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int div;
                int n1,n2;

                n1=Integer.parseInt(input1.getText().toString());
                n2=Integer.parseInt(input2.getText().toString());
                div=n1/n2;
                result.setText(Integer.toString(div));
                Toast.makeText(getApplication(), "division is:"  + div, Toast.LENGTH_SHORT).show();
            }
        });









    }
}