package com.ashutosh.doodlesword;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AssessMeFragment extends Fragment {

    RelativeLayout rl;
    Context ctx ;
    String studentName = null;
    ArrayList<DoodleRecylerViewSetter> traitList;
//    private GestureDetectorCompat mDetector;

    public AssessMeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_assess_me, container, false);
        if(getArguments()!=null)
            studentName = getArguments().getString("Student");
        ctx = getActivity();

        rl = (RelativeLayout)rootView.findViewById(R.id.relative_layout_assess_me);
        TextView tv = new TextView(ctx);
        tv.setText(studentName);
        tv.setId(1);

        RecyclerView recyclerView = new RecyclerView(ctx);
        LinearLayoutManager llm = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(llm);

        traitList = new ArrayList<>();
        String [] traits = {"Super Abilities","IQ level","Class Behaviour","Co-operative","Grittiness","Punctuality"};
        for(String item : traits){
            Trait t = new Trait(item);
            traitList.add(t);
        }
        Hardworking h = new Hardworking("Hardworking");
        traitList.add(h);

        DoodleRecyclerViewAdapter<DoodleRecylerViewSetter> adapter = new DoodleRecyclerViewAdapter<>(traitList);
        recyclerView.setAdapter(adapter);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, tv.getId());

        rl.addView(tv);
        rl.addView(recyclerView, params);
//
//        mDetector = new GestureDetectorCompat(getActivity(), new MyGestureListener());
//        rootView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return mDetector.onTouchEvent(motionEvent);
//            }
//        });

        return rootView;
    }


    public class Trait extends DoodleRecylerViewSetter {
        String text;

        Trait(String str) {
            text = str;
        }

        @Override
        protected void setViewChild(ViewGroup v) {
            RelativeLayout relativeLayout = ViewProvider.getRelativeLayout(v.getContext());

            TextView textView = new TextView(v.getContext());
            textView.setText(text);
            textView.setId(11);
            textView.setTextSize(30);
            textView.setMinHeight(30);
//            textView.setMaxHeight();

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), ((TextView) view).getText(), Toast.LENGTH_LONG).show();
                }
            });

//            EditText et = ViewProvider.getEditText(v.getContext(), "Enter");
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params.addRule(RelativeLayout.BELOW);

            relativeLayout.addView(textView);
//            relativeLayout.addView(et, params);
            v.addView(relativeLayout);
        }
    }

    public class Hardworking extends DoodleRecylerViewSetter {
        String text;

        Hardworking(String str) {
            text = str;
        }

        @Override
        protected void setViewChild(ViewGroup v) {
            RelativeLayout relativeLayout = ViewProvider.getRelativeLayout(v.getContext());

            String [] strings = {"Low","Average","High","Exceptional"};
            ArrayList<View> views = new ArrayList<>();
            for(String item : strings){
                TextView tv = new TextView(v.getContext());
                tv.setText(item);
                views.add(tv);
            }
            final Spinner spinner = new Spinner(v.getContext());
            DynamicListAdapter adapter = new DynamicListAdapter(views, v.getContext());
            spinner.setAdapter(adapter);
//            TextView tv = new TextView(ctx);
//            tv.setText("Hardworking");
//            spinner.setEmptyView(tv);
//            spinner.setPrompt("Hardworking");

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    int pos = spinner.getSelectedItemPosition();
                    spinner.setSelection(pos);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            relativeLayout.addView(spinner);
            v.addView(relativeLayout);
        }
    }

//    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
//
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2,
//                               float velocityX, float velocityY){
//
//            float diffX = e2.getX() - e1.getX();
//
//            if(diffX > 0){
//                onSwipeRight();
//            } else {
//                onSwipeLeft();
//            }
//            return true;
//        }
//
//        public void onSwipeLeft(){
//            Toast.makeText(getActivity(), "Swiped right to left", Toast.LENGTH_SHORT).show(); // error in getApplicationContext() may be...
//             launching an intent to canvas grid
//            Intent intent = new Intent(getActivity(), TeacherCurriculum.class);  // error may occur here...
//            startActivity(intent);
//        }
//
//        public void onSwipeRight(){
//            Toast.makeText(getActivity(), "Swiped left to right", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return true;
//        }
//    }
}
