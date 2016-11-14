package com.azshelton.ispy3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import static com.azshelton.ispy3.R.id.text;
import static com.azshelton.ispy3.R.id.textView;

public class Feeds extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        final TextView textView = (TextView) findViewById(R.id.textView2);
        Intent intent =getIntent();
        String str = intent.getStringExtra("location");
        textView.setText(str);
        String video = "";


        String location = textView.getText().toString();
        if (location == "Kitchen"){
            video = "https://www.cefns.nau.edu/~rs854/videos/Kitchen.mp4";
            videoView.setVideoPath(video);
        }
        if (location == "Dining Room"){
            video = "https://www.cefns.nau.edu/~rs854/videos/Kitchen.mp4";
            videoView.setVideoPath(video);
        }
        if (location == "Patio"){
            video = "https://www.cefns.nau.edu/~rs854/videos/Patio.mp4";
            videoView.setVideoPath(video);
        }
        if (location =="Hall"){
            video =  "https://www.cefns.nau.edu/~rs854/videos/Hall.mp4";
            videoView.setVideoPath(video);
        }
        if (location =="Entry"){
            video = "https://www.cefns.nau.edu/~rs854/videos/Entry.mp4";
            videoView.setVideoPath(video);
        }else{
            video = "https://www.cefns.nau.edu/~rs854/videos/Cat.mp4";
            videoView.setVideoPath(video);
        }

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}
