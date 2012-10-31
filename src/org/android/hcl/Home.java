package org.android.hcl;

import org.android.hcl.fragments.AnnouncementsFragment;
import org.android.hcl.fragments.CheatsFragment;
import org.android.hcl.fragments.ColumnsFragment;
import org.android.hcl.fragments.InterviewFragment;
import org.android.hcl.fragments.NewsFragment;
import org.android.hcl.fragments.ReviewFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;

public class Home extends SherlockFragmentActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.home);
		setTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// MenuInflater inflater = getSupportMenuInflater();
		// inflater.inflate(R.menu.home, menu);
		return super.onCreateOptionsMenu(menu);
	}

	private void setTabs() {
		ActionBar actionBar = getSupportActionBar();
		ActionBar.Tab tab = null;

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		tab = actionBar.newTab().setText(R.string.tab_news_title)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.tab_reviews_title)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.tab_announcements_title)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.tab_interview_title)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.tab_columns_title)
				.setTabListener(this);
		actionBar.addTab(tab);

		tab = actionBar.newTab().setText(R.string.tab_cheats_title)
				.setTabListener(this);
		actionBar.addTab(tab);
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		selectTab(tab, ft);

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	private void selectTab(Tab tab, FragmentTransaction ft) {

		if (tab.getText().equals("Vijesti")) {
			if(ft != null){
				ft.replace(android.R.id.content, new NewsFragment());
			} else{
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new NewsFragment());
			}
		} else if (tab.getText().equals("Recenzije")) {

			if (ft != null) {
				ft.replace(android.R.id.content, new ReviewFragment());
			} else {
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new ReviewFragment());
			}

		} else if (tab.getText().equals("Najave")) {

			if (ft != null) {
				ft.replace(android.R.id.content, new AnnouncementsFragment());
			} else {
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new AnnouncementsFragment());
			}

		} else if (tab.getText().equals("Intervju")) {
			
			if (ft != null) {
				ft.replace(android.R.id.content, new InterviewFragment());
			} else {
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new InterviewFragment());
			}

		} else if (tab.getText().equals("Kolumne")) {

			if (ft != null) {
				ft.replace(android.R.id.content, new ColumnsFragment());
			} else {
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new ColumnsFragment());
			}

		} else if (tab.getText().equals("Šifre")) {

			if (ft != null) {
				ft.replace(android.R.id.content, new CheatsFragment());
			} else {
				getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new CheatsFragment());
			}
		}

//		getSupportFragmentManager().executePendingTransactions();
		
	}

}
