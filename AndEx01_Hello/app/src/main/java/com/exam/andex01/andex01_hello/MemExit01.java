package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-06.
 */
public class MemExit01 extends Activity implements View.OnClickListener{
    private EditText vid;
    private EditText vpwd;
    String msg;
    private Button memBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_txt01);
        vid = (EditText) findViewById(R.id.vid);
        vpwd = (EditText) findViewById(R.id.vpwd);
        memBtn = (Button)findViewById(R.id.memBtm);
        memBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.memBtm)
        Toast.makeText(this,"이벤트 확인",Toast.LENGTH_SHORT).show();
    }



    public void memResult(View v) {
        msg = "아이디 : " + vid.getText().toString() + "패스워드 : " + vpwd.getText().toString();
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
