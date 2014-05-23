package com.example.managme;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
@SuppressLint("SetJavaScriptEnabled")
public class Instructions extends Activity {
	private WebView webView ;
	private Button button;
	private final String fontPath = "fonts/DOBRA_LIGHT.OTF";
	private Typeface typeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
		webView = (WebView)findViewById(R.id.webView);
		button = (Button)findViewById(R.id.button1);
		typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), fontPath);
		button.setTypeface(typeface,Typeface.BOLD);
		WebSettings s = webView.getSettings();
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
	        s.setAllowUniversalAccessFromFileURLs(true);
	        s.setAllowFileAccessFromFileURLs(true);
	    }
		
		webView.loadUrl("file:///android_asset/www/index.html");
		webView.getSettings().setJavaScriptEnabled(true);
	    webView.getSettings().setSaveFormData(true);
	    webView.getSettings().setBuiltInZoomControls(true);
	    webView.setWebViewClient(new MyWebViewClient());
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_instructions, menu);
		return true;
	}
	private class MyWebViewClient extends WebViewClient 
	{ 
	    @Override 
	    //show the web page in webview but not in web browser
	    public boolean shouldOverrideUrlLoading(WebView view, String url) { 
	        view.loadUrl (url); 
	        return true;
	    }
	}

}
