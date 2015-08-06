package com.ashutosh.doodlesword;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Satyender Yadav on 06-08-2015.
 */
public class TempPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> frags;

    public TempPagerAdapter(List<Fragment> frg,FragmentManager fm){
        super(fm);
        frags = frg;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}
