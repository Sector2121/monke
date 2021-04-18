package monke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ellenorzo {
	private static ArrayList<String> osszString = new ArrayList<>();
	public Ellenorzo() {
		
	}
	public void EllenorzoFv(String s) throws Exception {
		RandomAccessFile raf;
		String sor;
		ArrayList<String> elvart = new ArrayList<String>();
		raf = new RandomAccessFile(s + ".txt","r");
		for( sor = raf.readLine(); sor != null; sor = raf.readLine() )
		{
			elvart.add(sor);
		}
		raf.close();
		boolean siker = true;
		for(int i = 0; i < elvart.size(); i++) {
			if(osszString.get(i).equals(elvart.get(i))) {}
			else {
				siker = false;
				break;
			}
		}
		if(siker == true) {
			System.out.println("A teszt sikeres!");
		}
		else if (siker == false) {
			System.out.println("A teszt sikertelen!");
		}
	}
	public ArrayList<String> TesztBeolvaso(String s) throws Exception {
		RandomAccessFile raf;
	    String sor;
	    ArrayList<String> parancsok = new ArrayList<String>();
		raf = new RandomAccessFile(s+ ".txt","r");
	      for( sor = raf.readLine(); sor != null; sor = raf.readLine() )
	      {
	    	 parancsok.add(sor);
	      }
	      raf.close();
		return parancsok;
	}
	public void SetOsszString(String s) {
		osszString.add(s);
	}
	public ArrayList<String> GetOsszString() {
		return osszString;
	}
}
