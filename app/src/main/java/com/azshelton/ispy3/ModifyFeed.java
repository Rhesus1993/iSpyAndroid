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
    private ToggleButton addL;
    private Button remove;
    private Spinner location;
    String[] videoLocations;
    int count, i;
    Button b1[];
    String current;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_feed);
        remove = (Button)findViewById(R.id.Remove);
        addL = (ToggleButton)findViewById(R.id.toggleButton);
        location = (Spinner)findViewById(R.id.spinner1);
        LinearLayout buttonLayout = (LinearLayout)findViewById(R.id.layout1);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.TEXT_ALIGNMENT_CENTER,LinearLayout.VERTICAL);

        //drop down menu
        String[] items = new String[]{"Dining Room", "Kitchen", "Patio", "Living Room", "Entry", "Stairway"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        location.setAdapter(adapter);

        videoLocations = new String[count];
        for(int i = 0; i < videoLocations.length; i++){
            count++;
            b1[i] = new Button(this);
            b1[i].setId(i);
            b1[i].setText(videoLocations[i]);
            b1[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            buttonLayout.addView(b1[i]);
        }


    }

    public void onClickAdd(View v)
    {
        if (addL.isChecked()){
            location.setVisibility(View.VISIBLE);
            current = location.toString();
            videoLocations[count] = current;


        }else{
            location.setVisibility(View.INVISIBLE);

        }
    }


    public void onClickRemove(View v)
    {
        //TODO: Make array of buttons and have this remove the last one. Then set the onClickEvent in xml
    }

    public void onClickView(View v){
        //Button location = (Button) findViewById(R.id.btn1);
        //Intent mintent = new Intent(ModifyFeed.this, Feeds.class);
        //mintent.putExtra("location",location.getText().toString());
        //startActivity(mintent);
    }
}
