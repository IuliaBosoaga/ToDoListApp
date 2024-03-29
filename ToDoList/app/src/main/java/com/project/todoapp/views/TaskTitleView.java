package com.project.todoapp.views;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.project.todoapp.R;


public class TaskTitleView extends TextView {
    public static final int NORMAL = 0;
    public static final int DONE = 1;
    public static final int OVERDUE = 2;
    private int mState;

    private int dividerColor;
    private Paint paint;


    public TaskTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public TaskTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public TaskTitleView(Context context) {
        super(context);

    }


    public int getState() {
        return mState;
    }

    public void setState(int state) {
        switch (state) {
            case DONE:
                setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                break;
            case NORMAL:
                setPaintFlags(0);
                setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                break;
            case OVERDUE:
                setPaintFlags(0);
                setTextColor(ContextCompat.getColor(getContext(), R.color.red));
                break;
            default:
                return;
        }

        mState = state;
    }
}
