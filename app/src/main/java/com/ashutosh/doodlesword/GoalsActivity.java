package com.ashutosh.doodlesword;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;


public class GoalsActivity extends ActionBarActivity implements AddNewGoalFragment.OnFragmentInteractionListener, GoalsTickerFragment.OnFragmentInteractionListener{

    private ImageButton mImageButton;

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        // get the current running fragment.
        Fragment fragment = getFragmentManager().findFragmentById(R.id.relative_layout_goals);
        if(fragment == null) {
            // if there is no fragment inside goals activity then only add the fragment as GoalsTickerFragment fragment
            getFragmentManager().beginTransaction().add(R.id.relative_layout_goals, new GoalsTickerFragment(),
                    "GoalsTickerFragment").commit();
        }

        // get the imageButton in the activity layout and set listener to it so that whenever it is clicked the default fragment is
        // replaced by a new ( add goals ) fragment.
//        mImageButton = (ImageButton) findViewById(R.id.imageButton_goals);
        mImageButton = ViewProvider.getImageButton(this, R.drawable.ic_action_new);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // replace the current fragment with the AddNewGoalFragment.
                getFragmentManager().beginTransaction().replace(R.id.relative_layout_goals, new AddNewGoalFragment(),
                        "AddNewGoalFragment").commit();
                mImageButton.setVisibility(View.GONE);      // remove the image Button
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // if current fragment equals AddNewGoalFragment then replace it by GoalsTickerFragment else call super.onBackPressed
        Fragment fragment = getFragmentManager().findFragmentById(R.id.relative_layout_goals);
        if( fragment instanceof AddNewGoalFragment){
            getFragmentManager().beginTransaction().replace(R.id.relative_layout_goals, new GoalsTickerFragment()).commit();
            mImageButton.setVisibility(View.VISIBLE);
        }else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_goal, menu);
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
