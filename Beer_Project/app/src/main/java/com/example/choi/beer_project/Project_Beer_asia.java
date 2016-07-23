package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_asia extends Activity implements View.OnClickListener{
    int btn[] = {R.id.asahi, R.id.kirin, R.id.kloud,R.id.sanmiguel,R.id.sapporo, R.id.thintao, R.id.tiger, R.id.victoria};
    ImageButton btns[] = new ImageButton[btn.length];
    Class classes[] = {Project_Beer_europe_Guinness.class};
    int textview[] = {R.id.textasahi, R.id.textkirin, R.id.textkloud, R.id.textsanmiguel, R.id.textsapporo, R.id.textthintao,R.id.texttiger,R.id.textvictoria};
    TextView textviews[] = new TextView[textview.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_asia);

        for(int i=0; i<btn.length; i++){
            btns[i] = (ImageButton)findViewById(btn[i]);
            textviews[i] = (TextView)findViewById(textview[i]);
            btns[i].setOnClickListener(this);
        }
    }
    public void onClick(View v){
        for(int i=0; i<btn.length; i++){
            if(v.getId() == btn[i]){
                Intent intent = new Intent(getApplication(), classes[i]);
                String gotiitle = textviews[i].getText().toString();
                intent.putExtra("gotitle", gotiitle);
                startActivity(intent);
            }
        }
    }
}
