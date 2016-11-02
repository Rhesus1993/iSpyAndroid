package com.azshelton.ispy3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Feeds extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
    }
}
