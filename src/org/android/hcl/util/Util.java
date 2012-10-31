package org.android.hcl.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Util {

	private static final String TAG = Util.class.getName();

	public static boolean isDeviceConected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();

		if (ni == null) {
			return false;
		}
		return true;
	}

	public static void DownloadImage(Context context, String src, ImageView imageView, ProgressBar progress) {
		DownloadImage downloadImage = new DownloadImage(context, src, imageView, progress);
		downloadImage.execute();
	}
}
