package com.example.ddbb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_search_book, btn_add_book, btn_buy_book, btn_delete_book;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add_book = findViewById(R.id.main_btn_add_book);
        btn_buy_book = findViewById(R.id.main_btn_buy_book);
        btn_delete_book = findViewById(R.id.main_btn_remove_books);
        btn_search_book = findViewById(R.id.main_btn_serach_Book);

        btn_search_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  i = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(i);


            }
        });
        btn_add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  i = new Intent(getBaseContext(), AddActivity.class);
                startActivity(i);


            }
        });
        btn_buy_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  i = new Intent(getBaseContext(), BuyActivity.class);
                startActivity(i);


            }
        });
        btn_delete_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             i = new Intent(getBaseContext(), DeleteActivity.class);
                startActivity(i);


            }
        });


    }
}