package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-14.
 */
public class LayoutByCode02 extends Activity implements View.OnClickListener {
    LinearLayout layout01;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout01 = new LinearLayout(this);
        layout01.setOrientation(LinearLayout.VERTICAL);

        button1 = new Button(this);
        button1.setText("테스트 버튼1");
        button2 = new Button(this);
        button2.setText("테스트 버튼2");
        button1.setOnClickListener(this);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layout01.addView(button1, param);
        layout01.addView(button2, param);
        setContentView(layout01);
    }
    int sw = 0;
    public void onClick(View v){
        if(sw == 0){
            layout01.setOrientation(LinearLayout.HORIZONTAL);
            sw=1;
        }else if(sw ==1 ){
            layout01.setOrientation(LinearLayout.VERTICAL);
            sw=0;
        }

    }
}
