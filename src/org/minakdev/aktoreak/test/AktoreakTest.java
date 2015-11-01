package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreak.Pelikula;
import org.minakdev.aktoreak.Pelikulak;

public class AktoreakTest {

	

	@Before
	public void setUp() throws Exception{
		Aktoreak.getNireAktoreak().erreseteatu();
	}
	
	@Test
	public void sortuAktorea() {
		Aktoreak.getNireAktoreak().sortuAktorea(new Scanner("Aktore1 ###	 peli1### peli2    ###peli3 ### peli4\nAktore2 ### peli5 ### peli1 ### peli3"));
		assertSame(Aktoreak.getNireAktoreak().getAktoreZerrenda().size(),2);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli1").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"Aktore1");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli1").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"Aktore2");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli2").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"Aktore1");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli3").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"Aktore1");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli3").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"Aktore2");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli4").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"Aktore1");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("peli5").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"Aktore2");
		
	}
	
	@Test
	public void aktoreaEzabatu(){
		Aktorea akA = new Aktorea("AktoreaA");
		Pelikula pelA = new Pelikula("PelikulaA");
		Pelikula pelB = new Pelikula("PelikulaB");
		Pelikula pelC = new Pelikula("PelikulaC");
		akA.sartuPelikula(pelA);
		akA.sartuPelikula(pelB);
		akA.sartuPelikula(pelC);
		pelA.sartuAktorea(akA);
		pelA.sartuAktorea(new Aktorea("BU"));
		pelB.sartuAktorea(new Aktorea("dfsaegih"));
		pelB.sartuAktorea(akA);
		pelC.sartuAktorea(akA);
		Pelikulak.getNirePelikulak().sartuPelikula(pelA);
		Pelikulak.getNirePelikulak().sartuPelikula(pelB);
		Pelikulak.getNirePelikulak().sartuPelikula(pelC);
		Aktoreak.getNireAktoreak().aktoreaSartu(akA);
		Aktoreak.getNireAktoreak().getAktoreZerrenda().add(new Aktorea("sdf"));
		Aktoreak.getNireAktoreak().getAktoreZerrenda().add(new Aktorea("sq"));
		Aktoreak.getNireAktoreak().aktoreakOrdenatu();
		
		assertSame(Aktoreak.getNireAktoreak().getAktoreZerrenda().size(),3);
		assertSame(Aktoreak.getNireAktoreak().aktoreaBilatu("AktoreaA"),akA);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().size(),2);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"AktoreaA");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"BU");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().size(),2);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"dfsaegih");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"AktoreaA");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaC").aktoreakBueltatu().getZerrenda().size(),1);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaC").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"AktoreaA");
		
		Aktoreak.getNireAktoreak().aktoreaEzabatu("Txarto");
		assertSame(Aktoreak.getNireAktoreak().getAktoreZerrenda().size(),3);
		assertSame(Aktoreak.getNireAktoreak().aktoreaBilatu("AktoreaA"),akA);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().size(),2);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"AktoreaA");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"BU");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().size(),2);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"dfsaegih");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().get(1).getIzena(),"AktoreaA");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaC").aktoreakBueltatu().getZerrenda().size(),1);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaC").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"AktoreaA");
		
		Aktoreak.getNireAktoreak().aktoreaEzabatu("AktoreaA");
		assertSame(Aktoreak.getNireAktoreak().getAktoreZerrenda().size(),2);
		assertSame(Aktoreak.getNireAktoreak().aktoreaBilatu("AktoreaA"),null);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().size(),1);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaA").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"BU");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().size(),1);
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaB").aktoreakBueltatu().getZerrenda().get(0).getIzena(),"dfsaegih");
		assertEquals(Pelikulak.getNirePelikulak().pelikulaBueltatu("PelikulaC").aktoreakBueltatu().getZerrenda().size(),0);
	
	}

}
