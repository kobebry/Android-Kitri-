package com.exam.andex01.anddb01;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-13.
 */
public class MemIns extends LinearLayout implements View.OnClickListener{
    EditText editName, editId, editPwd,editEmail,editPhone,editAddr;
    Button join;
    String vName,vId, vPwd,vPhone,vEmail,vAddr, category;
    Context context;
    public MemIns(Context context){
        super(context);
        execute(context);
    }
    private void execute(Context context){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mem_ins,this,true);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        editName = (EditText)findViewById(R.id.editName);
        editId = (EditText)findViewById(R.id.editId);
        editPwd = (EditText)findViewById(R.id.editPwd);
        editEmail = (EditText)findViewById(R.id.editEmail);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editAddr = (EditText)findViewById(R.id.editAddr);
        join = (Button)findViewById(R.id.join);
        join.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId() == R.id.join){
            vName = editName.getText().toString();
            vId = editId.getText().toString();
            vPwd = editPwd.getText().toString();
            vPhone = editEmail.getText().toString();
            vEmail = editPhone.getText().toString();
            vAddr = editAddr.getText().toString();
            category ="mvcIns";


            String requestURL =  "http://192.168.15.21:8805/WebServer/andController.do";

            HttpClient client   = new DefaultHttpClient();
            HttpPost post    = new HttpPost(requestURL);
            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("mem_name" , vName));
            paramList.add(new BasicNameValuePair("mem_id"   , vId));
            paramList.add(new BasicNameValuePair("mem_pwd"  , vPwd));
            paramList.add(new BasicNameValuePair("mem_phone" , vPhone));
            paramList.add(new BasicNameValuePair("mem_email" , vEmail));
            paramList.add(new BasicNameValuePair("mem_addr"  , vAddr));
            paramList.add(new BasicNameValuePair("category"  , category));

            try {
                post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                HttpResponse response = client.execute(post);
            } catch(Exception e) {
                Log.d("sendPost===> ", e.toString());
            }
        }
    }


}
