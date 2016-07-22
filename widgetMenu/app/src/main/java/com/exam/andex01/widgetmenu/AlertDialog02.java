package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-20.
 */
public class AlertDialog02 extends Activity {
    AlertDialog.Builder builder;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog01);
        textview =(TextView)findViewById(R.id.textview);
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.linkedin);
        builder.setTitle("Question : ");
        builder.setMessage("회원가입을 하시겠습니까");
        builder.setPositiveButton("확인", postive);
        builder.setNegativeButton("취소", cancle);
    }

    DialogInterface.OnClickListener postive = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface d, int which){
            textview.setText("좋음");
        }
    };


    DialogInterface.OnClickListener cancle = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            textview.setText("시름");
        }
    };


    public void alertClick(View v) {
        builder.show();

    }


}
