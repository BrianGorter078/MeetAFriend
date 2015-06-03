package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;


public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton tb = (ImageButton) findViewById(R.id.toolbarSettings);
        tb.setEnabled(false);

        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setVisibility(View.INVISIBLE);
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setVisibility(View.INVISIBLE);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Settings");

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

    public void toEditProfile(View view) {
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void checkbuttonsFemale(View view) {
        RadioButton female = (RadioButton) findViewById(R.id.searchForFemale);
        RadioButton male = (RadioButton) findViewById(R.id.searchForMale);

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

    public void checkbuttonsMale(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.searchForMale);
        RadioButton female = (RadioButton) findViewById(R.id.searchForFemale);


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
