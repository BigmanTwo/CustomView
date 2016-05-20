package com.example.asus.customview.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Asus on 2016/5/20.
 */
public class MyLinerLayout extends LinearLayout {

    public MyLinerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyLinerLayout的onTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyLinerLayout的onTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyLinerLayout的onTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.onTouchEvent(event);
        Log.d("onTouch","MyLinerLayout的onTouchEvent方法默认返回值"+b);
        return b;
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyLinerLayout的onInterceptTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyLinerLayout的onInterceptTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyLinerLayout的onInterceptTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.onInterceptHoverEvent(event);
        Log.d("onTouch","MyLinerLayout的onInterceptTouchEvent方法默认返回值"+b);
        return b;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyLinerLayout的dispatchTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyLinerLayout的dispatchTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyLinerLayout的dispatchTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.dispatchTouchEvent(ev);
        Log.d("onTouch","MyLinerLayout的dispatchTouchEvent方法默认返回值"+b);
        return b;
    }
}
