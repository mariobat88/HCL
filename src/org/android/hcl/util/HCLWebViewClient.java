package org.android.hcl.util;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class HCLWebViewClient extends WebViewClient{

	private SherlockFragmentActivity activity;
	
	public HCLWebViewClient(SherlockFragmentActivity sherlockFragmentActivity) {
		this.activity = sherlockFragmentActivity;
	}
	
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		return true;
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		activity.setProgressBarIndeterminateVisibility(false);
		super.onPageFinished(view, url);
	}
	
}
