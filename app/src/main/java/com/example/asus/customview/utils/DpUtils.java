package com.example.asus.customview.utils;

import android.content.Context;

/**
 * Created by Asus on 2016/5/19.
 */
public class DpUtils {
    public static int dip2px(Context context,float dip){
       final  float scale=context.getResources().getDisplayMetrics().density;
        return (int)(dip*scale+0.5f);
    }
    public static int px2dip(Context context,float px){
       final  float scale=context.getResources().getDisplayMetrics().density;
        return (int)(px/scale+0.5f);
    }

}
