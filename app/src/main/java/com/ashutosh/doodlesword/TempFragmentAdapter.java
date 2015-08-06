package com.ashutosh.doodlesword;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by Satyender Yadav on 05-08-2015.
 */
public class TempFragmentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<TempFragment> tfrags;

    public TempFragmentAdapter(ArrayList<TempFragment> tfrags, Context c){
        mContext = c;
        this.tfrags = tfrags;
    }

    @Override
    public int getCount() {
        return tfrags.size();
    }

    @Override
    public Object getItem(int position) {
        return tfrags.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //if(convertView == null){      // use recycled convert view if convertView is not null
//        convertView = new RelativeLayout(mContext);
//        //}
//        ViewGroup pr = (ViewGroup)views.get(position).getParent();  // pr = parent of views
//        if(pr != null)
//            pr.removeView(views.get(position));     // remove the parent if views have any
//
//        ((RelativeLayout)convertView).addView(views.get(position));

        return null;
    }

//    public void setItem(View v,int position){
//        views.add(position,v);
//        this.count = views.size();
//        this.notifyDataSetChanged();
//    }
//
//    public void removeItem(int position){
//        views.remove(position);
//        this.count = views.size();
//        this.notifyDataSetChanged();
//    }
}
