package com.example.Paint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ramyashenoy on 12/9/14.
 */
public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        System.out.println("in here");
    }

    public void startPaintingActivity(View view){
        Intent paintIntent = new Intent(MainActivity.this, MyActivity.class);
        MainActivity.this.startActivity(paintIntent);
    }

    public void showSavedPaintingsActivity(View view){
        Intent paintIntent = new Intent(MainActivity.this, SavedPaintings.class);
        MainActivity.this.startActivity(paintIntent);
    }
}