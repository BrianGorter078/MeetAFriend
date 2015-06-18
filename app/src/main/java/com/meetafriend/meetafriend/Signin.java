package com.meetafriend.meetafriend;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Signin extends Activity implements OnClickListener, LocationListener {

    public static final String PREFS_NAME = "Login";

    String username;
    String password;
    private EditText user, pass;
    private Button bLogin;
    // Progress Dialog
    private ProgressDialog pDialog;
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    private static final String LOGIN_URL = "http://boermedia.com/maf/login.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_NO_CONNECTION = "No internet connection";
    private String provider;

    double longitude;
    double latitude;

    double offsetMeters1;
    double offsetMeters2;

    android.location.Location location;
    Location location1;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
//        latitude = (EditText) findViewById(R.id.latitude);
//        longitude = (EditText) findViewById(R.id.longitude);


        bLogin = (Button) findViewById(R.id.loginButton);
        bLogin.setOnClickListener(this);

        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setVisibility(View.INVISIBLE);
        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setVisibility(View.INVISIBLE);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        provider = LocationManager.GPS_PROVIDER;
        System.out.println(provider);
        location = locationManager.getLastKnownLocation(provider);
        System.out.println(location);


        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            latitude = location.getLatitude();
            longitude = location.getLongitude();

            String latitude2 = String.valueOf(latitude);
            String longitude2 = String.valueOf(longitude);

            com.meetafriend.meetafriend.Location location1 = new com.meetafriend.meetafriend.Location();
            location1.setLatitude(latitude2);
            location1.setLongitude(longitude2);
            System.out.print("Locatieeee");

            if (location1.getLatitude() != null && location1.getLongitude() != null) {
                locationManager.removeUpdates(this);
                System.out.print("We hebben er 1!!");
            }

        } else {
            //Do something without location
            System.out.print("Geen locatie");
        }



        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        username = settings.getString("Username", null);
        password = settings.getString("Password", null);

        user.setText(username);
        pass.setText(password);


    }

    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("Username",username);
        editor.putString("Password",password);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                username = user.getText().toString();
                password = pass.getText().toString();

                new AttemptLogin().execute(); // here we have used, switch case, because on login activity you may //also want to show registration button, so if the user is new ! we can go the //registration activity , other than this we could also do this without switch //case.
            default:
                break;
        }
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

        String latitude2 = String.valueOf(latitude);
        String longitude2 = String.valueOf(longitude);

        location1.setLatitude(latitude2);
        location1.setLongitude(longitude2);

        System.out.print("Nieuwe locatie !!" + latitude2 + "" + longitude2);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        locationManager.removeUpdates(this);
    }

    @Override
    public void onProviderEnabled(String provider) {


    }

    @Override
    public void onProviderDisabled(String provider) {
        locationManager.removeUpdates(this);
    }

    class AttemptLogin extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog *
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Signin.this);
            pDialog.setMessage("Attempting for login...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            offsetMeters1 = 10000;
            offsetMeters2 = 10000;

            LatLongCalculator latLongCalculator = new LatLongCalculator();
            latLongCalculator.offset(latitude, longitude, offsetMeters1, offsetMeters2);

            provider = LocationManager.GPS_PROVIDER;
            location = locationManager.getLastKnownLocation(provider);

            //System.out.print("Yeahhh");

            // here Check for success tag
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            String latitude_db = String.valueOf(latitude);
            String longitude_db = String.valueOf(longitude);


            if (Location.isNetworkAvailable(Signin.this)) {
                // available network
                if (user.length() != 0 && pass.length() != 0) {
                    try {
                        List<NameValuePair> params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("username", username));
                        params.add(new BasicNameValuePair("password", password));
                        params.add(new BasicNameValuePair("latitude", latitude_db));
                        params.add(new BasicNameValuePair("longitude", longitude_db));
                        //Log.d("request!", "starting");
                        JSONObject json = jsonParser.makeHttpRequest(LOGIN_URL, "POST", params); // checking log for json response
                        //Log.d("Login attempt", json.toString()); // success tag for json
                        success = json.getInt(TAG_SUCCESS);
                        if (success == 1) {
                            Log.d("Successfully Login!", json.toString());
                            Intent ii = new Intent(Signin.this, Home.class);
                            finish(); // this finish() method is used to tell android os that we are done with current //activity now! Moving to other activity
                            startActivity(ii);
                            return json.getString(TAG_MESSAGE);
                        } else {
                            return json.getString(TAG_MESSAGE);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Intent restart = new Intent(Signin.this, Signin.class);
                        startActivity(restart);
                    }


                }


            } else {
                return TAG_NO_CONNECTION;
            }
            return null;
        }

        /**
         * Once the background process is done we need to Dismiss the progress dialog asap * *
         */
        protected void onPostExecute(String message) {
            pDialog.dismiss();
            if (message != null) {
                Toast.makeText(Signin.this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
