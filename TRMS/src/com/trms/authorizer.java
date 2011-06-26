package com.trms;

public class authorizer {
	
	private static boolean mAuthorized = false;
	private static boolean mPassword = false;
	
	public static void authorize(){
		mAuthorized = true;
	}
	
	public static void deauthorize(){
		mAuthorized = false;
	}
	
	public boolean returnStatus(){
		return mAuthorized;
	}
	
	public static void havePassword(){
		mPassword = true;
	}
	
	public static void noPassword(){
		mPassword = false;
	}
	
	public boolean returnPasswordStatus(){
		return mPassword;
	}
	
}
