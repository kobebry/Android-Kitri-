package com.exam.andex01.anddb01;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016-07-13.
 */
public class MemBottom extends LinearLayout{
    Context context;
    public MemBottom(Context context){
        super(context);
        execute(context);
    }
    private void execute(Context context){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mem_bottom,this,true);
    }
}
