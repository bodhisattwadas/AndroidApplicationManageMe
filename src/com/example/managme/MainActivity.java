package com.example.managme;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements AnimationListener {
	private final String fontPath = "fonts/DOBRA_LIGHT.OTF";
	private Typeface typeface;
	private Animation animFadein;
	private TextView textView;
	private Button button;
	private Handler handler = new Handler();
	private ImageView imageView1,imageView2;
	private final int timeDelay = 7000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), fontPath);
		textView = (TextView)findViewById(R.id.textView1);
		imageView1 = (ImageView)findViewById(R.id.imageView1);
		imageView2 = (ImageView)findViewById(R.id.imageView2);
		textView.setTypeface(typeface,Typeface.BOLD);
		
		button = (Button)findViewById(R.id.button1);
		button.setTypeface(typeface,Typeface.BOLD);
		button.setText("Enter");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(),Instructions.class));
				
			}
		});
		// load the animation
        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        // set animation listener
        animFadein.setAnimationListener(this);
       // TODO Auto-generated method stub
				textView.setVisibility(View.VISIBLE);
				textView.startAnimation(animFadein);
				
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						textView.setText(getResources().getString(R.string.string_two));
						textView.setVisibility(View.VISIBLE);
						textView.startAnimation(animFadein);
						handler.postDelayed(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								textView.setText(getResources().getString(R.string.string_three));
								textView.setVisibility(View.VISIBLE);
								textView.startAnimation(animFadein);
								handler.postDelayed(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										textView.setText(getResources().getString(R.string.string_four));
										textView.setVisibility(View.VISIBLE);
										textView.startAnimation(animFadein);
										handler.postDelayed(new Runnable() {
											
											@Override
											public void run() {
												// TODO Auto-generated method stub
												textView.setText(getResources().getString(R.string.string_five));
												textView.setVisibility(View.VISIBLE);
												textView.startAnimation(animFadein);
												handler.postDelayed(new Runnable() {
													
													@Override
													public void run() {
														// TODO Auto-generated method stub
														imageView1.setImageDrawable(getResources().getDrawable(R.drawable.logo_icon));
														imageView2.setImageDrawable(getResources().getDrawable(R.drawable.text_icon));
														imageView1.setVisibility(View.VISIBLE);
														imageView2.setVisibility(View.VISIBLE);
														imageView1.startAnimation(animFadein);
														imageView2.startAnimation(animFadein);
														textView.setText("");
													}
												}, timeDelay);
											}
										}, timeDelay);
									}
								}, timeDelay);
							}
						}, timeDelay);
					}
				}, timeDelay);
				
			}	
        

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
	/**	if (animation == animFadein) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }*/
	//	textView.setText(getResources().getString(R.string.string_two));
		
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}
	

}
