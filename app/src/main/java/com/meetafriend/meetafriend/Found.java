package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Found extends Activity {

    private String matchName = "Brian";
    private String matchAge = "20";
    private String matchGender = "Male";
    private String matchInterests = "Niks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found);


        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Found");

        TextView name = (TextView) findViewById(R.id.usernameMatch);
        TextView age = (TextView) findViewById(R.id.ageMatch);
        TextView interests = (TextView) findViewById(R.id.interestsMatch);
        TextView gender = (TextView) findViewById(R.id.genderMatch);


        name.setText(matchName);
        age.setText(matchAge);
        interests.setText(matchInterests);
        gender.setText(matchGender);

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
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}
