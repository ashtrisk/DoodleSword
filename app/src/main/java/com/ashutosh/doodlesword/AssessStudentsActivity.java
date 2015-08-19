package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by Vostro-Daily on 8/12/2015.
 */
public class AssessStudentsActivity extends FragmentActivity {
    ViewPager mViewPager;
    PagerAdapter mPagerAdapter;
    ArrayList<Fragment> frags;
    String name;
    ArrayList<String> namesList;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);

        if(savedInstanceState == null) {
            frags = new ArrayList<>();
//            TempLoginFragment t1 = new TempLoginFragment();
//            Bundle args1 = new Bundle();
//            Display display = getWindowManager().getDefaultDisplay();
//            final Point size = new Point();
//            display.getSize(size);
//            args1.putInt("LoginPageWidth", size.x);
//            args1.putInt("LoginPageHeight", size.y);
//            t1.setArguments(args1);
            name = getIntent().getStringExtra("Student");
            namesList = getIntent().getStringArrayListExtra("Students");
//            Bundle args = new Bundle();
//            args.putString("Student", name);
////            args.putStringArrayList("Students",namesList);
//
//            AssessMeFragment f1 = new AssessMeFragment();
//            f1.setArguments(args);
//            frags.add(f1);

            // for each student create a fragment and add it to the viewpager
            for(String stud : namesList){
                Bundle args = new Bundle();
                args.putString("Student", stud);
                AssessMeFragment fragment = new AssessMeFragment();
                fragment.setArguments(args);
                frags.add(fragment);
            }

            mPagerAdapter = new TempPagerAdapter(frags, getSupportFragmentManager());
            mViewPager = new ViewPager(this);
            mViewPager.setId(R.id.pager);
            mViewPager.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            mViewPager.setAdapter(mPagerAdapter);
            mViewPager.setCurrentItem(namesList.indexOf(name));     //set the viewpager to the current student
        }

        setContentView(mViewPager);
//        mDetector = new GestureDetectorCompat(this, new MyGestureListener());
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.mDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        boolean handled = mDetector.onTouchEvent(ev);
//        if (!handled) {
//            return super.dispatchTouchEvent(ev);
//        }
//        return handled;
//    }

    public void addPage(String username, String title) {
//        TempFragment t = new TempFragment();
//        Bundle args = new Bundle();
//        args.putString("username", username);
////        args.putString("title", title);
////        t.setArguments(args);
////        frags.add(t);
//
//        if(title.equalsIgnoreCase("student")){
//            TempStudentFragment tsf = new TempStudentFragment();
//            tsf.setArguments(args);
//            frags.add(tsf);
//        } else if(title.equalsIgnoreCase("teacher")){
//            // create teacher temp fragment
//            TempTeacherFragment ttf = new TempTeacherFragment();
//            ttf.setArguments(args);
//            frags.add(ttf);
//        } else if(title.equalsIgnoreCase(("management"))){
//            TempManagementFragment tmf = new TempManagementFragment();
//            tmf.setArguments(args);
//            frags.add(tmf);
//        }

        mPagerAdapter.notifyDataSetChanged();
    }

    public void addAndGotoPage(String s, String s1) {
        addPage(s, s1);
        mViewPager.setCurrentItem(mPagerAdapter.getCount() - 1);
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
//            Toast.makeText(getApplicationContext(), "Swiped right to left", Toast.LENGTH_SHORT).show(); // error in getApplicationContext() may be...
//            // launching an intent to canvas grid
////            Intent intent = new Intent(getApplicationContext(), TeacherCurriculum.class);  // error may occur here...
////            startActivity(intent);
//            AssessMeFragment fragment = new AssessMeFragment();
//            String nextStud = namesList.get(namesList.indexOf(name)+1);     // check for outOfBounds index
//            Bundle args = new Bundle();
//            args.putString("Student",nextStud);
//            fragment.setArguments(args);
//            frags.add(fragment);
//            mPagerAdapter.notifyDataSetChanged();
//            mViewPager.setCurrentItem(mPagerAdapter.getCount()-1);
//            name = nextStud;
//        }
//
//        public void onSwipeRight(){
//            Toast.makeText(getApplicationContext(), "Swiped left to right", Toast.LENGTH_SHORT).show();
//            // Do nothing
//        }
//    }
}
