package com.trms;

import com.trms.test.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QR extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qr);

		// scan the qrcode

		// temp!

		// login button
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Toast.makeText(QR.this, "Login successful!", Toast.LENGTH_SHORT)
						.show();
				authorizer.authorize();
				startActivity(new Intent(getBaseContext(), unlockSetup.class));
			}
		});
	}
}