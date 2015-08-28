package com.infosys.model;

import java.io.Serializable;
import java.util.List;

public class Payload implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -1450138108073736099L;
private String website_name;
private List<Category> category;
public String getWebsite_name() {
	return website_name;
}
public void setWebsite_name(String website_name) {
	this.website_name = website_name;
}
public List<Category> getCategory() {
	return category;
}
public void setCategory(List<Category> category) {
	this.category = category;
}

}
