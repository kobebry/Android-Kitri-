package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-20.
 */
public class AlertDialog04 extends Activity {
    AlertDialog.Builder builder;
    TextView textview;
    String msg[]={"군필", "미필"};
    int chk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog01);
        textview =(TextView)findViewById(R.id.textview);
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.linkedin);
        builder.setTitle("Color : ");
        builder.setPositiveButton("확인",postive);

/*
        builder.setItems(msg,new DialogInterface.OnClickListener() {
*/

        builder.setSingleChoiceItems(msg, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                Toast.makeText(getApplicationContext(),msg[index] + "확인", Toast.LENGTH_SHORT).show();
                chk = index;
            }
        });

/*        builder.setPositiveButton("확인", postive);
        builder.setNegativeButton("취소", cancle);*/
    }

    DialogInterface.OnClickListener postive = new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface d, int index){
            if(chk ==0){
                textview.setText(msg[0] + "입니다.");
            }else if(chk==1){
                textview.setText(msg[1] + "입니다.");

            }
        }
    };
/*

    DialogInterface.OnClickListener cancle = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            textview.setText("시름");
        }
    };*/


    public void alertClick(View v) {
        builder.show();

    }


}
