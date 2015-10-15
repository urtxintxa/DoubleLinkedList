package org.minakdev.DoubleLinkedList;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	public void addToFront(T elem);
	// elementu bat gehituko du hasieran

	public void addToRear(T elem);
	// elementu bat gehituko du bukaeran
	
	public void addAfter(T elem, T target);
	// "elem" elementua "target" elementuaren ondoren gehitzen du ("target" listan zegoen)


}
