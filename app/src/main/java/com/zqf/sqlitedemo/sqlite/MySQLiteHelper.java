package com.zqf.sqlitedemo.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * class from
 * Created by zqf
 * Time 2018/1/29 15:28
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    //构造函数
    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建用户表的sql语句
        Log.e("Tag", "执行onCreate");
        String user_sql = "create table user (id integer primary key autoincrement," + "name vachar(20)," + "age integer," + "age integer)";
        db.execSQL(user_sql);
        db.close();
    }

    //升级表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
