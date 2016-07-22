package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by Administrator on 2016-07-13.
 */
public class Lotto_version1 extends Activity implements View.OnClickListener {

    Button lottobtn;
    ImageButton back;
    int[] numImg = {R.drawable.b01, R.drawable.b02, R.drawable.b03, R.drawable.b04, R.drawable.b05, R.drawable.b06, R.drawable.b07, R.drawable.b08, R.drawable.b09, R.drawable.b10, R.drawable.b11, R.drawable.b12,
            R.drawable.b13, R.drawable.b14, R.drawable.b15, R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20, R.drawable.b21, R.drawable.b22, R.drawable.b23, R.drawable.b24, R.drawable.b25,
            R.drawable.b26, R.drawable.b27, R.drawable.b28, R.drawable.b29, R.drawable.b30, R.drawable.b31, R.drawable.b32, R.drawable.b33, R.drawable.b34, R.drawable.b35, R.drawable.b36, R.drawable.b37, R.drawable.b38,
            R.drawable.b39, R.drawable.b40, R.drawable.b41, R.drawable.b42, R.drawable.b43, R.drawable.b44, R.drawable.b45};

    int[] topImg = {R.id.ball01, R.id.ball02, R.id.ball03, R.id.ball04, R.id.ball05, R.id.ball06};
    ImageView topImgs[] = new ImageView[topImg.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotto_version1);

        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(this);
        lottobtn = (Button) findViewById(R.id.lottobtn);
        lottobtn.setOnClickListener(this);
        for (int i = 0; i < topImg.length; i++) {
            topImgs[i] = (ImageView) findViewById(topImg[i]);
        }
    }

    @Override
    public void onClick(View v) {
        int ran1[] = new int[topImg.length];
        if (v.getId() == R.id.lottobtn) {
            for (int i = 0; i < topImg.length; i++) {
                boolean flag = false;
                int ran = getRandom(45) - 1;
                Log.v("ran", "ran" + ran);

                for (int j = 0; j < i; j++) {
                    if (ran == ran1[j]) {
                        flag = true;
                        Log.v("ran","중복됨");
                        break;
                    }
                }
                if (flag == true) {
                    i--;
                } else {
                    ran1[i] = ran;
                    topImgs[i].setImageResource(numImg[ran]);
                }
            }
        }else if(v.getId()==R.id.back){
            finish();
        }

    }


    public int getRandom(int num) {
        Random ran = new Random();
        int result = ran.nextInt(num) + 1;
        return result;
    }
}

