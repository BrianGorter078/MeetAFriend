package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;


public class signin extends Activity {

    String loginUsername = "Brian";
    String LoginPassword = "123";
    String inputUsername;
    String inputPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        ImageView homeGalery = (ImageView) findViewById(R.id.gallery);
        homeGalery.setImageResource(R.drawable.signin2);


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

        if(inputUsername == loginUsername && inputPassword == LoginPassword);
        {
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        }

    }

    public void register(View view) {

    }
}
