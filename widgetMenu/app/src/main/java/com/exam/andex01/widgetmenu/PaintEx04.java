package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016-07-19.
 */
public class PaintEx04 extends Activity implements View.OnClickListener{
    int btnSel[] = {R.id.redbtn, R.id.bluebtn, R.id.orangebtn, R.id.eraser,R.id.thickbtn, R.id.thinbtn, R.id.resetbtn};
    Button btns[] = new Button[btnSel.length];
    int cols[] = {Color.RED, Color.BLUE, Color.rgb(255,187,0),Color.rgb(255,255,255)};
    PaintView paintview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_ex04);

        paintview = (PaintView)findViewById(R.id.paintview);

        for(int i=0; i<btnSel.length; i++){
            btns[i] = (Button)findViewById(btnSel[i]);
            btns[i].setOnClickListener(this);
        }
    }
    public void onClick(View v){
        for(int i=0; i<cols.length; i++){
            if(btnSel[i] == v.getId()){
                paintview.setColor(cols[i]);
            }
        }if(v.getId() == btnSel[4]){
            paintview.setThinck();
        }else if(v.getId()==btnSel[5]){
            paintview.setThin();
        }else if(v.getId()==btnSel[6]){
            paintview.setReset();
        }
    }
}
