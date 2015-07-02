package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class Found extends Activity {

    private String matchName = "Brian";
    private String matchAge = "20";
    private String matchGender = "Male";
    private String matchInterests = "Niks";
    private String spInterests;
    private ArrayList<String> myInterests = new ArrayList<>();
    private String theInterests;
    private String otherInterest;
    private ArrayList<String> otherInterets = new ArrayList<>();
    private String theOtherInterests;

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
        TextView otherInterests = (TextView) findViewById(R.id.othetIntersts);

        ImageButton home = (ImageButton) findViewById(R.id.toolbarSubmitInterests);
        home.setEnabled(false);
        home.setVisibility(View.INVISIBLE);
        ImageButton settings = (ImageButton) findViewById(R.id.toolbarSettings);
        settings.setEnabled(false);
        settings.setVisibility(View.INVISIBLE);
        ImageButton friends = (ImageButton) findViewById(R.id.toolbarFriends);
        friends.setEnabled(false);
        friends.setVisibility(View.INVISIBLE);


        name.setText(matchName);
        age.setText(matchAge);

        SharedPreferences sp = getSharedPreferences("Interests", 0);

        for (int i = 0; i < 307; i++)
        {
            spInterests =  sp.getString("Interests" + i, null);

            if(spInterests != null)
            {
              myInterests.add(spInterests);
            }
        }


        for(int a = 0; a < myInterests.size() ; a++)
        {
            theInterests =  theInterests + ", " + myInterests.get(a);
        }

        SharedPreferences sp2 = getSharedPreferences("OtherInterests", 0);

        for (int i = 0; i < 307; i++)
        {
            if(Math.random() >= 0.95) {
                otherInterest = sp2.getString("Interests" + i, null);

                if (otherInterest != null) {
                    otherInterets.add(otherInterest);
                }
            }
        }


        for(int a = 0; a < otherInterets.size() ; a++)
        {
            theOtherInterests =  theOtherInterests + ", " + otherInterets.get(a);
        }

        interests.setText(theInterests);
        gender.setText(matchGender);
        otherInterests.setText(theOtherInterests);
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
