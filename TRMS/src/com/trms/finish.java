package com.trms;

import com.trms.test.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class finish extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.finish);

		// setup is finished
		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				authorizer.havePassword();
				//startActivity(new Intent(getBaseContext(), pwdInput.class));
				Toast.makeText(finish.this, "Setup is finished!", Toast.LENGTH_SHORT).show();
			}
		});


	}
}