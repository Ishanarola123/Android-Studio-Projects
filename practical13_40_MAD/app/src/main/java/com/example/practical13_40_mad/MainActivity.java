package com.example.practical13_40_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox b1,b2,b3;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.cricket);
        b2=findViewById(R.id.tennis);
        b3=findViewById(R.id.badminton);

        submit=findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
//            int count=0;


            @Override
            public void onClick(View view) {
                StringBuilder result=new StringBuilder();
                result.append(" ");
                if (b1.isChecked()){
                    result.append("cricket");


                }
                if (b2.isChecked()){
                    result.append(",tennis");

                }

                if (b3.isChecked()){
                    result.append(",badminton");

                }
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();


            }
        });

        



    }
}