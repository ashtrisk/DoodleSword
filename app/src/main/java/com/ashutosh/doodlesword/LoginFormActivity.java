package com.ashutosh.doodlesword;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Satyender Yadav on 02-08-2015.
 */
public class LoginFormActivity extends Activity {
    private int usableHeightPrevious;
    private FrameLayout.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private DynamicListAdapter dla;
    private EditText et1,et2;
    private boolean et1Focus,et2Focus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        FrameLayout content = (FrameLayout) this.findViewById(android.R.id.content);
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN + WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        ScrollView sv = new ScrollView(this);
        Display display = this.getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        //ListView lv = new ListView(this);
        //RelativeLayout rl1 = new RelativeLayout(this);
        //FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(size.x,size.y);
        //LinearLayout l1 = new LinearLayout(this);
        RelativeLayout rl2 = new RelativeLayout(this);
        //ViewGroup.LayoutParams vlp=new ViewGroup.LayoutParams(size.x/2,size.y/2);
        //sv.setLayoutParams(vlp);
        //sv.setVerticalScrollBarEnabled(true);
        //sv.setLayoutParams(vlp);
        FrameLayout.LayoutParams slp = new FrameLayout.LayoutParams(size.x,size.y);
        //rl2.setLayoutParams(new ViewGroup.LayoutParams(size.x,size.y));
        ImageView img2 = new ImageView(this);
        try {
            InputStream ims = getAssets().open("loginbk.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            img2.setImageDrawable(d);
            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(size.x,size.y);
            img2.setLayoutParams(rlp);
            img2.setScaleType(ImageView.ScaleType.FIT_XY);
            //RelativeLayout rl3 = new RelativeLayout(this);
            LinearLayout.LayoutParams rlp3 = new LinearLayout.LayoutParams(size.x / 5, size.y /15 );
            LinearLayout.LayoutParams rlp4 = new LinearLayout.LayoutParams(size.x / 5, size.y /15);
            //rlp3.leftMargin = size.x/6;
            //rlp3.topMargin = size.y/4 + size.y/20;
            ImageView img3 = ViewProvider.getAssetImageView(this,"loginid.png",size.x/4,size.y/15,size.x/4,size.y/15,rlp3,ImageView.ScaleType.FIT_XY);
            ImageView img4 = ViewProvider.getAssetImageView(this,"password.png",size.x/4,size.y/15,size.x/4,size.y/15,rlp4,ImageView.ScaleType.FIT_XY);
            //rl3.addView(img3);
            //rl3.setLayoutParams(rlp3);
            //img3.setRotation(-12);
            //RelativeLayout rl4 = new RelativeLayout(this);
            //rlp4.leftMargin = size.x/5;
            //img4.setRotation(-12);
            RelativeLayout.LayoutParams rlp5 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams rlp6 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams rlp7 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlp7.topMargin = size.y/12;
            et1 = ViewProvider.getEditText(this,"Login ID",size.x/2,size.y/15,size.x/2,size.y/15);
            et2 = ViewProvider.getEditText(this,"Password",size.x/2,size.y/15,size.x/2,size.y/15);
            et2.setTransformationMethod(new PasswordTransformationMethod());
            et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        //Toast.makeText(v.getContext(),"In Focus"+((LoginFormActivity)v.getContext()).computeUsableHeight(),Toast.LENGTH_LONG).show();
                        et1Focus = true;
                    } else {
                        et1Focus = false;
                        //Toast.makeText(v.getContext(),"Not In Focus"+((LoginFormActivity)v.getContext()).computeUsableHeight(),Toast.LENGTH_LONG).show();
                    }
                }
            });
            et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus){
                        //Toast.makeText(v.getContext(),"In Focus"+((LoginFormActivity)v.getContext()).computeUsableHeight(),Toast.LENGTH_LONG).show();
                        et2Focus = true;
                    } else {
                        et2Focus = false;
                        //Toast.makeText(v.getContext(),"Not In Focus"+((LoginFormActivity)v.getContext()).computeUsableHeight(),Toast.LENGTH_LONG).show();
                    }
                }
            });
            RelativeLayout rl3 = new RelativeLayout(this);
            LinearLayout rl4 = new LinearLayout(this);
            LinearLayout rl5 = new LinearLayout(this);
            //rl4.addView(img3);
            rl4.addView(et1);
            //rl5.addView(img4);
            rl5.addView(et2);
            rl4.setLayoutParams(rlp6);
            rl5.setLayoutParams(rlp7);
            RelativeLayout.LayoutParams rlp8 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
            rlp8.topMargin = size.y/6;
            //rlp8.leftMargin = size.x/4;
            ImageView img5 = ViewProvider.getAssetImageView(this,"login-button.png",size.x/4,size.y/15,size.x/4,size.y/15,rlp8,ImageView.ScaleType.FIT_XY);
            //img5.setOnClickListener();
            rl3.addView(rl4);
            rl3.addView(rl5);
            rl3.addView(img5);
            rlp5.leftMargin = size.x / 4;
            rlp5.topMargin = size.y / 4 + size.y/20;
            rl3.setLayoutParams(rlp5);
            rl3.setRotation(-11);
            //rl4.addView(img4);
//            img2.setFocusable(true);
//            img2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "" + v.requestFocus(), Toast.LENGTH_LONG).show();
//                }
//            });
//            img2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//                @Override
//                public void onFocusChange(View v, boolean hasFocus) {
//                    if (hasFocus) {
//                        Toast.makeText(v.getContext(), "In Focus", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(v.getContext(), "Not In Focus", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
            rl2.addView(img2);
            //rl2.addView(img3);
            rl2.addView(rl3);
        }catch (Exception e){

        }
        //rl1.setLayoutParams(flp);
        //sv.setFillViewport(true);
        RelativeLayout rl3 = new RelativeLayout(this);
        rl3.setLayoutParams(new ScrollView.LayoutParams(size.x, size.y / 2));
        TextView txt = new TextView(this);
        txt.setText("Hello");
        //rl3.addView(txt);
        //l1.addView(rl2);
        //l1.addView(rl3);
        //sv.addView(l1);
        //rl1.addView(sv);
        //ArrayList<View> views = new ArrayList<>();
        //views.add(rl2);
        //views.add(rl3);
        //dla = new DynamicListAdapter(views, this);
        //lv.setAdapter(dla);
        sv.addView(rl2);
        setContentView(sv);
        mChildOfContent = sv;
        //lv.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
        img2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                //Toast.makeText(mChildOfContent.getContext(), "In Focus", Toast.LENGTH_LONG).show();
                possiblyResizeChildOfContent();
            }
        });
        frameLayoutParams = (FrameLayout.LayoutParams) mChildOfContent.getLayoutParams();
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
        if(et2Focus){
            //Toast.makeText(this,"In Focus"+computeUsableHeight(),Toast.LENGTH_LONG).show();
            //et2Focus = false;
            et2.requestFocus();
        }
        if(et1Focus){
            //Toast.makeText(this,"In Focus"+computeUsableHeight(),Toast.LENGTH_LONG).show();
            //et2Focus = false;
            et1.requestFocus();
        }
    }

    private int computeUsableHeight() {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        return (r.bottom - r.top);
    }

}
