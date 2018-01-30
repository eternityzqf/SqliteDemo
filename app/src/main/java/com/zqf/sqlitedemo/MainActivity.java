package com.zqf.sqlitedemo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zqf.sqlitedemo.sqlite.MySQLiteHelper;

public class MainActivity extends AppCompatActivity {
    private SQLiteOpenHelper mOpenHelper;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.create_db_table_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建表
                Log.e("Tag", "create_db_table_btn");
                mOpenHelper = new MySQLiteHelper(MainActivity.this);
                mDatabase = mOpenHelper.getWritableDatabase();
                mDatabase.close();
            }
        });
        findViewById(R.id.insert_data_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //插入数据
                Log.e("Tag", "insert_data_btn");

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mOpenHelper != null) {
            mOpenHelper.close();
            mOpenHelper = null;
        }
    }
}
