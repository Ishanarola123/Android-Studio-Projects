package com.example.intership_project.Fragments_bottomnav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.intership_project.R;
import com.example.intership_project.orderlist.Model;
import com.example.intership_project.orderlist.MyviewHolder;
import com.example.intership_project.orderlist.Myadapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderListFragment extends Fragment {
    FirebaseRecyclerOptions<Model> options;
    FirebaseRecyclerAdapter<Model, MyviewHolder> adapter;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://foodorderapp-a4e2a-default-rtdb.firebaseio.com/");

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SupportFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderListFragment newInstance(String param1, String param2) {
        OrderListFragment fragment = new OrderListFragment();
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

        mAuth = FirebaseAuth.getInstance();
        RecyclerView recyclervieworderlistrec;


        View view = inflater.inflate(R.layout.fragment_orderlist, container, false);
        recyclervieworderlistrec = view.findViewById(R.id.orderlistrec);
        recyclervieworderlistrec.setLayoutManager(new LinearLayoutManager(view.getContext()));

//        checkloginusersusername();
        options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(databaseReference.child("orders"), Model.class).build();
        adapter = new Myadapter(options);
        recyclervieworderlistrec.setAdapter(adapter);
        return view;

    }

//    private void checkloginusersusername() {
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        String userid = currentUser.getUid().toString();
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String username = snapshot.child(userid).child("username").getValue(String.class);
//                String key = databaseReference.child("orders").getKey();
//                String orderusername = snapshot.child("orders").child(key).child("username").getValue(String.class);
//                if (orderusername.equals(username)) {
//                    //take id from that username
//                    String orderuserid = snapshot.child("orders").child(key).getValue(String.class);
//                    //bind this data with recycler view;
//                    options = new FirebaseRecyclerOptions.Builder<Model>().setQuery(databaseReference.child("orders"), Model.class).build();
//                    adapter = new Myadapter(options);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }


}