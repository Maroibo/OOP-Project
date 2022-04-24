package files;

import java.io.IOException;
import java.util.ArrayList;

import eQatarSystem.Camera;
import eQatarSystem.Trader;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		//new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76")
		ReaderAndWriter.ewrite(new Camera(1,22,"Marwan","red","1","2","3"));
		ReaderAndWriter.ewrite(new Camera(2,22,"Marwan","red","1","2","3"));
		ReaderAndWriter.ewrite(new Camera(3,22,"Marwan","red","1","2","3"));
//		ReaderAndWriter.getLog().addElectronic(new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76"));
//		Trader  t=new Trader(1,"Emad",true,false,87,"fdslj");
//		t.addElectronic(new Camera(1, 1400.9, "Nikon", "Red", "64", "10x", "76"));
//		ReaderAndWriter.currentLog(t);
		System.out.println(ReaderAndWriter.getLog().getElectronics());
		System.out.println(ReaderAndWriter.getLog());
//		System.out.println(ReaderAndWriter.tread());
//		System.out.println(ReaderAndWriter.dread());
//		System.out.println(ReaderAndWriter.eread());
//		System.out.println(ReaderAndWriter.getLog().getList());
	}

}
