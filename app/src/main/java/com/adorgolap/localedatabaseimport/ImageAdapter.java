package com.adorgolap.localedatabaseimport;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ifta on 11/19/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> items;
    public ImageAdapter(Context c,ArrayList<String> items) {
        mContext = c;
        this.items = items;
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
       TextView textView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            textView = new TextView(mContext);
//            textView.setLayoutParams(new GridView.LayoutParams(300, 300));
//            textView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            textView.setPadding(8, 8, 8, 8);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(items.get(position));
        return textView;
    }
}