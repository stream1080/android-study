package com.example.myapplication.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.OverScroller;

import androidx.annotation.Nullable;

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private static int VERSION = 1;

    public MySqliteOpenHelper(@Nullable Context context, @Nullable String name) {
        super(context, name, null, VERSION);

    }

    public MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create Table student(ID INTERER primary key autoincrement,name varchar(20),telephone char(11)";//主键自增
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //版本更新的时候，变更版本号
        VERSION = newVersion;
    }
}
