package com.ashutosh.doodlesword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */
public class ParentActivityFragment extends Fragment {

    ArrayList<String> parentListItems;
    TextView mTextView;
    ListView mListView;
    Context mContext;

    public ParentActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_parent, container, false);

        mContext = getActivity();
        mTextView = ViewProvider.getTextView(mContext,"Hello Parent!");
        // find listView set string array and add adapter to it.
        //parentListItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.stud_lis)));
        mListView = (ListView) rootView.findViewById(R.id.listView_student);

        mListView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.list_item_textView, parentListItems));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getActivity(), parentListItems.get(position), Toast.LENGTH_SHORT).show();
                Intent intent;
                String item = parentListItems.get(position);
                Context context = getActivity();
                if (item.equalsIgnoreCase("Goals")) {
                    //Launch Students goals activity
                    intent = new Intent(context, GoalsActivity.class);
                    startActivity(intent);
                } else if (item.equalsIgnoreCase("Curriculum")) {
                    // Launch Teachers curriculum
                    intent = new Intent(context, StudentCurriculum.class);
                    startActivity(intent);
                } else if (item.equalsIgnoreCase("performance")) {
                    // Launch Performance ( Teacher Assessment ) activity which in view only
                    intent = new Intent(context, Assessment.class);
                    startActivity(intent);
                } else if (item.equalsIgnoreCase("Location Tracker")) {
                    // Launch location Tracker activity
                    intent = new Intent(context, LocationActivity.class);
                    startActivity(intent);
                } else if (item.equalsIgnoreCase("Interact")) {
                    intent = new Intent(context, Interact.class);
                    startActivity(intent);
                } else if(item.equalsIgnoreCase("Do Some Stuff")){
                    // launch intent to DoSomeStuff activity
                }
            }
        });
        return rootView;
    }
}
