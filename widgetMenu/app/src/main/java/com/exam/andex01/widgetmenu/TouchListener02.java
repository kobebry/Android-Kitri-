package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-15.
 */
public class TouchListener02 extends Activity implements View.OnTouchListener {
    LinearLayout liner;
    ImageView nimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_listener02);
        nimo = (ImageView) findViewById(R.id.nimo);
        nimo.setOnTouchListener(this);

        liner = (LinearLayout) findViewById(R.id.liner);
        liner.setOnTouchListener(this);
    }

    public boolean onTouch(View v, MotionEvent m) {
        switch (m.getAction()) {
            case MotionEvent.ACTION_MOVE:
                nimo.setX(m.getX() - nimo.getWidth()/2);
                nimo.setY(m.getY() - nimo.getHeight()/2);
        }
        return true;
    }
}
