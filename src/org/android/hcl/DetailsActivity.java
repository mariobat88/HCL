package org.android.hcl;

import org.android.adapters.DetailsActivityViewPagerAdapter;
import org.android.hcl.entities.Channel;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Window;

public class DetailsActivity extends SherlockFragmentActivity implements OnPageChangeListener{

	private Channel channel;
	private int position;
	
	@Override
	protected void onCreate(Bundle arg0) {
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setProgressBarIndeterminateVisibility(true);
		
		setContentView(R.layout.activity_details);

		if(getIntent() != null){
			channel = (Channel)getIntent().getSerializableExtra(getString(R.string.bundle_feed));
			position = getIntent().getIntExtra(getString(R.string.bundle_position), 0);
		}
		
		setupLayout();
		
		super.onCreate(arg0);
	}
	
	
	private void setupLayout(){
		DetailsActivityViewPagerAdapter adapter = new DetailsActivityViewPagerAdapter(channel, getSupportFragmentManager());
		ViewPager viewPager = (ViewPager) findViewById(R.id.details_viewpager);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
		viewPager.setCurrentItem(position);
		
		
		getSupportActionBar().setTitle(channel.getItems().get(position).getTitle());
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int position) {
		getSupportActionBar().setTitle(channel.getItems().get(position).getTitle());
		
	}
}
