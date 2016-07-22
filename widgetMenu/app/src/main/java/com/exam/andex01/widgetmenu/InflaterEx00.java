package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-18.
 */
public class InflaterEx00 extends Activity implements View.OnClickListener {

    ImageButton imgbtn;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inflater00);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.imageview_ex01, container, true);

        imgbtn = (ImageButton) findViewById(R.id.imgbtn);
        edt = (EditText) findViewById(R.id.edt);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.imgbtn) {

        }
    }
}
