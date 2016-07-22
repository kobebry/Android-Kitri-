package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-08.
 */
public class TarotV01 extends Activity implements View.OnClickListener{
    TextView tarotext;
    ImageButton taro;
    int imgbtns[] = {R.drawable.taro2, R.drawable.taro3, R.drawable.taro4, R.drawable.taro5, R.drawable.taro6, R.drawable.taro7, R.drawable.taro8, R.drawable.taro9, R.drawable.taro10};
    String textbtns[] ={"컵의 기사 : 감성과 감정의 도전","컵의 소년 : 창의적 예술적 상상력", "TEN OF CUPS : 행복하고 사랑이 넘치는 가족", "NINE OF CUPS : 성공의 만족과 소망", "EUGHT OF CUPS : 과거의 성공을 버리고 새로운 시작",
                        "SEVEN OF CUPS : 환상속의 욕망과 성공","SIX OF CUPS : 과거의 어린시절 추억", "FIVE OF CUPS : 감정의 부분적인 상실","FOUR OF CUPS : 피로와 권태"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarov01);

        tarotext = (TextView)findViewById(R.id.tarotext);
        taro = (ImageButton)findViewById(R.id.taro);
        taro.setOnClickListener(this);
        ImageButton imgback = (ImageButton)findViewById(R.id.imgback);
        imgback.setOnClickListener(this);

    }

    public void onClick(View v){
        int ran = UserObj.getRandom(9)-1;
        taro.setImageResource(imgbtns[ran]);
        tarotext.setText(textbtns[ran]);

        if(v.getId() == R.id.imgback){
            finish();
        }
    }
}
