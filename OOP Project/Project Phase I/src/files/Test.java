package files;

import java.io.IOException;
import java.util.ArrayList;

import eQatarSystem.Camera;
import eQatarSystem.Trader;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		ReaderAndWriter.reset();
		System.out.println(ReaderAndWriter.tread());
		System.out.println(ReaderAndWriter.dread());
		System.out.println(ReaderAndWriter.eread());	
	}

}
