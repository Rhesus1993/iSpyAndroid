package com.azshelton.ispy3;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

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
        final Button download = (Button)findViewById(R.id.button2);
        final File file;
        Intent intent = getIntent();
        String str = intent.getStringExtra("location");
        textView.setText(str);

        String temp = str.toString().toLowerCase();

        if(temp.equals("dining room")){
            video="https://www.cefns.nau.edu/~rs854/videos/DiningRoom.mp4";
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
            video = "https://www.cefns.nau.edu/~rs854/videos/Stairway.mp4";
        }

        Uri uri=Uri.parse(video);
        file = new File(video);

        System.out.println(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoURI(uri);

        videoView.start();

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(file.exists()) {
                    Uri path = Uri.fromFile(file);
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "video/mp4");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    try{
                        startActivity(intent);
                    }catch (ActivityNotFoundException e){
                        Toast.makeText(Feeds.this, "No Application Available to View video", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(Feeds.this, "Unable to Download Video", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }

}
