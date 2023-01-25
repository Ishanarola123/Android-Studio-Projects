package com.example.intership_project.Fragments_bottomnav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.intership_project.R;

import com.example.intership_project.recviewcat.Model;
import com.example.intership_project.recviewcat.myadapter;

import com.example.intership_project.recviewpopular.myadapter_popular;
import com.example.intership_project.recviewpopular.Model_popular;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public HomeFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rcvcategories,rcv_popular;
        rcvcategories = view.findViewById(R.id.rcvcategories);
        rcv_popular=view.findViewById(R.id.rcv_popular);

        rcvcategories.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rcv_popular.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));

        myadapter myadapter = new myadapter(dataqueue());
        rcvcategories.setAdapter(myadapter);

        //set adapter into popular categories
        myadapter_popular myadapter_popular=new myadapter_popular(popular_dataqueue());
        rcv_popular.setAdapter(myadapter_popular);

        return view;
    }

    private ArrayList<Model_popular> popular_dataqueue() {
        ArrayList<Model_popular> holder = new ArrayList<>();
        Model_popular ob1 = new Model_popular();
        ob1.setItem_name("pepperponi pizza");
        ob1.setItem_price("$9.70");
        ob1.setImg_name(R.drawable.pop_1);
        holder.add(ob1);

        Model_popular ob2 = new Model_popular();
        ob2.setItem_name("cheese Burger");
        ob2.setItem_price("$8.79");
        ob2.setImg_name(R.drawable.pop_2);
        holder.add(ob2);

        Model_popular ob3 = new Model_popular();
        ob3.setItem_name("pepperponi pizza");
        ob3.setItem_price("$9.70");
        ob3.setImg_name(R.drawable.pop_3);
        holder.add(ob3);

        return holder;

    }

    public ArrayList<Model> dataqueue() {
        ArrayList<Model> holder = new ArrayList<>();

        Model ob1 = new Model();
        ob1.setCategoriesheader("Pizza");
        ob1.setImgname(R.drawable.cat_1);
        holder.add(ob1);

        Model ob2 = new Model();
        ob2.setCategoriesheader("Burger");
        ob2.setImgname(R.drawable.cat_2);
        holder.add(ob2);

        Model ob3 = new Model();
        ob3.setCategoriesheader("Hotdog");
        ob3.setImgname(R.drawable.cat_3);
        holder.add(ob3);

        Model ob4 = new Model();
        ob4.setCategoriesheader("Drink");
        ob4.setImgname(R.drawable.cat_4);
        holder.add(ob4);

        Model ob5 = new Model();
        ob5.setCategoriesheader("Pizza");
        ob5.setImgname(R.drawable.cat_1);
        holder.add(ob5);


        return holder;
    }
}
