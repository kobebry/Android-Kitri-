package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe_Krombacher extends Activity  implements View.OnClickListener{
    int btns[][] = {{R.id.onegood, R.id.onenotbad, R.id.onebad},
            {R.id.twogood, R.id.twonotbad, R.id.twobad},
            {R.id.threegood, R.id.threenotbad, R.id.threebad},
            {R.id.fourgood, R.id.fournotbad, R.id.fourbad},
            {R.id.fivegood, R.id.fivenotbad, R.id.fivebad}};
    CheckBox chks[][] = new CheckBox[btns.length][btns[0].length];


    ViewFlipper flipper;
    ImageButton next, prev;
    String gettitle;
    TextView toptitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe_krombacher);

        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                chks[i][a] = (CheckBox) findViewById(btns[i][a]);
                chks[i][a].setOnClickListener(this);
            }
        }

        next =(ImageButton)findViewById(R.id.next);
        next.setOnClickListener(this);
        prev =(ImageButton)findViewById(R.id.prev);
        prev.setOnClickListener(this);

        //타이틀 설정
        toptitle = (TextView)findViewById(R.id.toptitle);
        Intent intent = getIntent();
        gettitle = intent.getStringExtra("gotitle");
        toptitle.setText(gettitle);

        //사진 넘기는 기능 설정
        flipper= (ViewFlipper)findViewById(R.id.flipper);
        Animation showIn= AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }
    public void onClick(View v){
        if(v.getId() == R.id.next){
            flipper.showNext();//다음 View로 교체
        }else if(v.getId() == R.id.prev){
            flipper.showPrevious();
        }

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
}
