package com.ashutosh.doodlesword;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Satyender Yadav on 07-08-2015.
 */
public class TeacherPage {
    View currView;
    Person[] studentListItems = {new Person("Goals"),new Person("Curriculum"),new Person("Performance"),new Person("Location"),new Person("Messaging")};
    //DynamicListAdapter dynamicListAdapter;
    DoodleRecyclerViewAdapter<Person> mAdapter;

    TeacherPage(Context ctx, Bundle args){
        // read arguments
        String username = args.getString("username");

        RelativeLayout rl = new RelativeLayout(ctx);
        //ll.setLayoutParams(new FragmentLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT,ViewPager.LayoutParams.MATCH_PARENT));
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
        tv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 260));
        rl.addView(tv);
        rl.addView(rv);

        currView = rl;
    }

    public View getView(){
        return currView;
    }
}
