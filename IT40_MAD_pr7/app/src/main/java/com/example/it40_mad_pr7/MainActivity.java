package com.example.it40_mad_pr7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // TextView tv3;
    EditText input1,input2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        button=findViewById(R.id.button);
        //tv3=findViewById(R.id.tv3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,secondactivity.class);


                String s=input1.getText().toString()+input2.getText().toString();
              //  tv3.setText(s);

                intent.putExtra("firstname",input1.getText().toString());
                intent.putExtra("lastname",input2.getText().toString());


                intent.putExtra("concatstring",s);
                startActivity(intent);
            }
        });


    }
}