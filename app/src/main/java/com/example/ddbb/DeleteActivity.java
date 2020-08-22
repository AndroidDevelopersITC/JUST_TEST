package com.example.ddbb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {
    EditText et_delete_name;
    Button btn_delete_name;
    Access_DataBase access_dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        et_delete_name = findViewById(R.id.delete_et_search_name);
        btn_delete_name = findViewById(R.id.delete_btn_delete_name);
        access_dataBase = Access_DataBase.getInstance(this);
        access_dataBase.Open();
    btn_delete_name.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean b = access_dataBase.remove_itmes(et_delete_name.getText().toString());
            Toast.makeText(getBaseContext(), b + "", Toast.LENGTH_LONG).show();
        }
    });
        access_dataBase.Close();

    }
}