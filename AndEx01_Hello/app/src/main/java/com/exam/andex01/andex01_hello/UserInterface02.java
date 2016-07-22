package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-11.
 */
public class UserInterface02 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout01 = new LinearLayout(this);
        layout01.setOrientation(LinearLayout.VERTICAL);

        Button btn01 = new Button(this);
        btn01.setText("버튼01");
        btn01.setTextColor(Color.BLUE);
        btn01.setTextSize(20);
        layout01.addView(btn01);


        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"하하하",Toast.LENGTH_SHORT).show();
            }
        });



        Button btn02 = new Button(this);
        btn02.setText("버튼02");
        btn02.setTextColor(Color.rgb(0,255,0));
        btn02.setTextSize(20);
        layout01.addView(btn02);

        setContentView(layout01);
    }
}
