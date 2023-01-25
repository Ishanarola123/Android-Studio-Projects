package com.example.practical17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv1);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iteam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case  R.id.menuiteam1:
                Toast.makeText(getApplicationContext(), "you selected first iteam", Toast.LENGTH_SHORT).show();
       break;
        case  R.id.menuiteam2:
        Toast.makeText(getApplicationContext(), "you selected second iteam", Toast.LENGTH_SHORT).show();
break;
            case  R.id.menuiteam3:
                Toast.makeText(getApplicationContext(), "you selected third iteam", Toast.LENGTH_SHORT).show();
            default:  return super.onOptionsItemSelected(item);

    }

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

     return false;
    }

}