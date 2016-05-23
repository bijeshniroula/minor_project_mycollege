package com.example.bijesh.mycollege10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.effectivenavigation.R;

/**
 * Created by Bijesh on 8/26/2015.
 */
public class Facultieslist extends Activity {
    HTTPConnection http;
    LinearLayout science;
    LinearLayout management;
    LinearLayout humanities;

    //HTTPConnection http;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facultieslist);

        science = (LinearLayout) findViewById(R.id.science);

        http = new HTTPConnection(getApplicationContext());
        science.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(http.isNetworkConnection())
                {
                    Intent mainIntent =new Intent(getApplicationContext(),Sciencecollege.class);

                    startActivity(mainIntent);
                }

                else {
                    Toast.makeText(getApplication()," Not Connected", Toast.LENGTH_SHORT).show();
                }

            }
        });





        //onclick on management
        management = (LinearLayout) findViewById(R.id.management);

        http = new HTTPConnection(getApplicationContext());

        management.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(http.isNetworkConnection())
                {
                    Intent mainIntent =new Intent(getApplicationContext(),Managementcollege.class);

                    startActivity(mainIntent);
                }

                else {
                    Toast.makeText(getApplication()," Not Connected", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //humanities click


        humanities = (LinearLayout) findViewById(R.id.humanities);

        http = new HTTPConnection(getApplicationContext());
        humanities.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(http.isNetworkConnection())
                {
                    Intent mainIntent =new Intent(getApplicationContext(),Humanitiescollege.class);

                    startActivity(mainIntent);
                }

                else {
                    Toast.makeText(getApplication()," Not Connected", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }


}




