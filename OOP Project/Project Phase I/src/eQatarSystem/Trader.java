package eQatarSystem;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Anas Hammad - 202003757
 * @version 1.0.0
 */
public class Trader implements Serializable{
	private int id;
	private String name;
	private boolean isSeller;
	private boolean isBuyer;
	private ArrayList<Electronic> electronics = new ArrayList<Electronic>();
	private int phoneNumber;
	private String address;
	
	public Trader(int id, String name, boolean isSeller, boolean isBuyer, int phoneNumber, String address) {
		this.id = id;
		this.name = name;
		this.isSeller = isSeller;
		this.isBuyer = isBuyer;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//setter and getter for id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//setter and getter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//setter and getter for Seller
	public boolean isSeller() {
		return isSeller;
	}

	public void setSeller(boolean isSeller) {
		this.isSeller = isSeller;
	}

	//setter and getter for Buyer
	public boolean isBuyer() {
		return isBuyer;
	}

	public void setBuyer(boolean isBuyer) {
		this.isBuyer = isBuyer;
	}

	//setter and getter for Electronics ArrayList
	public ArrayList<Electronic> getElectronics() {
		return electronics;
	}

	public void setElectronics(ArrayList<Electronic> electronics) {
		this.electronics = electronics;
	}

	//setter and getter for phoneNumber
	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//setter and getter for address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * addElectronic method adds an electronic item to the trader�s item list (buyer or seller).
	 * @param electronic
	 */
	public void addElectronic(Electronic electronic) {
		boolean duplicated = false;
		for(Electronic e: electronics) {
			if(e.getId() == electronic.getId())
				duplicated = true;
		}
		if(duplicated == false)
			this.electronics.add(electronic);
	}
	
	
	/** 
	 * modifyProperties method modifies the item specification by replacing an existing item found
	 * in the list with the electronic item passed by parameter.
	 * @param electronic
	 */
	public void modifyProperties(Electronic electronic) {
		if(this.isSeller) {
			for(Electronic e: electronics) {
				if(e.getId() == electronic.getId()) {
					electronics.set(electronics.indexOf(e), electronic);
				} else
					System.out.println("You are not a seller you cannot use this method!");
			}
		}
	}
	
	/**
	 * typeOfTrader method returns whether the Trader is Buyer or Seller.
	 * @return String trader
	 */
	public String typeOfTrader() {
		if (this.isBuyer)
			return "Buyer";
		else
			return "Seller";
	}
	
	/**
	 * allElectronics method returns all Electronics toString
	 * @return String of Electronics toString
	 */
	public String allElectronics() {
		if(electronics.size()>0) {
		String e = electronics.get(0).toString();
		for (int i = 0; i < electronics.size(); i++) {
			e += "\n" + electronics.get(i).toString();
		}
		return e;}
		return null;
	}
	
	
	/**
	 * getList method returns ArrayList of electronics
	 * @return ArrayList of Electronic
	 */
	public ArrayList<Electronic> getList() {
		return electronics;
	}

	public String toString() {
		String details = String.format(
			"-(ID: %d)-\tName: %S\nPhone Number: %d\nAddress: %s\tType of Trader: %S\n",
			this.getId(), this.getName(), this.getPhoneNumber(), this.getAddress(), this.typeOfTrader());
		return details;
	}

}