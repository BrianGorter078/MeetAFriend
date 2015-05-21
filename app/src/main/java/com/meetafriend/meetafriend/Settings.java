package com.meetafriend.meetafriend;

import android.app.Activity;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
