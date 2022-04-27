package files;

import java.io.IOException;
import java.util.ArrayList;

import eQatarSystem.Camera;
import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import eQatarSystem.Smartphone;
import eQatarSystem.Trader;
import eQatarSystem.VideoGame;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ReaderAndWriter.currentLog(null);
		ReaderAndWriter.reset();
		Trader t1 = new Trader(1, "Marwan Emad", false, true, 63458365, "Alwakra");
		Trader t2 = new Trader(2, "Ali Mohammed", true, false, 38420582, "Alkhor");
		Electronic e1 = new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76");
		Electronic e3 = new VideoGame(3, 20.5, "Activision", "Cyan", "128", "35", "756", "745", "45");
		Electronic e5 = new Smartphone(5, 1500.7, "Apple", "White", "128", "6.7", "12");
		t2.addElectronic(e1);
		t2.addElectronic(e3);
		t2.addElectronic(e5);
		ReaderAndWriter.refresh();
		ReaderAndWriter.ewrite(e1);
		ReaderAndWriter.refresh();
		ReaderAndWriter.ewrite(e3);
		ReaderAndWriter.refresh();
		ReaderAndWriter.ewrite(e5);
		ReaderAndWriter.currentLog(t2);
		Deal d=new Deal(t1,t2,e1,"22-5-1990");
		Deal d2=new Deal(t1,t2,e3,"22-5-1990");
		Deal d3=new Deal(t1,t2,e5,"22-5-1990");
		ReaderAndWriter.refresh();
		ReaderAndWriter.dwrite(d);
		ReaderAndWriter.refresh();
		ReaderAndWriter.dwrite(d2);
		ReaderAndWriter.refresh();
		ReaderAndWriter.dwrite(d3);
		ReaderAndWriter.refresh();
		ReaderAndWriter.twrite(t1);
		ReaderAndWriter.refresh();
		ReaderAndWriter.twrite(t2);
		System.out.println(ReaderAndWriter.tread());
		System.out.println(ReaderAndWriter.dread());
		System.out.println(ReaderAndWriter.eread());
		System.out.println(ReaderAndWriter.getLog().getList());
	}

}