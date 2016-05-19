package com.example.asus.customview.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.asus.customview.R;
import com.example.asus.customview.utils.DpUtils;

/**
 * Created by Asus on 2016/5/19.
 */
public class MyEditText extends EditText {
    private Paint paint;
    private float width,height;
    public MyEditText(Context context) {
        super(context);
        init(context,null);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }
    private void init(Context context, AttributeSet attrs){
        paint=new Paint();
        paint.setStrokeWidth(20);
        paint.setTextSize(DpUtils.dip2px(context,20));
        paint.setAntiAlias(true);//抗锯齿
        if (attrs!=null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.MyEditText);
            int color=typedArray.getColor(R.styleable.MyEditText_myColor,Color.YELLOW);
            paint.setColor(color);
        }
    }
    //测量控件宽度的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width=getWidth();
        height=getHeight();
    }
    //绘制控件的方法

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String string=getText().length()+"/100";
        canvas.drawText(string,width- paint.measureText(string),height+getScrollY()-paint.measureText(string),paint);
    }
}
