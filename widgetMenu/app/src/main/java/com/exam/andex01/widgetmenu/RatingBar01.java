package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-07-15.
 */
public class RatingBar01 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_bar01);

        final RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingbar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "New Rating : " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
