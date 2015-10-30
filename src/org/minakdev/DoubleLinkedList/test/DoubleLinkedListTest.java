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
        assertSame(l.last(), null);
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
        assertSame(l.first(), null);
        assertSame(l.size(),0);
        l.adabegiakInprimatu();
        l.reverseAdabegiakInprimatu();
    }

    @Test
    public void testRemove() {
    	assertSame(l.size(),8);
    	assertNull(l.remove(new Integer(243))); //ez dago
    	assertSame(l.size(),8);
    	assertNotNull(l.remove(new Integer(7)));//erdian
    	assertSame(l.size(),7);
    	assertNotNull(l.remove(new Integer(1)));//hasieran
    	assertSame(l.size(),6);
    	assertNotNull(l.remove(new Integer(8)));//amaieran
    	assertSame(l.size(),5);
    	l.adabegiakInprimatu();
    	
    	l = new UnorderedDoubleLinkedList<Integer>();
    	l.addToRear(4);
    	assertSame(l.size(),1);
    	assertNull(l.remove(new Integer(2)));
    	assertSame(l.size(),1);
    	assertNotNull(l.remove(new Integer(4)));
    	assertSame(l.size(),0);
    	assertSame(l.last(), null);
        assertSame(l.first(), null);
    }

    @Test
    public void testFirst() {
        assertSame(l.first(),1);
        l = new UnorderedDoubleLinkedList<Integer>();
        assertNull(l.first());
    }

    @Test
    public void testLast() {
        assertSame(l.last(), 8);
        l = new UnorderedDoubleLinkedList<Integer>();
        assertNull(l.last());
    }

    @Test
    public void testContains() {
        assertFalse(l.contains(new Integer(324)));
        assertTrue(l.contains(new Integer(1)));
        assertTrue(l.contains(new Integer(7)));
        assertTrue(l.contains(new Integer(8)));
        
        l = new UnorderedDoubleLinkedList<Integer>();
        assertFalse(l.contains(new Integer(1)));
        
        l.addToRear(3);
        assertFalse(l.contains(new Integer(1)));
        assertTrue(l.contains(new Integer(3)));
    }

    @Test
    public void testFind() {
    	assertNotNull(l.find(1));
    	assertNotNull(l.find(7));
    	assertNotNull(l.find(8));
    	assertNull(l.find(475));
    	
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
        
        l = new UnorderedDoubleLinkedList<Integer>();
        	assertSame(l.size(),0);
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