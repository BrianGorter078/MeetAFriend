package com.meetafriend.meetafriend;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Signin extends Activity implements OnClickListener {
    private EditText user, pass;
    private Button bLogin;
    // Progress Dialog
    private ProgressDialog pDialog;
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    private static final String LOGIN_URL = "http://boermedia.com/maf/login.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        bLogin = (Button) findViewById(R.id.loginButton);
        bLogin.setOnClickListener(this);

        ImageButton toolbarBack = (ImageButton) findViewById(R.id.toolbarBack);
        toolbarBack.setVisibility(View.INVISIBLE);
        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
        toolbarFriends.setVisibility(View.INVISIBLE);
        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
        toolbarSettings.setVisibility(View.INVISIBLE);
    }

    public void register(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) { // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.loginButton:
                new AttemptLogin().execute(); // here we have used, switch case, because on login activity you may //also want to show registration button, so if the user is new ! we can go the //registration activity , other than this we could also do this without switch //case.
            default:
                break;
        }
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
                }
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
