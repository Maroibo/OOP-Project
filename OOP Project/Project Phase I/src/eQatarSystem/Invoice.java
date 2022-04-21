package eQatarSystem;

import java.io.Serializable;

/**
 * @author Alhasan Mahmood - 202104902
 * @version 1.0.0
 */
public class Invoice implements Serializable{
	private int invoiceNo;
	private double amount;
	private String dateCreated;
	private boolean isPaid;
	
	public Invoice(int invoiceNo, double amount, boolean isPaid, String dateCreated) {
		this.invoiceNo = invoiceNo;
		this.amount = amount;
		this.isPaid = isPaid;
		this.dateCreated = dateCreated;
	}
	
	//setter and getter for InvoiceNo
	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	//setter and getter for amount
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	//setter and getter for dateCreated
	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	//setter and getter for isPaid
	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	public String toString() {
		String details = String.format("Invoice Number: %d\nAmount: %.2f\nDate Created: %s\nPaid: %s",
				this.getInvoiceNo(), this.getAmount(), this.getDateCreated(), this.isPaid());
		return details;
	}
}
