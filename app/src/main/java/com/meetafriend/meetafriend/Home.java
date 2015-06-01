package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Home extends Activity implements LocationListener{

    Button mButton;
    EditText uEdit;
    EditText pEdit;
    private String xpassword = "123";
    private String xusername = "brian";
    double longitude;
    double latitude;
    private LocationManager locationManager;
    private String provider;
    TextView LongitudeEdit;
    TextView LatitudeEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Home");
        ImageButton toolbarBack = (ImageButton) findViewById(R.id.toolbarBack);
        toolbarBack.setVisibility(View.INVISIBLE);



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
        if (locationManager.getAllProviders() != null) {

        locationManager.requestLocationUpdates(provider, 0, 0, this);
        }
    }
    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = (double) location.getLatitude();
        longitude = (double) location.getLongitude();

        String latitude2 = String.valueOf(latitude);
        String longitude2 = String.valueOf(longitude);

        LongitudeEdit.setText("Huidige Lengtegraad: " + longitude2);
        LatitudeEdit.setText("Huidige Breedtegraad: " + latitude2);
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


//        Intent intent = new Intent(this, Search.class);
//        startActivity(intent);

        LongitudeEdit = (TextView) findViewById(R.id.textView14);
        LatitudeEdit = (TextView) findViewById(R.id.textView15);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        provider = locationManager.getBestProvider(criteria, true);
        System.out.println(provider);
        Location location = locationManager.getLastKnownLocation(provider);
        System.out.println(location);

        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            LongitudeEdit.setText("Geen locatie gevonden");
        }


        latitude = (double) location.getLatitude();
        longitude = (double) location.getLongitude();

        String latitude2 = String.valueOf(latitude);
        String longitude2 = String.valueOf(longitude);

        LongitudeEdit.setText("Huidige Lengtegraad: " + longitude2);
        LatitudeEdit.setText("Huidige Breedtegraad: " + latitude2);
    }

}







