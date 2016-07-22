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
public class AlertDialog05 extends Activity {
    AlertDialog.Builder builder;
    TextView textview;
    String msg[]={"도르트문트", "바르셀로나", "아스널", "리버풀", "에버튼"};
    int chk;
    final boolean chk2[] = new boolean[msg.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog01);
        textview = (TextView) findViewById(R.id.textview);
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.linkedin);
        builder.setTitle("좋아하는 클럽 : ");
        builder.setPositiveButton("확인", postive);


        builder.setMultiChoiceItems(msg, chk2, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "chk = " + chk2[index] + "내가좋아하는 클럽 : " + msg[index], Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), chk2[0] + "확인!!", Toast.LENGTH_SHORT).show();


            }
        });
    }





        DialogInterface.OnClickListener postive = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int index) {
                /*if (chk == 0) {
                    textview.setText(msg[0] + "입니다.");
                } else if (chk == 1) {
                    textview.setText(msg[1] + "입니다.");

                }*/
                String tmp="좋아하는 클럽 : ";
                for(int i=0;i<chk2.length;i++){
                  if(chk2[i]){
                      tmp += msg[i]+" ";
                  }
                }
                textview.setText(tmp + "입니다.");
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
