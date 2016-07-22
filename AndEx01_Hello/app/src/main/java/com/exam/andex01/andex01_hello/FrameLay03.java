package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016-07-12.
 */
public class FrameLay03 extends Activity implements View.OnClickListener {

    int viewid[] = {R.id.imgbg, R.id.imgsw, R.id.imgaa, R.id.imgbb, R.id.imgcc};
    int btns[] = {R.id.btnbg, R.id.btnsw, R.id.btnaa, R.id.btnbb, R.id.btncc};
    ImageButton btn[] = new ImageButton[btns.length];
    ImageView imageView[] = new ImageView[viewid.length];
    int view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_lay03);

        for (int i = 0; i < btn.length; i++) {
            btn[i] = (ImageButton) findViewById(btns[i]);
            imageView[i] = (ImageView) findViewById(viewid[i]);
            imageView[i].setVisibility(ImageView.INVISIBLE);
            btn[i].setOnClickListener(this);

        }
    }

    public void onClick(View v) {
        for (int i = 0; i < btn.length; i++) {
            if (v.getId() == btns[i]) {
                imageView[i].setVisibility(ImageView.VISIBLE);
                if (i != view) {
                    imageView[view].setVisibility(ImageView.INVISIBLE);
                }
                view = i;
            }
        }
    }
}


