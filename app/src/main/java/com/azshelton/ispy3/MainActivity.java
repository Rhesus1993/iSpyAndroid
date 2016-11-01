package com.azshelton.ispy3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ToggleButton advance = (ToggleButton) findViewById(R.id.toggleAdvance);
        final ToggleButton notification = (ToggleButton) findViewById(R.id.toggleNotification);
        final Button logout = (Button) findViewById(R.id.buttonLogOut);

        advance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    notification.setVisibility(buttonView.VISIBLE);
                    logout.setVisibility(buttonView.VISIBLE);
                } else {
                    notification.setVisibility(buttonView.INVISIBLE);
                    logout.setVisibility(buttonView.INVISIBLE);
                }
            }
        });

        notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                } else {

                }
            }
        });
    }
    public void onClickFeeds(View v){
        Intent mintent = new Intent(MainActivity.this, ModifyFeed.class);
        startActivity(mintent);
    }
}