package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-08.
 */
public class ActivityEx01 extends Activity implements View.OnClickListener {
    Button button1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex01);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "클릭 이벤트 확인", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),ActivityEx02.class);
        startActivity(intent);
    }
}
