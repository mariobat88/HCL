package org.android.adapters;

import java.util.List;

import org.android.hcl.R;
import org.android.hcl.entities.Item;
import org.android.hcl.util.HCLImageView;
import org.android.hcl.util.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewsFragmentAdapter extends BaseAdapter{

	private List<Item> items;
	private Context context;
	
	public NewsFragmentAdapter(List<Item> items, Context context) {
		this.items = items;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return items.indexOf(items.get(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Item item = items.get(position);
		View view = convertView;
		
		if(view == null){
			LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.fragment_news_list_item, null);
		}
		
		TextView title = (TextView) view.findViewById(R.id.news_list_item_title);
		title.setText(item.getTitle());
		
		ProgressBar progress = (ProgressBar) view.findViewById(R.id.news_list_item_progress);
		progress.setIndeterminate(true);
		
		HCLImageView image= (HCLImageView) view.findViewById(R.id.news_list_item_image);
		Util.DownloadImage(context, item.getImage(), image, progress);
		
		return view;
	}

}
