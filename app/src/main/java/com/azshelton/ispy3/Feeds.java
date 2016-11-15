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
    private String video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        final TextView textView = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("location");
        textView.setText(str);

        String temp = str.toString().toLowerCase();

        if(temp.equals("dining room")){
            video="https://www.cefns.nau.edu/~rs854/videos/Hall.mp4";
        }
        if(temp.equals("kitchen")){
            video="https://www.cefns.nau.edu/~rs854/videos/Kitchen.mp4";
        }
        if(temp.equals("patio")){
            video = "https://www.cefns.nau.edu/~rs854/videos/Patio.mp4";
        }
        if(temp.equals("living room")){
            video = "https://www.cefns.nau.edu/~rs854/videos/LivingRoom.mp4";
        }
        if(temp.equals("entry")){
            video = "https://www.cefns.nau.edu/~rs854/videos/Entry.mp4";
        }
        if(temp.equals("stairway")){
            video = "https://www.cefns.nau.edu/~rs854/videos/Hall.mp4";
        }

        Uri uri=Uri.parse(video);

        System.out.println(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(uri);

        videoView.start();
    }
}
