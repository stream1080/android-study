package com.example.myapplication.widge;

import android.content.Context;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.MotionEvent;


import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    private static final String TAG = "MyButton";
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent: " + "1");
            break;
        }
        return false;
    }
}
