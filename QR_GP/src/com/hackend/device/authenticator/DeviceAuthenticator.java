package com.hackend.device.authenticator;

import android.provider.Settings.Secure;
import android.content.ContentResolver;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.ResponseHandler;  
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.impl.client.DefaultHttpClient;  


public final class DeviceAuthenticator {

	private DeviceAuthenticator() {}
	
	public static boolean serverRequestForAuthentication(int userId, String qrCode, String deviceID)
	{
			
	        HttpClient httpclient = new DefaultHttpClient();  
	        HttpGet request = new HttpGet("http://50.18.82.15/" +  "device_auth.php");
	        //HttpGet request = new HttpGet("http://google.com/" +  "");
	        request.addHeader("x-device-id", deviceID);
	        request.addHeader("x-qr-string", qrCode);
	        ResponseHandler<String> handler = new BasicResponseHandler();
	        //boolean result = false;
	        String result = "";
	        try {  
	        	result = httpclient.execute(request, handler);
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }
	        System.out.println("result = " + result);
	        httpclient.getConnectionManager().shutdown();
	        System.out.println("result = "+result);
	        return false;
		/*
		if (qrCode.equals("NewlyGeneratedQRString"))
		{
			// persist the deviceID in the server
			// return true
			
			return true;
		}
		else
			return false;
			*/
	}
	
    /*This method contacts the server with the following params:
     * 1. Device ID (to register the device)
     * 2. Scanned QR code
     * 
     * If server replies "yes":
     * 	- persist the QR code on the phone
     * 	- inform the user that "the device has been authenticated"
     * else:
     * 	- inform the user that "authentication failed" */
	public static void authenticateUsingQR(ContentResolver cr, int userId, String qrCode)
	{
		//String deviceID = "TempId";
		
		String android_id = Secure.getString(cr, Secure.ANDROID_ID);
		System.out.println("android_id = "+android_id);
		boolean result = serverRequestForAuthentication(userId, qrCode, android_id);
		
		if(result == true)
		{
			// persist qrCode on the device
			
		}
		else
		{
			// Inform the user that the authentication failed
		}
	}
	
}
