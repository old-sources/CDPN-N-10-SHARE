package fr.imie.formation.poo.tp2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class testMain {

	public testMain() {

	}
	
	public static void main(String[] args) {
		ArrayList<Integer> liste = new ArrayList<Integer>();
		liste.add(10);
		liste.add(20);
		ArrayList<Integer> liste2 = new ArrayList<Integer>();
		liste.add(100);
		liste.add(200);
		Hashtable<String, ArrayList<Integer>> ht = new Hashtable<String, ArrayList<Integer>>();
		ht.put("test", liste);
		ht.put("test2", liste2);
		Enumeration<ArrayList<Integer>> enu = ht.elements();
		while (enu.hasMoreElements()) {
			for (int ii : enu.nextElement()) {
				System.out.println(ii);
			}
		}
	}

}
