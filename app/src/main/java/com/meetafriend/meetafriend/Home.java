package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends Activity implements LocationListener {

    Button mButton;
    EditText uEdit;
    EditText pEdit;
    private String xpassword = "123";
    private String xusername = "brian";
    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Home");

        ImageButton home = (ImageButton) findViewById(R.id.toolbarSubmitInterests);
        home.setEnabled(false);
        home.setVisibility(View.INVISIBLE);

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


    /* Request updates at startup */
    @Override
    protected void onResume() {
        super.onResume();

    }

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onLocationChanged(Location location) {


    }


    public void friends(View view) {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void meetSomeone(View view) {

        SharedPreferences sp = getSharedPreferences("First",0);
        SharedPreferences.Editor edit = sp.edit();
        firstTime = sp.getBoolean("FirstTime", true);

        System.out.println(firstTime);


    if (firstTime == true) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);


        edit.putBoolean("FirstTime", false);
        edit.commit();
    }
        else
    {
        Intent intent = new Intent(this, Found.class);
        startActivity(intent);
    }

    }

}





