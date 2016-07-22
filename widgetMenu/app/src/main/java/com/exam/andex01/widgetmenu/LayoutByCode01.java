package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-14.
 */
public class LayoutByCode01 extends Activity{

    LinearLayout LayoutManager;
    int sw=0;
    Button Button01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_by_code1);
        Button01 = (Button)findViewById(R.id.Button01);
        LayoutManager = (LinearLayout)findViewById(R.id.LayoutManager);

    }



    public void cngLay(View v){

        if(sw==0){
            Button01.setText("Vertical Change");
            LayoutManager.setOrientation(LinearLayout.VERTICAL);
            sw=1;
        }else if(sw == 1){
            Button01.setText("Horizontal Change");
            LayoutManager.setOrientation(LinearLayout.HORIZONTAL);
            sw=0;
        }


    }
}
