package com.ashutosh.doodlesword;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Vostro-Daily on 8/6/2015.
 */
public class StudentPage {
    View currView;
    Person[] studentListItems = {new Person("Hello"),new Person("Bye")};
    //DynamicListAdapter dynamicListAdapter;
    DoodleRecyclerViewAdapter<Person> mAdapter;

    StudentPage(Context ctx, Bundle args){
        // read arguments
        String username = args.getString("username");

        LinearLayout ll = new LinearLayout(ctx);
        //ListView listView = new ListView(ctx);
        //ArrayList<View> views = new ArrayList<>();

        //SudentListItems = new ArrayList<>(Arrays.asList(ctx.getResources().getStringArray(R.array.stud_list)));
        RecyclerView rv = new RecyclerView(ctx);
        LinearLayoutManager llm = new LinearLayoutManager(ctx);
        rv.setLayoutManager(llm);
        mAdapter = new DoodleRecyclerViewAdapter<>(Arrays.asList(studentListItems));
        rv.setAdapter(mAdapter);
//        for(String item : studentListItems){
//            TextView textView = new TextView(ctx);
//            textView.setText(item);
//            views.add(textView);
//        }
//
//        dynamicListAdapter = new DynamicListAdapter(views , ctx);
//        listView.setAdapter(dynamicListAdapter);

        TextView tv = new TextView(ctx);
        tv.setText(username);
        ll.addView(tv);
        ll.addView(rv);

        currView = ll;
    }

    public View getView(){
        return currView;
    }
}
