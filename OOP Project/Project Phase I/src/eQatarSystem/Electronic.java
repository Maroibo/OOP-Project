package eQatarSystem;

import java.io.Serializable;

/**
 * @author Mhd Hadi Nouh - 201909591
 * @version 1.0.0
 * {@link Smartphone}
 * {@link VideoGame}
 * {@link Camera}
 */
public abstract class Electronic implements Serializable{
	private String type;
	private int id;
	private double price;
	private String brand;
	private String color;
	private boolean isSold;
	
	public Electronic(int id, double price, String brand, String color) {
		this.type=this.getType();
		this.id = id;
		this.price = price;
		this.brand = brand;
		this.color = color;
	}
	
	public String getType() {
		if(this.getClass().getSimpleName().equals("Camera"))
			return "Camera";
		else if(this.getClass().getSimpleName().equals("Smartphone"))
			return "Smartphone";
		else
			return "Video Game";
	}

	public void setType(String type) {
		this.type = type;
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
		String details = String.format("ID: %d\t Price: %.2f\t Brand: %s\n Colour: %s\t Sold: %S\t ",
				this.getId(), this.getPrice(), this.getBrand(), this.getColor(), this.getIsSold());
		return details;
	}
}