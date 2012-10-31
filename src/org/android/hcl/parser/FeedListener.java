package org.android.hcl.parser;

import org.android.hcl.entities.Rss;

public interface FeedListener {
	public void onFeedAvailable(Rss feed);
}
