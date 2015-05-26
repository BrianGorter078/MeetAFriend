package com.meetafriend.meetafriend;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Settings");

        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setClickable(false);

        SeekBar mSeekbar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekText = (TextView) findViewById(R.id.kilometers);

        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                seekText.setText(Integer.toString(progress) + " KM");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {}

            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    public void friends(View view) {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void checkbuttons(View view) {
        RadioButton female = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton male = (RadioButton) findViewById(R.id.radioButton);

        if(female.isChecked())
        {
            male.setChecked(false);
            female.setChecked(true);

        }
        else if(!female.isChecked())
        {
            male.setChecked(true);
            female.setChecked(false);
        }

    }

    public void checkbuttons1(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.radioButton);
        RadioButton female = (RadioButton) findViewById(R.id.radioButton2);


        if(male.isChecked())
        {
            male.setChecked(true);
            female.setChecked(false);

        }
        else if(!male.isChecked())
        {
            male.setChecked(false);
            female.setChecked(true);
        }
    }
}
