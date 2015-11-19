package com.adorgolap.localedatabaseimport;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ifta on 11/19/15.
 */
public class ChapterActivity extends Activity {
    Context context;
    ListView lv;
    ArrayList<String > chapters = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    int _id = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        _id = getIntent().getIntExtra("_id",-1);
        lv = (ListView) findViewById(R.id.lvSubjects);
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbHelper.openDataBase();
        if(_id != -1) {
            Cursor cursor = dbHelper.getChapters(_id);
            while (cursor.moveToNext()) {
                chapters.add(cursor.getString(cursor.getColumnIndex("name")));
                ids.add(cursor.getInt(cursor.getColumnIndex("_id")));
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, chapters);
            lv.setAdapter(adapter);
        }
    }
}

