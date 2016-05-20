package com.example.asus.customview.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Asus on 2016/5/20.
 */
public class MyButton extends Button {

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
        case MotionEvent.ACTION_UP:
            Log.d("onTouch","MyButton的onTouchEvent方法抬起");
        break;
        case MotionEvent.ACTION_DOWN:
            Log.d("onTouch","MyButton的onTouchEvent方法按下");
        break;
        case MotionEvent.ACTION_MOVE:
            Log.d("onTouch","MyButton的onTouchEvent方法移动");
        break;
        default:
        break;
    }
    boolean b=super.onTouchEvent(event);
        Log.d("onTouch","MyButton的onTouchEvent方法默认返回值"+b);
    return b;


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","MyButton的dispatchTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","MyButton的dispatchTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","MyButton的dispatchTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.dispatchTouchEvent(event);
        Log.d("onTouch","MyButton的dispatchTouchEvent方法默认返回值"+b);
        return b;
    }
}
