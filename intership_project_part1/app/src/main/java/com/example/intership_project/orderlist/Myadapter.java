package com.example.intership_project.orderlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.intership_project.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Myadapter extends FirebaseRecyclerAdapter<Model, MyviewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Myadapter(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyviewHolder myviewHolder, int i, @NonNull Model model) {
        myviewHolder.textviewitemname.setText(model.getItemname());
        myviewHolder.textviewprice.setText((int) model.getPrice());
        myviewHolder.textvieworderquantity.setText(model.getOrderquantity());

    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlerow_categories, parent, false);
        return new MyviewHolder(view);
    }
}
