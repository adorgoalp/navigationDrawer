package com.adorgolap.localedatabaseimport;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Context context;
    TextView tvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        tvTest = (TextView)findViewById(R.id.tvTest);
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        try {
            dbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dbHelper.openDataBase();
        Cursor c = dbHelper.getQuestions(2);
        String result = "";
        while (c.moveToNext())
        {
            String question = c.getString(c.getColumnIndex("question"));
            result += question;
        }
        tvTest.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
