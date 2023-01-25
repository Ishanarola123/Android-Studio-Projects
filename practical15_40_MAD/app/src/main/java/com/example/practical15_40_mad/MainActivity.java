package com.example.practical15_40_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RatingBar ratingBar;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar=findViewById(R.id.ratingBar);

        result=findViewById(R.id.result);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                String rating=String.valueOf(ratingBar.getRating());
//                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder
                        = new AlertDialog
                        .Builder(MainActivity.this);

                builder.setMessage("You have given" + rating +"Rating out of 5" +" " );
                builder.setTitle("Display Rate");
                builder.setCancelable(false);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       finish();
                    }
                });



              AlertDialog alertDialog=builder.create();
              alertDialog.show();
            }
        });


    }



}