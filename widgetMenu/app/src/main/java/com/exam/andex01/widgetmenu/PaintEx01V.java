package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2016-07-18.
 */
public class PaintEx01V extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintEx02V makeLayout = new PaintEx02V(this);
        setContentView(makeLayout);
    }

    class PaintEx02V extends View {
        int x = 100, y = 100;

        public PaintEx02V(Context context) {
            super(context);
        }
        protected void onDraw(Canvas canvas){
            Paint paint = new Paint();
            paint.setColor(Color.BLUE);
            paint.setTextSize(100f);
            canvas.drawRect(x-100, y-100, x+100, y+100,paint);
            canvas.drawText("Nice",x-100,y+200,paint);

        }

        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    x = (int) event.getX();
                    y = (int) event.getY();
                    invalidate();

            }
            return true;
        }
    }
}


