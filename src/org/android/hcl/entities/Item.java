package org.android.hcl.entities;

import java.io.Serializable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Item implements Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 4321838290870263586L;

		public Item() {
			// TODO Auto-generated constructor stub
		}
		
	@Element
	private String title;
	
	@Element
	private String link;
	
	@Element
	private String guid;
	
	@Element
	private String description;
	
	@Element
	private String pubDate;
	
	private String image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
