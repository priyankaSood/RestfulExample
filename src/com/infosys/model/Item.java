package com.infosys.model;

import java.io.Serializable;

public class Item implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5805350195769107839L;
private String sku;
private String item_name;
private String price;
private String color;
private String description;
private String imageurl;

public String getItem_name() {
	return item_name;
}
public void setItem_name(String item_name) {
	this.item_name = item_name;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}
public String getSku() {
	return sku;
}
public void setSku(String sku) {
	this.sku = sku;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
