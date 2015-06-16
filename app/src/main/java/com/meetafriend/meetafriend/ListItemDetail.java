package com.meetafriend.meetafriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by weseykone on 16-6-2015.
 */
public class ListItemDetail extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        // Here we turn your string.xml in an array
        String[] myKeys = getResources().getStringArray(R.array.hobbies);

        TextView myTextView = (TextView) findViewById(R.id.list_item_textview);
        myTextView.setText(myKeys[position]);


    }

}
