package com.ashutosh.doodlesword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */
public class TeacherActivityFragment extends Fragment {

    private ArrayList<String> teacher_items_list;
    private WindowManager windowManager;
    private RelativeLayout mRelativeLayout;
    private ListView mListView;
    private TextView mTextView;

    public TeacherActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teacher, container, false);

        // add listView_teacher here and set Adapter to it.
        // Get the string array
        teacher_items_list = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.teacher_items)));

        // find the list view in the fragment_teacher layout xml file
//        mListView = (ListView) rootView.findViewById(R.id.listView_teacher);

        windowManager = (WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
        int height = windowManager.getDefaultDisplay().getHeight();

        mRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.relative_layout_teacher);
        mRelativeLayout.setMinimumHeight(height);

        mTextView = new TextView(getActivity());
        mTextView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height / 2));
        mTextView.setId(R.id.textView11);
        mTextView.setText("Hello Teacher!");

        mRelativeLayout.addView(mTextView);

        mListView = new ListView(getActivity());
        RelativeLayout.LayoutParams rLParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int)(height / 2.5));
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        rLParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mListView.setLayoutParams(rLParams);

        mRelativeLayout.addView(mListView, rLParams);

        // set adapter to the list view to inflate the list view with the string-array having layout of items as specified.

//        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.list_item_textView, teacher_items_list));
        // adding a custom adapter.
        final Context mContext = getActivity();
        ArrayList<View> views = new ArrayList<>();
        ArrayList<RelativeLayout> relativeLayouts = new ArrayList<RelativeLayout>();
        RelativeLayout tlout; // a temporary layout
        int length = teacher_items_list.size();

        int minHeight = height / 10, textSize = minHeight/5;
        // item - 1 : goals
        TextView textView = new TextView(mContext);
        textView.setText(teacher_items_list.get(0));
        textView.setClickable(true);
        textView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setMinHeight(minHeight);
        textView.setTextSize(textSize);
        textView.setGravity(Gravity.CENTER);
        //textView.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        //textView.getLayoutParams().height = 50;
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, GoalsActivity.class);
                mContext.startActivity(intent);
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView);

        relativeLayouts.add(tlout);

        // item - 2 : curriculum
        TextView textView1 = new TextView(mContext);
        textView1.setText(teacher_items_list.get(1));
        textView1.setClickable(true);
        textView1.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView1.setMinHeight(minHeight);
        textView1.setTextSize(textSize);
        textView1.setGravity(Gravity.CENTER);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TeacherCurriculum.class);
                mContext.startActivity(intent);
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView1);
        relativeLayouts.add(tlout);

        // item - 3 : assessment
        TextView textView2 = new TextView(mContext);
        textView2.setText(teacher_items_list.get(2));
        textView2.setClickable(true);
        textView2.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView2.setMinHeight(minHeight);
        textView2.setTextSize(textSize);
        textView2.setGravity(Gravity.CENTER);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Assessment.class);
                mContext.startActivity(intent);
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView2);
        relativeLayouts.add(tlout);

        // item -4 : attendance
        TextView textView3 = new TextView(mContext);
        textView3.setText(teacher_items_list.get(3));
        textView3.setClickable(true);
        textView3.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView3.setMinHeight(minHeight);
        textView3.setTextSize(textSize);
        textView3.setGravity(Gravity.CENTER);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Attendance.class);
                mContext.startActivity(intent);
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView3);
        relativeLayouts.add(tlout);

        // item - 5 : interact
        TextView textView4 = new TextView(mContext);
        textView4.setText(teacher_items_list.get(4));
        textView4.setClickable(true);
        textView4.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView4.setMinHeight(minHeight);
        textView4.setTextSize(textSize);
        textView4.setGravity(Gravity.CENTER);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Interact.class);
                mContext.startActivity(intent);
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView4);
        relativeLayouts.add(tlout);

        // item - 6 : do some stuff
        TextView textView5 = new TextView(mContext);
        textView5.setText(teacher_items_list.get(5));
        textView5.setClickable(true);
        textView5.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView5.setMinHeight(minHeight);
        textView5.setTextSize(textSize);
        textView5.setGravity(Gravity.CENTER);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(mContext, DoSomeStuff.class);
//                mContext.startActivity(intent);
                Toast.makeText(mContext, "Do Some stuff", Toast.LENGTH_SHORT).show();
            }
        });
        tlout = new RelativeLayout(mContext);
        tlout.addView(textView5);
        relativeLayouts.add(tlout);

        // add all Views/relativeLayouts ( each element of relativeLayouts array list to views array list
        views.add(relativeLayouts.get(0));
        views.add(relativeLayouts.get(1));
        views.add(relativeLayouts.get(2));
        views.add(relativeLayouts.get(3));
        views.add(relativeLayouts.get(4));
        views.add(relativeLayouts.get(5));

        // set adapter onto the listView
        mListView.setAdapter(new DynamicListAdapter(views, getActivity()));

        // set an onItemClickListener to the list to hear selection of an item in the list and respond appropiately
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // get the selected item
//                String item = teacher_items_list.get(position);
//                // compare item to launch appropriate activity
//                if (item.equalsIgnoreCase("goals")) {
//                    // launch goals activity
//                    Intent intent = new Intent(getActivity(), GoalsActivity.class);
//                    startActivity(intent);
//                }else if(item.equalsIgnoreCase("curriculum")){
//                    // launch curriculum activity
//                    Intent intent = new Intent(getActivity(), TeacherCurriculum.class);
//                    startActivity(intent);
//                }else if(item.equalsIgnoreCase("assessment")){
//                    // launch assessment activity
//                    Intent intent = new Intent(getActivity(), Assessment.class);
//                    startActivity(intent);
//                }else if(item.equalsIgnoreCase("attendance")){
//                    // launch attendance activity
//                    Intent intent = new Intent(getActivity(), Attendance.class);
//                    startActivity(intent);
//                }else if(item.equalsIgnoreCase("interact")){
//                    // launch interact activity
//                    Intent intent = new Intent(getActivity(), Interact.class);
//                    startActivity(intent);
//                }else {
//                    Toast.makeText(getActivity(), teacher_items_list.get(position), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return rootView;
    }
}
