package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-11.
 */
public class BaseBallGameV01 extends Activity implements View.OnClickListener {
    int edittexts[] = {R.id.guess1, R.id.guess2, R.id.guess3};
    EditText edittext[] = new EditText[edittexts.length];
    int btns[] = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero};
    Button btn[] = new Button[btns.length];
    Button reset, enter, del;
    int randoms[] = new int[3];
    int random, count;
    ImageButton back;
    TextView result;
    AlertDialog.Builder bulBilder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baeball_gamev01);

        bulBilder = new AlertDialog.Builder(this);

        bulBilder.setTitle("게임설명 : ");
        bulBilder.setIcon(R.drawable.linkedin);
        bulBilder.setMessage("1. 1~9사이의 숫자 3개 입력\n2. UserObj.getRandom()메소드 이용\n3. 위치 다르고, 같은 숫자 개수만큼 Ball\n4. 위치 같고, 같은 숫자 개수만큼 Strike\n5. 3 Strike인 경우 Game Over");


        bulBilder.setPositiveButton("확인", null);
        bulBilder.show();

        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.back) {
                    finish();
                }
            }
        });

        for (int a = 0; a < edittexts.length; a++) {
            edittext[a] = (EditText) findViewById(edittexts[a]);
            boolean flag = false;
            random = UserObj.getRandom(9);
            for (int j = 0; j < a; j++) {
                if (random == randoms[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                a--;
            } else {
                randoms[a] = random;
            }
            Log.v("랜덤값", String.valueOf(randoms[a]));

        }


        result = (TextView) findViewById(R.id.result);
        for (int i = 0; i < btns.length; i++) {
            btn[i] = (Button) findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }

        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);
        del = (Button) findViewById(R.id.del);
        del.setOnClickListener(this);


    }

    public void onClick(View v) {
        int strike = 0, ball = 0;
        for (int i = 0; i < btns.length; i++) {
            if (v.getId() == btns[i]) {
                for (int a = 0; a < edittexts.length; a++) {
                    if (edittext[a].isFocused()) {
                        edittext[a].setFocusable(true);
                        edittext[a].setText(btn[i].getText().toString());
                    }
                }
            }
        }

        //볼체크
        if (v.getId() == R.id.enter) {
            for (int i = 0; i < randoms.length; i++) {
                for (int a = 0; a < edittexts.length; a++) {
                    if (randoms[i] == Integer.parseInt(edittext[a].getText().toString())) {
                        if (i == a) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }

            }
            count++;
            if (strike == 3) {
                result.setText(count + "번째 정답!!" + strike + "스트라이크");

            } else {
                result.setText(strike + "스트라이크" + ball + "볼");
            }

            //리셋버튼
        } else if (v.getId() == R.id.reset)

        {
            for (int i = 0; i < edittext.length; i++) {
                edittext[i].setText("");
                result.setText("");
                count = 0;
                randoms[i] = UserObj.getRandom(9);
                Log.v("랜덤값", String.valueOf(randoms[i]));

            }
            //숫자 삭제
        } else if (v.getId() == R.id.del)

        {        Button b = (Button) findViewById(v.getId());

            for (int i = 0; i < edittext.length; i++) {
                if (edittext[i].isFocused()) {
                    if (edittext[i].length() > 0) {
                        edittext[i].setText(edittext[i].getText().subSequence(0, edittext[i].getText().length() - 1));
                    }
                }
            }
        }
    }
}