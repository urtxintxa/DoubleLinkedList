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
        assertSame(l.first(),1);
        l.removeFirst();
        assertSame(l.first(),3);
        l = new UnorderedDoubleLinkedList<>();
        l.addToFront(2);
        assertSame(l.first(), 2);
        l.removeFirst();
        assertSame(l.first(), null);
    }

    @Test
    public void testRemoveLast() {
        assertSame(l.last(), 8);
        l.removeLast();
        assertSame(l.last(), 20);
        l = new UnorderedDoubleLinkedList<>();
        l.addToFront(2);
        assertSame(l.last(), 2);
        l.removeLast();
        assertSame(l.last(), null);
    }

    @Test
    public void testRemove() {
        fail("Not yet implemented");
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
        fail("Not yet implemented");
    }

    @Test
    public void testSize() {
        fail("Not yet implemented");
    }

    @Test
    public void testIterator() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdabegiakInprimatu() {
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

}