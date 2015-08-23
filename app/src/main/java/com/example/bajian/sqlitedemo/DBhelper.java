package com.example.bajian.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hgx on 2015/8/23.
 */
public class DBhelper extends SQLiteOpenHelper {
    private  static String TAG="DBhelper";
    private  static String DB_NAME="sql.db";
    private  static int VERSION=1;

    public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBhelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public DBhelper(Context context,int version) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"onCreate");
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id integer primary key autoincrement, name varchar(60), password varchar(60))");
        db.execSQL("CREATE TABLE IF NOT EXISTS application (id integer primary key autoincrement, s varchar(60), tt varchar(60),st varchar(60),tc1 varchar(60), tc2 varchar(60), ru varchar(60),tn varchar(60),m varchar(60))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //在这里更新表，比如增加或者删除表，表的改名等等
        Log.d(TAG,"onUpgrade"+newVersion);
    }
}
