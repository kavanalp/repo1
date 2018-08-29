package com.example.kavan.behrouzkhani.fragment;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kavan.behrouzkhani.R;

import java.util.ArrayList;

public class First extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private EditText name ;
    LinearLayout linearLayout;
    private Button buttonAdd , buttonAddTel;

    private OnFragmentInteractionListener mListener;
    ArrayList<EditText> myList = new ArrayList<>();

    public First() {
    }
    private void addItem() {
        MasterItem masterItem = new MasterItem(getActivity());
        LinearLayout linearLayout2 = (LinearLayout) masterItem.getChildAt(0);
        final EditText editText= (EditText)linearLayout2.getChildAt(1);
        TextView textView = (TextView) linearLayout2.getChildAt(0);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        if(!"".equals(editText.getText().toString()))
            myList.add(editText);
        linearLayout.addView(masterItem);
    }

    public static First newInstance(String param1, String param2) {
        First fragment = new First();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        view = init(view);
        return view;


    }

    private View init(View view) {

        buttonAdd = view.findViewById(R.id.ButtonAdd);
        buttonAddTel = view.findViewById(R.id.ButtonAddTelephone);
        linearLayout = view.findViewById(R.id.telList);
        name = view.findViewById(R.id.name);
        buttonAddTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addItem();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDate();
            }
        });
        return view;
    }

    private void saveDate() {
        ContentValues values = new ContentValues();
        values.put("name" , name.getText().toString());
        values.put("image","");
        values.put("view_","0");
        values.put("most_used","0");


    }



    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
