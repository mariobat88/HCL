package org.android.adapters;

import java.util.List;

import org.android.hcl.R;
import org.android.hcl.entities.Item;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InterviewFragmentAdapter extends BaseAdapter{

	private List<Item> items;
	private Context context;
	
	public InterviewFragmentAdapter(List<Item> items, Context context) {
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
			view = inflater.inflate(R.layout.fragment_interview_list_item, null);
		}
		
		TextView title = (TextView) view.findViewById(R.id.interview_list_item_title);
		title.setText(item.getTitle());
		
		Spanned descriptionText = Html.fromHtml(item.getDescription());
		TextView description = (TextView) view.findViewById(R.id.interview_list_item_description);
		description.setText(descriptionText.subSequence(1, descriptionText.length()));
		
		return view;
	}

	
}
