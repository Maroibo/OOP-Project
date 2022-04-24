package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import eQatarSystem.*;

public class ReaderAndWriter {
	public static EQatar sys;
	public static ArrayList<Trader> t=new ArrayList<Trader>();
	public static ArrayList<Deal> d=new ArrayList<Deal>();
	public static ArrayList<Electronic> e=new ArrayList<Electronic>();
	public static ArrayList<Trader> l=new ArrayList<Trader>();

	public static void twrite(Trader trader) throws IOException {
		FileOutputStream f=new FileOutputStream("trader.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(f);
		t.add(trader);
		objOut.writeObject(t);
		objOut.close();
	}
	public static ArrayList<Trader> tread() throws IOException, ClassNotFoundException{
		FileInputStream f=new FileInputStream("trader.dat");
		ObjectInputStream objIn=new ObjectInputStream(f);
		return (ArrayList<Trader>) objIn.readObject();
	}
	public static void dwrite(Deal deal) throws IOException {
		FileOutputStream f=new FileOutputStream("deal.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(f);
		d.add(deal);
		objOut.writeObject(d);
		objOut.close();
	}
	public static ArrayList<Deal> dread() throws IOException, ClassNotFoundException{
		FileInputStream f=new FileInputStream("deal.dat");
		ObjectInputStream objIn=new ObjectInputStream(f);
		return (ArrayList<Deal>) objIn.readObject();
	}
	public static void ewrite(Electronic electronic) throws IOException {
		FileOutputStream f=new FileOutputStream("electronic.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(f);
		e.add(electronic);
		objOut.writeObject(e);
		objOut.close();
	}
	public static ArrayList<Electronic> eread() throws IOException, ClassNotFoundException{
		FileInputStream f=new FileInputStream("electronic.dat");
		ObjectInputStream objIn=new ObjectInputStream(f);
		return(ArrayList<Electronic>) objIn.readObject();
	}
	public static void refresh() throws ClassNotFoundException, IOException {
		t=tread();
		EQatar.setTraders(t);
		d=dread();
		EQatar.setDeals(d);
		e=eread();
		EQatar.setElectronics(e);
		l=lread();
	}
	public static void reset() throws ClassNotFoundException, IOException {
		t=new ArrayList<Trader>();
		d=new ArrayList<Deal>();
		e=new ArrayList<Electronic>();
		l=new ArrayList<Trader>();
		EQatar.setTraders(t);
		EQatar.setDeals(d);
		EQatar.setElectronics(e);
		FileOutputStream f=new FileOutputStream("trader.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(f);
		objOut.writeObject(t);
		objOut.close();
		FileOutputStream f1=new FileOutputStream("deal.dat");
		ObjectOutputStream objOut1=new ObjectOutputStream(f1);
		objOut1.writeObject(d);
		objOut1.close();
		FileOutputStream f2=new FileOutputStream("electronic.dat");
		ObjectOutputStream objOut2=new ObjectOutputStream(f2);
		objOut2.writeObject(e);
		objOut2.close();
		FileOutputStream f3=new FileOutputStream("log.dat");
		ObjectOutputStream objOut3=new ObjectOutputStream(f3);
		objOut3.writeObject(e);
		objOut3.close();
	}
	public static void currentLog(Trader t) throws IOException {
		l.add(t);
		FileOutputStream f2=new FileOutputStream("log.dat");
		ObjectOutputStream objOut2=new ObjectOutputStream(f2);
		objOut2.writeObject(l);
		objOut2.close();
	}
	public static void removeLog() {
		if(l.size()>0)
		l.remove(0);
	}
	public static Trader getLog() {
		if(l.size()>0)
			return l.get(0);
		return null;
	}
	public static ArrayList<Trader> lread() throws IOException, ClassNotFoundException{
		FileInputStream f=new FileInputStream("log.dat");
		ObjectInputStream objIn=new ObjectInputStream(f);
		return (ArrayList<Trader>) objIn.readObject();
	}
	public static void lwrite() throws IOException {
		FileOutputStream f=new FileOutputStream("log.dat");
		ObjectOutputStream objOut=new ObjectOutputStream(f);
		objOut.writeObject(l);
		objOut.close();
	}
}
