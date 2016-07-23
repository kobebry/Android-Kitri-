package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe extends Activity  implements View.OnClickListener{
    int btn[] = {R.id.guinness, R.id.bodding, R.id.wolfas,R.id.stella,R.id.kronenbourg, R.id.pilsner, R.id.heineken, R.id.hoegaarden,R.id.krombacher};
    ImageButton btns[] = new ImageButton[btn.length];
    Class classes[] = {Project_Beer_europe_Guinness.class,Project_Beer_europe_Bodding.class,Project_Beer_europe_Wolfas.class,Project_Beer_europe_Stella.class,Project_Beer_europe_kronenbourg.class,Project_Beer_europe_Pilsner.class,Project_Beer_europe_Heineken.class,Project_Beer_europe_Hoagarden.class,Project_Beer_europe_Krombacher.class};
    int textview[] = {R.id.textguinness, R.id.textboddingtons, R.id.textvolfas, R.id.textstella, R.id.textkronenbourg, R.id.textpilsner,R.id.textheineken,R.id.texthoegaarden,R.id.textkrombacher};
    TextView textviews[] = new TextView[textview.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe);

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
