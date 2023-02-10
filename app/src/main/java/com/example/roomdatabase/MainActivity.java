package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roomdatabase.ENTITY.StoreData;
import com.example.roomdatabase.HELPER.DataBaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTitle, edtamount;
    Button btnSumbit,btnView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();





    }

    private void initialize(){



        edtTitle = findViewById(R.id.title);
        edtamount = findViewById(R.id.amount);
        btnSumbit = findViewById(R.id.button);
        btnView = findViewById(R.id.button2);

        DataBaseHelper dataBaseHelper = DataBaseHelper.getDB(this);
        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = edtTitle.getText().toString();
                String amount = edtamount.getText().toString();

                if (title.isEmpty() || amount.isEmpty() ) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;

                }

                dataBaseHelper.storeDataDao().addData(
                        new StoreData(title, amount)

                );

                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                edtTitle.setText("");
                edtamount.setText("");
                




            }
        });


        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowData.class);

                startActivity(intent);



            }
        });












    }






}