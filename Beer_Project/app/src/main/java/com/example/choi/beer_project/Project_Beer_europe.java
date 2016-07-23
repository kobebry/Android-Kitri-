package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe extends Activity  implements View.OnClickListener{
    int btn[] = {R.id.guinness, R.id.bodding, R.id.wolfas,R.id.stella,R.id.kronenbourg, R.id.pilsner, R.id.heineken, R.id.hoegaarden,R.id.krombacher};
    ImageButton btns[] = new ImageButton[btn.length];
    Class classes[] = {Project_Beer_europe_Guinness.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe);

        for(int i=0; i<btn.length; i++){
            btns[i] = (ImageButton)findViewById(btn[i]);
            btns[i].setOnClickListener(this);
        }
    }
    public void onClick(View v){
        for(int i=0; i<btn.length; i++){
            if(v.getId() == btn[i]){
                Intent intent = new Intent(getApplication(), classes[i]);
                startActivity(intent);
            }
        }
    }
}
