package com.exam.andex01.anddb01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-13.
 */
public class MemTop extends Activity implements View.OnClickListener{

    LinearLayout top, main, bottom;
/*
    Class classes[] = {MemHom.class, MemLog.class, MemIns.class, MemUpd.class, MemDel.class};
*/
    int btn[] = {R.id.btnhome,R.id.btnlog,R.id.btnins,R.id.btnupdate,R.id.btndel,R.id.btnlist};
    Button btns[] = new Button[btn.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mem_top);

        top = (LinearLayout)findViewById(R.id.top);
        main = (LinearLayout)findViewById(R.id.main);
        bottom = (LinearLayout)findViewById(R.id.bottom);

        bottom.addView(new MemBottom(this));
        main.addView(new MemHom(this));

        for(int i=0; i<btn.length; i++){
            btns[i] = (Button)findViewById(btn[i]);
            btns[i].setOnClickListener(this);
        }

    }

    public void onClick(View v){
       if(v.getId()==R.id.btnhome){
           main.removeAllViews();
           main.addView(new MemHom(this));
       }else if(v.getId()==R.id.btnlog){
           main.removeAllViews();
           main.addView(new MemLog(this));
       }else if(v.getId()==R.id.btnins){
           main.removeAllViews();
           main.addView(new MemIns(this));
       }else if(v.getId()==R.id.btnlog){
           main.removeAllViews();
           main.addView(new MemLog(this));
       }else if(v.getId()==R.id.btnupdate){
           main.removeAllViews();
           main.addView(new MemUpd(this));
       }else if(v.getId()==R.id.btndel){
           main.removeAllViews();
           main.addView(new MemDel(this));
       }else if(v.getId()==R.id.btnlist){
           main.removeAllViews();
           main.addView(new MemSel(this));
       }
    }
}
