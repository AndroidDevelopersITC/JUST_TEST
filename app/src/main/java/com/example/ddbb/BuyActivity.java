package com.example.ddbb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {
    EditText et_book_buy;
    Button btn_buy;
    Access_DataBase access_dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        et_book_buy = findViewById(R.id.buy_et_buy_name);
        btn_buy = findViewById(R.id.buy_btn_buy_name);
        access_dataBase = Access_DataBase.getInstance(this);
        access_dataBase.Open();
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<LibContans> arrayList = access_dataBase.search_items(et_book_buy.getText().toString());
                int x = arrayList.get(0).getAmount_book();
                arrayList.get(0).setAmount_book(x - 1);
                access_dataBase.update_itmes(arrayList.get(0), et_book_buy.getText().toString());
                access_dataBase.Close();

            }
        });


    }
}