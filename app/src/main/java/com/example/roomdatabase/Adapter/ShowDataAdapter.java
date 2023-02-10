package com.example.roomdatabase.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.ENTITY.StoreData;
import com.example.roomdatabase.R;

import java.util.ArrayList;

public class ShowDataAdapter extends RecyclerView.Adapter<ShowDataAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<StoreData> storeDataArrayList ;
    Context context;
    // constructor
    public ShowDataAdapter(ArrayList<StoreData> storeDataArrayList, Context context) {
        this.storeDataArrayList = storeDataArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_data_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.

        StoreData storeData = storeDataArrayList.get(position);
      holder.title.setText(storeData.getTitle());
      holder.amount.setText(storeData.getAmount());


    }



    @Override
    public int getItemCount() {
        return storeDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
private TextView title,amount;
        public ViewHolder(View itemview) {
            super(itemview);
            // initializing our text views

            title = itemview.findViewById(R.id.show_title_textview);
            amount = itemview.findViewById(R.id.show_amount_textview);




        }
    }




}
