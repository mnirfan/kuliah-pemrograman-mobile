package com.nurulirfan.m004_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mnirfan on 15/05/17.
 */

public class ListDBHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "data.sql";
    protected static final int DATABASE_VERSION = 1;

    public ListDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE data ("+
                    "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "text TEXT)");
    }

    public void insert(ItemData data){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO data (text) VALUES (?)", new String[]{data.text});
        db.close();
    }

    public List<ItemData> getAll(){
        SQLiteDatabase db = getReadableDatabase();
        List<ItemData> res = new LinkedList<ItemData>();
        Cursor cur = db.rawQuery("SELECT  id, text FROM data", null);
        if (!cur.moveToFirst()){
            cur.close();
            return res;
        }

        do {
            ItemData data = new ItemData();
            data.id = cur.getLong(0);
            data.text = cur.getString(1);
            res.add(data);
        } while (cur.moveToNext());

        cur.close();
        db.close();

        return res;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }
}
