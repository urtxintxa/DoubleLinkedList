package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.AktoreZerrenda;
import org.minakdev.aktoreak.Aktorea;
import org.minakdev.aktoreak.Pelikula;

public class PelikulaTest {

	private Pelikula pelikula;
	
	private Aktorea aktore1;
	private Aktorea aktore2;
	
	@Before
	public void setUp() throws Exception {
		pelikula = new Pelikula("Pelikula1");
		
		aktore1 = new Aktorea("Aktore1");
		aktore2 = new Aktorea("Aktore2");
	}

	@After
	public void tearDown() throws Exception {
		pelikula = null;
		
		aktore1 = null;
		aktore2 = null;
	}

	@Test
	public void getIzena() {
		assertSame(pelikula.getIzena(), "Pelikula1");
	}
	
	
	@Test
	public void sartuAktorea() {
		pelikula.sartuAktorea(aktore1);
		pelikula.sartuAktorea(aktore2);
		
		AktoreZerrenda aktoreZerrenda = pelikula.aktoreakBueltatu();
		assertSame(aktoreZerrenda.getZerrenda().size(), 2);
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore1"), aktore1);
	}
	
	@Test
	public void aktoreaEzabatu() {
		pelikula.aktoreaEzabatu(aktore1);
		
		pelikula.sartuAktorea(aktore1);
		AktoreZerrenda aktoreZerrenda = pelikula.aktoreakBueltatu();
		assertSame(aktoreZerrenda.getZerrenda().size(), 1);
		
		pelikula.aktoreaEzabatu(aktore1);
		assertSame(aktoreZerrenda.getZerrenda().size(), 0);
	}
	
}
