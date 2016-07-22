package com.exam.andex01.widgetmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Administrator on 2016-07-19.
 */
public class OptionMenu02 extends AppCompatActivity {
    int menus[] = {R.id.gugudan, R.id.cal,R.id.imgchn, R.id.taro, R.id.lotto };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu02);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu02,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        for(int i=0; i<menus.length; i++){
            if(item.getItemId() == menus[i]){
                if(i == 0){
                    Intent intent = new Intent(getApplicationContext(),GuGuDan01.class);
                    startActivity(intent);
                }else if(i ==1){
                    Intent intent = new Intent(getApplicationContext(),Calculator01.class);
                    startActivity(intent);
                }else if(i ==2){
                    Intent intent = new Intent(getApplicationContext(),ImageViewEx02.class);
                    startActivity(intent);
                }else if(i ==3){
                    Intent intent = new Intent(getApplicationContext(),TarotV01.class);
                    startActivity(intent);
                }else if(i ==4){
                    Intent intent = new Intent(getApplicationContext(),Lotto_version1.class);
                    startActivity(intent);
                }
            }
        }

        return true;

    }
}