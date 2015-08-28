package com.infosys.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -7637079669883217133L;
private String cat_name;
private List<Item> items;
public String getCat_name() {
	return cat_name;
}
public void setCat_name(String cat_name) {
	this.cat_name = cat_name;
}
public List<Item> getItems() {
	return items;
}
public void setItems(List<Item> items) {
	this.items = items;
}

}
