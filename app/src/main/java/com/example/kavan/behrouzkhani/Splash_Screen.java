package com.example.kavan.behrouzkhani;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.kavan.behrouzkhani.activities.Login;
import com.example.kavan.behrouzkhani.activities.Main2Activity;

public class

Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ///////// hide notification bar
        ////////
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this,Login.class);
                startActivity(intent);
                finish();
            }
        } , 2000);

    }
}
