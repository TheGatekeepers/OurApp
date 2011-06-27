package com.test.android.trms;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TRMSActivity extends Activity
{
	/** Called when the activity is first created. */
	private LinearLayout linearLayoutMain;
	private TextView testText, testText2;
	private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, 
	imageView7, imageView8, imageView9;
	private float startX = 0, startY = 0, endX = 0, endY = 0;
	private String directionsCheck = "updownleftup";
	private ArrayList<Integer> imageCheck = new ArrayList<Integer>();
	private String directionsList = "";
	private ArrayList<Integer> imageList = new ArrayList<Integer>();
	private int gestureCounter = 0;
	private float radius = 20;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gesturelayout1);
		imageCheck.add(2130968577);imageCheck.add(2130968577);imageCheck.add(2130968577);imageCheck.add(2130968577);
		testText = (TextView) findViewById(R.id.textView1);
		testText2 = (TextView) findViewById(R.id.textView2);
		linearLayoutMain = (LinearLayout) findViewById(R.id.Linear_Vertical_Main);
		imageView1 = (ImageView) findViewById(R.integer.image1);
		imageView2 = (ImageView) findViewById(R.integer.image2);
		imageView3 = (ImageView) findViewById(R.integer.image3);
		imageView4 = (ImageView) findViewById(R.integer.image4);
		imageView5 = (ImageView) findViewById(R.integer.image5);
		imageView6 = (ImageView) findViewById(R.integer.image6);
		imageView7 = (ImageView) findViewById(R.integer.image7);
		imageView8 = (ImageView) findViewById(R.integer.image8);
		imageView9 = (ImageView) findViewById(R.integer.image9);
		linearLayoutMain.setOnTouchListener(myTouchListener);
		
		imageView1.setOnTouchListener(myTouchListener);
		imageView2.setOnTouchListener(myTouchListener);
		imageView3.setOnTouchListener(myTouchListener);
		imageView4.setOnTouchListener(myTouchListener);
		imageView5.setOnTouchListener(myTouchListener);
		imageView6.setOnTouchListener(myTouchListener);
		imageView7.setOnTouchListener(myTouchListener);
		imageView8.setOnTouchListener(myTouchListener);
		imageView9.setOnTouchListener(myTouchListener);
	}

	public OnTouchListener myTouchListener = new OnTouchListener()
	{
		public boolean onTouch(View v, MotionEvent event)
		{
			switch (event.getAction())
			{
				case (MotionEvent.ACTION_DOWN):
				{	
					imageList.add(v.getId());
					testText2.setText(imageList.toString());
					startX = event.getX();
					startY = event.getY();
					break;
				}
				case (MotionEvent.ACTION_UP):
				{
					endX = event.getX();
					endY = event.getY();
					float dx = endX - startX;
					float dy = endY - startY;
					if (Math.sqrt(Math.pow(dx, 2) + (Math.pow(dy, 2))) > radius)
					{
						gestureCounter++;
						// Use dx and dy to determine the direction
						if (Math.abs(dx) > Math.abs(dy))
						{
							if (dx > 0)
							{
								directionsList = directionsList + "right";
							}
							else
							{
								directionsList = directionsList + "left";
							}
						}
						else
						{
							if (dy > 0)
							{
								directionsList = directionsList + "down";
							}
							else
							{
								directionsList = directionsList + "up";
							}
						}
					}
					else
					{
						imageList.remove(imageList.size()-1);
					}
				}
			}
			if(gestureCounter >= 4)
			{
				//TODO: go to next activity
				if(directionsList.equals(directionsCheck) && imageList.equals(imageCheck))
				{
					Context context = getApplicationContext();
					CharSequence text = "Success!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
					directionsList = "";
					imageList = new ArrayList<Integer>();
					gestureCounter = 0;
				}
				else
				{
					Context context = getApplicationContext();
					CharSequence text = "Fail!";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
					directionsList = "";
					imageList = new ArrayList<Integer>();
					gestureCounter = 0;
				}
			}
			else
			{
				testText.setText(directionsList);
			}
			

			return true;
		}
	};
	

	/*
	 * @Override public void onCreate(Bundle savedInstanceState) {
	 * super.onCreate(savedInstanceState);
	 * setContentView(R.layout.gesturelayout);
	 * 
	 * LinearLayout itemsGrid =
	 * (LinearLayout)findViewById(R.id.Linear_Vertical_Main);
	 * itemsGrid.setOnTouchListener(new View.OnTouchListener() {
	 * 
	 * public boolean onTouch(View v, MotionEvent event) { float initialX = 0;
	 * float initialY = 0; float finalX = 0; float finalY = 0; float changeInX
	 * =0; final float radius = 10; switch (event.getAction() &
	 * MotionEvent.ACTION_MASK) { case MotionEvent.ACTION_DOWN: initialX =
	 * event.getX(); initialY = event.getY(); break; case MotionEvent.ACTION_UP:
	 * finalX = event.getX(); finalY = event.getY(); break; }
	 * if(Math.sqrt(Math.pow(finalX-initialX, 2) + (Math.pow(finalY-initialY,
	 * 2))) > radius) {
	 * 
	 * } return false; } });
	 * 
	 * }
	 */
}