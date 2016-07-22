package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-11.
 */
public class UserInterface03 extends Activity {

    ImageButton imgbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout01 = new LinearLayout(this);
        layout01.setOrientation(LinearLayout.VERTICAL);


        Button btn01 = new Button(this);
        btn01.setText("이미지를 클릭해주세요");
        btn01.setTextColor(Color.BLUE);
        btn01.setTextSize(20);
        layout01.addView(btn01);


        imgbtn = new ImageButton(this);
        imgbtn.setImageResource(R.drawable.dy);

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable tempImg = imgbtn.getDrawable();
                Drawable tempRes = UserInterface03.this.getResources().getDrawable(R.drawable.dy);

                Bitmap tmpBitmap = ((BitmapDrawable)tempImg).getBitmap();
                Bitmap tmpBitmapRes = ((BitmapDrawable)tempRes).getBitmap();

                if(tmpBitmap == tmpBitmapRes){
                    imgbtn.setImageResource(R.drawable.aa);
                }else{
                    imgbtn.setImageResource(R.drawable.dy);
                }
            }
        });

        layout01.addView(imgbtn);


        Button btn02 = new Button(this);
        btn02.setText("버튼02");
        btn02.setTextColor(Color.rgb(0,255,0));
        btn02.setTextSize(20);
        layout01.addView(btn02);

        setContentView(layout01);
    }
}
