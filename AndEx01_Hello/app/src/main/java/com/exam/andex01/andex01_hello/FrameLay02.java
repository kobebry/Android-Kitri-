package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-07-12.
 */
public class FrameLay02 extends Activity {

    ImageView bg;
    ImageView sw;
    int s = 0;
    Button imgbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_lay02);
        bg = (ImageView) findViewById(R.id.bg);
        sw = (ImageView) findViewById(R.id.sw);
        imgbtn = (Button) findViewById(R.id.imgbtn);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s == 0) {
                    s = 1;
                    bg.setVisibility(ImageView.VISIBLE);
                    sw.setVisibility(ImageView.INVISIBLE);
                } else {
                    s = 0;
                    bg.setVisibility(ImageView.INVISIBLE);
                    sw.setVisibility(ImageView.VISIBLE);
                }
            }
        });

    }
}

