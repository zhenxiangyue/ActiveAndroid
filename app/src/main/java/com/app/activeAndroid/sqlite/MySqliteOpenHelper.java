package com.app.activeAndroid.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/10/29.
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    public Context context;

    public static final String sql = "create table book (" +
            "id integer primary key autoincrement" +
            "auther text," +
            "price real," +
            "pages integer," +
            "name text" +
            ")";


    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        Toast.makeText(context, "Created Successed!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
