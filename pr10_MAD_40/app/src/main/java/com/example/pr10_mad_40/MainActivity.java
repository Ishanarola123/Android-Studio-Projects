package com.example.pr10_mad_40;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,password,email;
    Button loginbutton,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        submit=findViewById(R.id.submit);

      loginbutton=findViewById(R.id.button);
      loginbutton.setEnabled(false);


     submit.setOnClickListener(new View.OnClickListener() {
         String emailtotext=email.getText().toString();



          @Override
          public void onClick(View v) {
//              if ( !usernametotext.isEmpty() && !passwordtotext.isEmpty() && !emailtotext.isEmpty()  && Patterns.EMAIL_ADDRESS.matcher(emailtotext).matches()   ) {
//                  Toast.makeText(getApplicationContext(), "verified successfully!", Toast.LENGTH_LONG).show();
//
//                  loginbutton.setEnabled(true);
//              }
//              else{
//                  Toast.makeText(getApplicationContext(), "not verified", Toast.LENGTH_SHORT).show();
//              }
              String usernametotext=username.getText().toString();
              String passwordtotext=password.getText().toString();

              //username and password validation
              if (!usernametotext.isEmpty() &&  !passwordtotext.isEmpty()){

                  Toast.makeText(getApplicationContext(), " verified username and password !", Toast.LENGTH_LONG).show();
              }
              else{
                  Toast.makeText(getApplicationContext(), "Fill the value,it's required!!", Toast.LENGTH_LONG).show();
              }

              //email validation!
              emailvalidator(email);
          }
      });


    }

    private void emailvalidator(EditText email) {
        String emailtotext=email.getText().toString();
        if(!emailtotext.isEmpty()  && Patterns.EMAIL_ADDRESS.matcher(emailtotext).matches()){
            Toast.makeText(getApplicationContext(), "email verified successfully", Toast.LENGTH_SHORT).show();
            loginbutton.setEnabled(true);

        }
        else{
            Toast.makeText(getApplicationContext(), "email can not verified!,please enter the valid email", Toast.LENGTH_SHORT).show();
        }
    }
}