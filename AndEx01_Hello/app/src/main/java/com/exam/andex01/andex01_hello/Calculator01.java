package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-06.
 */
public class Calculator01 extends Activity implements View.OnClickListener {

    int btns[] = {R.id.clear, R.id.del, R.id.enter, R.id.division, R.id.multi, R.id.plus, R.id.minus, R.id.comma, R.id.zero, R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine};
    Button btn[] = new Button[btns.length];
    TextView edittext;
    double num1;
    double num2;
    double sum;
    double result;
    char op;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator01);
        edittext = (TextView)findViewById(R.id.edittext);


        Button imgback = (Button)findViewById(R.id.imgback);
        imgback.setOnClickListener(this);

        for (int i = 0; i < btns.length; i++) {
            btn[i] = (Button) findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) { //이벤트가 전송된 소스
        for(int i=0; i<btn.length; i++) {
            if (v.getId() == btns[i]) {
                Toast.makeText(getApplicationContext(), btn[i].getText().toString(), Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.imgback) {
                finish();
            }
        }
         Button b = (Button) findViewById(v.getId());
        if (v.getId() == R.id.clear) {
            edittext.setText("");
            result = 0;
            num1 = 0;
        } else if (v.getId() == R.id.del) {
            if (edittext.getText().length() > 0) {
                edittext.setText(edittext.getText().subSequence(0, edittext.getText().length() - 1));
            }

        }else if (v.getId() == R.id.enter) {
            num2 = Double.parseDouble(edittext.getText().toString());

            if (op == '+') {
                sum = result + num2;
                edittext.setText(String.valueOf(sum));
            } else if (op == '-') {
                sum = num1 - num2;
                edittext.setText(String.valueOf(sum));
            } else if (op == '/') {
                sum = num1 / num2;
                edittext.setText(String.valueOf(sum));
            } else if (op == '*') {
                sum = num1 * num2;
                edittext.setText(String.valueOf(sum));
            }

        } else if (v.getId() == R.id.division) {
            num1 = Double.parseDouble(edittext.getText().toString());
            op = '/';
            edittext.setText("");
        } else if (v.getId() == R.id.multi) {
            num1 = Double.parseDouble(edittext.getText().toString());

            op = '*';
            edittext.setText("");
        } else if (v.getId() == R.id.plus) {
            num1 = Double.parseDouble(edittext.getText().toString());
            result += num1;
            op = '+';
            edittext.setText("");
        } else if (v.getId() == R.id.minus) {
            num1 = Double.parseDouble(edittext.getText().toString());
            op = '-';
            edittext.setText("");
        }  else {
            edittext.setText(edittext.getText().toString() + b.getText().toString());

        }
    }


}
