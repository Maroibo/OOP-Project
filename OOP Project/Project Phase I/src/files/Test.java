package files;

import java.io.IOException;
import java.util.ArrayList;

import eQatarSystem.Camera;
import eQatarSystem.Deal;
import eQatarSystem.Electronic;
import eQatarSystem.Trader;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		ReaderAndWriter.currentLog(null);
		ReaderAndWriter.reset();
		Trader t1 = new Trader(1, "Marwan Emad", false, true, 63458365, "Alwakra");
		Trader t2 = new Trader(2, "Ali Mohammed", true, false, 38420582, "Alkhor");
		Electronic e1 = new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76");
		t2.addElectronic(e1);
		ReaderAndWriter.currentLog(t2);
		Deal d=new Deal(t1,t2,e1,"22-5-1990");
		ReaderAndWriter.dwrite(d);
		System.out.println(ReaderAndWriter.tread());
		System.out.println(ReaderAndWriter.dread());
//		System.out.println(ReaderAndWriter.eread());
		System.out.println(ReaderAndWriter.getLog().getList());
	}

}
