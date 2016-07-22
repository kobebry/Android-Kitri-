package com.exam.andex01.andex01_hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {//초기화
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout); //화면보여주기
    }
    public void click01(View v){
        Toast.makeText(getApplicationContext(),"클릭 이벤트 확인",Toast.LENGTH_SHORT).show();
    }
}
