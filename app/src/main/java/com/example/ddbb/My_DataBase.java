package com.example.ddbb;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


class My_DataBase extends SQLiteAssetHelper {
    public static final String  DB_NAME="lala.db";
    public static final String  TB_NAME = "tt";
 //   public static final String CLN_ID="id_book";
    public static final String CLN_NAME="name";
    public static final String CLN_AMOUNT="amount";
    public static final String CLN_PRICE="price";
    public static final int VERSION=1;




    public My_DataBase(Context context ) {


        super(context,DB_NAME,  null, VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
