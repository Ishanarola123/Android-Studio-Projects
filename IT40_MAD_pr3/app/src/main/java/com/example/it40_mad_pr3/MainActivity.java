package com.example.it40_mad_pr3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.t1) ;
        t2=(TextView)findViewById(R.id.t2) ;
        t3=(TextView)findViewById(R.id.t3) ;
        b1=(Button) findViewById(R.id.b1) ;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1,n2;
                n1=Double.parseDouble((t1.getText().toString()));
                n2=Double.parseDouble((t2.getText().toString()));
                double sum=n1+n2;
                t3.setText(Double.toString(sum));
                Toast.makeText(getApplicationContext(),Double.toString(sum),Toast.LENGTH_LONG).show();

            }
        });

    }
}