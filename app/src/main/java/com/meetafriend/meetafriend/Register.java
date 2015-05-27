package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;


public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Register");
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setVisibility(View.INVISIBLE);
        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setVisibility(View.INVISIBLE);
    }

    public void friends(View view) {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }

    public void createAccount(View view) {
        Intent intent = new Intent(this, Interests.class);
        startActivity(intent);
    }

    public void checkbuttonsFemale(View view) {
        RadioButton female = (RadioButton) findViewById(R.id.youAreRadiobuttonFemale);
        RadioButton male = (RadioButton) findViewById(R.id.youAreRadiobuttonMale);
        RadioButton male2 = (RadioButton) findViewById(R.id.youWantRadiobuttonMale);
        RadioButton female2 = (RadioButton) findViewById(R.id.youWantRadiobuttonFemale);

        if(female.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }
        else if(!female.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }

        if(female2.isChecked()) {
            male2.setChecked(false);
            female2.setChecked(true);
        }
        else if(!female2.isChecked()) {
            male2.setChecked(true);
            female2.setChecked(false);
        }
    }

    public void checkbuttonsMale(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.youAreRadiobuttonMale);
        RadioButton female = (RadioButton) findViewById(R.id.youAreRadiobuttonFemale);
        RadioButton male2 = (RadioButton) findViewById(R.id.youWantRadiobuttonMale);
        RadioButton female2 = (RadioButton) findViewById(R.id.youWantRadiobuttonFemale);

        if(male.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }
        else if(!male.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }

        if(male2.isChecked()) {
            male2.setChecked(true);
            female2.setChecked(false);
        }
        else if(!male2.isChecked()) {
            male2.setChecked(false);
            female2.setChecked(true);
        }
    }
}
