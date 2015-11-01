package org.minakdev.aktoreak.test;

import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Pelikula;
import org.minakdev.aktoreak.PelikulaZerrenda;

public class PelikulaZerrendaTest {
	
	private PelikulaZerrenda pelikulaZerrenda;
	
	private Pelikula pelikula1;
	private Pelikula pelikula2;
	private Pelikula pelikula3;
	
	private Aktorea aktore1;
	private Aktorea aktore2;

	@Before
	public void setUp() throws Exception {
		pelikulaZerrenda = new PelikulaZerrenda();
		
		pelikula1 = new Pelikula("Pelikula1");
		pelikula2 = new Pelikula("Pelikula2");
		pelikula3 = new Pelikula("Pelikula3");
		
		aktore1 = new Aktorea("Aktorea1");
		aktore2 = new Aktorea("Aktorea2");
	}

	@After
	public void tearDown() throws Exception {
		pelikulaZerrenda = null;
		
		pelikula1 = null;
		pelikula2 = null;
		pelikula3 = null;
		
		aktore1 = null;
		aktore2 = null;
	}
	
	@Test
	public void sartuPelikula() {
		assertSame(pelikulaZerrenda.getPelikulaZerrenda().size(), 0);
		
		pelikulaZerrenda.sartuPelikula(pelikula1);
		assertSame(pelikulaZerrenda.getPelikulaZerrenda().size(), 1);
	}
	
	@Test
	public void akoreaEzabatu() {
		pelikula1.sartuAktorea(aktore1);
		pelikula2.sartuAktorea(aktore1);
		pelikula2.sartuAktorea(aktore2);
		pelikulaZerrenda.sartuPelikula(pelikula1);
		pelikulaZerrenda.sartuPelikula(pelikula2);
		
		pelikulaZerrenda.aktoreaEzabatu(aktore1);
		assertSame(pelikula1.aktoreakBueltatu().getZerrenda().size(), 0);
		assertSame(pelikula2.aktoreakBueltatu().getZerrenda().size(), 1);
	}
	
	@Test
	public void pelikulaBueltatu() {
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula1"), null);
		
		pelikulaZerrenda.sartuPelikula(pelikula1);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula2"), null);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula1"), pelikula1);
		
		pelikulaZerrenda.sartuPelikula(pelikula3);
		pelikulaZerrenda.sartuPelikula(pelikula2);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula4"), null);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula1"), pelikula1);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula2"), pelikula2);
		assertSame(pelikulaZerrenda.pelikulaBueltatu("Pelikula3"), pelikula3);
	}

}
