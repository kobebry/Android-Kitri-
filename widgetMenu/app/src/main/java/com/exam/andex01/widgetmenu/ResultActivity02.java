package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-07-20.
 */
public class ResultActivity02 extends Activity{
    EditText editsend2;
    Button calbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity02);
        editsend2 = (EditText)findViewById(R.id.editsend2);



    }

    public void resultBtn(View v){
        Intent intent = new Intent();

        //넘길 데이터값 설정
        intent.putExtra("textcode",editsend2.getText().toString());
        setResult(100,intent);
        finish();
    }
}
