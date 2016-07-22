package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016-07-20.
 */
public class AlertDialog01 extends Activity {
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog01);

        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.linkedin);
        builder.setTitle("Question : ");
        builder.setMessage("회원가입을 하시겠습니까");
        builder.setPositiveButton("확인",null);
    }

    public void alertClick(View v){
        builder.show();

    }
}
