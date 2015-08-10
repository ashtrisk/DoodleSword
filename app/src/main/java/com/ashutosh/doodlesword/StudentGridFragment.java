package com.ashutosh.doodlesword;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentGridFragment extends Fragment {

    private FrameLayout mFrameLayout;
    private GridView mGridView;
    private Context ctx;

    public StudentGridFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_student_grid, container, false);

        // add a grid view dynamically to the layout.
        mFrameLayout = (FrameLayout) rootView.findViewById(R.id.frame_layout_student_grid);
        ctx = getActivity();

//        final String[] student_names = new String[]{ "Ashu","Bhavna","Corey","Dimple","Eminem","Faiz",
//                "Gurminder","Hackd","Inamul","Jasmine","Krish","Lokesh","Marvan","Nathan","Obrian","Pariniti"};
//
//        mGridView = new GridView(getActivity());
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        mGridView.setLayoutParams(layoutParams);
//        //gridView.setId();
//        int dp10= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
//        mGridView.setHorizontalSpacing(dp10);
//        mGridView.setVerticalSpacing(dp10);
//        mGridView.setColumnWidth(dp10 * 14);
//        mGridView.setGravity(Gravity.CENTER);
//        mGridView.setNumColumns(GridView.AUTO_FIT);
//        mGridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
//                R.layout.list_item_grid_attendance, R.id.textView_grid_item, student_names);
//
//        mGridView.setAdapter(adapter);
//        mFrameLayout.addView(mGridView);

        RecyclerView recyclerView = new RecyclerView(ctx);
        GridLayoutManager glm = new GridLayoutManager(ctx, 2);
        recyclerView.setLayoutManager(glm);

        ArrayList<Student> students = new ArrayList<>();
        String [] names = {"Ashutosh","Gurminder","Arihant","Sourabh","Amit","Rohit","Parveen","Madhav","Gaurav","Nikhil","Rajkumar"
                        ,"Satyendra","Utkarsh","Shubham","Ankush","Prateek","Vicky","Pramod"};
        for(String name : names){
            Student s = new Student(name);
            students.add(s);
        }

        DoodleRecyclerViewAdapter<Student> adapter = new DoodleRecyclerViewAdapter<>(students);
        recyclerView.setAdapter(adapter);

//        students.clear();
//        adapter = new DoodleRecyclerViewAdapter<>(students);
//        recyclerView.setAdapter(adapter);

        mFrameLayout.addView(recyclerView);

        return rootView;
    }


}
