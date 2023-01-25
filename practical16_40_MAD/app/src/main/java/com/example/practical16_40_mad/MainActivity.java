package com.example.practical16_40_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   RadioGroup radioGroup;
    RadioButton r1,r2,r3;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.radiogroup);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        textView=findViewById(R.id.textview);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //it convert text into bold style
                textView.setTypeface(null, Typeface.BOLD);
            }
        });

        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTypeface(null,Typeface.ITALIC);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTypeface(null,Typeface.BOLD_ITALIC);
            }
        });

    }
}