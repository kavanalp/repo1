package com.example.kavan.behrouzkhani.myCustoms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class MycustomText extends android.support.v7.widget.AppCompatTextView {
    public MycustomText(Context context) {
        super(context);
        init();
    }
    public MycustomText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MycustomText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/IranNastaliq.ttf");
        setTypeface(typeface);
    }

}
