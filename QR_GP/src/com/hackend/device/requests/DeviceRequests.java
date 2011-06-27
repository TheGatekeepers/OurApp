package com.hackend.device.requests;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.ResponseHandler;  
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.impl.client.DefaultHttpClient;

import org.json.*;

//import 
public class DeviceRequests {
	
	private DeviceRequests(){}
	
	public static ArrayList<String> getImageURLs(String qrCode)
	{
		HttpClient httpclient = new DefaultHttpClient();  
        HttpGet request = new HttpGet("http://50.18.82.15/" +  "user_order_images.php");
        request.addHeader("x-qr-string", qrCode);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String result="";
        JSONArray jarray;
        ArrayList<String> urlList = new ArrayList<String>();
        try {  
        	result = httpclient.execute(request, handler);
        	JSONObject jObject = new JSONObject(result);
        	jarray = jObject.getJSONArray("image_urls");
        	for(int i=0; i<jarray.length();++i)
        	{
        		urlList.add(jarray.getString(i));
        		System.out.println("jarray["+i+"]="+jarray.getString(i));
        	}
        } catch (ClientProtocolException e) {
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        catch (JSONException e){
        	e.printStackTrace();
        }
        
        System.out.println("result = " + result);
        httpclient.getConnectionManager().shutdown();
		
        return urlList;
		//return false;
	}

}
