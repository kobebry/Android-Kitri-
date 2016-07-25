package com.exam.andex01.anddb01;

import android.content.Context;
import android.graphics.Color;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-25.
 */
public class MemSel extends LinearLayout {
    String category;
    Context context;
    LinearLayout layoutSel;
    public MemSel(Context context){
        super(context);
        execute(context);
    }

    private void execute(Context context){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mem_sel,this,true);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        layoutSel = (LinearLayout)findViewById(R.id.layoutSel);


        String requestURL = "http://192.168.15.21:8805/WebServer/andController.do";
        try {
            List<MemberDTO> list;
            category = "mvcSel";
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("category", category));

            post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            HttpResponse response = client.execute(post);
            HttpEntity entity = response.getEntity();
            InputStream is = entity.getContent();
            list = getXML(is);

            Toast.makeText(context.getApplicationContext(),"list size = " + list.size(),Toast.LENGTH_SHORT).show();

            LinearLayout layoutSub[] = new LinearLayout[list.size()];
            TextView txtName[] = new TextView[list.size()];

            MemberDTO dto;
            for(int i=0; i<list.size();i++){
                dto = list.get(i);
                layoutSub[i] = new LinearLayout(context);
                txtName[i] = new TextView(context);
                layoutSub[i].setOrientation(LinearLayout.HORIZONTAL);
                txtName[i].setText(dto.getMem_name().toString()+"\t\t\t"+dto.getMem_id().toString()+"\t\t\t"+ dto.getMem_pwd().toString()+"\t\t\t"+ dto.getMem_email().toString()+"\t\t\t"+dto.getMem_phone().toString()+"\t\t\t"+dto.getMem_addr().toString());
                txtName[i].setTextColor(Color.rgb(255,200,00));
                txtName[i].setTextSize(15f);
                layoutSub[i].addView(txtName[i]);
                layoutSel.addView(layoutSub[i]);
            }

        } catch (Exception e) {
            Log.d("sendPost===> ", e.toString());
        }
    }

    public List<MemberDTO> getXML(InputStream is) {
        List<MemberDTO> list = new ArrayList<>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(is, "UTF-8");

            int eventType = parser.getEventType();

            MemberDTO dto = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        String startTag = parser.getName();

                        if (startTag.equals("member")) {
                            dto = new MemberDTO();
                        }
                        if (dto != null) {
                            if (startTag.equals("vName")) {
                                dto.setMem_name(parser.nextText());
                            } else if (startTag.equals("vId")) {
                                dto.setMem_id(parser.nextText());
                            } else if (startTag.equals("vPwd")) {
                                dto.setMem_pwd(parser.nextText());
                            } else if (startTag.equals("vEmail")) {
                                dto.setMem_email(parser.nextText());
                            } else if (startTag.equals("vPhone")) {
                                dto.setMem_phone(parser.nextText());
                            } else if (startTag.equals("vAddr")) {
                                dto.setMem_addr(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        String endTag = parser.getName();
                        if (endTag.equals("member")) {
                            list.add(dto);
                        }
                        break;
                }
                eventType = parser.next();
            } // end of while
        } catch (Exception e) {
            Log.d("SelectActivityError", e.toString());
        } // end of try
        return list;
    }
}