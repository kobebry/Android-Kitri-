package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-08.
 */
public class GaWiBaWiBoV01 extends Activity implements View.OnClickListener {
    ImageView com;
    ImageView user;
    int img[] = {R.drawable.rock, R.drawable.scissors, R.drawable.paper};
    int btns[] = {R.id.rock, R.id.scissor, R.id.papper};
    ImageButton btn[] = new ImageButton[btns.length];

    TextView compoint, userpoint, score;
    int comscore, userscore;
    Button result,stop;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gawibawibov01);
        com = (ImageView) findViewById(R.id.com);
        user = (ImageView) findViewById(R.id.user);

        compoint = (TextView) findViewById(R.id.compoint);
        userpoint = (TextView) findViewById(R.id.userpoint);
        score = (TextView) findViewById(R.id.score);

        for (int i = 0; i < btns.length; i++) {
            btn[i] = (ImageButton) findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }
        ImageButton backbtn = (ImageButton)findViewById(R.id.imgback);
        backbtn.setOnClickListener(this);
        result = (Button) findViewById(R.id.result);
        result.setOnClickListener(this);
        stop = (Button) findViewById(R.id.stop);
        stop.setOnClickListener(this);

    }

    public void onClick(View v) {
        caldo(v);
        result(v);

        //그만하기
        if (v.getId() == R.id.stop) {
            comscore = 0;
            userscore = 0;
            compoint.setText("");
            userpoint.setText("");
            score.setText("");
        }

    }
    //결과보기
    public void result(View v){
        if (v.getId() == R.id.result) {
            int coma = Integer.parseInt(compoint.getText().toString());
            int usera = Integer.parseInt(userpoint.getText().toString());
            System.out.println("컴퓨터 값: "+coma);
            System.out.println("유저 값: "+usera);
            if(Integer.parseInt(compoint.getText().toString()) > Integer.parseInt(userpoint.getText().toString())) {
                score.setText("컴퓨터가 이김");
            }else if(Integer.parseInt(compoint.getText().toString()) < Integer.parseInt(userpoint.getText().toString())){
                score.setText("사용자가 이김");
            }else{
                score.setText("비김");
            }
        }
    }
    //비교하기
    public void caldo(View v){
        for (int i = 0; i < btns.length; i++) {
            if (v.getId() == btns[i]) {
                int ran = UserObj.getRandom(3) - 1;
                com.setImageResource(img[ran]);
                user.setImageResource(img[i]);
                System.out.println(i);
                if (i == 0) {
                    if (ran == 1) {
                        userscore++;
                        userpoint.setText(String.valueOf(userscore));
                    } else if (ran == 2) {
                        comscore++;
                        compoint.setText(String.valueOf(comscore));
                    }
                } else if (i == 1) {
                    if (ran == 0) {
                        comscore++;
                        compoint.setText(String.valueOf(comscore));
                    } else if (ran == 2) {
                        userscore++;
                        userpoint.setText(String.valueOf(userscore));
                    }
                } else if (i == 2) {
                    if (ran == 1) {
                        comscore++;
                        compoint.setText(String.valueOf(comscore));
                    } else if (ran == 0) {
                        userscore++;
                        userpoint.setText(String.valueOf(userscore));
                    }
                }

/*                if(i==3 && ran==1 || i==2 && ran==3 || i==1&& ran==2){
                    userscore++;
                    userpoint.setText(String.valueOf(userscore));
                    score.setText("사용자가 이김");
                }else if(i==3 && ran==2 || i==2 && ran==1 || i==1 && ran==3){
                    comscore++;
                    compoint.setText(String.valueOf(comscore));
                    score.setText("컴퓨가 이김");
                }else{
                    score.setText("비김");
                }*/
            }else if(v.getId() == R.id.imgback) {
                finish();
            }
        }
    }
}
