package com.ashutosh.doodlesword;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
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
            FrameLayout.LayoutParams butt_params = new FrameLayout.LayoutParams(width/3,height/12);
            login_params.topMargin = height / 4;
            login_params.leftMargin = width / 6;
            et1 = ViewProvider.getEditText(ctx,"Login ID",width*2/3,height/12,width*2/3,height/12,login_params, Color.WHITE);
            //et1.setLayoutParams(login_params);
            pass_params.topMargin = height / 4 + height/6;
            pass_params.leftMargin = width / 6;

            et2 = ViewProvider.getEditText(ctx, "Password", width * 2 / 3, height / 12, width * 2 / 3, height / 12, pass_params, Color.WHITE);
            et2.setTransformationMethod(new PasswordTransformationMethod());

            butt_params.leftMargin = width/3;
            butt_params.topMargin = height/4 + height/3;
            ImageView butt_img = ViewProvider.getAssetImageView(ctx,"login-button.png",width/3,height/12,width/3,height/12,butt_params,ImageView.ScaleType.FIT_XY);
            butt_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name = et1.getText().toString();
                    String password = et2.getText().toString();

                    FetchUserDetails fud = new FetchUserDetails();
                    fud.execute(name,password);

                }
            });
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

    public class FetchUserDetails extends AsyncTask<String, Void, String[]>{
        @Override
        protected String[] doInBackground(String... strings) {
            String username = strings[0];
            String password = strings[1];

            //String username = str.substring(0, str.indexOf(" "));
            //String password = str.substring(str.indexOf(" ") + 1);

            // fetch user details here, user will either be null if no match is found or it will contain user details
            String [] user = ViewProvider.getUser(username, password);

            return user;
        }

        @Override
        protected void onPostExecute(String[] user) {
            super.onPostExecute(user);

            if (user != null) {
//                ((TempActivity) view.getContext()).addPage(user[0], user[3]);
//                Toast.makeText(view.getContext(), ViewProvider.getUser(name, password)[3], Toast.LENGTH_SHORT).show();
                ((TempActivity)currView.getContext()).addAndGotoPage(user[0], user[2]);
            } else {
//                Toast.makeText(view.getContext(), "Wrong username or password" , Toast.LENGTH_SHORT).show();
                et1.setText("");
                et2.setText("");
            }

        }
    }
}
