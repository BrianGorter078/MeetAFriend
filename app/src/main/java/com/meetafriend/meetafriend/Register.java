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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Register extends Activity implements View.OnClickListener {

    private EditText user, pass, email, age;
    private Button bLogin;
    // Progress Dialog
    private ProgressDialog pDialog;
    // JSON parser class
    JSONParser jsonParser = new JSONParser();
    private static final String REGISTER_URL = "http://boermedia.com/maf/register.php";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private String gender;
    private String gender_want;
    RadioGroup rg;
    int pos;
    int pos1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = (EditText) findViewById(R.id.usernameRegister);
        pass = (EditText) findViewById(R.id.passwordRegister);
        email = (EditText) findViewById(R.id.emailRegister);
        age = (EditText) findViewById(R.id.ageRegister);
        //gender = (RadioButton) findViewById(R.id.youAreRadiobuttonFemale);
        bLogin = (Button) findViewById(R.id.makeAccountButton);
        bLogin.setOnClickListener(this);

        TextView toolbarTextview = (TextView) findViewById(R.id.toolbarTextview);
        toolbarTextview.setText("Register");
//        ImageButton toolbarFriends = (ImageButton) findViewById(R.id.toolbarFriends);
//        toolbarFriends.setVisibility(View.INVISIBLE);
//        ImageButton toolbarSettings = (ImageButton) findViewById(R.id.toolbarSettings);
//        toolbarSettings.setVisibility(View.INVISIBLE);


        rg = (RadioGroup) findViewById(R.id.radio_gender);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                // Method 1 For Getting Index of RadioButton
                pos=rg.indexOfChild(findViewById(checkedId));

                Toast.makeText(getBaseContext(), "Method 1 ID = "+String.valueOf(pos),
                        Toast.LENGTH_SHORT).show();

                //Method 2 For Getting Index of RadioButton
                pos1=rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

                Toast.makeText(getBaseContext(), "Method 2 ID = "+String.valueOf(pos1),
                        Toast.LENGTH_SHORT).show();

                switch (pos)
                {
                    case 0 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 1",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 2",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 3",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        //The default selection is RadioButton 1
                        Toast.makeText(getBaseContext(),"You have Clicked RadioButton 1" ,
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


    }
    public void onClick(View v) {
        new AttemptRegister().execute(); // here we have used, switch case, because on login activity you may //also want to show registration button, so if the user is new ! we can go the //registration activity , other than this we could also do this without switch //case.
    }
    class AttemptRegister extends AsyncTask<String, String, String> {
        /**
         * Before starting background thread Show Progress Dialog *
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Attempting to register...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // here Check for success tag
            int success;
            String register_username = user.getText().toString();
            String register_password = pass.getText().toString();
            String register_emailaddress = email.getText().toString();
            String register_age = "0"; //String register_age = age.getText().toString();
            //String register_gender = gender.toString();
            //System.out.println(register_gender);

            if(user.length()!= 0){
                try {
                    List<NameValuePair> params = new ArrayList<NameValuePair>();
                    params.add(new BasicNameValuePair("username", register_username));
                    params.add(new BasicNameValuePair("password", register_password));
                    params.add(new BasicNameValuePair("email", register_emailaddress));
                    params.add(new BasicNameValuePair("age", register_age));
                    //params.add(new BasicNameValuePair("gender", register_gender));

                    //params.add(new BasicNameValuePair("gender", gender));
                    //Log.d("request!", "starting");
                    JSONObject json = jsonParser.makeHttpRequest(REGISTER_URL, "POST", params); // checking log for json response
                    //Log.d("Login attempt", json.toString()); // success tag for json
                    success = json.getInt(TAG_SUCCESS);
                    if (success == 1) {
                        Log.d("Successfully registered!", json.toString());
                        Intent ii = new Intent(Register.this, Home.class);
                        finish(); // this finish() method is used to tell android os that we are done with current //activity now! Moving to other activity
                        startActivity(ii);

                    } else if(success == 0){

                        return json.getString(TAG_MESSAGE);

                    } else{
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
                Toast.makeText(Register.this, message, Toast.LENGTH_LONG).show();
            }
            //email.setError("Test...");
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

    public void checkbuttonsFemale(View view) {
        RadioButton female = (RadioButton) findViewById(R.id.gender1);
        RadioButton male = (RadioButton) findViewById(R.id.gender0);
        RadioButton male2 = (RadioButton) findViewById(R.id.youWantRadiobuttonMale);
        RadioButton female2 = (RadioButton) findViewById(R.id.youWantRadiobuttonFemale);

        if(female.isChecked()) {
            gender = "F";
            male.setChecked(false);
            female.setChecked(true);
            System.out.println(gender.toString());
        }
        else if(!female.isChecked()) {
            male.setChecked(true);
            female.setChecked(false);
        }

        if(female2.isChecked()) {
            gender = "F";
            male2.setChecked(false);
            female2.setChecked(true);
            System.out.println(gender.toString());
        }
        else if(!female2.isChecked()) {
            gender_want = "M";
            male2.setChecked(true);
            female2.setChecked(false);
        }
    }

    public void checkbuttonsMale(View view) {
        RadioButton male = (RadioButton) findViewById(R.id.gender0);
        RadioButton female = (RadioButton) findViewById(R.id.gender1);
        RadioButton male2 = (RadioButton) findViewById(R.id.youWantRadiobuttonMale);
        RadioButton female2 = (RadioButton) findViewById(R.id.youWantRadiobuttonFemale);

        if(male.isChecked()) {
            gender = "M";
            male.setChecked(true);
            female.setChecked(false);
            System.out.println(gender.toString());
        }
        else if(!male.isChecked()) {
            male.setChecked(false);
            female.setChecked(true);
        }

        if(male2.isChecked()) {
            gender_want = "M";
            male2.setChecked(true);
            female2.setChecked(false);
            System.out.println(gender.toString());
        }
        else if(!male2.isChecked()) {
            gender_want = "F";
            male2.setChecked(false);
            female2.setChecked(true);
        }
    }
}
