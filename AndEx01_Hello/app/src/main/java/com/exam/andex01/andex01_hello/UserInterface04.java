package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-11.
 */
public class UserInterface04 extends Activity {
    int imgs[] = {R.drawable.aa, R.drawable.bb, R.drawable.cc, R.drawable.rock, R.drawable.scissors};
    ImageButton imgbtn[] = new ImageButton[imgs.length];
    ImageView imgview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout01 = new LinearLayout(this);
        layout01.setOrientation(LinearLayout.VERTICAL);

        LinearLayout layout03 = new LinearLayout(this);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layout03.setLayoutParams(param);
        layout01.addView(layout03);

        LinearLayout layout02 = new LinearLayout(this);
        layout02.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layout02.setLayoutParams(param2);
        layout01.addView(layout02);

        final LinearLayout layout04 = new LinearLayout(this);
        LinearLayout.LayoutParams param3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        layout03.setLayoutParams(param3);
        layout01.addView(layout04);

        imgview = new ImageView(this);
        imgview.setImageResource(R.drawable.aa);


        TextView text01 = new TextView(this);
        text01.setText("이미지 버튼 바꾸기");
        text01.setTextColor(Color.BLUE);
        text01.setTextSize(20);
        layout03.addView(text01);

        for (int i=0; i<imgs.length;i++){
            imgbtn[i] = new ImageButton(this);
            imgbtn[i].setScaleType(ImageView.ScaleType.FIT_XY);
            imgbtn[i].setImageResource(imgs[i]);
            LinearLayout.LayoutParams layoutparam = new LinearLayout.LayoutParams(1, 200, 200);
            layout02.addView(imgbtn[i], layoutparam);
            imgbtn[i].setTag(i);
            imgbtn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgview.setImageResource(imgs[Integer.parseInt(v.getTag().toString())]);
                }
            });
        }
        layout04.addView(imgview);

        /*img01 = new ImageButton(this);
        img01.setScaleType(ImageView.ScaleType.FIT_XY);
        img01.setImageResource(R.drawable.aa);

        img02 = new ImageButton(this);
        img02.setScaleType(ImageView.ScaleType.FIT_XY);
        img02.setImageResource(R.drawable.bb);

        img03 = new ImageButton(this);
        img03.setId(R.id.cc);
        img03.setScaleType(ImageView.ScaleType.FIT_XY);
        img03.setImageResource(R.drawable.cc);

        img04 = new ImageButton(this);
        img04.setScaleType(ImageView.ScaleType.FIT_XY);
        img04.setImageResource(R.drawable.rock);

        img05 = new ImageButton(this);
        img05.setScaleType(ImageView.ScaleType.FIT_XY);
        img05.setImageResource(R.drawable.scissors);*/


       /* layout02.addView(img01, layoutparam);
        layout02.addView(img02, layoutparam);
        layout02.addView(img03, layoutparam);
        layout02.addView(img04, layoutparam);
        layout02.addView(img05, layoutparam);
*/

      /*  imgview = new ImageView(this);
        imgview.setImageResource(R.drawable.aa);
        layout04.addView(imgview);

        for (int i = 0; i < imgs.length; i++) {
            imgview.setImageResource(imgs[i]);
            imgbtn[i].setOnClickListener(this);
        }*/
        setContentView(layout01);
    }

/*

    public void onClick(View v) {
        Integer.parseInt(imgbtn[i].getTag().toString());
    }
*/


}

