package com.ashutosh.doodlesword;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Vostro-Daily on 7/24/2015.
 */
public class DynamicListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<View> views;
    private int count;


    public DynamicListAdapter(ArrayList<View> views, Context c){
        mContext = c;
        this.views = views;
        this.count = views.size();
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return views.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //if(convertView == null){      // use recycled convert view if convertView is not null
            convertView = new RelativeLayout(mContext);
        //}
        ViewGroup pr = (ViewGroup)views.get(position).getParent();  // pr = parent of views
        if(pr != null)
            pr.removeView(views.get(position));     // remove the parent if views have any

        ((RelativeLayout)convertView).addView(views.get(position));

        return (View)convertView;
    }
}
