package com.example.bajian.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by hgx on 2015/8/23.
 */
public class SqlDao {
    private DBhelper dbhelper;
    private static String TAG="SqlDao";

    public SqlDao(Context context)
    {
        dbhelper = new DBhelper(context);
    }

    public void insert(String name,String pwd)
    {
        Log.d(TAG, "insert"+name+"-"+pwd);
        String sql = "insert into users (name,password) values('"+name+"','"+pwd+"') ;";
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }
    public void query(String name)
    {
        Log.d(TAG, "query"+name);
        String sql = "select * from users where name= '"+name+"' limit 0,30";
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor c =db.rawQuery(sql, new String[]{});
        if (c.moveToFirst()){
            Log.d(TAG,"query result:"+c.getInt(0));
            Log.d(TAG,"query result:"+c.getString(1));
            Log.d(TAG,"query result:"+c.getString(2));
        }
        c.close();

        db.close();
    }

    public void queryAll()
    {
        Log.d(TAG, "queryAll");
        String sql = "select * from users limit 0,30";
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor c =db.rawQuery(sql, new String[]{});
        while (c.moveToNext()){
            Log.d(TAG,"query result:"+c.getInt(0));
            Log.d(TAG,"query result:"+c.getString(1));
            Log.d(TAG,"query result:"+c.getString(2));
        }
        c.close();
        db.close();
    }


}
