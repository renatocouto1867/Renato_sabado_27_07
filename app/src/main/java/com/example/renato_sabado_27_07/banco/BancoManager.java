package com.example.renato_sabado_27_07.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoManager {
    private BancoHelper dbHelper;
    private SQLiteDatabase database;

    public BancoManager(Context context) {
        dbHelper = new BancoHelper(context);
    }

    public SQLiteDatabase open() {
        database = dbHelper.getWritableDatabase();
        return database;
    }

    public void close() {
        dbHelper.close();
    }


}//BancoManager
