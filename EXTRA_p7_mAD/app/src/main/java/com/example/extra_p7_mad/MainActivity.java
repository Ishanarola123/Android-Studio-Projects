package com.example.extra_p7_mad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,email;
    Button login,submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        login=findViewById(R.id.login);

      submit=findViewById(R.id.finallogin);
      submit.setEnabled(false);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
                   Toast.makeText(getApplicationContext(), "please fill the value of the username and password ", Toast.LENGTH_SHORT).show();

                   AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                   builder.setTitle("alert!");
                   builder.setMessage("Please fill the value of username and password!");
                   builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {

                       }
                   });
                   builder.setCancelable(false);
                   AlertDialog alertDialog=builder.create();
                   alertDialog.show();
               }
               else
               {
                    Intent intent=new Intent(MainActivity.this,secondactivity.class);
                    intent.putExtra("username", username.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    emailvalidate(email);
                     if (emailvalidate(email)){
                         submit.setEnabled(true);
                         startActivity(intent);
                     }

               }





            }
        });

    }

    private boolean emailvalidate(EditText email) {
        String emailtotext=email.getText().toString();
        if (!emailtotext.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailtotext).matches());{
            Toast.makeText(getApplicationContext(), "email verified successfully!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}