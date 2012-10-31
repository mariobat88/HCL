package org.android.hcl.parser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.android.hcl.entities.Item;
import org.android.hcl.entities.Rss;
import org.android.hcl.util.Util;
import org.apache.commons.io.FileUtils;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class FeedLoader extends AsyncTask<Void, Void, Rss> {

	private static final String TAG = FeedLoader.class.getName();

	private Context context;
	private String feedUrl;
	private String fileName;
	private Rss feed;

	private FeedListener listener;
	private File destinationFile;

	public FeedLoader(Context context, String feedUrl, String filename,
			FeedListener listener) {
		this.context = context;
		this.feedUrl = feedUrl;
		this.listener = listener;
		this.fileName = filename;
	}

	@Override
	protected void onPreExecute() {
		destinationFile = new File(context.getFilesDir(), fileName);
		if(!destinationFile.exists()){
			try {
				destinationFile.createNewFile();
			} catch (IOException e) {
				Log.e(TAG, e.getMessage());
				e.printStackTrace();
			}
		}
		super.onPreExecute();
	}

	@Override
	protected Rss doInBackground(Void... params) {
		if (Util.isDeviceConected(context)) {
			saveToCache();
			getFromCache();
		}

		return feed;
	}

	@Override
	protected void onPostExecute(Rss feed) {
		if (listener != null && feed != null) {
			listener.onFeedAvailable(feed);
		}
		super.onPostExecute(feed);
	}

	private void saveToCache() {
		URL url = null;
		try {
			url = new URL(feedUrl);
			FileUtils.copyURLToFile(url, destinationFile);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
		}
	}

	private void getFromCache() {
		Serializer serializer = new Persister();
		try {
			feed = serializer.read(Rss.class, destinationFile, false);
			//We are getting the images from the news item description, 
			//so we are finding the image in the description tag with the help of regex
			getImages(feed);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void getImages(Rss feed){
		List<Item> items = feed.getChannel().getItems();
		Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");

		for (Item item : items) {
			Matcher m = p.matcher(item.getDescription());
			
			if(m.find()){
				item.setImage(m.group(1));
			}else{
				item.setImage(null);
			}
		}

	}

}
