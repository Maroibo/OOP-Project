package eQatarSystem;

import java.util.ArrayList;

/**
 * @author Marwan Emad - 202104862
 * @version 1.0.0
 * {@link Deal}
 * {@link Trader}
 * {@link Electronic}
 */	
public class EQatar {
	private ArrayList<Electronic> electronics;
	private ArrayList<Trader> traders;
	private ArrayList<Deal> deals;
	
	public EQatar() {
		this.electronics = new ArrayList<Electronic>();
		this.traders = new ArrayList<Trader>();
		this.deals = new ArrayList<Deal>();
	}
	
	/**
	 * addElectronic method adds a new electronic item to the product catalog of the system.
	 * @param electronic
	 */
	public void addElectronic(Electronic electronic) {
		electronics.add(electronic);
	}
	
	/**
	 * findElectronic method Searches for an electronic item using “id” and returns it.
	 * @param id
	 * @return Electronic object
	 */
	public Electronic findElectronic(int id) {
		for(int i = 0; i < electronics.size(); i++) {
			if(electronics.get(i).getId() == id)
				return electronics.get(i);
		}
		return null;
	}
	
	/**
	 * This method changes the status of a specific item with the “id” to sold; setting isSold attribute to true.
	 * @param id
	 */
	public void changeElectronicStatusToSold(int id) {
		for(int i = 0; i < electronics.size(); i++) {
			if(electronics.get(i).getId() == id) {
				electronics.get(i).setSold(true);
			}
		}
	}
	
	/**
	 * addTrader method adds a new trader to the system only if trader is not buyer & seller at the same time.
	 * @param trader
	 */
	public void addTrader(Trader trader) {
		if(!(trader.isBuyer() && trader.isSeller())) {
			traders.add(trader);
		}
	}
	
	/**
	 * findTrader method searches for a trader using “id” and returns it.
	 * @param id
	 * @return Trader object
	 */
	public Trader findTrader(int id) {
		for(int i = 0; i < traders.size(); i++) {
			if(traders.get(i).getId() == id)
				return traders.get(i);
		}
		return null;
	}
	
	/**
	 * This method returns a list of smartphones that are not sold yet.
	 * @return ArrayList of Smartphone
	 */
	public ArrayList<Smartphone> getListOfAvailableSmartphones() {
		ArrayList<Smartphone> availableSmartphones = new ArrayList<Smartphone>();
		for(Electronic e: electronics) {
			if(e instanceof Smartphone) {
				Smartphone phone = (Smartphone) e;
				if(!(phone.getIsSold())) {
					availableSmartphones.add(phone);
				}
			}
		}
		return availableSmartphones;
	}
	
	/**
	 * This method returns a list of cameras that are not sold yet. 
	 * @return ArrayList of Camera
	 */
	public ArrayList<Camera> getListOfAvailableCameras(){
		ArrayList<Camera> availableCameras = new ArrayList<Camera>();
		for(Electronic e: electronics) {
			if(e instanceof Camera) {
				Camera camera = (Camera) e;
				if(!(camera.getIsSold())) {
					availableCameras.add(camera);
				}
			}
		}
		return availableCameras;
	}
	
	/**
	 * This method returns a list of video games that are not sold yet.
	 * @return ArrayList of VideoGame
	 */
	public ArrayList<VideoGame> getListOfAvailableVideoGames(){
		ArrayList<VideoGame> availableVideoGames = new ArrayList<VideoGame>();
		for(Electronic e: electronics) {
			if(e instanceof VideoGame) {
				VideoGame game = (VideoGame) e;
				if(!(game.getIsSold())) {
					availableVideoGames.add(game);
				}
			}
		}
		return availableVideoGames;
	}
	
	/**
	 * createDeal method creates a deal between the buyer and seller on the electronic item.
	 * @param buyer
	 * @param electronic
	 */
	public void createDeal(Trader buyer, Electronic electronic, String dateCreated) {
		deals.add(new Deal(buyer, this.findSellerByElectronicId(electronic.getId()), electronic, dateCreated));
	}
	
	/**
	 * This method searches for a seller who owns the electronic using the item “id” passed by parameter.
	 * @param id
	 * @return Trader object
	 */
	public Trader findSellerByElectronicId(int id) {
		for (int i = 0; i < traders.size(); i++) {
			if (traders.get(i).isSeller()) {
				for (Electronic e : traders.get(i).getList()) {
					if (e.getId() == id)
						return traders.get(i);
				}
			}
		}
		return null;
	}
	
	/**
	 * This method returns a list of deals that are closed; isClosed attribute is true.
	 * @return ArrayList of Deal
	 */
	public ArrayList<Deal> getListOfClosedDeals() {
		ArrayList<Deal> closedDeals = new ArrayList<Deal>();
		for(Deal d: deals) {
			if(d.getIsClosed()) {
				closedDeals.add(d);
			}
		}
		return closedDeals;
	}
	
	/**
	 * This method returns a list of deals that are not closed; isClosed attribute is false.
	 * @return ArrayList of Deal
	 */
	public ArrayList<Deal> getListOfUnClosedDeals() {
		ArrayList<Deal> unClosedDeals = new ArrayList<Deal>();
		for(Deal d: deals) {
			if(!(d.getIsClosed())) {
				unClosedDeals.add(d);
			}
		}
		return unClosedDeals;
	}
	
	/**
	 * findDeal method searches for a specific deal having the “id” passed by parameter and returns it.
	 * @param id
	 * @return Deal object
	 */
	public Deal findDeal(int id) {
		for (int i = 0; i < deals.size(); i++) {
			if (deals.get(i).getDealNo() == id)
				return deals.get(i);
		}
		return null;
	}
	
	/**
	 * This method returns a list of invoices that are not yet paid; isPaid attribute is false.
	 * @return ArrayList of Invoice
	 */
	public ArrayList<Invoice> getListOfUnPaidInvoices() {
		ArrayList<Invoice> unPaidInvoices = new ArrayList<Invoice>();
		for(Deal d: deals) {
			if(!(d.getInvoice().isPaid())) {
				unPaidInvoices.add(d.getInvoice());
			}
		}
		return unPaidInvoices;
	}
	
	/**
	 * This method takes a date parameter and returns ALL deals created in the same “date”.
	 * @param dateCreated
	 * @return ArrayList of Deal
	 */
	public ArrayList<Deal> getDealsCreatedOnSpecificDate(String dateCreated) {
		ArrayList<Deal> specificDateDeals = new ArrayList<Deal>();
		for(Deal d: deals) {
			if(d.getDateCreated().equals(dateCreated)) {
				specificDateDeals.add(d);
			}
		}
		return specificDateDeals;
	}
	
	/**
	 * closeDeal method searches for a deal having the “dealNo” to change its status to closed; setting isClosed attribute to true.
	 * @param dealNo
	 */
	public void closeDeal(int dealNo) {
		for(Deal d: deals) {
			if(d.getDealNo() == dealNo) {
				d.setClosed(true);
			}
		}
	}
	
}
