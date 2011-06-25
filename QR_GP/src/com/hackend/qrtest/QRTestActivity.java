package com.hackend.qrtest;

import android.app.Activity;
import com.google.zxing.integration.android.IntentIntegrator;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class QRTestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Capture our button from layout
        Button button = (Button)findViewById(R.id.QRButton);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(mScan);
       // TextView tv = new TextView(this);
        //tv.setText("Its QR time!");
        //setContentView(tv);
    }
    
    public Button.OnClickListener mScan = new Button.OnClickListener() {
        public void onClick(View v) {
        	Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.setPackage("com.google.zxing.client.android");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
            startActivityForResult(intent, 0);
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                
                /*Next step is to call a method that would contact the server with the following params:
                 * 1. Device ID (to register the device)
                 * 2. Scanned QR code
                 * 
                 * If server replies "yes":
                 * 	- persist the QR code on the phone
                 * 	- inform the user that "the device has been authorized"
                 * else:
                 * 	- inform the user that "authorization failed" */
                
                authenticateUsingQR(userId, contents, deviceId)
                System.out.println(contents);
                System.out.print(format);
                
                
                // Handle successful scan
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
            	/* If QR code can not be scanned, inform the user and present the alternate authorization technique 
            	 * (using username and password)*/
            	
            }
        }
    }
    
}