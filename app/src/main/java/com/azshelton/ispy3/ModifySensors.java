package com.azshelton.ispy3;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;


public class ModifySensors extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static int notify_on;
    private Spinner location;
    private int count;
    private String [] items = new String[]{"Master Window", "Kids Room", "Ofice", "Front Door", "Back Door", "Garage"};
    private RadioGroup radio;
    ArrayList<String> videoLocation;
    String current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_sensors);
        location = (Spinner)findViewById(R.id.spinner1);

        //drop down menu

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        location.setAdapter(adapter);

        Intent mIntent = getIntent();
        int recInt = mIntent.getIntExtra("identify_on", 0);
        int temp = recInt;
        ModifySensors.notify_on = temp;
        System.out.println(ModifySensors.notify_on);

    }
    //adds views to feed
    public void onClickAdd(View v)
    {
        final LinearLayout buttonLayout = (LinearLayout)findViewById(R.id.layout1);
        final RadioGroup radio = (RadioGroup)findViewById(R.id.popup);
        final RadioButton radioNo = (RadioButton)findViewById(R.id.Radiono);
        final RadioButton radioYes = (RadioButton)findViewById(R.id.Radioyes);

        videoLocation = new ArrayList<String>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);

        //gets contents of drop down and adds to array
        current = location.getSelectedItem().toString();
        videoLocation.add(current);
        System.out.println(videoLocation);

        //creates buttons from array
        for (int i = 0; i < videoLocation.size(); i++){
            count++;
            LinearLayout bl = new LinearLayout(this);
            bl.setOrientation(LinearLayout.HORIZONTAL);
            final Button btn = new Button(this);
            btn.setId(count);
            System.out.println(btn.getId());
            btn.setText(videoLocation.get(i));
            btn.setLayoutParams(params);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //creates a listener to open the video feed for the corresponding button
                    //TODO random change a notiication is created
                }
            });
            //for removing a view
            btn.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    radio.setVisibility(View.VISIBLE);
                    radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        //checks if the users really wants to remove the view
                        public void onCheckedChanged(RadioGroup radioGroup, int i) {
                            switch(i){
                                case R.id.Radioyes:
                                    btn.setVisibility(View.GONE);
                                    radio.setVisibility(View.INVISIBLE);
                                    radio.clearCheck();
                                    if(notify_on == 1) {
                                        NotificationRemovedView();
                                    }
                                case R.id.Radiono:
                                    radio.setVisibility(View.INVISIBLE);
                                    radio.clearCheck();
                            }

                        }
                    });
                    return true;
                }
            });
            //adds buttons to the display
            bl.addView(btn);
            buttonLayout.addView(bl);
            if(notify_on == 1) {
                NotificationAddedView();
            }
        }

    }
    public void NotificationRemovedView() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.security)
                        .setContentTitle("ISpy Security")
                        .setContentText("A motion sensor was removed from your account");

        // Sets an ID for the notification
        int mNotificationId = count;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
    public void NotificationAddedView() {
        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.security)
                        .setContentTitle("ISpy Security")
                        .setContentText("A motion sensor was synced to you account");

        // Sets an ID for the notification
        int mNotificationId = count;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
