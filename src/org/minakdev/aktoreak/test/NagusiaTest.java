package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Aktoreak;
import org.minakdev.aktoreak.Nagusia;
import org.minakdev.aktoreak.Pelikula;
import org.minakdev.aktoreak.Pelikulak;

public class NagusiaTest {

	
	private Aktorea aktore1;
	private Aktorea aktore2;
	private Pelikula pelikula1;
	private Pelikula pelikula2;
	
	
	@Before
	public void setUp() throws Exception {
		aktore1 = new Aktorea("Aktore1");
		aktore2 = new Aktorea("Aktore2");
		pelikula1 = new Pelikula("Pelikula1");
		pelikula2 = new Pelikula("Pelikula2");
	}

	@After
	public void tearDown() throws Exception {
		aktore1 = null;
		aktore2 = null;
		pelikula1= null;
		pelikula2 = null;
	}
	
	
	
	@Test
	public void aktoreBatenPelikulakBueltatu(){
		Aktoreak.getNireAktoreak().aktoreaSartu(aktore1);
		aktore1.sartuPelikula(pelikula1);
		Aktoreak.getNireAktoreak().aktoreaSartu(aktore2);
		
		assertNull(Nagusia.getNireNagusia().aktoreBatenPelikulakBueltatu());//izen okerra sartu
		assertNotNull(Nagusia.getNireNagusia().aktoreBatenPelikulakBueltatu());//Aktore1
	}

	@Test
	public void pelikulaBatekoAktoreakBueltatu(){
		Pelikulak.getNirePelikulak().sartuPelikula(pelikula1);
		pelikula1.sartuAktorea(aktore1);
		
		assertNull(Nagusia.getNireNagusia().pelikulaBatekoAktoreakBueltatu());//izen okerra
		assertNotNull(Nagusia.getNireNagusia().pelikulaBatekoAktoreakBueltatu());//Pelikula1
	}
	
	@Test
	public void diruaGehitu(){
		Pelikulak.getNirePelikulak().sartuPelikula(pelikula1);
		
		Nagusia.getNireNagusia().diruaGehitu();// Pelikula2 1000.00
		assertEquals(pelikula2.getDirua(),0,0);
		Nagusia.getNireNagusia().diruaGehitu();// Pelikula1 1000.00
		assertEquals(pelikula1.getDirua(),1000,0);
		
		
		
	}
}
