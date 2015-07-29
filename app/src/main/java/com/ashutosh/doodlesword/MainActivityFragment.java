package com.ashutosh.doodlesword;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * A MainActivityFragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RelativeLayout mRelativeLayout;
    private TextView mTextView;
    private LinearLayout mLinearLayout;
    private Button mParentButton;
    private Button mTeacherButton;
    private Context mContext;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mContext = getActivity();
        // find view groups and views in the fragment_main xml file.
        mRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativeLayout);
//        mTextView = (TextView) rootView.findViewById(R.id.textView_main);
//        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.linearLayout_main);

        mTextView = ViewProvider.getTextView(mContext, "Welcome to Frog Ticker!!");
        mLinearLayout = ViewProvider.getLinearLayout(mContext);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        // create buttons - Parent and Teacher, add onClickListeners to them and add the buttons to the linear layout.
        // parentButton
        mParentButton = ViewProvider.getSimpleButton(mContext, "Parent");
        mParentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ParentActivity.class);
                startActivity(intent);
            }
        });
        mLinearLayout.addView(mParentButton);

        // teacherButton
        mTeacherButton = ViewProvider.getSimpleButton(mContext, "Teacher");
        mTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TeacherActivity.class);
                startActivity(intent);
            }
        });
        mLinearLayout.addView(mTeacherButton);

        mRelativeLayout.addView(mTextView);
        mRelativeLayout.addView(mLinearLayout, params);

        return rootView;
    }
}
