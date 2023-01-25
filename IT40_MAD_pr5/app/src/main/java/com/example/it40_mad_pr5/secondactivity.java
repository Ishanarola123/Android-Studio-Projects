package com.example.it40_mad_pr5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        Toast toast=Toast.makeText(this,"secondactivity start",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();






    }
    String msg="event being invoked";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg,"onstart() Method");
        Toast.makeText(this, "act-2 onstart run", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg,"onresume Method");
        Toast.makeText(this, "act-2 onresume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg,"onpause Method");
        Toast.makeText(this, "act-2 onpause", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg,"onstop Method");
        Toast.makeText(this, "act-2 onstop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(msg,"onrestart Method");
        Toast.makeText(this, "act-2 onrestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg,"ondestroy Method");
        Toast.makeText(this, "act-2 ondestroy", Toast.LENGTH_SHORT).show();
    }
}
