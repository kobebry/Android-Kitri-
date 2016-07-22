package com.exam.andex01.widgetmenu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;

/**
 * Created by Administrator on 2016-07-15.
 */
public class RatingBar02 extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_bar01);

        final RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingbar);

        ratingBar.setStepSize((float)0.5);
        ratingBar.setRating((float)2.5);
        ratingBar.setIsIndicator(false);
    }
}
