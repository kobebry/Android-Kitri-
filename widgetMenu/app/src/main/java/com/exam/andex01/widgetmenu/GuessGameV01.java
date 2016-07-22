package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-11.
 */
public class GuessGameV01 extends Activity implements View.OnClickListener {
    EditText guess;
    int btns[] = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero};
    Button btn[] = new Button[btns.length];
    Button reset, enter, del;
    int random, count = 0;
    ImageButton back;
    int guess01;
    TextView result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guess_gamev01);


        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.back) {
                    finish();
                }
            }
        });

        guess = (EditText) findViewById(R.id.guess);
        result = (TextView) findViewById(R.id.result);
        for (int i = 0; i < btns.length; i++) {
            btn[i] = (Button) findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }

        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        del = (Button)findViewById(R.id.del);
        del.setOnClickListener(this);

        random = UserObj.getRandom(30);
        Toast.makeText(getApplicationContext(), String.valueOf(random), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v) {
        Button b = (Button) findViewById(v.getId());
        for (int i = 0; i < btn.length; i++) {
            if (v.getId() == btns[i]) {
                guess.setText(guess.getText().toString() + b.getText().toString());
            }

        }
        //리셋버튼
        if (v.getId() == R.id.reset) {
            guess.setText("");
            result.setText("");
            random = UserObj.getRandom(30);
            Toast.makeText(getApplicationContext(), String.valueOf(random), Toast.LENGTH_SHORT).show();

        } else if (v.getId() == R.id.enter) {
            count++;
            guess01 = Integer.parseInt(guess.getText().toString());
            if (random == guess01) {
                if (count < 3) {
                    result.setText("빙고!!" + count + " 번째 성공" + "\n 천재이십니다.");

                } else if (3 < count && count < 5) {
                    result.setText("빙고!!" + count + " 번째 성공" + "\n 양호하십니다.");

                } else if (5 < count && count < 10) {
                    result.setText("빙고!!" + count + " 번째 성공" + "\n 분발하세요.");

                } else if (10 < count && count < 20) {
                    result.setText("빙고!!" + count + " 번째 성공" + "\n 과락입니다..");

                }
            } else if (guess01 < random) {
                result.setText("틀렸습니다."+guess01+"보다 큰 숫자를 입력하세요");

            } else if (random < guess01) {
                result.setText("틀렸습니다."+guess01+ "보다 작은 숫자를 입력하세요");
            }

            if (count == 20) {
                result.setText("그만!!!! 똥멍청이");

            }

        } else if(v.getId()==R.id.del){
            if(guess.getText().length() >0){
                guess.setText(guess.getText().subSequence(0,guess.getText().length()-1));
            }
        }
    }
}
