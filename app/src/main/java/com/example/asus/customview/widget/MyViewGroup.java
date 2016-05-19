package com.example.asus.customview.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Asus on 2016/5/19.
 */
public class MyViewGroup extends ViewGroup{
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int w=getMeasuredWidth();//得到viewgroup的宽
        int width=0;
        for (int i=0;i<getChildCount();i++){
            View childView=getChildAt(i);
            int childWidth=childView.getMeasuredWidth();
            int childHeight=childView.getMeasuredHeight();
            if(childWidth<w-width){
                childView.layout(width,0,childWidth+width,childHeight);
                width+=childWidth;
            }else{
                childView.layout(0,childHeight+20,childWidth,childHeight);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }
}
