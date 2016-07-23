package com.example.choi.beer_project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe_Guinness extends Activity  implements View.OnClickListener{
    int img[] = {R.id.img01, R.id.img02, R.id.img03,R.id.img04};
    ImageView imgs[] = new ImageView[img.length];
    ViewFlipper flipper;
    ImageButton next, prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe_guinness);

        flipper= (ViewFlipper)findViewById(R.id.flipper);

        next =(ImageButton)findViewById(R.id.next);
        next.setOnClickListener(this);
        prev =(ImageButton)findViewById(R.id.prev);
        prev.setOnClickListener(this);
        for(int i=0; i<img.length; i++){
            imgs[i] = (ImageView)findViewById(img[i]);
        }
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
