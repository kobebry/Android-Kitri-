package com.exam.andex01.andex01_hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-07.
 */
public class OutLineV01Activity extends Activity implements View.OnClickListener{
    int btns[] = {R.id.btngugudan, R.id.btntaro, R.id.btnimage, R.id.btncal, R.id.btngawibawi};
    Button btn[] = new Button[btns.length];



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outlinev01);

        for(int i=0; i < btns.length; i++){
            btn[i] = (Button)findViewById(btns[i]);
            btn[i].setOnClickListener(this);
        }

    }
    public void onClick(View v){
        for(int i=0; i < btns.length; i++){
            if(v.getId() == btns[i]){
                if(btns[i] == R.id.btngugudan){
                    Toast.makeText(getApplicationContext(), "구구단 이벤트", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),GuGuDan01.class);
                    startActivity(intent);
                }else if(btns[i] == R.id.btntaro){
                    Toast.makeText(getApplicationContext(), "타로 이벤트", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),TarotV01.class);
                    startActivity(intent);
                }else if(btns[i] == R.id.btngawibawi){
                    Toast.makeText(getApplicationContext(), "가위바위보 이벤트", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),GaWiBaWiBoV01.class);
                    startActivity(intent);
                }else if(btns[i] == R.id.btncal){
                    Toast.makeText(getApplicationContext(), "계산기 이벤트", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Calculator01.class);
                    startActivity(intent);
                }else if(btns[i] == R.id.btnimage){
                    Toast.makeText(getApplicationContext(), "이미지 이벤트", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ImageViewEx02.class);
                    startActivity(intent);
                }

            }
        }
    }
}
