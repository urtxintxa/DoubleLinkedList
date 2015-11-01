package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Pelikula;
import org.minakdev.aktoreak.PelikulaZerrenda;

public class AktoreaTest {
	
	private Aktorea aktorea;
	
	private Pelikula pelikula1;
	private Pelikula pelikula2;

	@Before
	public void setUp() throws Exception {
		aktorea = new Aktorea("Aktore1");
		
		pelikula1 = new Pelikula("Pelikula1");
		pelikula2 = new Pelikula("Pelikula2");
	}

	@After
	public void tearDown() throws Exception {
		aktorea = null;
		
		pelikula1 = null;
		pelikula2 = null;
	}
	
	@Test
	public void getIzena() {
		assertSame(aktorea.getIzena(), "Aktore1");
	}
	
	@Test
	public void sartuPelikula() {
		aktorea.sartuPelikula(pelikula1);
		aktorea.sartuPelikula(pelikula2);
		
		//PelikulaZerrenda pelikulaZerrenda = aktorea.pelikulakBueltatu();
		
		//assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula1"), pelikula1);
		
		
		Iterator<Pelikula> itr = aktorea.getIteradorea();
		
		assertSame(itr.next(), pelikula1);
		assertSame(itr.next(), pelikula2);
		
		
	}
}
