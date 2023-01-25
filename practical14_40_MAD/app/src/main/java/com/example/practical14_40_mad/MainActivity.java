package com.example.practical14_40_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggleButton1;
        toggleButton1 = findViewById(R.id.toggleButton1);

        if (toggleButton1.isActivated()){
            toggleButton1.setText("on");
        }
        else {
            toggleButton1.setText("OFF");
        }

        ToggleButton toggleButton2;
        toggleButton2 = findViewById(R.id.toggleButton2);

        if (toggleButton2.isActivated()){
            toggleButton2.setText("on");
        }
        else {
            toggleButton2.setText("OFF");
        }

    }

}