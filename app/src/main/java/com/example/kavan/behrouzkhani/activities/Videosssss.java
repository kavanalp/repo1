package com.example.kavan.behrouzkhani.activities;

import android.app.ActionBar;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.kavan.behrouzkhani.R;

public class Videosssss extends AppCompatActivity {
    VideoView videoView;
    MediaController media;
    android.support.v7.app.ActionBar actionBar;
    android.widget.LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_todo);
        actionBar = getSupportActionBar();
        videoView = findViewById(R.id.videoss);
        media = new MediaController(this);
        setVideo();
    }

    private void setVideo() {
        String videoPath = "android.resource://com.example.kavan.behrouzkhani/" + R.raw.aaaaaaaa;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.setMediaController(media);
        media.setAnchorView(videoView);
    }

    public void btnPlay(View view) {
        actionBar.hide();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) videoView.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        videoView.setLayoutParams(params);
        videoView.start();
    }

}

