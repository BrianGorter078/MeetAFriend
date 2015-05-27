package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;


public class Register extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Register");
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

        if(female.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }
        else if(!female.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }
    }

    public void checkbuttonsMale(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.youAreRadiobuttonMale);
        RadioButton female = (RadioButton) findViewById(R.id.youAreRadiobuttonFemale);

        if(male.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }
        else if(!male.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }
    }
}
