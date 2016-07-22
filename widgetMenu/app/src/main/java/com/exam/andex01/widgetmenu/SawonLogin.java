package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016-07-20.
 */
public class SawonLogin extends Activity {
    EditText editid, editpass;
    String goid, gopass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sawon_login);

        editid = (EditText)findViewById(R.id.editid);
        editpass = (EditText)findViewById(R.id.editpass);

    }

    public void loginevent(View v){
        Intent intent = new Intent(getApplicationContext(), SawonCertify.class);
        goid = editid.getText().toString();
        gopass = editid.getText().toString();
        intent.putExtra("goid", goid);
        intent.putExtra("gopass", gopass);
        startActivity(intent);
    }
}
