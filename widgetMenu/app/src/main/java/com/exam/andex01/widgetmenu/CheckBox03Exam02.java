package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-15.
 */
public class CheckBox03Exam02 extends Activity implements View.OnClickListener {

    int btns[][] = {{R.id.onegood, R.id.onenotbad, R.id.onebad},
            {R.id.twogood, R.id.twonotbad, R.id.twobad},
            {R.id.threegood, R.id.threenotbad, R.id.threebad},
            {R.id.fourgood, R.id.fournotbad, R.id.fourbad},
            {R.id.fivegood, R.id.fivenotbad, R.id.fivebad}};
    CheckBox chks[][] = new CheckBox[btns.length][btns[0].length];
    TextView score;
    int su;
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_box_exam02);

        score = (TextView) findViewById(R.id.score);
        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                chks[i][a] = (CheckBox) findViewById(btns[i][a]);
                chks[i][a].setOnClickListener(this);
            }
        }
    }

    public void onClick(View v) {
        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                if (v.getId() == btns[i][a]) {
                    for (int j = 0; j < 3; j++) {
                        if (v.getId() == btns[i][j]) {

                        } else {
                            chks[i][j].setChecked(false);
                        }
                    }
                }
            }
        }
    }

    public void score(View v) {

        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                if (chks[i][a].isChecked()) {
                    if (a == 0) {
                        su = 2;
                    } else if (a == 1) {
                        su = 1;
                    } else if (a == 2) {
                        su = 0;
                    }
                    sum += su;
                }
            }

        }
        score.setText("점수는 : " + String.valueOf(sum));
        sum = 0;
    }
}
