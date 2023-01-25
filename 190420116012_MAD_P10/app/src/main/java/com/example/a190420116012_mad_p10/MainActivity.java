package com.example.a190420116012_mad_p10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    TextView tv1,tv2;
    Button btn;
    private EditText uname;
    private EditText password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=findViewById(R.id.et1);
        password=findViewById(R.id.et2);
        submit=findViewById(R.id.btn);

        String name=uname.getText().toString();
        String passwd=password.getText().toString();

        uname.addTextChangedListener(text);
        password.addTextChangedListener(text);
    }
    TextWatcher text=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            submit.setEnabled(false);
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            submit.setEnabled(false);
            String name=uname.getText().toString();
            String passwd=password.getText().toString();
            String emailPattern="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            if (name.matches(emailPattern)&&passwd.length()>5){
                submit.setEnabled(true);
            }
            else {
                Toast.makeText(getApplicationContext(), "Enter Valid email and password", Toast.LENGTH_SHORT).show();
                submit.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public boolean checkEmail(String email, String emailPattern){
        if (email.matches(emailPattern)){
            return true;
        }
        return false;
    }
}