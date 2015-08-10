package com.ashutosh.doodlesword;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;

/**
 * A simple {@link Fragment} subclass.
 */
// NOTE : ** comments represents lines of code which are different from TeacherCurriculum Fragment
public class StudentCurriculumFragment extends Fragment {

    private ListView mListView;         // listView defined in the xml
    private ArrayList<String> mList;    // current list of items
    private ArrayAdapter mAdapter;
    private String json;                // json string fetched from file
    public String uri;                  // the uri for the current view item list in the database or in the json tree
    public Stack<String> stack;         // elements or uri parameters are pushed on to the stack when next view is reqd.
                                            // and popped off when previous view is being fetched
    private DataBaseHelper dbHelper;    // reads json string from the database, and helps to parse it
    private ArrayList<View> views;
    private Context context;

    public StudentCurriculumFragment() {
        // Required empty public constructor
    }

    public boolean onBackPressed(){
        // pop an item from the uri, get the list on the basis of this uri, add that list on to the array adapter
        // Toast.makeText(getActivity(), stack.get(1), Toast.LENGTH_SHORT).show();
        int size = dbHelper.getSize(uri);
        if(size == 0)
            return false;

        removeItemFromUri(); // remove the last item from the uri
        stack.pop();

        mList = dbHelper.fetchList(uri);

        mAdapter.clear();
        mAdapter.addAll(mList);

        return true;
    }

    // removes the last item from the uri
    private void removeItemFromUri() {
        int size = dbHelper.getSize(uri);
        String newUri = "/";
        // if size = 1 newUri remains "/"

        for(int i=0; i < size -1; i++) { // find each item and add to new uri
            String str1 = uri.substring(uri.indexOf("/") + 1);
            String ele = str1.substring(0, str1.indexOf("/"));
            uri = str1.substring(str1.indexOf("/"));
            newUri = newUri + ele + "/";
        }
        uri = newUri;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            ArrayList<String> list = savedInstanceState.getStringArrayList("list");
            mAdapter.clear();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("list", mList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_curriculum, container, false);

        context = getActivity();
        stack = new Stack<>();      // creating a new stack
        // read json file from the assets directory
        json = null;
        try {
            InputStream inputStream = getActivity().getAssets().open("curriculum");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            //****************
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONObject list = jsonObject.getJSONObject("list");
                JSONArray jsonArray = list.getJSONArray("items");
                String studentClass = jsonArray.getString(0);   // gets the item at 0th place i.e. class of student class can be 0, 1 or some other no...
                JSONObject classObject = list.getJSONObject(studentClass);
                json = classObject.toString();
            }catch (JSONException ex){
                ex.printStackTrace();
                Log.e("StudentCurricFragment", "something wrong with json 1");
            }
            // ****************
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        uri = "/";  // start of uri .... represents the list of classes or list of subjects in case of students
        mList = new ArrayList<>();
        dbHelper = new DataBaseHelper();
        mList = dbHelper.fetchList(uri); // fetches the list of subjects in this case (Student)
        if(savedInstanceState != null) {
            mList = savedInstanceState.getStringArrayList("list");
        }

        views = new ArrayList<>();

        // creating listView dynamically
        mListView = new ListView(context);
        mListView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mListView.setMinimumHeight(200);

        ViewGroup frameLayout = (ViewGroup)rootView.findViewById(R.id.frame_layout_curriculum);     // the viewGroup is a frameLayout
        frameLayout.addView(mListView);

        TextView textView;
        for(String item : mList){   // create a textView for each item in the list and add to views
            textView = new TextView(context);
            textView.setText(item);
            views.add(textView);
        }

        mAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1, mList);

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String item = (String) mAdapter.getItem(position);
                int size = dbHelper.getSize(uri);
                if(size < 4 ) {     //** 4 = depth-1 of json tree sub, unit, section, sub-section, topic
                    mList = getChildList(item);
                    mAdapter.clear();
                    mAdapter.addAll(mList);
                }
            }
        });

        return rootView;
    }

    // returns the string list containing the items in the child view i.e. for units it returns sections list
    public ArrayList<String> getChildList(String item){

        stack.push(item);
        addItemToUri(item);
        ArrayList<String> childList = new ArrayList<>();
        childList = dbHelper.fetchList(uri);

        return childList;
    }

    public void addItemToUri(String item){
        uri = uri + item + "/";
    }

    private class DataBaseHelper {

        ArrayList<String> itemList;
        int noOfItems = 0;

        public DataBaseHelper(){

        }

        public ArrayList<String> fetchList(String uri){

            noOfItems = getSize(uri);

            JSONObject jsonObject;
            itemList = new ArrayList<String>();
            try {

                jsonObject = new JSONObject(json);      // object containing class 5
//                JSONObject list = jsonObject.getJSONObject("list");
                JSONArray jsonArray = jsonObject.getJSONArray("items");

                // add each subject to the itemList
                for(int i=0; i<jsonArray.length(); i++){
                    itemList.add(jsonArray.getString(i));
                }

                JSONObject obj = new JSONObject();
                obj = jsonObject;   // ** list <-> jsonObject

                for( int i=0; i<noOfItems; i++ ){
                    // get to the child we want iteratively
                    String str1 = uri.substring(uri.indexOf("/")+1);
                    String ele = str1.substring(0, str1.indexOf("/"));
                    uri = str1.substring(str1.indexOf("/"));
                    obj = obj.getJSONObject(ele);
                    JSONArray array = obj.getJSONArray("items");

                    itemList.clear();
                    for(int j=0 ; j<array.length(); j++){
                        itemList.add(array.getString(j));
                    }
                }

            }catch (JSONException ex){
                ex.printStackTrace();
                Log.e("DataBaseHelper", "something wrong with json");
            }

            return itemList;
        }

        public int getSize(String uri){ //returns length of uri i.e. no. of items e.g. / = 0, /classes/ = 1, /classes/subjects/ = 2
            int count = 0;
            uri = uri.substring(uri.indexOf("/")+1);    //** "subjects/"

            for(;;){
                if(uri.equals("") || uri.indexOf("/") == -1)
                    break;
                uri = uri.substring(uri.indexOf("/")+1);
                count++;
            }

            return count;
        }

    }

}