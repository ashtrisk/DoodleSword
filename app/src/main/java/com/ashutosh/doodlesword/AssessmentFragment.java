package com.ashutosh.doodlesword;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssessmentFragment extends Fragment {

    private GridView mGridView;
    private FrameLayout mFrameLayout;
    String [] names = {"Ashutosh","Gurminder","Arihant","Sourabh","Amit","Rohit","Parveen","Madhav","Gaurav","Nikhil","Rajkumar"
            ,"Satyendra","Utkarsh","Shubham","Ankush","Prateek","Vicky","Pramod"};

    public AssessmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_assessment, container, false);
//        // add a grid view dynamically to the layout.
        mFrameLayout = (FrameLayout) rootView.findViewById(R.id.frame_layout_assessment);
//        final String[] student_names = new String[]{ "Ashu","Bhavna","Corey","Dimple","Eminem","Faiz",
//                "Gurminder","Hackd","Inamul","Jasmine","Krish","Lokesh","Marvan","Nathan","Obrian","Pariniti"};
//
//        mGridView = new GridView(getActivity());
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        mGridView.setLayoutParams(layoutParams);
//        //mGridView.setId();
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

        Context ctx = getActivity();
        RecyclerView recyclerView = new RecyclerView(ctx);
        GridLayoutManager glm = new GridLayoutManager(ctx, 2);
        recyclerView.setLayoutManager(glm);

        ArrayList<Student11> students = new ArrayList<>();

        for(String name : names){
            Student11 s = new Student11(name);
            students.add(s);
        }

        DoodleRecyclerViewAdapter<Student11> adapter = new DoodleRecyclerViewAdapter<>(students);
        recyclerView.setAdapter(adapter);

        mFrameLayout.addView(recyclerView);

        return rootView;
    }

    public class Student11 extends DoodleRecylerViewSetter{
        String name;
        Student11(String str){
            name = str;
        }

        @Override
        protected void setViewChild(ViewGroup v) {
            Context ctx = v.getContext();
            FrameLayout frameLayout = ViewProvider.getFrameLayout(ctx);

            final TextView textView = ViewProvider.getTextView(ctx, name);
            textView.setTextSize(30);
            textView.setMinHeight(40);
//            textView.setBackgroundColor(Color.WHITE);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    view.setBackgroundColor(Color.YELLOW);
                    Intent intent = new Intent(view.getContext(), AssessStudentsActivity.class);
                    intent.putExtra("Student", name);
                    intent.putStringArrayListExtra("Students",new ArrayList<String>( Arrays.asList(names)));
                    startActivity(intent);
                }
            });
            frameLayout.addView(textView);

            v.addView(frameLayout);
        }
    }

}
