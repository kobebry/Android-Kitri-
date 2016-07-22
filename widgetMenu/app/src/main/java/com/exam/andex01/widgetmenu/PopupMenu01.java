package com.exam.andex01.widgetmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-19.
 */
public class PopupMenu01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu01);
    }

    public void popClick(View v){
        PopupMenu pop = new PopupMenu(getApplicationContext(), v);
        pop.getMenuInflater().inflate(R.menu.popup_menu01,pop.getMenu());
        pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.serch){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.add){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.edit){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.share){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.noting){
                    Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        pop.show();
    }
}
