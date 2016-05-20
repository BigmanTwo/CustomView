package com.example.asus.customview.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.asus.customview.utils.DpUtils;

import java.text.DecimalFormat;

/**
 * Created by Asus on 2016/5/19.
 */
public class MyView extends View {
    private Paint textPaint,circlePaint,pathPaint;
    private int width;
    private int height;
    private float num=0;
    private float offset=0;
    private int num1=10,num2=20;
    private Path path;
    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getMeasuredWidth();
        height=getMeasuredHeight();
    }
    private void init(){
        circlePaint=new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.GREEN);
        circlePaint.setStrokeWidth(1);
        circlePaint.setStyle(Paint.Style.FILL);
        textPaint=new Paint();
        textPaint.setStrokeWidth(1);
        textPaint.setTextSize(DpUtils.dip2px(getContext(),20));
        textPaint.setColor(Color.WHITE);

        pathPaint=new Paint();
        pathPaint.setStyle(Paint.Style.FILL);
        pathPaint.setColor(Color.BLUE);
        pathPaint.setStrokeWidth(1);
        pathPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        path=new Path();
        sendMessage();
    }
    private void setNum(float num){this.num=num;}
    public void setAnimation(){
        ObjectAnimator objectAnimation=ObjectAnimator.ofFloat(this,"num",0,100);
        objectAnimation.setDuration(10000);
        objectAnimation.start();
        objectAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("数值",animation.getAnimatedValue()+"");
               setNum ((Float) animation.getAnimatedValue()) ;

                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(width/2,height/2,height/2,circlePaint);
        int save=canvas.saveLayer(0,0,width,height,textPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawCircle(width/2,height/2,height/2,circlePaint);
        path.reset();
        path.moveTo(0,height);
        path.lineTo(width,height);
        path.lineTo(width+offset,height-height*num/100);
        Log.d("d值",num+"");
        for (int i = 0; i < width/num2 ;i++) {
            path.rQuadTo(-num2,-num1,-num2*5,0);
            path.rQuadTo(-num2,num1,-num2*2,0);

        }
        path.close();
        canvas.drawPath(path,pathPaint);
        canvas.restoreToCount(save);
        DecimalFormat fnum=new DecimalFormat("##0.00");
        String percent=fnum.format(num);
        canvas.drawText(percent+"%",width/2,height/2,textPaint);
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    offset=+5;
                    if (offset>num2*2){
                        offset=0;
                    }
                    invalidate();
                    sendEmptyMessageDelayed(1,50);
                    break;
            }
        }
    };
public void sendMessage(){
    Message message=new Message();
    message.what=1;
    mHandler.sendMessage(message);
}
}
