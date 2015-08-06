package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vostro-Daily on 8/6/2015.
 */
public class TempLoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return (new LoginPage(container.getContext(),getArguments().getInt("LoginPageWidth"),getArguments().getInt("LoginPageHeight"))).getView();
    }
}
