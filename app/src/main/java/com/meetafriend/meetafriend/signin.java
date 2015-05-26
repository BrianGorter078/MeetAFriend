package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;
import java.util.List;


public class signin extends AppCompatActivity {

//    Object[] object;


    //
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signin);
////        ImageView homeGalery = (ImageView) findViewById(R.id.gallery);
////        homeGalery.setImageResource(R.drawable.signin2);
//
//
//    }
    boolean a;
    EditText un, pw;
    TextView error;
    Button ok;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        un = (EditText) findViewById(R.id.username);
        pw = (EditText) findViewById(R.id.password);
        ok = (Button) findViewById(R.id.loginButton);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
//        setSupportActionBar(toolbar);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "AtJHSuDCGrtUquV7JKUI6cyn32sj313AbBXBH6UY", "reP6s8xtAOVXYBow3d0QZ6g7Qr1HD9yhEv07uavR");






//        error = (TextView) findViewById(R.id.error);
//        ok.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//
//            public void onClick(View view) {
//                System.out.println("1...");
//                ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
//                postParameters.add(new BasicNameValuePair("name", un.getText().toString()));
//                postParameters.add(new BasicNameValuePair("password", pw.getText().toString()));
//
////String valid = "1";
//                String response = null;
//                try {
//                    response = CustomHttpClient.executeHttpPost("http://boermedia.com/maf/connect.php", postParameters);  //Enetr Your remote PHP,ASP, Servlet file link
//                    System.out.println("2...");
//                    String res = response.toString();
//                    System.out.println("3...");
//// res = res.trim();
//                    res = res.replaceAll("\\s+", "");
////error.setText(res);
//                    System.out.println("4...");
//                    if (res.equals("1"))
//                        error.setText("Correct Username or Password");
//                    else
//                        error.setText("Sorry!! Incorrect Username or Password");
//
//                } catch (Exception e) {
//                    System.out.println("TEST...");
//                    un.setText(e.toString());
//                    System.out.println(e.toString());
//                    e.printStackTrace();
//
//                }
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signin, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search)
        {

            return true;
        }
        if (id == R.id.action_user)
        {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);

    }

    public void register(View view) {



        TextView us = (TextView) findViewById(R.id.username);
        TextView ps = (TextView) findViewById(R.id.password);

        String us1 =  us.getText().toString();
        String ps1 =  ps.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(us1);
        user.setPassword(ps1);
        user.setEmail("email@example.com");

        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {

            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    System.out.println("Geslaagd");
                } else {
                    System.out.println("Mislukt");
                }
            }
        });

        }



    public boolean logins(boolean a) {

        return a;
    }
}
