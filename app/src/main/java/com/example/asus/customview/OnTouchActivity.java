package com.example.asus.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class OnTouchActivity extends AppCompatActivity {
    private Button mButton;
    private GestureDetector mDetector;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);
        mButton=(Button)findViewById(R.id.mybutton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Button","点击事件");
            }
        });
        mDetector=new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.d("MainActivity","双击屏幕");
                return super.onDoubleTap(e);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d("MainActivity","手指快速滑动");
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d("MainActivity","手指滑动");
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
    }
    //事件的消费机制

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","OnTouchActivity的onTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","OnTouchActivity的onTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","OnTouchActivity的onTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.onTouchEvent(event);
        Log.d("onTouch","OnTouchActivity的onTouchEvent方法默认返回值"+b);
        return b;
    }
    //分配事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                Log.d("onTouch","OnTouchActivity的dispatchTouchEvent方法抬起");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.d("onTouch","OnTouchActivity的dispatchTouchEvent方法按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("onTouch","OnTouchActivity的dispatchTouchEvent方法移动");
                break;
            default:
                break;
        }
        boolean b=super.dispatchTouchEvent(ev);
        Log.d("onTouch","OnTouchActivity的dispatchTouchEvent方法默认返回值"+b);
        return b;
    }


}
