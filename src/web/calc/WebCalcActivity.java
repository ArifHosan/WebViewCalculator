package web.calc;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class WebCalcActivity extends Activity {
	private static final String URL="file:///android_asset/calc.html";
	private static final String URL2="file:///android_asset/calc2.html";
	private WebView webView;
	
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebApp(this), "Android");
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
    }
    
    public boolean isOnline() {
    	ConnectivityManager cm =
    	        (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    	    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    	    return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    
	@Override
	protected void onResume() {
		super.onResume();
		if(isOnline()) {
			Toast.makeText(this, "Internet Available. Loading Calculator from Remote Server", Toast.LENGTH_SHORT).show();
			webView.loadUrl(URL);
		}
		else {
			Toast.makeText(this, "Internet Not Available. Loading Calculator from Asset", Toast.LENGTH_SHORT).show();
			webView.loadUrl(URL2);
		}
		
		//webView.loadUrl("javascript:document.body.style.width = '1000px';");
		//webView.loadUrl("javascript:document.body.style.height = '100%';");
	}
    
}