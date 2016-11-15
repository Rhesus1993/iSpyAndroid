package com.azshelton.ispy3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button feed;
    private ToggleButton advance;
    private ToggleButton notification;
    private ToggleButton about;
    private Button logout;
    private int notify_on = 1;
    private ScrollView aboutscroll;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feed = (Button) findViewById(R.id.buttonViewFeeds);
        advance = (ToggleButton) findViewById(R.id.toggleAdvance);
        notification = (ToggleButton) findViewById(R.id.toggleNotification);
        logout = (Button) findViewById(R.id.buttonLogOut);
        about = (ToggleButton) findViewById(R.id.toggleButtonAbout);
        aboutscroll = (ScrollView)findViewById(R.id.aboutView);
    }
    public void onClickFeeds(View v){
        Intent mintent = new Intent(MainActivity.this, ModifyFeed.class);
        startActivity(mintent);
    }
    public void onClickAdvanced(View v)
    {
        if (advance.isChecked()) {
            notification.setVisibility(notification.VISIBLE);
            logout.setVisibility(logout.VISIBLE);
            about.setVisibility(about.VISIBLE);
        } else {
            notification.setVisibility(notification.INVISIBLE);
            logout.setVisibility(logout.INVISIBLE);
            about.setVisibility(about.INVISIBLE);
        }
    }

    public void onClickAbout(View v){
        if (about.isChecked()){
            aboutscroll.setVisibility(View.VISIBLE);
            feed.setVisibility(View.INVISIBLE);


        }else{
            aboutscroll.setVisibility(View.INVISIBLE);
            feed.setVisibility(View.VISIBLE);

        }
    }
    public void onClickNotify(View v)
    {
        notify_on += 1;
    }
    public boolean notificationsOn()
    {
        return (notify_on % 2 == 1);
    }
    public void onClickLogout(View v){
        Intent mintent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(mintent);
    }

}