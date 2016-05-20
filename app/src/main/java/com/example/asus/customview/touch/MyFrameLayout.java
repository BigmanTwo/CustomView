package com.example.asus.customview.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Asus on 2016/5/20.
 */
public class MyFrameLayout extends FrameLayout{


    public MyFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyFrameLayout的onTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyFrameLayout的onTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyFrameLayout的onTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.onTouchEvent(event);
        Log.d("onTouch","MyFrameLayout的onTouchEvent方法默认返回值"+b);
        return b;

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyFrameLayout的dispatchTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyFrameLayout的dispatchTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyFrameLayout的dispatchTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.dispatchTouchEvent(ev);
        Log.d("onTouch","MyFrameLayout的dispatchTouchEvent方法默认返回值"+b);
        return b;
    }
        //阻拦事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyFrameLayout的onInterceptTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyFrameLayout的onInterceptTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyFrameLayout的onInterceptTouchEvent方法移动");
                break;
            default:
                break;
        }
//        boolean b=super.onInterceptTouchEvent(ev);
        boolean b=true;
        Log.d("onTouch","MyFrameLayout的onInterceptTouchEvent方法默认返回值"+b);
        return b;
    }
}
