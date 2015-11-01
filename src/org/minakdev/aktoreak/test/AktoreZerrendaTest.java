package org.minakdev.aktoreak.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.aktoreak.AktoreZerrenda;
import org.minakdev.aktoreak.Aktorea;

public class AktoreZerrendaTest {
	
	private AktoreZerrenda aktoreZerrenda;
	private Aktorea aktore1;
	private Aktorea aktore2;
	private Aktorea aktore3;
	private Aktorea aktore4;

	@Before
	public void setUp() throws Exception {
		aktoreZerrenda = new AktoreZerrenda();
		
		aktore1 = new Aktorea("Aktore1");
		aktore2 = new Aktorea("Aktore2");
		aktore3 = new Aktorea("Aktore3");
		aktore4 = new Aktorea("Aktore4");
	}

	@After
	public void tearDown() throws Exception {
		aktoreZerrenda = null;
		aktore1 = null;
		aktore2 = null;
		aktore3 = null;
		aktore4 = null;
	}
	
	@Test
	public void aktoreaSartu() {
		aktoreZerrenda.aktoreaSartu(aktore2);
		assertSame(aktoreZerrenda.getZerrenda().size(), 1);
		
		aktoreZerrenda.aktoreaSartu(aktore1);
		assertSame(aktoreZerrenda.getZerrenda().size(), 2);
	}
	
	@Test
	public void aktoreaTxertatu() {
		
		aktoreZerrenda.aktoreaTxertatu("Aaktore");
		assertSame(aktoreZerrenda.getZerrenda().size(), 1);
		
		aktoreZerrenda.aktoreaTxertatu("Aaktore");
		assertSame(aktoreZerrenda.getZerrenda().size(), 1);
		
		aktoreZerrenda.aktoreaTxertatu("Baktore");
		assertSame(aktoreZerrenda.getZerrenda().size(), 2);
		
		aktoreZerrenda.aktoreaTxertatu("Baktore");
		assertSame(aktoreZerrenda.getZerrenda().size(), 2);
		
		aktoreZerrenda.aktoreaSartu(new Aktorea("Caktore"));
		
		aktoreZerrenda.aktoreaTxertatu("Baktore");
		assertSame(aktoreZerrenda.getZerrenda().size(), 3);
		
		aktoreZerrenda.aktoreaTxertatu("AAA");
		assertSame(aktoreZerrenda.getZerrenda().size(), 4);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktoreZerrenda.aktoreaBilatu("AAA")), 0);
		
		aktoreZerrenda.aktoreaTxertatu("BBB");
		assertSame(aktoreZerrenda.getZerrenda().size(), 5);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktoreZerrenda.aktoreaBilatu("BBB")), 2);
		
		aktoreZerrenda.aktoreaTxertatu("ZZZ");
		assertSame(aktoreZerrenda.getZerrenda().size(), 6);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktoreZerrenda.aktoreaBilatu("ZZZ")), 5);
		
	
		
	}
	
	@Test
	public void aktoreaBilatu() {
		//zerrenda hutsa
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore2"), null);
		
		//Zerrendan aktore bakarra egonik, hau egotea
		aktoreZerrenda.aktoreaSartu(aktore1);
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore1"), aktore1);
		
		//Zerrendan aktore bakarra egonik, hau ez egotea
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore2"), null);
		
		
		//Zerrendan aktore bat baino gehiago egonik:
		aktoreZerrenda.aktoreaSartu(aktore2);
		aktoreZerrenda.aktoreaSartu(aktore3);
		aktoreZerrenda.aktoreaSartu(aktore4);
		//Aktorea hasieran egotea
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore1"), aktore1);
		//Aktorea amaieran egotea
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore4"), aktore4);
		//Aktorea erdialdetik egotea
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore2"), aktore2);
		//Aktorea ez egotea
		assertSame(aktoreZerrenda.aktoreaBilatu("Aktore5"), null);
	}
	
	@Test
	public void aktoreakOrdenatu() {
		//Zerrendan aktorerik ez izatea
		aktoreZerrenda.aktoreakOrdenatu();
		
		//Zerrendak elementu bakarra izatea
		aktoreZerrenda.aktoreaSartu(aktore1);
		aktoreZerrenda.aktoreakOrdenatu();
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore1), 0);
		
		//Zerrendan elementu bat baino gehiago egotea, eta hauek ordenatuta egotea (Atik Zra)
		aktoreZerrenda=new AktoreZerrenda();
		aktoreZerrenda.aktoreaSartu(aktore1);
		aktoreZerrenda.aktoreaSartu(aktore2);
		aktoreZerrenda.aktoreaSartu(aktore3);
		aktoreZerrenda.aktoreaSartu(aktore4);
		aktoreZerrenda.aktoreakOrdenatu();
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore1), 0);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore2), 1);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore3), 2);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore4), 3);
		
		//Zerrendan elementu bat baino gehiago egotea, eta hauek ordenatuta egotea (Ztik Ara)
		aktoreZerrenda=new AktoreZerrenda();
		aktoreZerrenda.aktoreaSartu(aktore4);
		aktoreZerrenda.aktoreaSartu(aktore3);
		aktoreZerrenda.aktoreaSartu(aktore2);
		aktoreZerrenda.aktoreaSartu(aktore1);
		aktoreZerrenda.aktoreakOrdenatu();
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore1), 0);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore2), 1);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore3), 2);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore4), 3);
		
		//Zerrendan elementu bat baino gehiago egotea, eta hauek desordenatuta egotea
		aktoreZerrenda=new AktoreZerrenda();
		aktoreZerrenda.aktoreaSartu(aktore4);
		aktoreZerrenda.aktoreaSartu(aktore1);
		aktoreZerrenda.aktoreaSartu(aktore2);
		aktoreZerrenda.aktoreaSartu(aktore3);
		aktoreZerrenda.aktoreakOrdenatu();
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore1), 0);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore2), 1);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore3), 2);
		assertSame(aktoreZerrenda.getZerrenda().indexOf(aktore4), 3);
	}
	
	@Test
	public void aktoreaEzabatu() {
		
		aktoreZerrenda.aktoreaSartu(aktore1);
		assertSame(aktoreZerrenda.getZerrenda().size(), 1);
		
		aktoreZerrenda.aktoreaEzabatu(aktore1);
		assertSame(aktoreZerrenda.getZerrenda().size(), 0);
	}

}
