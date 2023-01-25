package com.example.intership_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intership_project.SqliteDatabase.DBHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainScreen2 extends AppCompatActivity {
    ImageView imageView, imageView_plus, imageView_minus;
    TextView item_name;
    TextView item_price;
    TextView number_of_order_txt;
    TextView description_text;
    Button add_cart;
    int number_of_order = 1;
    TextView orderByUsername, orderPhone;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://foodorderapp-a4e2a-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen2);
        mAuth = FirebaseAuth.getInstance();
        imageView = findViewById(R.id.image);
        item_name = findViewById(R.id.item_name_tv);
        item_price = findViewById(R.id.item_price_tv);
        imageView_plus = findViewById(R.id.imageView_plus);
        imageView_minus = findViewById(R.id.imageView_minus);
        number_of_order_txt = findViewById(R.id.display_count);
        description_text = findViewById(R.id.description_text);
        orderPhone = findViewById(R.id.order_phone);
        orderByUsername = findViewById(R.id.order_By_username);
        number_of_order_txt.setText(String.valueOf(number_of_order));
        add_cart = findViewById(R.id.add_cart_detail);


        imageView.setImageResource(getIntent().getIntExtra("imagename", 0));
        item_name.setText(getIntent().getStringExtra("itemname"));
        String subString = getIntent().getStringExtra("itemprice").substring(1);
        Double price = Double.valueOf(subString).doubleValue();

        item_price.setText(" $" + price.toString());


        checkloginuser();
        imageView_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_of_order = number_of_order + 1;
                number_of_order_txt.setText(String.valueOf(number_of_order));
                final int order_count = number_of_order;

            }
        });

        imageView_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number_of_order > 1) {
                    number_of_order = number_of_order - 1;
                    final int order_count = number_of_order;
                }

                number_of_order_txt.setText(String.valueOf(number_of_order));
            }
        });

        DBHelper helper = new DBHelper(this);
        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = databaseReference.push().getKey();
                assert key != null;
                databaseReference.child("orders").child(key).child("username").
                        setValue(orderByUsername.getText().toString());
                databaseReference.child("orders").child(key).child("phonenumber").
                        setValue(orderPhone.getText().toString());
                databaseReference.child("orders").child(key).child("price").
                        setValue(price);
                databaseReference.child("orders").child(key).child("order quantity").
                        setValue(number_of_order);
                databaseReference.child("orders").child(key).child("description").
                        setValue(description_text.getText().toString());
                databaseReference.child("orders").child(key).child("item name").
                        setValue(item_name.getText().toString());

                Toast.makeText(MainScreen2.this, "record has been inserted", Toast.LENGTH_SHORT).show();
//                boolean is_inserted = helper.insertOrder(order_By_username.getText().toString(),
//                        order_phone.getText().toString(),
//                        price,
//                        number_of_order,
//                        description_text.getText().toString(),
//                        item_name.getText().toString());

//                if (is_inserted) {
//                    Intent intent=new Intent(MainScreen2.this, SupportFragment.class);
//                    startActivity(intent);
//                    Toast.makeText(MainScreen2.this, "record has been inserted", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainScreen2.this, "your record can not be added", Toast.LENGTH_LONG).show();
//                }


            }
        });


    }

    private void checkloginuser() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        String userid = currentUser.getUid().toString();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child(userid).child("username").getValue(String.class);
                String phonenumber = snapshot.child(userid).child("phone_number").getValue(String.class);
                orderByUsername.setText(username);
                orderPhone.setText(phonenumber);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
