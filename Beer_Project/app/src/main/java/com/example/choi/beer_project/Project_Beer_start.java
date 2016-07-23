package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_start extends Activity implements View.OnClickListener{
    int btn[] ={R.id.asiabtn, R.id.europebtn, R.id.americabtn};
    Class classes[] = {Project_Beer_asia.class, Project_Beer_europe.class, Project_Beer_america.class};
    ImageButton btns[] = new ImageButton [btn.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_start);

        for(int i=0; i<btn.length; i++){
            btns[i] =(ImageButton)findViewById(btn[i]);
            btns[i].setOnClickListener(this);
        }
    }
    public void onClick(View v){
        for(int i=0; i<btns.length; i++){
            if(v.getId() == btn[i]){
                Intent intent = new Intent(getApplicationContext(),classes[i]);
                startActivity(intent);
            }
        }
    }
}
