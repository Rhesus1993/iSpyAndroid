package com.azshelton.ispy3;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class ModifyFeed extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private Button addL;
    private Button remove;
    private Spinner location;
    private int count;
    private String [] items = new String[]{"Dining Room", "Kitchen", "Patio", "Living Room", "Entry", "Stairway"};

    ArrayList<String> videoLocation;
    String current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_feed);
        remove = (Button)findViewById(R.id.Remove);
        addL = (Button)findViewById(R.id.toggleButton);
        location = (Spinner)findViewById(R.id.spinner1);

        //drop down menu

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        location.setAdapter(adapter);

        //remove views from feed
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    //adds views to feed
    public void onClickAdd(View v)
    {
        final LinearLayout buttonLayout = (LinearLayout)findViewById(R.id.layout1);
        videoLocation = new ArrayList<String>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

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
            btn.setWidth(1000);
            btn.setHeight(100);
            btn.setLayoutParams(params);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //creates a listener to open the video feed for the corresponding button
                    Button location = (Button) findViewById(btn.getId());
                    Intent mintent = new Intent(ModifyFeed.this, Feeds.class);
                    mintent.putExtra("location",location.getText().toString());
                    startActivity(mintent);
                }
            });
            //adds buttons to the display
            bl.addView(btn);
            buttonLayout.addView(bl);
        }
    }
    public void onClickRemove(View v){
        //TODO
    }
}
