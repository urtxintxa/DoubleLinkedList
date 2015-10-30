package org.minakdev.aktoreak;

import java.util.Iterator;

public class Aktorea implements Comparable<Aktorea>{
	
	private String izena;
	private PelikulaZerrenda pelikulaZerrenda;
	
	public Aktorea(String pIzena) {
		this.izena = pIzena;
		this.pelikulaZerrenda = new PelikulaZerrenda();
	}
	
	public String getIzena() {
		return this.izena;
	}
	
	public Iterator<Pelikula> getIteradorea(){
		return this.pelikulaZerrenda.getIteradorea();
	}
	
	public void sartuPelikula(Pelikula pPelikula) {
		pelikulaZerrenda.sartuPelikula(pPelikula);
	}
	
	public PelikulaZerrenda pelikulakBueltatu() {
		return this.pelikulaZerrenda;
	}

	public void pelikuletatikEzabatu() {
		this.pelikulaZerrenda.aktoreaEzabatu(this);
		
	}

	@Override
	public int compareTo(Aktorea o){
		// TODO Auto-generated method stub
		return this.izena.compareTo(o.izena);}
	}
