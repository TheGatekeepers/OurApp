package com.hackend.device.authenticator;

public final class DeviceAuthenticator {

	private DeviceAuthenticator() {}
	
	// This method needs to exist on the server side part of the app
	public static boolean serverRequestForAuthentication(int userId, String qrCode, String deviceID)
	{
		if (qrCode.equals("NewlyGeneratedQRString"))
		{
			// persist the deviceID in the server
			// return true
			
			return true;
		}
		else
			return false;
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
	public static void authenticateUsingQR(int userId, String qrCode)
	{
		String deviceID;
		boolean result = serverRequestForAuthentication(userId, qrCode, deviceID);
		
		if(result == true)
		{
			
		}
		else
		{
			// Inform the user that the authentication failed
		}
	}
	
}
