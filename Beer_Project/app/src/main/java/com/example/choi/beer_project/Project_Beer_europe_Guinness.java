package com.example.choi.beer_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-07-15.
 */
public class Project_Beer_europe_Guinness extends Activity implements View.OnClickListener {
    int btns[][] = {{R.id.onegood, R.id.onenotbad, R.id.onebad},
            {R.id.twogood, R.id.twonotbad, R.id.twobad},
            {R.id.threegood, R.id.threenotbad, R.id.threebad},
            {R.id.fourgood, R.id.fournotbad, R.id.fourbad},
            {R.id.fivegood, R.id.fivenotbad, R.id.fivebad}};
    CheckBox chks[][] = new CheckBox[btns.length][btns[0].length];

    int score[] = new int[5];
    float sum;
    String category;
    AlertDialog.Builder builder;


    Button done;
    ViewFlipper flipper;
    ImageButton next, prev;
    String gettitle, title;
    TextView toptitle;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_beer_europe_guinness);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                chks[i][a] = (CheckBox) findViewById(btns[i][a]);
                chks[i][a].setOnClickListener(this);
            }
        }

        next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(this);
        prev = (ImageButton) findViewById(R.id.prev);
        prev.setOnClickListener(this);
        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(this);
        //타이틀 설정
        toptitle = (TextView) findViewById(R.id.toptitle);
        Intent intent = getIntent();
        gettitle = intent.getStringExtra("gotitle");
        toptitle.setText(gettitle);

        //사진 넘기는 기능 설정
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        Animation showIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        flipper.setInAnimation(showIn);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            flipper.showNext();//다음 View로 교체
        } else if (v.getId() == R.id.prev) {
            flipper.showPrevious();
        } else if (v.getId() == R.id.done) {
            builder.setMessage("평점이 등록되었습니다.");
            builder.setPositiveButton("확인", null);
            for (int i = 0; i < btns.length; i++) {
                for (int a = 0; a < btns[0].length; a++) {
                    if (chks[i][a].isChecked()) {
                        if (a == 0) {
                            score[i] = 2;
                        } else if (a == 1) {
                            score[i] = 1;
                        } else if (a == 2) {
                            score[i] = 0;
                        }
                        sum += score[i];
                    }
                }

            }
            title = toptitle.getText().toString();
            category = "addscore";
            String requestURL = "http://192.168.15.21:8805/WebServer/andController.do";

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(requestURL);
            List<NameValuePair> paramList = new ArrayList<>();
            paramList.add(new BasicNameValuePair("title", title));
            paramList.add(new BasicNameValuePair("score", sum));
            paramList.add(new BasicNameValuePair("category"  , category));

            try {
                post.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
                HttpResponse response = client.execute(post);
                Toast.makeText(getApplicationContext(), "mem DB  저장 확인 ",
                        Toast.LENGTH_SHORT).show();
            } catch(Exception e) {
                Log.d("sendPost===> ", e.toString());
            }
        }

        for (int i = 0; i < btns.length; i++) {
            for (int a = 0; a < btns[0].length; a++) {
                if (v.getId() == btns[i][a]) {
                    for (int j = 0; j < 3; j++) {
                        if (v.getId() == btns[i][j]) {

                        } else {
                            chks[i][j].setChecked(false);
                        }
                    }
                }
            }
        }

    }
}
