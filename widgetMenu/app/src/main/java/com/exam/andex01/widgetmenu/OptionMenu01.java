package com.exam.andex01.widgetmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-19.
 */
public class OptionMenu01 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu01);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu01,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.apple){
            Toast.makeText(getApplicationContext(),"사과사과",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.grape){
            Toast.makeText(getApplicationContext(),"포도포도",Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.banana){
            Toast.makeText(getApplicationContext(),"바나나",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
