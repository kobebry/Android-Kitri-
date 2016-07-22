package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-07-07.
 */
public class ImageViewEx02 extends Activity implements View.OnClickListener {
    int btns[] = {R.id.dy, R.id.aa, R.id.bb, R.id.cc};
    int img[] = {R.drawable.dy, R.drawable.aa,R.drawable.bb, R.drawable.cc};
    ImageButton btn[] = new ImageButton[btns.length];
    ImageView view;
    ImageButton backbtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_ex02);
        view = (ImageView)findViewById(R.id.view);
        view.setOnClickListener(this);

        for(int i=0; i<btns.length; i++){
            btn[i] = (ImageButton)findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }
        ImageButton backbtn = (ImageButton)findViewById(R.id.imgback);
        backbtn.setOnClickListener(this);
    }
    public void onClick(View v){
/*        if(v.getId() == R.id.dy){
            view.setImageResource(R.drawable.dy);
        }else if(v.getId() ==R.id.aa){
            view.setImageResource(R.drawable.aa);
        }else if(v.getId() ==R.id.bb){
            view.setImageResource(R.drawable.bb);
        }else if(v.getId() ==R.id.cc){
            view.setImageResource(R.drawable.cc);
        }*/

        for(int i=0; i<btns.length; i++){
            if(v.getId() == btns[i]){
                view.setImageResource(img[i]);
            }else if(v.getId() == R.id.imgback){
                finish();
            }
        }
    }
}
