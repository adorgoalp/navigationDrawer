package com.adorgolap.localedatabaseimport;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;

public class SubjectActivity extends Activity {
    Context context;
    //    ListView lv;
//    ListView navList;
    GridView gridView;
    //    ArrayList<String> navItems = new ArrayList<String>();
    ArrayList<String> subjects = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        context = this;
        gridView = (GridView) findViewById(R.id.gridview);

//        lv = (ListView) findViewById(R.id.lvSubjects);
//        navList = (ListView)findViewById(R.id.left_drawer);
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbHelper.openDataBase();
        Cursor cursor = dbHelper.getSubjects();
        while (cursor.moveToNext()) {
            subjects.add(cursor.getString(cursor.getColumnIndex("name")));
            ids.add(cursor.getInt(cursor.getColumnIndex("_id")));
        }
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        subjects.add("A");
        ImageAdapter adapter = new ImageAdapter(context, subjects);
        gridView.setAdapter(adapter);
    }
}
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,subjects);
//        lv.setAdapter(adapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(context, ChapterActivity.class);
//                intent.putExtra("_id", ids.get(position));
//                startActivity(intent);
//            }
//        });
////        navItems.add("Item a");
////        navItems.add("Item b");
////        navItems.add("Item c");
////        navItems.add("Item d");
////        ArrayAdapter<String> navAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,navItems);
//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        View v = inflater.inflate(R.layout.header, null);
//        v.setActivated(false);
//        v.setClickable(false);
//        navList.addHeaderView(v);
////        navList.addFooterView(inflater.inflate(R.layout.header,null));
//        navList.setAdapter(adapter);
//        navList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position !=0) {
//                    Intent intent = new Intent(context, ChapterActivity.class);
//                    intent.putExtra("_id", ids.get(position - 1));
//                    startActivity(intent);
//                }
//            }
//        });
//    }
//}
