package com.ashutosh.doodlesword;

import android.view.ViewGroup;

/**
 * Created by Vostro-Daily on 7/29/2015.
 */
public abstract class DoodleRecylerViewSetter {
    protected abstract void setViewChild(ViewGroup v);

    final void setView(ViewGroup v){
        v.removeAllViews();
        setViewChild(v);
    };
}
