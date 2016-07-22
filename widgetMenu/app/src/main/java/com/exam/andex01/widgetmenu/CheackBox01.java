package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-14.
 */
public class CheackBox01 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheack_box01);
    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cheackbox_meat:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "고기 선택", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "고기 선택 해제", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cheackbox_cheese:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "치즈 선택", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "치즈 선택 해제", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
