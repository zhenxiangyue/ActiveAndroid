package com.app.activeAndroid.sqlite;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.app.activeAndroid.R;

/**
 * Created by Administrator on 2017/10/29.
 */

public class SqliteActivity extends AppCompatActivity {

    private MySqliteOpenHelper mySqliteOpenHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_sqlite);

        mySqliteOpenHelper = new MySqliteOpenHelper(this, "BookStore.db", null, 1);

        findViewById(R.id.btnCreateSQL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySqliteOpenHelper.getWritableDatabase();
            }
        });


    }
}
