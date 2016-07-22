package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-20.
 */
public class SawonCustomerActivity extends Activity {
    TextView viewtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sawon_customer_activity);

        viewtext = (TextView) findViewById(R.id.viewtext);
        Intent intent = new Intent();
        intent.putExtra("textcode", viewtext.getText().toString());
        setResult(100, intent);

    }

    public void backbtn(View v) {
        finish();
    }
}
