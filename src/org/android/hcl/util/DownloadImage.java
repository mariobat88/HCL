package org.android.hcl.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class DownloadImage extends AsyncTask<Void, Void, Bitmap>{

	private String src;
	private ImageView imageView;
	private Context context;
	private Animation animation;
	private ProgressBar progress;
	
	public DownloadImage(Context context, String src, ImageView imageView, ProgressBar progress) {
		this.src = src;
		this.imageView = imageView;
		this.context = context;
		this.progress = progress;
	}
	
	@Override
	protected Bitmap doInBackground(Void... params) {
		try {
			Log.e("src", src);
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			Log.e("Bitmap", "returned");
			return myBitmap;
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Exception", e.getMessage());
			return null;
		}
	}
	
	@Override
	protected void onPostExecute(Bitmap bitmap) {
		progress.setVisibility(View.GONE);
		imageView.setImageBitmap(bitmap);
		super.onPostExecute(bitmap);
	}

	
}
