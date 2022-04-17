package eQatarSystem;

public class App {

	public static void main(String[] args) {
		Trader t1 = new Trader(1, "Marwan Emad", false, true, 63458365, "Alwakra");
		Trader t2 = new Trader(2, "Ali Mohammed", true, false, 38420582, "Alkhor");
		Trader t3 = new Trader(3, "Alhasan Mahmood", true, false, 34496714, "Doha");
		Trader t4 = new Trader(4, "Osama Ashraf", true, false, 64349261, "Alrayan");
		
		Electronic e1 = new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76");
		Electronic e2 = new Camera(2, 1199.5, "Canon", "Blue", "108", "20x", "24");
		Electronic e3 = new VideoGame(3, 20.5, "Activision", "Cyan", "128", "35", "756", "745", "45");
		Electronic e4 = new VideoGame(4, 38.2, "Epic Games", "Black", "64", "567", "64", "86", "234");
		Electronic e5 = new Smartphone(5, 1500.7, "Apple", "White", "128", "6.7", "12");
		Electronic e6 = new Smartphone(6, 1200.2, "Samsung", "Pink","256", "7.0", "108");
		Electronic e7 = new Electronic(7, 28.1, "LG", "Brown");
		
		t1.addElectronic(e1);
		t1.addElectronic(e2);
		t2.addElectronic(e3);
		t2.addElectronic(e6);
		t3.addElectronic(e2);
		t3.addElectronic(e4);
		t4.addElectronic(e5);
		t4.addElectronic(e7);
		
		System.out.println("We registered the following traders:-");
		System.out.println("--------------------------------------");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		
		Electronic e8 = new Electronic(2, 50.6, "HiSense", "Silver");
		t1.modifyProperties(e8);
		System.out.println("The trader after modifying the properties:\n" + "--------------------------------------");
		System.out.println(t1);
		
		Deal d1 = new Deal(t1, t3, e1, "2022-08-20");
		d1.createInvoice();
		
		System.out.println("We created an Invoice:- ");
		System.out.println("------------------------------------");
		System.out.println(d1.getInvoice());
		System.out.println();
		
		System.out.println("Testing EQatar System");
		System.out.println("--------------------------");
		EQatar sys = new EQatar();
		sys.addElectronic(e1);
		sys.addElectronic(e8);
		sys.addElectronic(e3);
		sys.addElectronic(e4);
		sys.addElectronic(e5);
		sys.addElectronic(e6);
		sys.addElectronic(e7);
		sys.addTrader(t1);
		sys.addTrader(t2);
		sys.addTrader(t3);
		sys.addTrader(t4);
		
		System.out.println("Finding Trader and Electronic Items:");
		System.out.println("---------------------------------------");
		System.out.println("Trader with ID 1 :");
		System.out.println();
		System.out.println(sys.findTrader(1));
		System.out.println("Electronic item with ID 1 :");
		System.out.println(sys.findElectronic(1));
		System.out.println("---------------------------------------");
		System.out.println();
		
		System.out.println("We changed electronic item with the (id: 5) to sold");
		sys.changeElectronicStatusToSold(5);
		System.out.println(sys.findElectronic(5));
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("Now we are creating deals:");
		System.out.println("-----------------------------------------");
		sys.createDeal(t3, e7, "2022-04-14");
		sys.createDeal(t3, e6, "2022-02-05");
		sys.createDeal(t3, e5, "2022-06-25");
		sys.createDeal(t3, e4, "2022-10-03");
		sys.createDeal(t3, e3, "2022-09-15");
		System.out.println(sys.findDeal(1));
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of UNCLOSED deals:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfUnClosedDeals());
		System.out.println();
		
		System.out.println("List of CLOSED deals:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfClosedDeals());
		System.out.println();
		
		System.out.println("Now we close all the deals:");
		System.out.println("-----------------------------------------");
		sys.closeDeal(1);
		sys.closeDeal(2);
		sys.closeDeal(3);
		sys.closeDeal(4);
		sys.closeDeal(5);
		System.out.println(sys.getListOfClosedDeals());
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of UNPAID invoices:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfUnPaidInvoices());
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of deals created on a specific date:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getDealsCreatedOnSpecificDate("2022-04-14"));
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of Available Cameras:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfAvailableCameras());
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of Available Smartphones:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfAvailableSmartphones());
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.println("List of Available Video Games:");
		System.out.println("-----------------------------------------");
		System.out.println(sys.getListOfAvailableVideoGames());
		System.out.println("-----------------------------------------");
		System.out.println();
	}

}
