package monke;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ellenorzo {
	public void Ellenorzo(String s) throws IOException, Exception {
		FileInputStream fajlbe = new FileInputStream("konzol");
		ObjectInputStream be = new ObjectInputStream(fajlbe);
		ArrayList<String> parancsok = (ArrayList<String>)be.readObject();
		be.close();
		FileInputStream fajlbeelvart = new FileInputStream(s);
		ObjectInputStream bee = new ObjectInputStream(fajlbeelvart);
		ArrayList<String> parancsokelvart = (ArrayList<String>)be.readObject();
		be.close();
		if(parancsok.equals(parancsokelvart)) {
			System.out.println("A teszt sikeres");
		}
		else {
			System.out.println("A teszt sikertelen");
		}
	}
	public ArrayList<String> TesztBeolvaso(String s) throws Exception {
		FileInputStream fajlbe = new FileInputStream(s);
		ObjectInputStream be = new ObjectInputStream(fajlbe);
		ArrayList<String> parancsok = (ArrayList<String>)be.readObject();
		be.close();
		return parancsok;
	}
}
