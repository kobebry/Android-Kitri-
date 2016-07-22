package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-14.
 */
public class RadioBtn02 extends Activity {


    int imgs[] = {R.drawable.vader1, R.drawable.vader2, R.drawable.vader3, R.drawable.vader4, R.drawable.vader5, R.drawable.vader6};
    int radiobtn[] = {R.id.radio_01, R.id.radio_02,R.id.radio_03,R.id.radio_04,R.id.radio_05,R.id.radio_06};
    RadioButton btns[] = new RadioButton[radiobtn.length];
    ImageView imgview;
    TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_btn02);
        txtview = (TextView)findViewById(R.id.txtview);
        imgview = (ImageView)findViewById(R.id.imgview);
        for(int i=0; i<btns.length; i++){
            btns[i] = (RadioButton)findViewById(radiobtn[i]);
        }
    }
    public void selectradio(View v){

        for(int i=0; i<btns.length; i++){
            if(btns[i].isChecked()){
                imgview.setImageResource(imgs[i]);
                txtview.setText(i+1 + "번째" + " 아바타 저장됨");
            }
        }

    }
}
