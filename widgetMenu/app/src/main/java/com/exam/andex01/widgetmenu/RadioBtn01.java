package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-14.
 */
public class RadioBtn01 extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_btn01);
    }

    public void onRadioButtonClicked(View v){
        Toast.makeText(getApplicationContext(),((RadioButton)v).getText(),Toast.LENGTH_SHORT).show();
        }
    }


