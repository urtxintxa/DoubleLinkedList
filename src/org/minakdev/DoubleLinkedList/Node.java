package org.minakdev.DoubleLinkedList;

public class Node<T> {
	public T data; 			// Nodoaren datua
	public Node<T> next; 	// Zerrendaren hurrengo nodoaren erakuslea
	public Node<T> prev;	// Zerrendaren aurreko nodoaren erakuslea

	public Node(T dd)
	{
		data = dd;
		next = null;
		prev = null;
	}
}


