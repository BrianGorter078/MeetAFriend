package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;


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

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        // create manager instance after the content view is set
        SystemBarTintManager mTintManager = new SystemBarTintManager(this);
        // enable status bar tint
        mTintManager.setStatusBarTintEnabled(true);
        mTintManager.setTintColor(getResources().getColor(R.color.colorPrimaryDark));


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

    }

    public boolean logins(boolean a) {

        return a;
    }
}
