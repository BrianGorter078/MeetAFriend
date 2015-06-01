package com.meetafriend.meetafriend;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Register extends Activity implements View.OnClickListener {

    private EditText user, pass;
    private Button bLogin;
    // Progress Dialog
    private ProgressDialog pDialog;
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    private static final String REGISTER_URL = "http://boermedia.com/maf/register.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


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
    public void onClick(View v) { // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.makeAccountButton:
                new AttemptRegister().execute(); // here we have used, switch case, because on login activity you may //also want to show registration button, so if the user is new ! we can go the //registration activity , other than this we could also do this without switch //case.
            default:
                break;
        }
    }
    class AttemptRegister extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog *
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            pDialog = new ProgressDialog(Register.this);
//            pDialog.setMessage("Attempting for login...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // here Check for success tag
            int success;
            String username = user.getText().toString();
            String password = pass.getText().toString();
            if(user.length()!=0 && pass.length()!=0)
            {
                try {
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("username", username));
                    params.add(new BasicNameValuePair("password", password));
                    //Log.d("request!", "starting");
                    JSONObject json = jsonParser.makeHttpRequest(REGISTER_URL, "POST", params); // checking log for json response
                    //Log.d("Login attempt", json.toString()); // success tag for json
                    success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        Log.d("Successfully Login!", json.toString());
                        Intent ii = new Intent(Register.this, Home.class);
                        finish(); // this finish() method is used to tell android os that we are done with current //activity now! Moving to other activity
                        startActivity(ii);
                        return json.getString(TAG_MESSAGE);
                    } else {
                        return json.getString(TAG_MESSAGE);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         * Once the background process is done we need to Dismiss the progress dialog asap * *
         */
        protected void onPostExecute(String message) {
            //pDialog.dismiss();
            if (message != null) {
                Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
            }
        }
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

//    public void createAccount(View view) {
//        Intent intent = new Intent(this, Interests.class);
//        startActivity(intent);
//    }

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
