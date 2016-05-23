package com.example.bijesh.mycollege10;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.effectivenavigation.R;

/**
 * Created by Bijesh on 8/14/2015.
 */
public class Sciencedetails extends FragmentActivity {
    ImageView call;
    TextView websites;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.college_details);


            Colleges c = (Colleges) getIntent().getSerializableExtra("college");

            ((TextView) findViewById(R.id.name)).setText(c.getName());

            ((TextView) findViewById(R.id.address)).setText(c.getAddress());
        ((TextView)findViewById(R.id.faculties)).setText(c.getFaculties());

          ((TextView) findViewById(R.id.contact)).setText("0"+c.getContact());

        ((TextView) findViewById(R.id.websites)).setText(c.getWebsites());

        ((TextView) findViewById(R.id.coldtails)).setText(c.getDetails());


//call option direct call
       /* call = (ImageView) findViewById(R.id.call);
           call.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   TextView callnow =(TextView)findViewById(R.id.contact);
                   String uri = "tel:" + callnow.getText().toString();
                   Intent intent = new Intent(Intent.ACTION_CALL);
                   intent.setData(Uri.parse(uri));
                   startActivity(intent);
               }
           });*/

        //website clickable

   websites = (TextView) findViewById(R.id.websites);
           websites.setOnClickListener(new View.OnClickListener(){

               @Override
               public void onClick(View v) {
                   TextView web = (TextView)findViewById(R.id.websites);
                   web .setText(websites.getText().toString());
                   Linkify.addLinks(web, Linkify.WEB_URLS);
               }
           });


      }
}
