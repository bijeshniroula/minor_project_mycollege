package com.example.bijesh.mycollege10;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.effectivenavigation.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bijesh on 9/9/2015.
 */
public class Managementcollege extends FragmentActivity{

    HTTPConnection http;

    List<Management> management = new ArrayList<Management>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.college_list);
        http = new HTTPConnection(getApplicationContext());
        if (http.isNetworkConnection()) {

            //String data = http.HTTPGetData("http://localhost/minorproject/show.php");
            //Toast.makeText(getApplicationContext(),data ,Toast.LENGTH_LONG).show();
            task.execute();
        }
        else {


            Toast.makeText(getApplicationContext(), "check your connection",
                    Toast.LENGTH_LONG).show();
        }
    }


    AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

        @Override
        protected String doInBackground(Void... params) {
            String data = http.HTTPGetData("http://192.168.164.1/mycollege/managementfaculty.php");
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            populateList(result);
            displayList();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

    };
    protected void populateList(String result) {
        try {
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            JSONObject jobj = new JSONObject(result);
            String res = jobj.getString("success");
            if (!res.equals("true")) {
                Toast.makeText(getApplicationContext(), "JSON Error",
                        Toast.LENGTH_LONG).show();
                return;
            }
            else
            {
                JSONArray data = jobj.getJSONArray("msg");
                //	Toast.makeText(getApplicationContext(),"successss",Toast.LENGTH_SHORT).show();
                for (int i = 0; i < data.length(); i++) {
                    JSONObject col = data.getJSONObject(i);
                    Management cg = new Management(col.getString("name"),
                            col.getString("address"),
                            col.getString("faculties"),

                            col.getString("contact"),
                            col.getString("details"),
                            col.getString("websites"),
                            col.getString("facebook"));

                    management.add(cg);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }


    }


    protected void displayList() {
        ArrayAdapter<Management> adapter = new ArrayAdapter<Management>(this, R.layout.list_item,management){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = getLayoutInflater().inflate(R.layout.list_item,null);
                //set values
                Management c = management.get(position);
                ((TextView)view.findViewById(R.id.name)).setText(c.getName());
                ((TextView)view.findViewById(R.id.address)).setText(c.getAddress());
				/*
((TextView)view.findViewById(R.id.contact)).setText(c.getContact());
				*/
                return view;
            }

        };

        final ListView collegelistnew = (ListView) findViewById(R.id.listView);
        collegelistnew.setAdapter(adapter);

       /* collegelistnew.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
				*//*Toast.makeText(
						getApplicationContext(),
						"You clicked position" + position + "with item name"
								+ college.get(position).getName(),
						Toast.LENGTH_LONG).show();*//*


                Intent newIntent =new Intent(getApplicationContext(),Managementdetails.class);

                newIntent.putExtra("management", management.get(position));
                startActivity(newIntent);



            }

        });*/

    }

}



