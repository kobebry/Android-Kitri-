package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe_kronenbourg extends Activity  implements View.OnClickListener{

    ViewFlipper flipper;
    ImageButton next, prev;
    String gettitle;
    TextView toptitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe_kronenbourg);


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

    }
}
