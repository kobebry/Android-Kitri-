package com.example.choi.beer_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
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
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe extends Activity implements View.OnClickListener {
    int btn[] = {R.id.guinness, R.id.bodding, R.id.wolfas, R.id.stella, R.id.kronenbourg, R.id.pilsner, R.id.heineken, R.id.hoegaarden, R.id.krombacher};
    ImageButton btns[] = new ImageButton[btn.length];
    Class classes[] = {Project_Beer_europe_Guinness.class, Project_Beer_europe_Bodding.class, Project_Beer_europe_Wolfas.class, Project_Beer_europe_Stella.class, Project_Beer_europe_kronenbourg.class, Project_Beer_europe_Pilsner.class, Project_Beer_europe_Heineken.class, Project_Beer_europe_Hoagarden.class, Project_Beer_europe_Krombacher.class};
    int textview[] = {R.id.textguinness, R.id.textboddingtons, R.id.textvolfas, R.id.textstella, R.id.textkronenbourg, R.id.textpilsner, R.id.textheineken, R.id.texthoegaarden, R.id.textkrombacher};
    TextView textviews[] = new TextView[textview.length];
    int ratingbar[] = {R.id.rating_guinness, R.id.rating_boddingtons, R.id.rating_volfas, R.id.rating_stella, R.id.rating_kronenbourg, R.id.rating_pilsner, R.id.rating_heineken, R.id.rating_hoegaarden, R.id.rating_krombacher};
    RatingBar ratingbars[] = new RatingBar[ratingbar.length];
    String category;
    int count = 0;
    int sum = 0;
    int su[] = new int[ratingbar.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        for (int i = 0; i < btn.length; i++) {
            btns[i] = (ImageButton) findViewById(btn[i]);
            textviews[i] = (TextView) findViewById(textview[i]);
            ratingbars[i] = (RatingBar)findViewById(ratingbar[i]);
            btns[i].setOnClickListener(this);
        }

            String requestURL = "http://192.168.15.21:8805/WebServer/andController.do";

            try {
                List<BeerDTO> list;
                category = "selectbeer";
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(requestURL);
                List<NameValuePair> paramList = new ArrayList<>();
                paramList.add(new BasicNameValuePair("category", category));

                post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                HttpResponse response = client.execute(post);
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                list = getXML(is);
/*                        if(dto.getTitle().equals(textviews[0].getText().toString())){
                            ratingbars[0].setRating(5);

*//*
                            ratingbars[0].setRating(Float.valueOf(dto.getScore())/2);
*//*
                        }*/
                BeerDTO dto;
/*                for(int b=0; b<textviews.length; b++){
                    for (int a = 0; a < list.size(); a++) {
                        dto = list.get(a);
                            if(textviews[b].getText().toString().equals(dto.getTitle())){
                                su[b] += count;
                                sum += Integer.valueOf(dto.getScore());
                            }
                        }
                    Toast.makeText(getApplicationContext(),String.valueOf(ratingbars[b].getRating()),Toast.LENGTH_SHORT).show();
                    ratingbars[b].setRating(Float.valueOf(sum/2/su[b]));
                    sum=0;
                }*/
                Toast.makeText(getApplicationContext(), String.valueOf(list.size()), Toast.LENGTH_SHORT).show();

                for (int a = 0; a < list.size(); a++) {
                    dto = list.get(a);
                    String title = dto.getTitle();

                    int temp = 0;
                    temp += Integer.parseInt(dto.getScore());
                    /*if(title.equals("Guinness")) {
                        count += 1;
                        sum += Integer.parseInt(dto.getScore());
                        //Log.v("sum값 : ", title);
                        //Toast.makeText(getApplicationContext(), String.valueOf(sum), Toast.LENGTH_SHORT).show();
                    }*/
                    this.sum += temp;
                    Log.v("string", Integer.toString(temp));
                }
                Log.v("string", Integer.toString(sum));
                Toast.makeText(getApplicationContext(), Integer.toString(sum), Toast.LENGTH_SHORT).show();
                //ratingbars[0].setRating(Float.valueOf(sum/2/count));



            } catch (Exception e) {
                Log.d("sendPost===> ", e.toString());
            }

    }

    public List<BeerDTO> getXML(InputStream is) {
        List<BeerDTO> list = new ArrayList<>();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(is, "UTF-8");

            int eventType = parser.getEventType();

            BeerDTO dto = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        String startTag = parser.getName();

                        if (startTag.equals("beer")) {
                            dto = new BeerDTO();
                        }
                        if (dto != null) {
                            if (startTag.equals("title")) {
                                dto.setTitle(parser.nextText());
                            } else if (startTag.equals("score")) {
                                dto.setScore(parser.nextText());
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        String endTag = parser.getName();
                        if (endTag.equals("beer")) {
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



    public void onClick(View v) {
        for (int i = 0; i < btn.length; i++) {
            if (v.getId() == btn[i]) {
                Intent intent = new Intent(getApplication(), classes[i]);
                String gotiitle = textviews[i].getText().toString();
                intent.putExtra("gotitle", gotiitle);
                startActivity(intent);
            }
        }
    }
}
