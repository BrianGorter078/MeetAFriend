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

    public static final String PREFS_NAME = "Settings";
    boolean genderWant;
    boolean interests;
    boolean friends;
    boolean pictures;
    boolean notifications;
    int distance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        Switch sameInterests = (Switch) findViewById(R.id.sameInterests);
        Switch friendsCheck = (Switch) findViewById(R.id.onlyFriendsSwitch);
        Switch onlyPicture = (Switch) findViewById(R.id.OnlyPictureSwitch);
        Switch showNotficiations = (Switch) findViewById(R.id.showNotificationSwitch);
        RadioButton male = (RadioButton) findViewById(R.id.searchForMale);
        RadioButton female = (RadioButton) findViewById(R.id.searchForFemale);

        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setEnabled(false);
        toolbarSettings.setVisibility(View.INVISIBLE);
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setEnabled(false);
        toolbarFriends.setVisibility(View.INVISIBLE);
        ImageButton toolbarSubmitInterests = (ImageButton) findViewById(R.id.toolbarSubmitInterests);
        toolbarSubmitInterests.setEnabled(false);
        toolbarSubmitInterests.setVisibility(View.INVISIBLE);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Settings");

        SeekBar mSeekbar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekText = (TextView) findViewById(R.id.kilometers);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        interests = settings.getBoolean("Interests", false);
        friends = settings.getBoolean("Friends", false);
        pictures = settings.getBoolean("Pictures", false);
        notifications = settings.getBoolean("Notifications", false);
        distance = settings.getInt("Distance", 0);
        genderWant = settings.getBoolean("Gender", false);


        if(interests == true)
        {
            sameInterests.setChecked(true);
        }
        else
        {
            sameInterests.setChecked(false);
        }

        if(pictures == true)
        {
            onlyPicture.setChecked(true);
        }
        else
        {
            onlyPicture.setChecked(false);
        }

        if(friends == true)
        {
            friendsCheck.setChecked(true);
        }
        else
        {
            friendsCheck.setChecked(false);
        }

        if(notifications == true)
        {
            showNotficiations.setChecked(true);
        }
        else
        {
            showNotficiations.setChecked(false);
        }
        if(distance > 0)
        {
            mSeekbar.setProgress(distance);
            seekText.setText(distance + " KM");
        }
        else
        {
            mSeekbar.setProgress(0);
        }
        if(genderWant == true)
        {
            male.setChecked(true);
        }
        else
        {
            female.setChecked(true);
        }


        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekText.setText(progress + " KM");

                distance = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("Interests", interests);
        editor.putBoolean("Friends",friends);
        editor.putBoolean("Pictures", pictures);
        editor.putBoolean("Notifications", notifications);
        editor.putBoolean("Gender", genderWant);
        editor.putInt("Distance", distance);
        editor.commit();
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
            genderWant = false;
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
            male.setChecked(true);
            female.setChecked(false);
            genderWant = true;

        } else if (!male.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);

        }
    }


    public void checkInterests(View view) {

        Switch sameInterests = (Switch) findViewById(R.id.sameInterests);

        if(sameInterests.isChecked()) {
            interests = true;
            System.out.println(interests);
        } else {
            interests = false;
            System.out.println(interests);
        }

    }

    public void checkFriends(View view) {
        Switch friendsCheck = (Switch) findViewById(R.id.onlyFriendsSwitch);

        if(friendsCheck.isChecked()) {
            friends = true;
            System.out.println(friends);
        } else {
            friends = false;
            System.out.println(friends);
        }
    }

    public void checkOnlyPicture(View view) {

        Switch onlyPicture = (Switch) findViewById(R.id.OnlyPictureSwitch);

        if(onlyPicture.isChecked()) {
            pictures = true;
            System.out.println(pictures);
        } else {
            pictures = false;
            System.out.println(pictures);
        }
    }

    public void checkNotifications(View view) {

        Switch showNotficiations = (Switch) findViewById(R.id.showNotificationSwitch);
        if(showNotficiations.isChecked()) {
            notifications = true;
            System.out.println(notifications);
        } else {
            notifications = false;
            System.out.println(notifications);
        }
    }
}
