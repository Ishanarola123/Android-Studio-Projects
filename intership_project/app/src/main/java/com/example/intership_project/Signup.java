package com.example.intership_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
    TextView signin;
    Button register;
    EditText username,password,cpassword,email,phoneno;
    private FirebaseAuth  mAuth;;

    //create object of firebasedatabase-refrence class to access the realtime database




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();

        register=findViewById(R.id.signupbtn);
        signin=findViewById(R.id.signintv);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        email=findViewById(R.id.emailaddress);
        phoneno=findViewById(R.id.phonenumber);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });


//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String usernametxt=username.getText().toString();
//                final String phonenumtxt=phoneno.getText().toString();
//                final String emailtxt=email.getText().toString();
//                final String passwordtxt=password.getText().toString();
//                final String cpasswordtxt=cpassword.getText().toString();
//
//
//                validateusersignup();
//                if (validateusersignup()){
//                    //if registered phone number os already registered then?
//                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if (snapshot.hasChild(phonenumtxt)){
//                                Toast.makeText(getApplicationContext(), "This phone number is already registered,please enter new number ", Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//
//                                //sending data into firebase database using phonenumber as primary key-unique key
//                                databaseReference.child("users").child(phonenumtxt).child("username").setValue(usernametxt);
//                                databaseReference.child("users").child(phonenumtxt).child("email").setValue(emailtxt);
//                                databaseReference.child("users").child(phonenumtxt).child("password").setValue(passwordtxt);
//
//                                Toast.makeText(getApplicationContext(), "User registered successfully!", Toast.LENGTH_SHORT).show();
//                                Intent intent=new Intent(Signup.this,MainScreen.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "please enter data in a proper way!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               validateusersignup();
           }
       });
    }

    private boolean validateusersignup() {
        final String usernametxt=username.getText().toString();
        final String phonenumtxt=phoneno.getText().toString();
        final String emailtxt=email.getText().toString();
        final String passwordtxt=password.getText().toString();
        final String cpasswordtxt=cpassword.getText().toString();


        if (usernametxt.isEmpty()) {
            username.setError("your username is required");
            username.requestFocus();
            return false;
        }
        else if (phonenumtxt.isEmpty()) {
            phoneno.setError("your phonenumber is required");
            phoneno.requestFocus();
            return false;
        }
        else   if (emailtxt.isEmpty()) {
            email.setError("your email is required");
            email.requestFocus();
            return false;
        }
        else  if (passwordtxt.isEmpty()) {
           password.setError("your password is required");
           password.requestFocus();
            return false;
        }
        else  if (cpasswordtxt.isEmpty()) {
           cpassword.setError("your confirmpassword is required");
           cpassword.requestFocus();
            return false;
        }
        else  if (passwordtxt.length() < 6) {
            password.setError("minimum password length should be 6 characters ");
            password.requestFocus();
            return false;
        }
        else  if (cpasswordtxt.length() < 6) {
            password.setError("minimum password length should be 6 characters ");
            password.requestFocus();
            return false;
        }
        else  if (!cpasswordtxt.equals(passwordtxt)) {
            password.setError("please enter the password as it enter before ");
            password.requestFocus();
            return false;
        }

        else   if (!Patterns.EMAIL_ADDRESS.matcher(emailtxt).matches()) {
            email.setError("please enter the valid email!");
            email.requestFocus();
            return false;
        }
        else{
           // Toast.makeText(this, "your all data validate successfully!", Toast.LENGTH_SHORT).show();
            mAuth.createUserWithEmailAndPassword(emailtxt,passwordtxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){

                        FirebaseUser user = mAuth.getCurrentUser();

//                        user.sendEmailVerification();
                        Toast.makeText(Signup.this, "Registered successfully.", Toast.LENGTH_LONG).show();

                      //put data into firebase data
                        ReadWriteableUserDetails writeableUserDetails=new ReadWriteableUserDetails(usernametxt,phonenumtxt,emailtxt,passwordtxt);

                        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReferenceFromUrl("https://foodorderapp-a4e2a-default-rtdb.firebaseio.com/");
                        databaseReference.child(user.getUid()).setValue(writeableUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()){
                                    Intent intent = new Intent(Signup.this, MainScreen.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "User Registered failed!please try again!!!", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });

                    } else {
                        Toast.makeText(Signup.this, "can not Registerd !", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        return true;
    }
}