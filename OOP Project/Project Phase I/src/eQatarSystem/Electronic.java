package eQatarSystem;

import java.io.Serializable;

/**
 * @author Mhd Hadi Nouh - 201909591
 * @version 1.0.0
 * {@link Smartphone}
 * {@link VideoGame}
 * {@link Camera}
 */
public class Electronic implements Serializable{
	private int id;
	private double price;
	private String brand;
	private String color;
	private boolean isSold;
	
	public Electronic(int id, double price, String brand, String color) {
		this.id = id;
		this.price = price;
		this.brand = brand;
		this.color = color;
		this.isSold = isSold;
	}
	
	//setter and getter for id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//setter and getter for price
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//setter and getter for brand
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	//setter and getter for color
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	//setter and getter for isSold
	public boolean getIsSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}
	
	public String toString() {
		String details = String.format("\nId: %d\nPrice: %.2f\nBrand: %s\nColour: %s\nSold: %S\n",
				this.getId(), this.getPrice(), this.getBrand(), this.getColor(), this.getIsSold());
		return details;
	}
}
