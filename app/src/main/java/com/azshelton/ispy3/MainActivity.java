package com.azshelton.ispy3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton advance;
    private ToggleButton notification;
    private Button logout;
    private int notify_on = 1;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        advance = (ToggleButton) findViewById(R.id.toggleAdvance);
        notification = (ToggleButton) findViewById(R.id.toggleNotification);
        logout = (Button) findViewById(R.id.buttonLogOut);
    }
    public void onClickFeeds(View v){
        Intent mintent = new Intent(MainActivity.this, ModifyFeed.class);
        startActivity(mintent);
    }
    public void onClickAdvanced(View v)
    {
        if (advance.isChecked()) {
            notification.setVisibility(notification.VISIBLE);
            logout.setVisibility(notification.VISIBLE);
        } else {
            notification.setVisibility(notification.INVISIBLE);
            logout.setVisibility(notification.INVISIBLE);
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