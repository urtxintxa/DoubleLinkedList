package org.minakdev.DoubleLinkedList.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.minakdev.DoubleLinkedList.UnorderedDoubleLinkedList;

public class DoubleLinkedListTest {
    
    UnorderedDoubleLinkedList<Integer> l;
    
    @Before
    public void setUp() throws Exception {
        l = new UnorderedDoubleLinkedList<Integer>();
        l.addToRear(1);
        l.addToRear(3);
        l.addToRear(9);
        l.addToRear(7);
        l.addToRear(6);
        l.addToRear(0);
        l.addToRear(20);
        l.addToRear(8);
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void testRemoveFirst() {
    	System.out.println("Revome first________");
        assertSame(l.first(),1);
        assertSame(l.size(),8);
        l.removeFirst();
        assertSame(l.first(),3);
        assertSame(l.size(),7);
        l.adabegiakInprimatu();
        l.reverseAdabegiakInprimatu();
        l = new UnorderedDoubleLinkedList<>();
        l.addToFront(2);
        assertSame(l.first(), 2);
        assertSame(l.size(),1);
        l.removeFirst();
        assertSame(l.first(), null);
        assertSame(l.size(),0);
        l.adabegiakInprimatu();
        l.reverseAdabegiakInprimatu();
    }

    @Test
    public void testRemoveLast() {
    	System.out.println("Revome last________");
        assertSame(l.last(), 8);
        assertSame(l.size(),8);
        l.removeLast();
        assertSame(l.last(), 20);
        assertSame(l.size(),7);
        l.adabegiakInprimatu();
        l.reverseAdabegiakInprimatu();
        l = new UnorderedDoubleLinkedList<>();
        l.addToFront(2);
        assertSame(l.last(), 2);
        assertSame(l.size(),1);
        l.removeLast();
        assertSame(l.last(), null);
        assertSame(l.size(),0);
        l.adabegiakInprimatu();
        l.reverseAdabegiakInprimatu();
    }

    @Test
    public void testRemove() {
    	assertSame(l.size(),8);
    	assertNull(l.remove(new Integer(243)));
    	assertSame(l.size(),8);
    	assertNotNull(l.remove(new Integer(7)));
    	assertSame(l.size(),7);
    }

    @Test
    public void testFirst() {
        assertSame(l.first(),1);
    }

    @Test
    public void testLast() {
        assertSame(l.last(), 8);
    }

    @Test
    public void testContains() {
        fail("Not yet implemented");
    }

    @Test
    public void testFind() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsEmpty() {
       assertFalse(l.isEmpty());
       l = new UnorderedDoubleLinkedList<>();
       assertTrue(l.isEmpty());
       l.addToFront(new Integer(1));
       assertFalse(l.isEmpty());
    }

    @Test
    public void testSize() {
        assertSame(l.size(),8);
        l.removeFirst();
        assertSame(l.size(),7);
    }


    @Test
    public void testAdabegiakInprimatu() {
    	l.adabegiakInprimatu();
    }
    
    @Test
    public void testReverseAdabegiakInprimatu() {
    	l.reverseAdabegiakInprimatu();
    }

}