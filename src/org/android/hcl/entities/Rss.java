package org.android.hcl.entities;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Rss implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -314925832515708109L;
	
	@Element
	private Channel channel;

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
	
}
