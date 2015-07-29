package com.ashutosh.doodlesword;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class StudentCurriculum extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        Fragment fragment = getFragmentManager().findFragmentById(R.id.relative_layout_curriculum);
        //if(fragment == null){   // if there is no fragment then add a new fragment on to the activity
            getFragmentManager().beginTransaction().add(R.id.relative_layout_curriculum,
                    new StudentCurriculumFragment()).commit();
       // }else{
          //  getFragmentManager().beginTransaction().add(R.id.relative_layout_curriculum, (StudentCurriculumFragment)fragment).commit();
        //}

    }
    @Override
    public void onBackPressed() {

        // find the fragment in the activity
        StudentCurriculumFragment fragment = (StudentCurriculumFragment)getFragmentManager().findFragmentById(R.id.relative_layout_curriculum);
        if(fragment.onBackPressed() == false){  // if the back press is done on 1st screen
            super.onBackPressed();              // then call the default backpressed() method of super class
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student_curriculum, menu);
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
