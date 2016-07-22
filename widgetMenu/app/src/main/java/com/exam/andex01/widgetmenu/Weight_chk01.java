package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016-07-11.
 */
public class Weight_chk01 extends Activity implements View.OnClickListener {
    EditText height, weight, result;
    int btns[] = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero};
    Button btn[] = new Button[btns.length];
    Button reset ,next,enter;

    int chk;
    ImageButton back;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_chkv01);


        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.back){
                    finish();
                }
            }
        });





        height = (EditText) findViewById(R.id.height);
        height.setFocusable(true);
        weight = (EditText) findViewById(R.id.weight);
        result = (EditText) findViewById(R.id.result);

        for (int i = 0; i < btns.length; i++) {
            btn[i] = (Button) findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }

        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

    }

    public void onClick(View v) {
        //리셋버튼
        if (v.getId() == R.id.reset) {
            height.setText("");
            weight.setText("");

        //표준체중계산
        }else if(v.getId() == R.id.enter){
            double height01 = Integer.parseInt(height.getText().toString());
            double weight01 = Integer.parseInt(weight.getText().toString());
            double avg = (height01-100)*0.9;
            if(avg > weight01){
                double su = avg-weight01;
                if(su > 5){
                    result.setText("체중 미달입니다. 적정체중은" + avg +"kg입니다");
                }else{
                    result.setText("정상체중입니다.");
                }

            }else if(weight01 > avg){
                double su = weight01 - avg;
                if(su > 5){
                    result.setText("과체중입니다. 적정체중은" + avg +"kg입니다");
                }else{
                    result.setText("정상체중입니다.");
                }
            }
        }

        Button b = (Button) findViewById(v.getId());
        //포커스 바꾸기
        if(chk==0){
            for (int i = 0; i < btn.length; i++) {
                if (v.getId() == btns[i]) {
                    height.setFocusable(true);
                    height.requestFocus();
                    height.setText(height.getText().toString() + b.getText().toString());
                }
            }
            if(v.getId() == R.id.next){
                chk=1;
            }
        }else if(chk ==1){
            for (int i = 0; i < btn.length; i++) {
                if (v.getId() == btns[i]) {
                    weight.setFocusable(true);
                    weight.requestFocus();
                    weight.setText(weight.getText().toString() + b.getText().toString());
                }
            }
            if(v.getId() == R.id.next){
                chk=0;
            }
        }


    }
}
