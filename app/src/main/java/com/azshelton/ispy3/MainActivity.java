package com.azshelton.ispy3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button feed;
    private ToggleButton advance;
    private ToggleButton notification;
    private ToggleButton about;
    private Button logout;
    private static int notify_on = 0;
    private ScrollView aboutscroll;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println(MainActivity.notify_on);
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
        System.out.println("notify_on " + MainActivity.notify_on);
        Intent myIntent = new Intent(MainActivity.this, ModifyFeed.class);
        myIntent.putExtra("identify_on", MainActivity.notify_on);
        startActivity(myIntent);
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
    /*
    public void onClickNotify(View v)
    {
        notify_on += 1;
    }
    public boolean notificationsOn()
    {
        return (notify_on % 2 == 1);
    }
    */
    public void onClickNotification(View v){
        if(notification.isChecked()){
            addNotification();
            MainActivity.notify_on = 1;
            System.out.println(notify_on);

        }else{
            MainActivity.notify_on = 0;
            System.out.println(notify_on);
        }
    }


    public void addNotification() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.security)
                        .setContentTitle("ISpy Security")
                        .setContentText("Actively Monitoring");

        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}