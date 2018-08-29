package com.example.kavan.behrouzkhani.myCustoms;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by Mohamad-PC on 4/14/2017.
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/pen.ttf");
        setTypeface(tf ,1);
        setTypeface(tf);

    }

}
