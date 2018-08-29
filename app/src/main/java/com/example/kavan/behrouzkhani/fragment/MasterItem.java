package com.example.kavan.behrouzkhani.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.kavan.behrouzkhani.R;

public class MasterItem extends LinearLayout {
    public MasterItem(Context context) {
        super(context);


        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(R.layout.master_item,this , true);

    }

}
