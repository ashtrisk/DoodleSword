package com.ashutosh.doodlesword;


import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewGoalFragment extends Fragment {

    private FrameLayout mFrameLayout;
    private List<String> headerList;
    private HashMap<String, List<String>> childList;
    public AddNewGoalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_new_goal, container, false);
        mFrameLayout = (FrameLayout)rootView.findViewById(R.id.frameLayout_add_goal);

        String [] classList = {"class 5", "class 6", "class 7"};
        String [] subList = {"sub 1", "sub 2", "sub 3"};
        String [] unitList = {"unit 1", "unit 2", "unit 3", "unit 4"};
        String [] sectionList = {"section 1", "section 2", "section 3", "section 4"};
        String [] subSectionList = {"sub-section 1", "sub-section 2", "sub-section 3", "sub-section 4"};
        String [] topicList = {"topic 1","topic 2","topic 3","topic 4","topic 5"};

        ArrayList<String[]> curriculumList = new ArrayList<>();
        curriculumList.add(classList);
        curriculumList.add(subList);
        curriculumList.add(unitList);
        curriculumList.add(sectionList);
        curriculumList.add(subSectionList);
        curriculumList.add(topicList);

        Context ctx = getActivity();
        RecyclerView rv = new RecyclerView(ctx);
        LinearLayoutManager llm = new LinearLayoutManager(ctx);
        rv.setLayoutManager(llm);

        ArrayList<DoodleRecylerViewSetter> list = new ArrayList<>();

        GoalItem item11 = new GoalItem("Goal Name", "editText");
        list.add(item11);
        GoalItem item22 = new GoalItem("Set Alarm", "checkBox");
        list.add(item22);
//        String [] content = {"class", "unit", "section", "sub-section"};
//        GoalItem item33 = new GoalItem("Select Content", "spinner", content);
//        list.add(item33);
//        GoalItem item40 = new GoalItem("From", "datePickerSpinner");
//        list.add(item40);

//        for(String[] itemList : curriculumList){
//            GoalItem item = new GoalItem("Select", "spinner", itemList);
//            list.add(item);
//        }
        prepareList();      // called whenever we need an expandableListView
        GoalItem itemX = new GoalItem("Select", "expandableListView", headerList, childList);
        list.add(itemX);
        GoalItem item44 = new GoalItem("Description", "multiLineText");
        list.add(item44);
        GoalItem itemLast = new GoalItem("UnsetAll");
        list.add(itemLast);

        DoodleRecyclerViewAdapter<DoodleRecylerViewSetter> adapter = new DoodleRecyclerViewAdapter<>(list);
        rv.setAdapter(adapter);
//        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        mFrameLayout.addView(rv);

//        if(savedInstanceState!=null){
//            return null;
//        }
        return rootView;
    }

    public class GoalItem extends DoodleRecylerViewSetter {
        String text;
        String type;
        String [] itemList;
        List<String> listDataHeader;
        HashMap<String, List<String>> listDataChild;

        GoalItem(String str, String type, List<String> headerList, HashMap<String, List<String>> childList){
            text = str;     this.type = type;
            listDataHeader = headerList;
            listDataChild = childList;
        }
        GoalItem(String str, String type, String [] list){
            text = str;     this.type = type;       itemList = list;
        }
        GoalItem(String str, String type) {
            this(str, type, null);
        }
        GoalItem(String str){
            this(str, new String());
        }

        @Override
        protected void setViewChild(ViewGroup v) {
            final Context ctx = v.getContext();
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.height = 80;

            if(type.equalsIgnoreCase("editText")){
                EditText et = ViewProvider.getEditText(ctx, text);
                et.setSingleLine();
                et.setTextSize(30);
                v.addView(et, params);
            }else if(type.equalsIgnoreCase("checkBox")){
                CheckBox checkBox = ViewProvider.getCheckBox(ctx);
                checkBox.setTextSize(30);
                checkBox.setHint(text);
                v.addView(checkBox, params);
            }else if(type.equalsIgnoreCase("spinner")){
                final Spinner spinner = new Spinner(ctx);
                ArrayList<View> views = new ArrayList<>();
                for(String item : itemList){
                    TextView tv = ViewProvider.getTextView(ctx, item);
                    tv.setTextSize(30);
                    views.add(tv);
                }
                final DynamicListAdapter adapter = new DynamicListAdapter(views, ctx);
//                spinner.setPrompt("hello");
                spinner.setEnabled(false);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
//                        Toast.makeText(ctx, adapterView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(ctx, "Nothing selected", Toast.LENGTH_SHORT).show();
                    }
                });
//                ViewGroup.LayoutParams paramsSp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                paramsSp.height = 0;
                v.addView(spinner, params);
            }if(type.equalsIgnoreCase("multiLineText")){
                EditText et = ViewProvider.getEditText(ctx, text);
                et.setTextSize(30);
                ViewGroup.LayoutParams paramsM = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                v.addView(et, paramsM);
            }if(type.equalsIgnoreCase("datePickerSpinner")){
                Spinner spinner = new Spinner(ctx);
                DatePickerDialog pickerDialog = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    }
                }, 1, 1, 1);
                v.addView(spinner, params);
            }if(type.equalsIgnoreCase("expandableListView")){
                ExpandableListView expListView = new ExpandableListView(ctx);
                DynamicExpandableListAdapter adapter = new DynamicExpandableListAdapter(ctx, listDataHeader, listDataChild);
                expListView.setAdapter(adapter);
                ViewGroup.LayoutParams paramsL = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                paramsL.height = 500;
//                expListView.setMinimumHeight(500);

                v.addView(expListView, paramsL);
            }else{
                TextView textView = ViewProvider.getTextView(ctx, text);
                textView.setTextSize(30);
                v.addView(textView, params);
            }

            ViewGroup.LayoutParams paramsV = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            v.setLayoutParams(paramsV);
        }
    }

    // prepares header list and child list for expandable list view
    public void prepareList(){
        headerList = new ArrayList<String>();
        childList = new HashMap<String, List<String>>();

        // Adding child data
        headerList.add("Class");
        headerList.add("Subject");
        headerList.add("Unit");

        // Adding child data
        List<String> classList = new ArrayList<String>();
        classList.add("The Shawshank Redemption");classList.add("The Godfather");classList.add("The Godfather: Part II");
        classList.add("Pulp Fiction");classList.add("The Good, the Bad and the Ugly");classList.add("The Dark Knight");classList.add("12 Angry Men");

        List<String> subList = new ArrayList<String>();
        subList.add("The Conjuring");subList.add("Despicable Me 2");subList.add("Turbo");
        subList.add("Grown Ups 2");subList.add("Red 2");subList.add("The Wolverine");

        List<String> unitList = new ArrayList<String>();
        unitList.add("2 Guns");unitList.add("The Smurfs 2");unitList.add("The Spectacular Now");
        unitList.add("The Canyons");unitList.add("Europa Report");

        childList.put(headerList.get(0), classList); // Header, Child data
        childList.put(headerList.get(1), subList);
        childList.put(headerList.get(2), unitList);

    }
}
