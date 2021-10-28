package com.pdprogramer.dentapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class PlayerMediaActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    int orientation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);
        orientation=this.getResources().getConfiguration().orientation;
//        Toolbar myChildToolbar =(Toolbar) findViewById(R.id.bara_playing);
//        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        if(orientation==ORIENTATION_PORTRAIT){
            videoView=findViewById(R.id.reproductor);

        }else {
            videoView=findViewById(R.id.reproductor2);
        }
        Intent intent=getIntent();
        String value_video="android.resource://"+getApplication().getPackageName()+"/"+intent.getIntExtra("video",0);


        mediaController=new MediaController(this);
        videoView.setVideoPath(value_video);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();




    }
}
