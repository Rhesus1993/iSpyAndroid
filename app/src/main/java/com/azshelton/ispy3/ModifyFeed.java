package com.azshelton.ispy3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class ModifyFeed extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private ToggleButton add;
    private EditText name;
    private EditText location;
    private Button btn1;
    private Button remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add = (ToggleButton) findViewById(R.id.add);
        name = (EditText) findViewById(R.id.editText3);
        location = (EditText) findViewById(R.id.editText4);
        btn1 = (Button) findViewById(R.id.btn1);
        remove = (Button) findViewById(R.id.Remove);
        setContentView(R.layout.activity_modify_feed);

    }
    public void onClickAdd(View v)
    {
        if (add.isChecked()){
            name.setVisibility(View.VISIBLE);
            location.setVisibility(View.VISIBLE);
        }else{
            name.setVisibility(View.INVISIBLE);
            location.setVisibility(View.INVISIBLE);
        }
    }
    public void onClickRemove(View v)
    {
        //TODO: Make array of buttons and have this remove the last one. Then set the onClickEvent in xml
    }

    public void onClickView(View v){
        Intent mintent = new Intent(ModifyFeed.this, Feeds.class);
        startActivity(mintent);
    }
}
