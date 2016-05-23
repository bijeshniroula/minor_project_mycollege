package com.example.bijesh.mycollege10;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.effectivenavigation.R;

/**
 * Created by Bijesh on 9/15/2015.
 */
public class Addressfind extends FragmentActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);  // Set up GUI

        final EditText addressfield = (EditText) findViewById(R.id.ad);  // Reference edit field
        final Button launchmapbtn = (Button) findViewById(R.id.addbtn);  // Reference search button
        launchmapbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                try {
                    String address = addressfield.getText().toString(); // Get address
                    address = address.replace(' ', '+');
                    Intent geoIntent = new Intent (android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=colleges"));
                  // geoIntent.setPackage("com.example.bijesh.mycollege10.maps");// Prepare intent
                    startActivity(geoIntent);	// Initiate lookup
                }
                catch (Exception e){


                }
            }
        });
    }
}