package com.ashutosh.doodlesword;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Satyender Yadav on 31-07-2015.
 */
public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        //this.setTitle("Welcome");
        RelativeLayout rl = new RelativeLayout(this);
        this.setContentView(rl);
        FrameLayout.LayoutParams vlp=new FrameLayout.LayoutParams(size.x,size.y);
        rl.setLayoutParams(vlp);
        //TextView txt = new TextView(this);
        //txt.setText("Hello");
        //Log.d("Size is ", "" + size.x);
        ImageView img = new ImageView(this);
        try {
            InputStream ims = getAssets().open("splashscreen.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            img.setImageDrawable(d);
            //img.setImageResource(R.drawable.splashscreen);
            //img.setAdjustViewBounds(true);
            //img.setMaxHeight(40);
            //img.setMaxWidth(40);
            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
            img.setLayoutParams(rlp);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            //img.setAdjustViewBounds(true);
            rl.addView(img);
        } catch (IOException e){

        }
        //rlp.addRule(RelativeLayout.ALIGN_BOTTOM);
        //txt.setLayoutParams(rlp);
        //rl.addView(txt);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(mainIntent);
                HomeActivity.this.finish();
            }
        }, 1000);
    }
}
