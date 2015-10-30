package org.minakdev.aktoreak;

public class Pelikulak {

	private static Pelikulak nirePelikulak;
	private PelikulaZerrenda pelikulaZerrenda;
	
	private Pelikulak() {
		this.pelikulaZerrenda = new PelikulaZerrenda();
	}

	public static Pelikulak getNirePelikulak() {
		if (nirePelikulak == null) {
			nirePelikulak = new Pelikulak();
		}
		return nirePelikulak;
	}
	
	public void sartuPelikula(Pelikula pPelikula) {
		pelikulaZerrenda.sartuPelikula(pPelikula);
	}
	
	public Pelikula pelikulaBueltatu(String izena){
		return this.pelikulaZerrenda.pelikulaBueltatu(izena);
	}
}
