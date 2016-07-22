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
public class PaintEx02 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintEx02V makeLayout = new PaintEx02V(this);
        setContentView(makeLayout);
    }

    class PaintEx02V extends View {

        public PaintEx02V(Context context) {
            super(context);

        }


        protected void onDraw(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            canvas.drawRect(300, 500, 800, 800, paint);

            paint.setColor(Color.rgb(255, 225, 168));
            canvas.drawCircle(550, 350, 150, paint);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);
            canvas.drawLine(550, 330, 550, 380, paint);
            canvas.drawLine(450, 330, 500, 330, paint);
            canvas.drawLine(600, 330, 650, 330, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(10f);
            canvas.drawLine(500, 430, 600, 430, paint);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);
            canvas.drawRect(100,500,300,600,paint);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);
            canvas.drawRect(800,500,1000,600,paint);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);
            canvas.drawRect(400,800,500,1500,paint);

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(10f);
            canvas.drawRect(600,800,700,1500,paint);

            paint.setColor(Color.CYAN);
            paint.setStrokeWidth(10f);
            canvas.drawCircle(60, 550, 40,paint);

            paint.setColor(Color.CYAN);
            paint.setStrokeWidth(10f);
            canvas.drawCircle(1040, 550, 40,paint);

            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(10f);
            canvas.drawRect(300, 1500, 500,1600,paint);

            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(10f);
            canvas.drawRect(600, 1500, 800,1600,paint);
        }
    }

}
