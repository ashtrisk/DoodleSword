package com.ashutosh.doodlesword;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Satyender Yadav on 01-08-2015.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        Display display = getWindowManager().getDefaultDisplay();
        final Point size = new Point();
        display.getSize(size);
        //this.setTitle("Welcome");
        RelativeLayout rl = new RelativeLayout(this);
        this.setContentView(rl);
        FrameLayout.LayoutParams vlp=new FrameLayout.LayoutParams(size.x,size.y);
        rl.setLayoutParams(vlp);
        ImageView img = new ImageView(this);
        try {
            InputStream ims = getAssets().open("loginback.png");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            img.setImageDrawable(d);
            InputStream ims2 = getAssets().open("login.png");
            // load image as Drawable
            Drawable d2 = Drawable.createFromStream(ims2, null);
            //img.setImageResource(R.drawable.splashscreen);
            //img.setAdjustViewBounds(true);
            //img.setMaxHeight(40);
            //img.setMaxWidth(40);
            RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
            img.setLayoutParams(rlp);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            //img.setAdjustViewBounds(true);
            RelativeLayout.LayoutParams rlp2 = new RelativeLayout.LayoutParams(size.x/3,size.y/10);
            rlp2.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
            ImageButton imb = new ImageButton(this);
            imb.setAdjustViewBounds(true);
            imb.setMinimumWidth(size.x / 3);
            imb.setMinimumHeight(size.y / 10);
            imb.setMaxWidth(size.x / 3);
            imb.setMaxHeight(size.y / 10);
            imb.setScaleType(ImageView.ScaleType.FIT_XY);
            imb.setImageDrawable(d2);
            imb.setLayoutParams(rlp2);
            imb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mainIntent = new Intent(LoginActivity.this, LoginFormActivity.class);
                    LoginActivity.this.startActivity(mainIntent);
                    LoginActivity.this.finish();
                }
            });
            rl.addView(img);
            rl.addView(imb);
        } catch (IOException e){

        }
    }
}
