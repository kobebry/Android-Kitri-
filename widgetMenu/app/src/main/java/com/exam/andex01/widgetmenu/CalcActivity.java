package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-07-20.
 */
public class CalcActivity extends Activity {
    EditText su1, su2;
    int temp1, temp2;
    Button calbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_activity);

        su1 = (EditText)findViewById(R.id.su1);
        su2 = (EditText)findViewById(R.id.su2);
        calbtn = (Button)findViewById(R.id.calbtn);
        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalcResult.class);
                temp1 = Integer.parseInt(su1.getText().toString());
                temp2 = Integer.parseInt(su2.getText().toString());
                intent.putExtra("su1", temp1);
                intent.putExtra("su2", temp2);
                startActivity(intent);
            }
        });
    }
}
