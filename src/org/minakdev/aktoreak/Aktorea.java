package org.minakdev.aktoreak;

import java.util.Iterator;
import org.minakdev.DoubleLinkedList.UnorderedDoubleLinkedList;

public class Aktorea implements Comparable<Aktorea>{
	
	private String izena;
	private UnorderedDoubleLinkedList<Pelikula> pelikulaZerrenda;
	
	public Aktorea(String pIzena) {
		this.izena = pIzena;
		this.pelikulaZerrenda = new UnorderedDoubleLinkedList<Pelikula>();
	}
	
	public String getIzena() {
		return this.izena;
	}
	
	public Iterator<Pelikula> getIteradorea(){
		return this.pelikulaZerrenda.iterator();
	}
	
	public void sartuPelikula(Pelikula pPelikula) {
		pelikulaZerrenda.addToRear(pPelikula);
	}
	
	public UnorderedDoubleLinkedList<Pelikula> pelikulakBueltatu() {
		return this.pelikulaZerrenda;
	}

//public void pelikuletatikEzabatu() {
//	this.pelikulaZerrenda.aktoreaEzabatu(this);
//	
//}
	public void pelikuletatikEzabatu2() {
		Iterator<Pelikula> it = this.pelikulaZerrenda.iterator();
		while (it.hasNext()) {
			Pelikula pel = it.next();
			pel.aktoreaEzabatu(this);
		}
	}

	@Override
	public int compareTo(Aktorea o){
		// TODO Auto-generated method stub
		return this.izena.compareTo(o.izena);
	}
}
