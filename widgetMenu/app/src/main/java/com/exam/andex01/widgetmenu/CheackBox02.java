package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-14.
 */
public class CheackBox02 extends Activity {
    int boxs[] = {R.id.check01sun, R.id.check02rose, R.id.check03lily, R.id.check04wild, R.id.check05cana, R.id.check06free};
    CheckBox box[] = new CheckBox[boxs.length];
    TextView resultview;
    CheckBox allcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_box02);
        resultview = (TextView) findViewById(R.id.resultview);
        allcheck =(CheckBox)findViewById(R.id.allcheck);
        for (int i = 0; i < boxs.length; i++) {
            box[i] = (CheckBox) findViewById(boxs[i]);
        }

    }

    //전부 체크 메소드
    public void allclicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        if (checked) {
            for (int i = 0; i < boxs.length; i++) {
                box[i].setChecked(true);
            }

        } else {
            for (int i = 0; i < boxs.length; i++) {
                box[i].setChecked(false);
            }
        }

    }

    public void resultflower(View v) {
        String msg="";
        for (int i = 0; i < boxs.length; i++) {
            if (box[i].isChecked()) {
                msg += box[i].getText().toString() + "\n";
            }
        }
        resultview.setText(msg);

    }

    public void delflower(View v){
        for(int i=0; i<boxs.length; i++){
            box[i].setChecked(false);
            resultview.setText("");
        }
        allcheck.setChecked(false);
    }


    public void checkedclicked(View v) {
        boolean checked = ((CheckBox) v).isChecked();
        for (int i = 0; i < box.length; i++) {
            if (v.getId() == boxs[i]) {
                if (checked) {
                }
            }
        }
    }
}
