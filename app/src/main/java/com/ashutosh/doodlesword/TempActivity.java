package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by Satyender Yadav on 04-08-2015.
 */
public class TempActivity extends FragmentActivity {
    TempPagerAdapter mPagerAdapter;
    ArrayList<Fragment> frags;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        this.setRequestedOrientation(1);
        if(savedInstanceState == null) {
            frags = new ArrayList<>();
            TempFragment t1 = new TempFragment();
            Bundle args1 = new Bundle();
            args1.putString("curr_text", "First Page");
            t1.setArguments(args1);
            frags.add(t1);
            mPagerAdapter = new TempPagerAdapter(frags, getSupportFragmentManager());
            mViewPager = new ViewPager(this);
            mViewPager.setId(110011);
            mViewPager.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
            setContentView(mViewPager);
            mViewPager.setAdapter(mPagerAdapter);
        } else {
            setContentView(mViewPager);
        }
    }

    public void addPage() {
        TempFragment t = new TempFragment();
        Bundle args = new Bundle();
        args.putString("curr_text", "Second Page");
        t.setArguments(args);
        frags.add(t);
        mPagerAdapter.notifyDataSetChanged();
    }
}
