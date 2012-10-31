package org.android.hcl.entities;

import java.io.Serializable;
import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root(name = "channel")
public class Channel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833583382825800699L;

	public Channel() {
		// TODO Auto-generated constructor stub
	}
	
	@Element
	private String title;
	
	@Element
	private String description;
	
	@ElementList(inline = true)
	private List<Item> item;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getItems() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}
