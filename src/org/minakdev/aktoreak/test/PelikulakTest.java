package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.Pelikula;
import org.minakdev.aktoreak.Pelikulak;

public class PelikulakTest {
	
	Pelikulak gurePelikulak = Pelikulak.getNirePelikulak();
	
	Pelikula pelikula1;
	Pelikula pelikula2;
	
	@Before
	public void setUp() throws Exception {
		pelikula1 = new Pelikula("Pelikula1");
	}

	@After
	public void tearDown() throws Exception {
		pelikula1 = null;
	}
	
	@Test
	public void pelikulaBueltatu() {
		assertSame(gurePelikulak.pelikulaBueltatu("Pelikula1"), null);
	
		gurePelikulak.sartuPelikula(pelikula1);
		assertSame(gurePelikulak.pelikulaBueltatu("Pelikula1"), pelikula1);
	}

}
