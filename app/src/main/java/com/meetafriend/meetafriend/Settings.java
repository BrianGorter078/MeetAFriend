package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class Settings extends Activity {

    String genderWant;
    String searchFor;
    String interests;
    String friends;
    String pictures;
    String notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setEnabled(false);
        toolbarSettings.setVisibility(View.INVISIBLE);
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setEnabled(false);
        toolbarFriends.setVisibility(View.INVISIBLE);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Settings");

        SeekBar mSeekbar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekText = (TextView) findViewById(R.id.kilometers);


        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekText.setText(Integer.toString(progress) + " KM");
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
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
        Intent intent = new Intent(this, Interests.class);
        startActivity(intent);
    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }

    public void checkbuttonsFemale(View view) {
        RadioButton female = (RadioButton) findViewById(R.id.searchForFemale);
        RadioButton male = (RadioButton) findViewById(R.id.searchForMale);

        if (female.isChecked()) {
            genderWant = "F";
            male.setChecked(false);
            female.setChecked(true);

        } else if (!female.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }

    }

    public void checkbuttonsMale(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.searchForMale);
        RadioButton female = (RadioButton) findViewById(R.id.searchForFemale);


        if (male.isChecked()) {
            genderWant = "M";
            male.setChecked(true);
            female.setChecked(false);

        } else if (!male.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }
    }


    public void checkInterests(View view) {
        Switch sameInterests = (Switch) findViewById(R.id.sameInterests);

        if(sameInterests.isChecked()) {
            interests = "You son of a bitch! #brian == noep";
            System.out.println(interests);
        } else {
            interests = "WE LOST!";
            System.out.println(interests);
        }

    }

    public void checkFriends(View view) {
        Switch friendsCheck = (Switch) findViewById(R.id.onlyFriendsSwitch);

        if(friendsCheck.isChecked()) {
            friends = "It actually goddamn works";
            System.out.println(friends);
        } else {
            friends = "WE LOST!";
            System.out.println(friends);
        }
    }

    public void checkOnlyPicture(View view) {
        Switch onlyPicture = (Switch) findViewById(R.id.onlyPictureSwitch);

        if(onlyPicture.isChecked()) {
            pictures = "now weve got fucking pictures";
            System.out.println(interests);
        } else {
            pictures = "no pictures needed";
            System.out.println(interests);
        }
    }

    public void checkNotifications(View view) {
        Switch showNotficiations = (Switch) findViewById(R.id.showNotificationSwitch);

        if(showNotficiations.isChecked()) {
            notifications = "well those notifications are handy....";
            System.out.println(interests);
        } else {
            notifications = "Bullshit notifications";
            System.out.println(interests);
        }
    }
}
