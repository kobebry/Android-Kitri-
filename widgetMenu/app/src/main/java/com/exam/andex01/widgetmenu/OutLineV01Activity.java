package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016-07-07.
 */
public class OutLineV01Activity extends Activity implements View.OnClickListener{
    int btns[] = {R.id.btngugudan, R.id.btntaro, R.id.btnimage, R.id.btncal, R.id.btngawibawi,R.id.weightchk,R.id.score,R.id.lotto,R.id.paint,R.id.guess,R.id.baseball,R.id.number};
    Button btn[] = new Button[btns.length];
    Class classes[] = {GuGuDan01.class, TarotV01.class, ImageViewEx02.class, Calculator01.class, GaWiBaWiBoV01.class,
            Weight_chk01.class, Inflater03SungjukGraphic.class, Lotto_version1.class, PaintEx04.class,GuessGameV01.class,BaseBallGameV01.class,NumberGameV01.class};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outlinev01);

        for(int i=0; i < btns.length; i++){
            btn[i] = (Button)findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }

    }
    public void onClick(View v){
        for(int i=0; i < btns.length; i++){
            if(v.getId() == btns[i]){
                Intent intent = new Intent(getApplicationContext(), classes[i]);
                startActivity(intent);
            }
        }
    }
}
