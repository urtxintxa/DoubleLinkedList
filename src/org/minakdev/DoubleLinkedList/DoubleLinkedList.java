package org.minakdev.DoubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> first; // lehenengoaren erreferentzia
	protected Node<T> last;
	protected String deskr;  // deskribapena
	protected int count;

	public DoubleLinkedList() {
		first = null;
		last = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
		deskr = ize;
	}

	public String getDeskr() {
		return deskr;
	}

	public T removeFirst() {
	// listako lehen elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
	// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: zerrenda ez da hutsa
	// KODEA OSATU ETA KOSTUA KALKULATU
	}


	public T remove(T elem) {
	// Aurrebaldintza: zerrenda ez da hutsa
	// Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
	//  bueltatuko du (null ez baldin badago)
	
	
	// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
	  if (isEmpty())
	      return false;
	
	  boolean found = false;
	  Node<T> current = first; // Bigarren elementuarekin hasiko da
	
	      while ((current != null) && !elem.equals(current.data)) 
	            current = current.next;
	              if (current == null) return false;
	      else return elem.equals(current.data);
	   }

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela

		// KODEA OSATU ETA KOSTUA KALKULATU
		
		
	}

	public boolean isEmpty() { 
		return first == null;
	}
	
	public int size() { 
		return count;
	}
	
	public Iterator<T> iterator() { 
		return new ListIterator(); 
	} 

	private class ListIterator implements Iterator<T> {

		private int indizea = 0; //Hasieran indizea 0 balioa edukiko du.
		private Node<T> egungoElementua = first.next;
		private Node<T> begiratutakoAzkena = null;
		
		@Override
		public boolean hasNext() {
			return (indizea < count);
		}

		@Override
		public T next() {
			T t = egungoElementua.data;
			begiratutakoAzkena = egungoElementua;
			egungoElementua = egungoElementua.next;
			indizea++;
			return t;
		}
		
	} 
		
	public void adabegiakInprimatu() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}	
	return "SimpleLinkedList " + result + "]";
	}
}
