package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016-07-18.
 */
public class PaintEx03 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintEx03V makeLayout = new PaintEx03V(this);
        setContentView(makeLayout);
    }

    class PaintEx03V extends View {
        int a = 400;
        int su = 100;
        int x = 100;

        public PaintEx03V(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(5f);
            canvas.drawLine(200, 300, 200, 1400, paint);

            paint.setStrokeWidth(5f);
            canvas.drawLine(200, 1400, 1000, 1400, paint);

            paint.setTextSize(40f);
            canvas.drawText("국어" ,300 ,1450,paint);
            canvas.drawText("영어" ,580 ,1450,paint);
            canvas.drawText("수학" ,870 ,1450,paint);



            for(int i=0; i<=9; i++){
                paint.setStrokeWidth(3f);
                canvas.drawLine(200, a, 1000, a, paint);

                paint.setTextSize(30f);
                canvas.drawText(String.valueOf(su) ,x,a,paint);
                su = su-10;
                a = a+100;
            }


            for(int a=0; a<3; a++){

            }
            canvas.drawLine(350, 1400, 350,300,paint);
            canvas.drawLine(630, 1400, 630,300,paint);
            canvas.drawLine(900, 1400, 900,300,paint);


            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(6f);
            canvas.drawLine(350, 500, 630,600,paint);
            canvas.drawLine(630, 600, 900,400,paint);

            paint.setColor(Color.RED);
            canvas.drawCircle(350, 500, 30,paint);
            canvas.drawCircle(630, 600, 30,paint);
            canvas.drawCircle(900, 400, 30,paint);

        }

    }

}
