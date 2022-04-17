package eQatarSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Alhasan Mahmood - 202104902
 * @version 1.0.0
 * {@link Invoice}
 */
public class Deal {
	private static int totalDeals = 0;
	private String dateCreated;
	private int dealNo;
	private Trader buyer;
	private Trader seller;
	private Electronic electronicItem;
	private Invoice invoice;
	private boolean isClosed;
	
	public Deal(Trader buyer, Trader seller, Electronic electronicItem, String dateCreated) {
		this.dateCreated = dateCreated;
		this.dealNo = totalDeals;
		this.buyer = buyer;
		this.seller = seller;
		this.electronicItem = electronicItem;
		totalDeals++;
		this.createInvoice();
	}

	//setter and getter for dateCreated
	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	//setter and getter for dealNo
	public int getDealNo() {
		return dealNo;
	}

	public void setDealNo(int dealNo) {
		this.dealNo = dealNo;
	}

	//setter and getter for Buyer
	public Trader getBuyer() {
		return buyer;
	}

	public void setBuyer(Trader buyer) {
		this.buyer = buyer;
	}

	//setter and getter for Seller
	public Trader getSeller() {
		return seller;
	}

	public void setSeller(Trader seller) {
		this.seller = seller;
	}
	
	//setter and getter for ElectronicItem
	public Electronic getElectronicItem() {
		return electronicItem;
	}

	public void setElectronicItem(Electronic electronicItem) {
		this.electronicItem = electronicItem;
	}

	//setter and getter for Invoice
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	//setter and getter for isClosed
	public boolean getIsClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	/**
	 * createInvoice method creates an invoice with the buyer, seller and item information including the item price.
	 */
	public void createInvoice() {
		this.invoice = new Invoice(dealNo, this.getElectronicItem().getPrice(), this.getIsClosed(), this.getDateCreated());
	}
	
	public String toString() {
		String details = String.format(
				"Date created: %s\nDeal number: %d\nBuyer: %s\nSeller: %s\nElectronic item: %s\nInvoice: %s\nClosed: %s",
				this.getDateCreated(), this.getDealNo(), this.getBuyer(), this.getSeller(), this.getElectronicItem(),
				this.getInvoice(), this.getIsClosed());
		return details;
	}
}
