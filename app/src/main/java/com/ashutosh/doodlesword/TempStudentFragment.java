package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Vostro-Daily on 8/6/2015.
 */
public class TempStudentFragment extends android.support.v4.app.Fragment{
    private StudentPage spg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        Bundle args = getArguments();
        spg = new StudentPage(container.getContext(), args);
        return (spg.getView());
    }



//    @Override
//    public void onResume() {
//        super.onResume();
//        Toast.makeText(getActivity(), "Resume", Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        Toast.makeText(getActivity(), "Pause", Toast.LENGTH_SHORT).show();
//    }
}
