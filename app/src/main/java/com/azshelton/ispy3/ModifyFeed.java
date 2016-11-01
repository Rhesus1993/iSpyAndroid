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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ToggleButton add = (ToggleButton) findViewById(R.id.add);
        final EditText name = (EditText) findViewById(R.id.editText3);
        final EditText location = (EditText) findViewById(R.id.editText4);
        final Button btn1 = (Button) findViewById(R.id.btn1);
        final Button remove = (Button) findViewById(R.id.Remove);
        setContentView(R.layout.activity_modify_feed);

        add.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if (isChecked){
                    name.setVisibility(buttonView.VISIBLE);
                    location.setVisibility(buttonView.VISIBLE);
                }else{
                    name.setVisibility(buttonView.INVISIBLE);
                    location.setVisibility(buttonView.INVISIBLE);
                }
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V){
                btn1.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void onClickView(View v){
        Intent mintent = new Intent(ModifyFeed.this, Feeds.class);
        startActivity(mintent);
    }
}
