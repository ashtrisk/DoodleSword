package com.ashutosh.doodlesword;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vostro-Daily on 7/29/2015.
 */
public class Person extends DoodleRecylerViewSetter {
    String text;
    Person(String str){
        text = str;
    }

    @Override
    protected void setViewChild(ViewGroup v) {
        TextView txt = new TextView(v.getContext());
        txt.setText(text);
        txt.setTextSize(50);
        txt.setMinHeight(40);
        
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), ((TextView) view).getText(), Toast.LENGTH_LONG).show();
            }
        });
        v.addView(txt);
    }

}
