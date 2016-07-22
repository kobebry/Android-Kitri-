package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016-07-19.
 */
public class ContextMenu01 extends Activity {
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu01);
        textview = (TextView)findViewById(R.id.textview);
        registerForContextMenu(textview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("컨텍스트 메뉴");
        menu.add(0,1,0,"배경색 : RED");
        menu.add(0,2,0,"배경색 : GREEN");
        menu.add(0,3,0,"배경색 : BLUE");
        menu.add(0,4,0,"배경색 : ORANGE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                textview.setBackgroundColor(Color.RED);
                break;
            case 2:
                textview.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                textview.setBackgroundColor(Color.BLUE);
                break;
            case 4:
                textview.setBackgroundColor(Color.rgb(204,102,0));
                break;
        }
        return true;
    }
}
