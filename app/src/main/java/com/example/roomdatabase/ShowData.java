package com.example.roomdatabase;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.Adapter.ShowDataAdapter;
import com.example.roomdatabase.ENTITY.StoreData;
import com.example.roomdatabase.HELPER.DataBaseHelper;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {


    ArrayList<StoreData> arrStoreData;
    DataBaseHelper dataBaseHelper;
    ShowDataAdapter showDataAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);


        // initializing our all variables.

        arrStoreData = new ArrayList<>();
        dataBaseHelper = DataBaseHelper.getDB(this);

        // getting our course array
        // list from db handler class.

        ArrayList<StoreData> arrStoreData =( ArrayList<StoreData>)dataBaseHelper.storeDataDao().getData();

        // on below line passing our array list to our adapter class.
        showDataAdapter = new ShowDataAdapter(arrStoreData,ShowData.this);
        recyclerView = findViewById(R.id.show_data_rv);

        // setting layout manager for our recycler view.

      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowData.this, RecyclerView.VERTICAL,false);
      recyclerView.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        recyclerView.setAdapter(showDataAdapter);
















    }
}