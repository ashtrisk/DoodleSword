package com.ashutosh.doodlesword;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Satyender Yadav on 01-08-2015.
 */
public class LoginActivity extends Activity {
    private FrameLayout.LayoutParams frameLayoutParams;
    private ViewGroup mChildOfContent;
    private int usableHeightPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
//        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                | View.SYSTEM_UI_FLAG_LOW_PROFILE
//                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_IMMERSIVE;
//
//        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        //this.setTitle("Welcome");
        FrameLayout rl = (FrameLayout)(new LoginPage(this,size.x,size.y).getView());
        ScrollView sv = new ScrollView(this);
        sv.addView(rl);
        mChildOfContent = sv;
        rl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                //Toast.makeText(mChildOfContent.getContext(), "In Focus", Toast.LENGTH_LONG).show();
                possiblyResizeChildOfContent();
            }
        });
        this.setContentView(sv);
        frameLayoutParams = (FrameLayout.LayoutParams)sv.getLayoutParams();
    }

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != usableHeightPrevious) {
            int usableHeightSansKeyboard = mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard/4)) {
                // keyboard probably just became visible
                RelativeLayout rl3 = new RelativeLayout(this);
                rl3.setLayoutParams(new ScrollView.LayoutParams(100, 100));
                //dla.setItem(rl3,1);
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;
                mChildOfContent.requestLayout();
            } else {
                // keyboard probably just became hidden
//                if(et2Focus){
//                    et2.requestFocus();
//                }
//                try {
//                    //dla.removeItem(1);
//                }catch (Exception e){
//
//                }
                frameLayoutParams.height = usableHeightSansKeyboard;
                mChildOfContent.requestLayout();
            }
            //mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        return (r.bottom - r.top);
    }
}
