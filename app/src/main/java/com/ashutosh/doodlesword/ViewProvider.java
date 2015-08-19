package com.ashutosh.doodlesword;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.InputStream;

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
    public static final String[][] user_data= { {"saty","yad","teacher","1"} , {"trina","das","management","2"} , {"ashu","chamoli","student","3"}};

    public static String[] getUser(String username,String password){
        for (String[] item:user_data){
            if(username.equals(item[0]) && password.equals(item[1])){
                return item;
            }
        }
        return null;
    }

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
        mButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return mButton;
    }

    public static ImageButton getImageButton(Context context, int resId){
        mImageButton = new ImageButton(context);
        mImageButton.setImageResource(resId);
//        mImageButton.setLayoutParams();
        return mImageButton;
    }

    public static ImageView getAssetImageView(Context context,String assetName,int minWidth,int minHeight,int maxWidth,int maxHeight,ViewGroup.LayoutParams params,ImageView.ScaleType scaleType){
        ImageView mImage = new ImageView(context);
        try {
            InputStream ims = context.getAssets().open(assetName);
            Drawable d = Drawable.createFromStream(ims, null);
            mImage.setImageDrawable(d);
            mImage.setScaleType(scaleType);
            mImage.setMinimumWidth(minWidth);
            mImage.setMinimumHeight(minHeight);
            mImage.setMaxWidth(maxWidth);
            mImage.setMaxHeight(maxHeight);
            mImage.setLayoutParams(params);
            return mImage;
        } catch (Exception e) {
            return null;
        }
    }

    public static EditText getEditText(Context context, String placeholder){
        EditText et = new EditText(context);
        et.setHint(placeholder);
        return et;
    }

    public static EditText getEditText(Context context,String placeholder,int minWidth,int minHeight,int maxWidth,int maxHeight,ViewGroup.LayoutParams params){
        EditText mEditText = new EditText(context);
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        mEditText.setHint(placeholder);
        mEditText.setMinimumHeight(minHeight);
        mEditText.setMinimumWidth(minWidth);
        mEditText.setMaxHeight(maxHeight);
        mEditText.setMaxWidth(maxWidth);
        mEditText.setTextSize(maxHeight/(2*scaledDensity));
        mEditText.setLayoutParams(params);
        return mEditText;
    }

    public static EditText getEditText(Context context,String placeholder,int minWidth,int minHeight,int maxWidth,int maxHeight,ViewGroup.LayoutParams params, int color){
        EditText mEditText = new EditText(context);
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        mEditText.setHint(placeholder);
        mEditText.setMinimumHeight(minHeight);
        mEditText.setMinimumWidth(minWidth);
        mEditText.setMaxHeight(maxHeight);
        mEditText.setMaxWidth(maxWidth);
        mEditText.setTextSize(maxHeight / (2 * scaledDensity));
        mEditText.setTextColor(color);

        mEditText.setLayoutParams(params);
        return mEditText;
    }

    public static EditText getEditText(Context context,String placeholder,int minWidth,int minHeight,int maxWidth,int maxHeight){
        EditText mEditText = new EditText(context);
        mEditText.setHint(placeholder);
        mEditText.setMinimumHeight(minHeight);
        mEditText.setMinimumWidth(minWidth);
        mEditText.setMaxHeight(maxHeight);
        mEditText.setMaxWidth(maxWidth);
        mEditText.setTextSize(maxHeight);
        return mEditText;
    }

    public static CheckBox getCheckBox(Context context){
        return new CheckBox(context);
    }

}

