package org.android.hcl.fragments;

import org.android.adapters.CheatsFragmentAdapter;
import org.android.hcl.DetailsActivity;
import org.android.hcl.R;
import org.android.hcl.entities.Channel;
import org.android.hcl.entities.Rss;
import org.android.hcl.parser.FeedListener;
import org.android.hcl.parser.FeedLoader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;

public class CheatsFragment extends SherlockListFragment implements FeedListener{

	public static final String TAG = CheatsFragment.class.getName();
	
	private Channel channel;
	private FeedLoader feedLoader;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		feedLoader = new FeedLoader(getSherlockActivity(), getString(R.string.feed_hcl_cheats), "feed_hcl_cheats", this);
		feedLoader.execute();
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public void onStop() {
		if(feedLoader != null){
			feedLoader.cancel(true);
		}
		super.onStop();
	}

	@Override
	public void onFeedAvailable(Rss feed) {
		
		channel = feed.getChannel();
		CheatsFragmentAdapter adapter = new CheatsFragmentAdapter(channel.getItems(), getSherlockActivity());
		setListAdapter(adapter);
	}
	
	@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
		Bundle b = new Bundle();
		b.putSerializable(getString(R.string.bundle_feed), channel);
		b.putInt(getString(R.string.bundle_position), position);
		Intent intent = new Intent(getSherlockActivity(), DetailsActivity.class);
		intent.putExtras(b);
		startActivity(intent);
		}
}
