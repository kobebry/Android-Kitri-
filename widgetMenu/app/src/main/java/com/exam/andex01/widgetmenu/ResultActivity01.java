package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-20.
 */
public class ResultActivity01 extends Activity{
    EditText editsend1, result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity01);
        editsend1 = (EditText)findViewById(R.id.editsend1);
        result =(EditText)findViewById(R.id.result);

    }
    public void requestBtn(View v){
        Intent intent = new Intent(getApplicationContext(), ResultActivity02.class);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String msg = "request : " + requestCode+ " result : "+ resultCode + " data : " + data.getStringExtra("textcode");

        //넘어온 data값을 저장
        result.setText(data.getStringExtra("textcode"));

        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
