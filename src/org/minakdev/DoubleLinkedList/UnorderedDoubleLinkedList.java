package org.minakdev.DoubleLinkedList;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		Node<T> aux = new Node<T>(elem);
		if(this.count==0){
			this.first = aux;
			this.last = aux;
		}
		else {
			aux.next = this.first;
			this.first.prev = aux;
			this.first = aux;
		}
		this.count++;

	}

	public void addToRear(T elem) {
	// bukaeran gehitu
		Node<T> aux = new Node<T>(elem);
		if(this.count==0){
			this.first = aux;
			this.last = aux;
		}
		else {
			aux.prev = this.last;
			this.last.next = aux;
			this.last = aux;
		}
		this.count++;

	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		Node<T> egungoa = first;
		boolean aurkitua = false;
		Node<T> aux = new Node<T>(elem);
		
		while((egungoa != null) && !aurkitua){
			if(egungoa.data.equals(target)){
				aurkitua = true;
				if(egungoa== last){
					egungoa.next = aux;
					aux.prev = egungoa;
					this.last = aux;
				}
				else{
					aux.prev = egungoa;
					aux.next = egungoa.next;
					egungoa.next.prev = aux;
					egungoa.next = aux;
				}
				this.count++;	
			}
		}
	}

}
