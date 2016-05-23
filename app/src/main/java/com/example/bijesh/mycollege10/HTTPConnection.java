package com.example.bijesh.mycollege10;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;

public class
		HTTPConnection {

	Context context;
	public HTTPConnection(Context context){
		this.context = context;
	}
	
	
	public boolean isNetworkConnection(){
		ConnectivityManager cm = ((ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE));
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if(ni == null)
		{
			return false;
		}
		return true;
	}
	
	
	public String HTTPGetData(String url, ArrayList<BasicNameValuePair> params){
		return HTTPGetData(url + "?" + URLEncodedUtils.format(params,"utf-8"));
	}
	
	
	public String HTTPGetData(String url){
		try {
			HttpGet request = new HttpGet(new URI(url));
			HttpResponse response = new DefaultHttpClient().execute(request);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
	}
	public String HTTPPostData(String url, ArrayList<BasicNameValuePair> params){
		try {
			HttpPost request = new HttpPost(new URI(url));
			request.setEntity(new UrlEncodedFormEntity(params));
			HttpResponse response = new DefaultHttpClient().execute(request);
			HttpEntity httpEntity = response.getEntity();
			return EntityUtils.toString(httpEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
		
	}
	
}
