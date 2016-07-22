package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2016-07-21.
 */
public class NumberGameV01 extends Activity implements View.OnClickListener {
    int btn[] = {R.id.btn01, R.id.btn02, R.id.btn03, R.id.btn04, R.id.btn05};
    int su[] = {1, 2, 4, 8, 16};
    int bbtn[] = {R.id.btn06,R.id.btn07,R.id.btn08,R.id.btn09,R.id.btn10};
    Button back;

    RadioButton btns[] = new RadioButton[btn.length];
    RadioButton bbtns[] = new RadioButton[bbtn.length];

    int group[] = {R.id.group1, R.id.group2, R.id.group3, R.id.group4, R.id.group5};
    RadioGroup groups[] = new RadioGroup[group.length];
    Button test, clear;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_gamev01);

        for (int i = 0; i < btn.length; i++) {
            btns[i] = (RadioButton) findViewById(btn[i]);
            bbtns[i] = (RadioButton)findViewById(bbtn[i]);
            groups[i] = (RadioGroup) findViewById(group[i]);
        }
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
        clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    public void onClick(View v) {
        int sum = 0;
        boolean flag = false;
        builder = new AlertDialog.Builder(this);

        if (v.getId() == R.id.test) {
            for (int i = 0; i < btn.length; i++) {
                if (!btns[i].isChecked() && !bbtns[i].isChecked()) {
                    flag = false;
                    builder.setMessage("모두 체크해주세요");
                    builder.setPositiveButton("확인", null);
                    builder.show();
                    break;
                } else {
                    if (btns[i].isChecked()) {
                        sum += su[i];
                        Log.v("숫자값", String.valueOf(sum));
                        flag = true;
                    }else if(bbtns[i].isChecked()){
                        flag = true;
                    }
                }
            }

            if(flag == true){
                builder.setTitle("선택한 숫자는");
                builder.setMessage(sum+"번 입니다.");
                builder.setPositiveButton("확인", null);
                builder.show();
            }

        } else if (v.getId() == R.id.clear) {
            for (int i = 0; i < group.length; i++) {
                groups[i].clearCheck();
            }
        }else if(v.getId()==R.id.back){
            finish();
        }
    }
}
