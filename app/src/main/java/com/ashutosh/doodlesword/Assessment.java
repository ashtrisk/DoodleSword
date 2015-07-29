package com.ashutosh.doodlesword;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class Assessment extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        getFragmentManager().beginTransaction().add(R.id.relative_layout_assessment, new AssessmentFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assessment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//
//
//    public class CircleLayout extends View {
//
//        private final static int TOTAL_DEGREE = 360;
//        private final static int START_DEGREE = -90;
//
//        private Paint mPaint;
//        private RectF mOvalRect = null;
//
//        private int mItemCount = 5;
//        private int mSweepAngle;
//
//        private int mInnerRadius;
//        private int mOuterRadius;
//        private Bitmap mCenterIcon;
//        private int[] mColors = new int[5];
//        private String[] mTitles = {"Hard Working", "Helping Others", "Bad Behaviour", "Top 10",
//                "Completed Tasks"};
//
//        public CircleLayout(Context context) {
//            this(context, null);
//        }
//
//        public CircleLayout(Context context, AttributeSet attrs) {
//            this(context, attrs, 0);
//        }
//
//        public CircleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
//            super(context, attrs, defStyleAttr);
//
//            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//            mPaint.setStrokeWidth(2);
//
//            mSweepAngle = TOTAL_DEGREE / mItemCount;
//
////            mInnerRadius = 125;
////            mOuterRadius = 400;
//            mInnerRadius = 70;
//            mOuterRadius = 260;
//
//            mCenterIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
//        }

//        @Override
//        protected void onDraw(Canvas canvas) {
//
//            mColors[4] = Color.parseColor("#38d6e0");
//            mColors[1] = Color.parseColor("#ffa500");
//            mColors[2] = Color.parseColor("#ff4444");
//            mColors[3] = Color.parseColor("#4da6ff");
//            mColors[0] = Color.parseColor("#ffff00");
//
//            int width = getWidth();
//            int height = getHeight();
//
//            if (mOvalRect == null) {
//                mOvalRect = new RectF(width / 2 - mOuterRadius, height / 2 - mOuterRadius,
//                        width / 2 + mOuterRadius, height / 2 + mOuterRadius);
//            }
//
//            for (int i = 0; i < mItemCount; i++) {
//                int startAngle = START_DEGREE + i * mSweepAngle;
//                mPaint.setColor(mColors[i]);
//                mPaint.setStyle(Paint.Style.FILL);
//                canvas.drawArc(mOvalRect, startAngle, mSweepAngle, true, mPaint);
//
//                mPaint.setColor(Color.BLACK);
//                mPaint.setStyle(Paint.Style.STROKE);
//                canvas.drawArc(mOvalRect, startAngle, mSweepAngle, true, mPaint);
//
//                int centerX = (int) ((mOuterRadius + mInnerRadius) / 2 * Math.cos(Math.toRadians(startAngle + mSweepAngle / 2)));
//                int centerY = (int) ((mOuterRadius + mInnerRadius) / 2 * Math.sin(Math.toRadians(startAngle + mSweepAngle / 2)));
//                canvas.drawBitmap(mCenterIcon, width / 2 + centerX - mCenterIcon.getWidth() / 2,
//                        height / 2 + centerY - mCenterIcon.getHeight() / 2, null);
//
//                mPaint.setColor(Color.BLACK);
//                mPaint.setStyle(Paint.Style.FILL);
//                canvas.drawText(mTitles[i], width / 2 + centerX - mCenterIcon.getWidth() / 2,
//                        height / 2 + centerY + mCenterIcon.getHeight(), mPaint);
//            }
//
//            mPaint.setColor(Color.WHITE);
//            mPaint.setStyle(Paint.Style.FILL);
//            canvas.drawCircle(width / 2, height / 2, mInnerRadius, mPaint);
//            canvas.drawBitmap(mCenterIcon, width / 2 - mCenterIcon.getWidth() / 2, height / 2 - mCenterIcon.getHeight() / 2, null);
//
//            super.onDraw(canvas);
//        }
//    }

}
