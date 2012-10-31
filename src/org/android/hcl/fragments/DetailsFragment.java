package org.android.hcl.fragments;

import org.android.hcl.R;
import org.android.hcl.entities.Channel;
import org.android.hcl.util.HCLWebView;
import org.android.hcl.util.HCLWebViewClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class DetailsFragment extends SherlockFragment{

	public static final String TAG = DetailsFragment.class.getName();
	
	private Channel channel;
	private int position;
	private HCLWebViewClient webClient;
	private HCLWebView webView;
	
	public DetailsFragment(Channel channel, int position) {
		this.position = position;
		this.channel = channel;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_details, container, false);
		setupWebView(view);
		return view;
	}

	
	private void setupWebView(View view){
		
		webClient = new HCLWebViewClient(getSherlockActivity());		
		webView = (HCLWebView) view.findViewById(R.id.details_fragment_webview);
		webView.setWebViewClient(webClient);
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.loadUrl(channel.getItems().get(position).getLink());

	}
	
}
