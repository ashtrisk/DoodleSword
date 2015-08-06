package com.ashutosh.doodlesword;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.InputStream;

/**
 * Created by Satyender Yadav on 05-08-2015.
 */
public class LoginPage {
    private View currView;
    private EditText et1,et2;
    private ScrollView.LayoutParams flp;

    LoginPage(Context ctx,int width,int height){
        flp = new ScrollView.LayoutParams(width,height);
        FrameLayout fl = new FrameLayout(ctx);
        fl.setLayoutParams(flp);
        try{
            ImageView back_img = new ImageView(ctx);
            InputStream ims = ctx.getAssets().open("loginback.png");
            Drawable d = Drawable.createFromStream(ims, null);
            back_img.setImageDrawable(d);
            FrameLayout.LayoutParams back_img_params = new FrameLayout.LayoutParams(width,height);
            back_img.setLayoutParams(back_img_params);
            back_img.setScaleType(ImageView.ScaleType.FIT_XY);
            FrameLayout.LayoutParams login_params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
            FrameLayout.LayoutParams pass_params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
            FrameLayout.LayoutParams butt_params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT);
            login_params.topMargin = height / 4;
            login_params.leftMargin = width / 6;
            et1 = ViewProvider.getEditText(ctx,"Login ID",width*2/3,height/12,width*2/3,height/12,login_params);
            //et1.setLayoutParams(login_params);
            pass_params.topMargin = height / 4 + height/6;
            pass_params.leftMargin = width / 6;
            et2 = ViewProvider.getEditText(ctx, "Password", width * 2 / 3, height / 12, width * 2 / 3, height / 12, pass_params);
            et2.setTransformationMethod(new PasswordTransformationMethod());
            butt_params.leftMargin = width/3;
            butt_params.topMargin = height/4 + height/3;
            ImageView butt_img = ViewProvider.getAssetImageView(ctx,"login-button.png",width/3,height/12,width/3,height/12,butt_params,ImageView.ScaleType.FIT_XY);
            fl.addView(back_img);
            fl.addView(et1);
            fl.addView(et2);
            fl.addView(butt_img);
            currView = fl;
        } catch (Exception e){
            currView = null;
        }
    }

    public View getView(){
        return currView;
    }
}
