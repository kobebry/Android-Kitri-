package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-20.
 */
public class AlertDialog03 extends Activity {
    AlertDialog.Builder builder;
    TextView textview;
    String msg[]={"Red", "Orange","Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_dialog01);
        textview =(TextView)findViewById(R.id.textview);
        builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.linkedin);
        builder.setTitle("Color : ");

        builder.setItems(msg,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                Toast.makeText(getApplicationContext(),msg[index] + "컬러", Toast.LENGTH_SHORT).show();
                if(index==0){
                    textview.setBackgroundColor(Color.RED);
                }else if(index==1){
                    textview.setBackgroundColor(Color.rgb(255,153,51));
                }else if(index==2){
                    textview.setBackgroundColor(Color.YELLOW);
                }

            }
        });

/*        builder.setPositiveButton("확인", postive);
        builder.setNegativeButton("취소", cancle);*/
    }

  /*  DialogInterface.OnClickListener postive = new DialogInterface.OnClickListener(){
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
*/

    public void alertClick(View v) {
        builder.show();

    }


}
