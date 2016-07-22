package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-20.
 */
public class SawonCertify extends Activity implements View.OnClickListener {
    TextView topview, backview;
    String getid;

    int btn[] = {R.id.customer, R.id.product, R.id.revenue};
    Button btns[] = new Button[btn.length];
    Class location[] = {SawonCustomerActivity.class,SawonProductActivity.class, SawonRevenueActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sawon_certify);

        topview = (TextView) findViewById(R.id.topview);
        backview = (TextView)findViewById(R.id.backview);

        Intent intent = getIntent();
        getid = intent.getStringExtra("goid");
        topview.setText(getid + "님 환영합니다.");

        for (int i = 0; i < btn.length; i++) {
            btns[i] = (Button) findViewById(btn[i]);
            btns[i].setOnClickListener(this);
        }

    }

    public void onClick(View v) {
        for (int i = 0; i < btn.length; i++) {
            if(v.getId() == btn[i]){
                Intent intent = new Intent(getApplicationContext(), location[i]);
                startActivityForResult(intent, 100);
            }
        }
    }

    //finsh에서 넘어온 값을 받아온다.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        backview.setText("선택된 화면 : " + data.getStringExtra("textcode"));

    }
}