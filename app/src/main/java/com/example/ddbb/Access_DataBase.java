package com.example.ddbb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class Access_DataBase {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static Access_DataBase instance;

    private Access_DataBase(Context context) {
        this.sqLiteOpenHelper = new My_DataBase(context);


    }

    public static Access_DataBase getInstance(Context context) {
        if (instance == null) {
            instance = new Access_DataBase(context);


        }
        return instance;


    }

    public void Open() {
        this.sqLiteDatabase = this.sqLiteOpenHelper.getWritableDatabase();


    }

    public void Close() {
        if (this.sqLiteDatabase != null)
            this.sqLiteDatabase.close();


    }


    public boolean remove_itmes(String name) {

        String agrs[] = {name};

        int s = sqLiteDatabase.delete(My_DataBase.TB_NAME, " name = ?", agrs);
        if (s == 0)
            return false;
        return true;


    }

    public long itmes_count() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, My_DataBase.TB_NAME);


    }

    public ArrayList<LibContans> getItems() {

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  " +My_DataBase.TB_NAME, null);
        ArrayList<LibContans> itemsArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {


            do {
              //  int id = cursor.getInt(cursor.getColumnIndex(My_DataBase.CLN_ID));

                String name = cursor.getString(cursor.getColumnIndex(My_DataBase.CLN_NAME));
                int amount = cursor.getInt(cursor.getColumnIndex(My_DataBase.CLN_AMOUNT));
                double price = cursor.getDouble(cursor.getColumnIndex(My_DataBase.CLN_PRICE));


                LibContans item = new LibContans( name, amount, price);
                itemsArrayList.add(item);

            } while (cursor.moveToNext());
            cursor.close();
        }

        return itemsArrayList;
    }

    public boolean insert_itmes(LibContans items) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(My_DataBase.CLN_AMOUNT, items.getAmount_book());
        contentValues.put(My_DataBase.CLN_NAME, items.getName_book());
        contentValues.put(My_DataBase.CLN_PRICE, items.getPrice_book());
        int s = (int) sqLiteDatabase.insert(My_DataBase.TB_NAME, null, contentValues);

        if (s == -1) {
            return false;

        }
        return true;

    }

    public ArrayList<LibContans> search_items(String nameBook) {
        String a[] = {nameBook};
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + My_DataBase.TB_NAME + " where name  = ? ", a);
        ArrayList<LibContans> itemsArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {


            do {
               // int id = cursor.getInt(cursor.getColumnIndex(My_DataBase.CLN_ID));

                String name = cursor.getString(cursor.getColumnIndex(My_DataBase.CLN_NAME));
                int amount = cursor.getInt(cursor.getColumnIndex(My_DataBase.CLN_AMOUNT));
                double price = cursor.getDouble(cursor.getColumnIndex(My_DataBase.CLN_PRICE));

                LibContans item = new LibContans( name, amount, price);
                itemsArrayList.add(item);

            } while (cursor.moveToNext());
            cursor.close();
        }
        return itemsArrayList;
    }

    public boolean update_itmes(LibContans items, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(My_DataBase.CLN_AMOUNT, items.getAmount_book());
        contentValues.put(My_DataBase.CLN_NAME, items.getName_book());
        contentValues.put(My_DataBase.CLN_PRICE, items.getPrice_book());


        String agrs[] = {name};

        int s = sqLiteDatabase.update(My_DataBase.TB_NAME, contentValues, " name =?", agrs);
        if (s == 0)
            return false;
        return true;


    }
}
