package com.ashutosh.doodlesword;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Vostro-Daily on 7/28/2015.
 */
public class ViewProvider {

    public static RelativeLayout mRelativeLayout;
    public static LinearLayout mLinearLayout;
    public static FrameLayout mFrameLayout;
    public static TextView mTextView;
    public  static Button mButton;
    public static ImageButton mImageButton;

    public static RelativeLayout getRelativeLayout(Context context){
        mRelativeLayout = new RelativeLayout(context);
        mRelativeLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return mRelativeLayout;
    }

    public static LinearLayout getLinearLayout(Context context){
        mLinearLayout = new LinearLayout(context);
        mLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return mLinearLayout;
    }
    public static FrameLayout getFrameLayout(Context context){
        mFrameLayout = new FrameLayout(context);
        mFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return mFrameLayout;
    }

    public static TextView getTextView(Context context, String text){
        mTextView = new TextView(context);
        mTextView.setText(text);
        mTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return mTextView;
    }

    public static Button getSimpleButton(Context context, String text){
        mButton = new Button(context);
        mButton.setText(text);
//        mButton.setLayoutParams();
        return mButton;
    }

    public static ImageButton getImageButton(Context context, int resId){
        mImageButton = new ImageButton(context);
        mImageButton.setImageResource(resId);
//        mImageButton.setLayoutParams();
        return mImageButton;
    }
}

