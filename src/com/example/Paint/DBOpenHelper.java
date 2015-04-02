package com.example.Paint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by ramyashenoy on 12/9/14.
 */
class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String dbName, int version) {
        // third argument id to a cursor factory -- we don't care about
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS FILES (FILENAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FILES");
        this.onCreate(db);
    }
}