package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-20.
 */
public class CalcResult extends Activity {

    TextView result;
    int su1, su2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_result);
        result = (TextView)findViewById(R.id.result);
        Intent intent = getIntent();

        su1 = intent.getIntExtra("su1", 0);
        su2 = intent.getIntExtra("su2", 0);
        Log.v("숫자1", ""+su1);
        Log.v("숫자2", ""+su2);

        sum = su1+su2;

        result.setText(String.valueOf(sum));
    }

}
