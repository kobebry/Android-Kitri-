package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-18.
 */
public class Inflater03SungjukGraphic extends Activity {
    int sugID[] = {R.id.koreanscore, R.id.englishscore, R.id.mathscore};
    EditText sungEdt[] = new EditText[sugID.length];
    Button sungButton;
    int a ;
    int su ;
    int x ;
    int q;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inflate03_sungjukgraphic);


        for (int i = 0; i < sugID.length; i++) {
            sungEdt[i] = (EditText) findViewById(sugID[i]);
        }
        sungButton = (Button) findViewById(R.id.sungButton);
        back = (ImageButton)findViewById(R.id.back);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);

        SungJukGraphV view = new SungJukGraphV(this);

        container.addView(view);
    }

    class SungJukGraphV extends View implements View.OnClickListener {
        int kor;
        int eng;
        int math;
        Inflater03SungjukGraphic context;

        public SungJukGraphV(Context context) {
            super(context);
            this.context = (Inflater03SungjukGraphic) context;
            this.context.sungButton.setOnClickListener(this);
            this.context.back.setOnClickListener(this);


        }

        public void onClick(View v) {
            if(v.getId() == R.id.back){
                finish();
            }else{
                kor = Integer.parseInt(context.sungEdt[0].getText().toString());
                eng = Integer.parseInt(context.sungEdt[1].getText().toString());
                math = Integer.parseInt(context.sungEdt[2].getText().toString());

                invalidate();
            }

        }

        protected void onDraw(Canvas canvas) {
            a = 100;
            su = 100;
            q = 250;
            Paint paint = new Paint();
            Paint textpaint = new Paint();

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5f);
            canvas.drawLine(100, 50, 100, 1000, paint);

            paint.setStrokeWidth(5f);
            canvas.drawLine(100, 1000, 1000, 1000, paint);

            textpaint.setTextAlign(Paint.Align.CENTER);
            textpaint.setTextSize(40f);
            canvas.drawText("국어" ,q ,1050,textpaint);
            canvas.drawText("영어" ,q*2 ,1050,textpaint);
            canvas.drawText("수학" ,q*3 ,1050,textpaint);


            for(int i=0; i<=9; i++){
                        paint.setStrokeWidth(3f);
                canvas.drawLine(100, a, 1000, a, paint);
                paint.setTextSize(30f);
                canvas.drawText(String.valueOf(su) ,x,a,paint);
                su = su-10;
                a = a+100;
            }


            paint.setColor(Color.RED);
            paint.setTextSize(100f);
            canvas.drawRect(q-10,1000-kor*10,q+20,1000, paint);
            canvas.drawRect(q*2-10,1000-eng*10,q*2+20,1000, paint);
            canvas.drawRect(q*3-10,1000-math*10,q*3+20,1000, paint);

        }

    }

}

