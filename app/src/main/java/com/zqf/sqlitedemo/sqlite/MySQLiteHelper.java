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
    private static final String db_Name = "db_one.db";
    private static final String db_table = "user";
    private static final int db_version = 1;

    //构造函数
    public MySQLiteHelper(Context context) {
        super(context, db_Name, null, db_version);
    }

    //创建表
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建用户表的sql语句
        Log.e("Tag", "执行onCreate");
        String user_sql = "create table if not exists " + db_table
                + "(_id integer primary key autoincrement, "
                + "name varchar(5),"
                + "sex integer,"
                + "age integer)";
        db.execSQL(user_sql);
    }

    //升级表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("Tag", "执行onUpgrade");
    }
}
