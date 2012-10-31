package org.android.adapters;

import org.android.hcl.entities.Channel;
import org.android.hcl.fragments.DetailsFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DetailsActivityViewPagerAdapter extends FragmentPagerAdapter{

	private Channel channel;
	
	public DetailsActivityViewPagerAdapter(Channel channel, FragmentManager fm) {
		super(fm);
		this.channel = channel;
	}	
	
	@Override
	public Fragment getItem(int position) {
		DetailsFragment fragment = new DetailsFragment(channel, position);
		return fragment;
	}

	@Override
	public int getCount() {
		return channel.getItems().size();
	}

	
	
}
