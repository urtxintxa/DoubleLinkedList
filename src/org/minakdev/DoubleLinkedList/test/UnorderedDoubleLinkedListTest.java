package org.minakdev.DoubleLinkedList.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.DoubleLinkedList.UnorderedDoubleLinkedList;

public class UnorderedDoubleLinkedListTest {
	
	private UnorderedDoubleLinkedList<Integer> unordered;

	@Before
	public void setUp() throws Exception {
		unordered = new UnorderedDoubleLinkedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		unordered = null;
	}

	@Test
	public void testAddToFront() {
		assertSame(unordered.size(),0);
		unordered.addToFront(2);
		assertTrue(unordered.first().equals(2));
		assertTrue(unordered.last().equals(2));
		assertSame(unordered.size(),1);
		
		unordered.addToFront(1);
		assertSame(unordered.size(),2);
		assertTrue(unordered.first().equals(1));
		assertTrue(unordered.last().equals(2));
		
		unordered.addToFront(23);
		assertSame(unordered.size(),3);
		assertTrue(unordered.first().equals(23));
		assertTrue(unordered.last().equals(2));
		unordered.adabegiakInprimatu();
		
	}

	@Test
	public void testAddToRear() {
		assertSame(unordered.size(),0);
		unordered.addToRear(2);
		assertTrue(unordered.first().equals(2));
		assertTrue(unordered.last().equals(2));
		assertSame(unordered.size(),1);
		
		unordered.addToRear(1);
		assertTrue(unordered.first().equals(2));
		assertTrue(unordered.last().equals(1));
		assertSame(unordered.size(),2);
		
		unordered.addToRear(213);
		assertTrue(unordered.first().equals(2));
		assertTrue(unordered.last().equals(213));
		assertSame(unordered.size(),3);
		
		unordered.adabegiakInprimatu();
	}

	@Test
	public void testAddAfter() {
		unordered.addToFront(1);
		
		unordered.addAfter(2, 1);
		assertTrue(unordered.last().equals(2));
		
		unordered.addToRear(3);
		unordered.addToRear(4);
		unordered.addToRear(5);
		
		assertSame(unordered.size(),5);
		unordered.addAfter(12, 1);
		assertSame(unordered.size(),6);
		unordered.addAfter(34, 3);
		assertSame(unordered.size(),7);
		unordered.addAfter(56, 5);
		assertSame(unordered.size(),8);
		assertSame(unordered.last(),56);
		unordered.adabegiakInprimatu();
	}

}
