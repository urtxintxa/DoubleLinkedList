package org.minakdev.aktoreak;

import java.util.ArrayList;

public class AktoreZerrenda {

	private ArrayList<Aktorea> aktoreZerrenda;

	public AktoreZerrenda(){
		this.aktoreZerrenda = new ArrayList<Aktorea>();
	}
	public ArrayList<Aktorea> getZerrenda() {
		return aktoreZerrenda;
	}
	
	public void aktoreaSartu(Aktorea pAktorea) {
		aktoreZerrenda.add(pAktorea);
	}

	public Aktorea aktoreaBilatu(String izena) {
		int ezker = 0;
		int eskuin = this.aktoreZerrenda.size() - 1;
		Aktorea aktore = null;
		while (ezker <= eskuin && aktore == null){
			int i = (ezker + eskuin) / 2;
			int lag = this.aktoreZerrenda.get(i).getIzena().compareTo(izena);
			if (lag == 0){
				aktore = this.aktoreZerrenda.get(i);}
			else{
				if (lag < 0){
					ezker= i+1;
				}
				else{
					eskuin= i-1;
				}
			}
		}
		return aktore;
	}
	
	public void aktoreakOrdenatu() {
		Aktorea aktoreArray[] = new Aktorea[this.aktoreZerrenda.size()];              
		for(int i = 0; i < this.aktoreZerrenda.size(); i++){
			aktoreArray[i] = this.aktoreZerrenda.get(i);
		}
		this.mergeSort(aktoreArray);
		this.aktoreZerrenda.clear();
		for(int i = 0; i < aktoreArray.length; i++){
			this.aktoreZerrenda.add(aktoreArray[i]);
		}
	}
	
	public void mergeSort(Aktorea[] taula){
		 this.mergeSort(taula, 0, taula.length-1);
		}
		
	private void mergeSort (Aktorea[] taulaBat, int hasiera, int bukaera){
		 if (hasiera < bukaera) { // taulan elementu bat baino gehiago badago
			 this.mergeSort(taulaBat, hasiera, (hasiera+bukaera)/2);
			 this.mergeSort(taulaBat, ((hasiera+bukaera)/2)+1, bukaera);
			 this.bateratze(taulaBat, hasiera, (hasiera+bukaera)/2, bukaera);
		 }
	}
	
	private void bateratze (Aktorea[] taula, int i, int erdikoa, int f){
		Aktorea[] bateratua = new Aktorea[f-i+1];
		int ezker = i;
		int eskuin = erdikoa+1;
		int k = 0; //bateratua taula betetzeko indizea
		while ( ezker<=erdikoa && eskuin<=f ){
			if ( taula[ezker].compareTo(taula[eskuin])<= 0 ){
				bateratua[k] = taula[ezker];
				k++;
				ezker++;
			}
			else {
				bateratua[k] = taula[eskuin];
				k++;
				eskuin++;
			}
		}
		if ( ezker > erdikoa ) {
			while ( eskuin<=f ){
				bateratua[k] = taula[eskuin];
				k++;
				eskuin++;
			}
		}	 
		else {
			while ( ezker<=erdikoa ){
				bateratua[k] = taula[ezker];
				k++;
				ezker++;
			}
		}
		for (int j=i; j<=f; j++){
			taula[j] = bateratua[j-i];
		}
	}

	public void aktoreaEzabatu(Aktorea aktorea) {
		this.aktoreZerrenda.remove(aktorea);		
	}
	
	public void aktoreaTxertatu(String izena) {
		int i =0;
		while (i<aktoreZerrenda.size() && izena.compareTo(aktoreZerrenda.get(i).getIzena())>0){	
			i ++;
		}
		
		if(i==aktoreZerrenda.size()){
			aktoreZerrenda.add(new Aktorea(izena));

			System.out.println("Aktorea arazorik gabe txertatu da.");
		}
		else if(izena.compareTo(aktoreZerrenda.get(i).getIzena())==0){
			System.out.println("Aktorea ezin da txertatu, izen bereko aktore bat baitago.");
		}
		else{
			aktoreZerrenda.add(i, new Aktorea(izena));
			System.out.println("Aktorea arazorik gabe txertatu da.");
		}
		
	}
	
	
	//Junit-ak probatzeko
	public void erreseteatu() {
		this.aktoreZerrenda.clear();
		
	}
	public int luzera() {
		return this.aktoreZerrenda.size();
	}
}
