package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-13.
 */
public class MemHom extends Activity{

    LinearLayout top, main, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mem_home);

        top = (LinearLayout)findViewById(R.id.top);
        main = (LinearLayout)findViewById(R.id.main);
        bottom = (LinearLayout)findViewById(R.id.bottom);




    }
}
