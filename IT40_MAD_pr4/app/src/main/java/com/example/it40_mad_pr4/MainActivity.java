package com.example.it40_mad_pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2;
    Button b1,b2 ;
    EditText editText1,edittext2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         t1=(TextView)findViewById(R.id.t1);
         editText1=(EditText)findViewById(R.id.editText1);
         b1=(Button)findViewById(R.id.b1);


        t2=(TextView)findViewById(R.id.t2);
        edittext2=(EditText)findViewById(R.id.editText2);
        b2=(Button)findViewById(R.id.b2);



        b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
  double ruppes;
  ruppes=Double.parseDouble((editText1.getText().toString()));
  double dollar=ruppes*0.013;
  t1.setText(Double.toString(dollar));
    }
});

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dollar;
                dollar=Double.parseDouble((edittext2.getText().toString()));
                double ruppes=dollar*74.29;
                t2.setText(Double.toString(ruppes));
            }
        });






    }
}