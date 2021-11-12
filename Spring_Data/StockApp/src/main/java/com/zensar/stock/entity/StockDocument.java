package com.zensar.stock.entity;

import org.springframework.data.annotation.Id;

//@Document(collection = "stocks")
public class StockDocument {

	@Id
	private int id;
	private String name;
	private String marketName;
	private double price;
	public StockDocument(int id, String name, String marketName, double price) {
		super();
		this.id = id;
		this.name = name;
		this.marketName = marketName;
		this.price = price;
	}
	public StockDocument() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "StockDocument [id=" + id + ", name=" + name + ", marketName=" + marketName + ", price=" + price + "]";
	}
	
	
}
