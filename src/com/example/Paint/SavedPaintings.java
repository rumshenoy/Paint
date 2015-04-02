package com.example.Paint;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by ramyashenoy on 12/9/14.
 */
public class SavedPaintings extends ListActivity {

    DBOpenHelper dbOpenHelper;
    SQLiteDatabase readableDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbOpenHelper = new DBOpenHelper(this, "My_Database", 3);
        readableDatabase = dbOpenHelper.getReadableDatabase();

        ArrayList<String> fileNames = getSavedFileNames();
        String[] savedFiles = new String[fileNames.size()];
        savedFiles = fileNames.toArray(savedFiles);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.saved, savedFiles));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

                Intent paintIntent = new Intent(SavedPaintings.this, ViewActivity.class);
                paintIntent.putExtra("fileToLoad", ((TextView) view).getText());
                SavedPaintings.this.startActivity(paintIntent);
            }
        });
    }

    private ArrayList<String> getSavedFileNames() {

        Cursor c = readableDatabase.rawQuery("SELECT * FROM FILES", null);
        ArrayList<String> fileNames = new ArrayList<String>();
        for (int i = 0; i < c.getCount(); i++) {
            c.moveToNext();
            Log.i("SqliteAndroid", "Filename=" + c.getString(0));
            fileNames.add(c.getString(0));
        }


        readableDatabase.close();
        return fileNames;
    }
}