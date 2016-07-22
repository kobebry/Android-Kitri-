package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-06.
 */
public class GuGuDan01 extends Activity implements View.OnClickListener{
    EditText dan;
    TextView pan;
    int su;
    String gu = "";
    Button guid;
    Button resetid;


    int btns[] = {R.id.guid, R.id.resetid};
    Button btn[] = new Button[btns.length];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gugudan01);
        dan = (EditText)findViewById(R.id.dan);
        pan = (TextView)findViewById(R.id.pan);
        ImageButton backbtn = (ImageButton)findViewById(R.id.imgback);
        backbtn.setOnClickListener(this);
/*        guid = (Button)findViewById(R.id.guid);
        resetid = (Button)findViewById(R.id.resetid);*/

        for(int i=0; i<btns.length; i++){
            btn[i] = (Button)findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }
/*

        guid.setOnClickListener(this);
        resetid.setOnClickListener(this);
*/
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.guid){
            su = Integer.parseInt(dan.getText().toString());
            for(int i=2; i<=9; i++){
                gu += su+"x"+i+"="+su*i+"\n";
            }
            pan.setText(gu);
        }else if(v.getId()==R.id.resetid){
            gu = "";
            pan.setText(gu);
        }else if(v.getId() == R.id.imgback){
            finish();
        }
    }

    public void guResult(View v){
        Log.i("GuGuResult",dan.getText().toString());
        su = Integer.parseInt(dan.getText().toString());
        for(int i=2; i<=9; i++){
            gu += su+"x"+i+"="+su*i+"\n";

        }
        pan.setText(gu);
    }

    public void reset(View v){
        gu = "";
        pan.setText(gu);
    }
}
