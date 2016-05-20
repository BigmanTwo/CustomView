package com.example.asus.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton1,mButton2,mButton3,mButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1=(Button)findViewById(R.id.view_but);
        mButton2=(Button)findViewById(R.id.view_group_but);
        mButton3=(Button)findViewById(R.id.view_but1);
        mButton4=(Button)findViewById(R.id.touch_button);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.view_but:
                intent=new Intent(this,MyEditext.class);
                startActivity(intent);
                break;
            case  R.id.view_group_but:
                intent=new Intent(this,MyViewGroupActivity.class);
                startActivity(intent);
                break;
            case R.id.view_but1:
                intent=new Intent(this,MyViewActivity.class);
                startActivity(intent);
                break;
            case R.id.touch_button:
                intent=new Intent(this,OnTouchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
