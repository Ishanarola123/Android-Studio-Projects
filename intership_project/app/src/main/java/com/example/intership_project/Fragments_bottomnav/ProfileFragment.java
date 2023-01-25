package com.example.intership_project.Fragments_bottomnav;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intership_project.ChangePassword;
import com.example.intership_project.MainActivity;
import com.example.intership_project.R;
import com.example.intership_project.ReadWriteableUserDetails;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    FirebaseAuth mAuth;
    TextView username_display,email_display,mobile_no_display,gender_display;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String UserId;
        Button changepassword,logout;
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();

        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        changepassword=view.findViewById(R.id.changepassword);
        username_display=view.findViewById(R.id.username_fetch);
        email_display=view.findViewById(R.id.email_fetch);
        mobile_no_display=view.findViewById(R.id.mobile_no_fetch);
        gender_display=view.findViewById(R.id.gender_fetch);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        Log.d("TAG","current user is" + currentUser);
        DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("");

        UserId=currentUser.getUid();

        databaseReference.child(UserId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ReadWriteableUserDetails readWriteableUserDetails=snapshot.getValue(ReadWriteableUserDetails.class);
                if (readWriteableUserDetails != null){
                    String username=readWriteableUserDetails.username;
                    String email=readWriteableUserDetails.email;
                    String mobileno=readWriteableUserDetails.phone_number;

                    username_display.setText(username);
                    email_display.setText(email);
                    mobile_no_display.setText(mobileno);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something wrong happened!", Toast.LENGTH_SHORT).show();
            }
        });

        logout=view.findViewById(R.id.logout);
        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), ChangePassword.class);
                startActivity(intent);

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Toast.makeText(getContext(), "logout successfully!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}