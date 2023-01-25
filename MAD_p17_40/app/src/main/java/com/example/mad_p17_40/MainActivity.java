package com.example.mad_p17_40;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        tv=findViewById(R.id.tv);
        switch (item.getItemId()) {
            case R.id.option_menu_item_1:
                tv.setBackgroundColor(Color.RED);
                break;
            case R.id.option_menu_item_2:
                tv.setBackgroundColor(Color.BLUE);
                break;
            case R.id.option_menu_item_3:
                tv.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.option_menu_item_4:
                tv.setBackgroundColor(Color.GRAY);
                break;
            case R.id.option_menu_item_5:
                tv.setBackgroundColor(Color.LTGRAY);
                break;
            case R.id.option_menu_item_6:
                tv.setBackgroundColor(Color.GREEN);
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return false;
    }
}