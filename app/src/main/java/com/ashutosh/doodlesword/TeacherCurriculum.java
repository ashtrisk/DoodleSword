package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class TeacherCurriculum extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        // add curriculum fragment to the activity
//        if(savedInstanceState == null)        // **only get the fragment manager if savedInstanceState == null
            getFragmentManager().beginTransaction().add(R.id.relative_layout_curriculum,
                    new TeacherCurriculumFragment()).commit();
        //getFragmentManager().beginTransaction().replace(R.id.relative_layout_curriculum, new TeacherCurriculumFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(this, "hello back button ", Toast.LENGTH_SHORT).show();
        // find the fragment in the activity
        TeacherCurriculumFragment fragment = (TeacherCurriculumFragment)getFragmentManager().findFragmentById(R.id.relative_layout_curriculum);
        if(fragment.onBackPressed() == false){  // if the back press is done on 1st screen
            super.onBackPressed();              // then call the default backpressed() method of super class
        }
        // if ( the view contains the list of classes then only go to the parent activity i.e. call super method){
        //  super.onBackPressed();  }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_curriculum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
