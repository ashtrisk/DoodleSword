package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Satyender Yadav on 07-08-2015.
 */
public class TempTeacherFragment extends Fragment {
    TeacherPage tpg;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        Bundle args = getArguments();
        tpg = new TeacherPage(container.getContext(), args);
        return (tpg.getView());
    }
}
