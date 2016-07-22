package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-15.
 */
public class TouchListener01 extends Activity implements View.OnClickListener, View.OnTouchListener {
    Button onclickbtn, ontouchbtn;
    TextView clickview, touchview;
    int su;
    int su1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_listner01);

        clickview = (TextView) findViewById(R.id.clickview);
        touchview = (TextView) findViewById(R.id.touchview);

        onclickbtn = (Button) findViewById(R.id.onclickbtn);
        ontouchbtn = (Button) findViewById(R.id.ontouchbtn);

        onclickbtn.setOnClickListener(this);
        ontouchbtn.setOnTouchListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.onclickbtn) {
            su1++;
            clickview.setText(String.valueOf(su1));
        }

    }


    public boolean onTouch(View v, MotionEvent m) {
        if (v.getId() == R.id.ontouchbtn) {
            int status = m.getAction();
            su++;
            touchview.setText(String.valueOf(su));
            if(status == MotionEvent.ACTION_UP){
                su = 0;
                touchview.setText(String.valueOf(su));
            }
        }

        return true;
    }
}
