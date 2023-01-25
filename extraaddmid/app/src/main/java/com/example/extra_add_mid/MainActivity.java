package com.example.extra_add_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input1,input2;
        Button add;

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        add=(Button) findViewById(R.id.btn);
add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Double n1;
        Double n2;
        Double divide;

        n1=Double.parseDouble(input1.getText().toString());
        n2=Double.parseDouble(input2.getText().toString());

        try {
            divide=n1/n2;
            Toast.makeText(getApplicationContext(), "answer is "+ divide, Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            divide=n1/n2;
            Toast.makeText(getApplicationContext(), "can't divide"+ e, Toast.LENGTH_SHORT).show();
        }
        




    }
});


    }
}