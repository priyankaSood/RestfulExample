package com.infosys.model;

import java.io.Serializable;

public class Item implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5805350195769107839L;
private String sku;
private String price;
private String color;
private String description;
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
