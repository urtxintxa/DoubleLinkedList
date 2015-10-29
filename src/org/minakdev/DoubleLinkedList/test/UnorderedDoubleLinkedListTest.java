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
		unordered.addToFront(2);
		unordered.addToFront(1);
		assertTrue(unordered.first().equals(1));
		assertTrue(unordered.last().equals(2));
	}

	@Test
	public void testAddToRear() {
		unordered.addToRear(2);
		unordered.addToRear(1);
		assertTrue(unordered.first().equals(2));
		assertTrue(unordered.last().equals(1));
	}

	@Test
	public void testAddAfter() {
		unordered.addToFront(1);
		unordered.addAfter(2, 1);
		assertTrue(unordered.last().equals(2));
	}

}
