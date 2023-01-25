package com.example.it40_pr5_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String msg="method being invoked!!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv1;
        tv1=findViewById(R.id.tv1);

        Toast.makeText(this,    "oncreate method", Toast.LENGTH_LONG).show();
        Log.d(msg,"oncreate method run");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg," onstart() Method");
        Toast.makeText(this, "act-1 onstart run", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg,"onresume Method");
        Toast.makeText(this, " act-1 onresume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg,"onpause Method");
        Toast.makeText(this, "act-1 onpause", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg,"onstop Method");
        Toast.makeText(this, "act-1 onstop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(msg,"onrestart Method");
        Toast.makeText(this, "act-1 onrestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg,"ondestroy Method");
        Toast.makeText(this, " act-1 ondestroy", Toast.LENGTH_SHORT).show();
    }
}