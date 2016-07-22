package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016-07-07.
 */
public class ImageViewEx01 extends Activity implements View.OnClickListener{
    int sw;
    ImageButton img;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_ex01);
        img = (ImageButton)findViewById(R.id.img);
        img.setOnClickListener(this);
    }

    public void onClick(View v){
        if(sw == 0){
            sw = 1;
            img.setImageResource(R.drawable.zz);
        }else if(sw == 1){
            sw =0;
            img.setImageResource(R.drawable.dy);
        }

    }
}
