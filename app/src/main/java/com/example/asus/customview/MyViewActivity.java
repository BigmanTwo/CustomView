package com.example.asus.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.customview.widget.MyView;

public class MyViewActivity extends AppCompatActivity {
    private Button mButton;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        myView=(MyView)findViewById(R.id.myView);
        mButton=(Button)findViewById(R.id.animotion);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setAnimation();
            }
        });
    }
}
