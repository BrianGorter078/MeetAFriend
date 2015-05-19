package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class signin extends Activity {

    String loginUsername = "Brian";
    String LoginPassword = "123";
    String inputUsername;
    String inputPassword;


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
    EditText un,pw;
    TextView error;
    Button ok;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        un = (EditText) findViewById(R.id.username);
        pw = (EditText) findViewById(R.id.password);
        ok = (Button) findViewById(R.id.button);
        error = (TextView) findViewById(R.id.error);
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
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);



        inputUsername = username.getText().toString();
        inputPassword = password.getText().toString();
        inputUsername = inputUsername.trim();

        System.out.println(inputUsername + " = " + loginUsername);
        System.out.println(inputPassword + " = " + LoginPassword);

        if(inputUsername.equals(loginUsername) && inputPassword.equals(LoginPassword))
        {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }
        else
        {
            username.setText("");
        }



    }

    public void register(View view) {

    }


}
