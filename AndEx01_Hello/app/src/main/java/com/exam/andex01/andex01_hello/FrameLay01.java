package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-07-12.
 */
public class FrameLay01 extends Activity {
    ImageView imgbg;
    int sw =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_lay01);
        imgbg = (ImageView)findViewById(R.id.imgbg);
    }


    public void chkImg(View v){
        if(sw==0){
            sw=1;
            imgbg.setVisibility(ImageView.INVISIBLE);
        }else{
            sw=0;
            imgbg.setVisibility(ImageView.VISIBLE);
        }
    }
}
