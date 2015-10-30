package org.minakdev.aktoreak;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import TartetikKanpoException.TartetikKanpoException;

public class Nagusia {
	
	private static Nagusia nireNagusia;
	
	private static String fitxategia = "aktore-zerrenda.txt";
	
	private static Scanner sc = new Scanner(System.in);

	private Nagusia() {
	}

	public static Nagusia getNireNagusia() {
		if (nireNagusia == null) {
			nireNagusia = new Nagusia();
		}
		return nireNagusia;
	}

	public static void main(String[] args) {
		nireNagusia = Nagusia.getNireNagusia();
		
		nireNagusia.fitxategiaKargatu(fitxategia);
		
		System.out.println("AKOTEAK ETA PELIKULAK KUDEATZEKO APLIKAZIOA");
		System.out.println("Aplikazioa honek aukera hauek ditu:");
		do{
			System.out.println("1 - Aktore bat bilatu");
			System.out.println("2 - Aktore berri bat txertatu");
			System.out.println("3 - Aktore baten pelikulak ikusi");
			System.out.println("4 - Pelikula baten aktoreak ikusi");
			System.out.println("5 - Pelikula batek lortutako dirua ezarri");
			System.out.println("6 - Aktore bat ezabatu");
			System.out.println("7 - Aktoreen zerrenda gorde");
			System.out.println("8 - Irten");
			
			System.out.println();
			
			int aukera = 0;
			boolean ezAmaitu = true;
			
			do {
				try {
					System.out.println("Hautatu nahi duzun aukera: ");
					aukera = sc.nextInt();	
					if(aukera > 8 || aukera < 1){
						throw new TartetikKanpoException("Zenbaki okerra hautatu duzu.");
					}
					ezAmaitu = false;
				} catch (InputMismatchException  e) {
					sc.nextLine();
					aukera = 0;
					System.out.println("Zenbaki okerra hautatu duzu.");
				} catch (TartetikKanpoException e) {
					System.out.println(e.getMessage());
				}
			} while (ezAmaitu);
			
			if (aukera == 1){
				nireNagusia.aktoreaBilatu();
			}
			else if(aukera == 2){
				nireNagusia.aktoreaTxertatu();
			}
			else if(aukera == 3){
				nireNagusia.aktoreBatenPelikulakBueltatu();
			}
			else if(aukera == 4){
				nireNagusia.pelikulaBatekoAktoreakBueltatu();
			}
			else if(aukera == 5){
				nireNagusia.diruaGehitu();
			}
			else if(aukera == 6){
				nireNagusia.aktoreBatenEzabaketa();
			}
			else if(aukera == 7){
				try {
					nireNagusia.aktoreenZerrendaGorde();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
			}
			else if(aukera == 8){
				System.exit(0);
			}
		}while(true);
		
		
	}
	
	public void fitxategiaKargatu(String pFitxategia) {
		
		try {
			
			Scanner sc = new Scanner(new FileReader(pFitxategia));
			
			String aktoreaPelikulak;
			
			while(sc.hasNext()) {
				aktoreaPelikulak = sc.nextLine();
				Aktoreak.getNireAktoreak().sortuAktorea(aktoreaPelikulak);
			}
			
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Aktoreak.getNireAktoreak().aktoreakOrdenatu();
	}
	
	public void aktoreenZerrendaGorde() throws FileNotFoundException, UnsupportedEncodingException {		
		PrintWriter idatzi = new PrintWriter("AktoreakOutput.txt", "UTF-8");
		
		Iterator<Aktorea> itr =  Aktoreak.getNireAktoreak().getAktoreZerrenda().iterator();
		
		while(itr.hasNext()) {
			Aktorea egungoAktorea = itr.next();
			idatzi.print(egungoAktorea.getIzena());
			
			Iterator<Pelikula> itr2 = egungoAktorea.getIteradorea();
			while (itr2.hasNext()) {
				Pelikula egungoPelikula = itr2.next();
				idatzi.print(" ### "+egungoPelikula.getIzena());
			}
			idatzi.print("\n");
		}
		
		idatzi.close();
	}
	
	public void aktoreBatenPelikulakBueltatu() {
		
	}
	
	public AktoreZerrenda pelikulaBatekoAktoreakBueltatu() {
		System.out.println("Sartu pelikularen izena");
		String izenburu=this.stringEskatu();
		Pelikula pelikula= Pelikulak.getNirePelikulak().pelikulaBueltatu(izenburu);
		if (pelikula==null){
			System.out.println("pelikula ez da existitzen edo izena txarto sartu duzu");
			return null;}
		else{ return pelikula.aktoreakBueltatu();}
	}
	
	public void diruaGehitu() {
		System.out.println("Sartu pelikularen izena");
		String pelIzen=this.stringEskatu();
		Pelikula peli= Pelikulak.getNirePelikulak().pelikulaBueltatu(pelIzen);
		if(peli==null){
			System.out.println("Pelikula hori ez dago. Ezin da dirurik gehitu.");
		}
		else{
			float n=this.diruaEskatu();
			peli.diruaGehitu(n);
		}	
		
	}
	
	public void aktoreBatenEzabaketa() {
		System.out.println("Sartu ezabatu nahi duzun aktorearen izena.");
		String izena = nireNagusia.stringEskatu();
		Aktoreak.getNireAktoreak().aktoreaEzabatu(izena);
	}
	
	private float diruaEskatu(){
		float n;
		
		boolean ezAmaitu = true;
		
		do {
			try {
				System.out.println("Sartu diru kantitate bat: ");
				n = sc.nextFloat();
				ezAmaitu=false;
			} catch (InputMismatchException e) {
				sc.nextLine();
				n = 0;
				System.out.println("Sartu duzuna ez da diru kantitate bat.");
			} 
		}while (ezAmaitu);
		
		return n;
	}
	
	private String stringEskatu(){
		Scanner sc=new Scanner(System.in);
		
		String izena = sc.nextLine();
		sc.close();
		return izena;
		
	}
	
	public void aktoreaTxertatu(){
		String izena=this.stringEskatu();
		Aktoreak.getNireAktoreak().aktoreaTxertatu(izena);
	}
	
	public Aktorea aktoreaBilatu(){
		System.out.println("Sartu pelikularen izena");
		String aktoreIzen=this.stringEskatu();
		return Aktoreak.getNireAktoreak().aktoreaBilatu(aktoreIzen);
		

	}

}
