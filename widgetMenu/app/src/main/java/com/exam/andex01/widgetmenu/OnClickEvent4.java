package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-14.
 */
public class OnClickEvent4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_click_event4);

        Button button = (Button) findViewById(R.id.button);

        MyListenerClass buttonListner = new MyListenerClass();
        button.setOnClickListener(buttonListner);
    }

    class MyListenerClass implements View.OnClickListener {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();

        }
    }

}
