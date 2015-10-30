package org.minakdev.DoubleLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

    // Atributuak
    protected Node<T> first; // lehenengoaren erreferentzia
    protected Node<T> last; // azkenaren erreferentzia
    protected String deskr;  // deskribapena
    protected int count; // elementuen kopurua

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
        T o = first.data;
        if (last == first){
            last  = null;
            first = null;
        }
        else{
            first = first.next;
            first.prev = null;
        }
        count--;
        return o;
    }

    public T removeLast() {
    // listako azken elementua kendu da
    // Aurrebaldintza: zerrenda ez da hutsa
        T o = last.data;
        if (last == first){
            last  = null;
            first = null;
        }
        else{
            last = last.prev;
            last.next = null;
        }
        count--;
        return o;
    }

    public T remove(T elem) {
    // Aurrebaldintza: zerrenda ez da hutsa
    // Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia 
    //  bueltatuko du (null ez baldin badago)
        T o = null;
        Node<T> egungoa = first;
        
        while((egungoa != null) && (o == null)){
            if (egungoa.data.equals(elem)){
                o = egungoa.data;
                if(egungoa == first){
                    this.removeFirst();
                }
                else if(egungoa == last){
                    this.removeLast();
                }
                else{
                    egungoa.prev.next = egungoa.next;
                    egungoa.next.prev = egungoa.prev;
                    count--;
                }
            }
            else{ egungoa = egungoa.next;}
            
        }
        return o;
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
      
      Node<T> current = first; // Bigarren elementuarekin hasiko da
    
          while ((current != null) && !elem.equals(current.data)) 
                current = current.next;
                  if (current == null) return false;
          else return elem.equals(current.data);
       }

    public T find(T pElementua) {
        T elementua = null;
    
        Iterator<T> it = iterator();
        boolean topatua = false;
        
        while (it.hasNext() && !topatua) {
            elementua = it.next();
            if(pElementua.equals(elementua)) {
                topatua = true;
            }
        }
        if(topatua){
            return elementua;
        }
        else{
            return null;
        }
        
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

    public Iterator<T> reverseIterator() { 
        return new ReverseListIterator(); 
    } 

    private class ListIterator implements Iterator<T> {
        
        private Node<T> egungoElementua = first;
        
        @Override
        public boolean hasNext() {
            return (egungoElementua != null);
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T t = egungoElementua.data;
            egungoElementua = egungoElementua.next;
            return t;
        }
        
    } 
    
    private class ReverseListIterator implements Iterator<T> {

        
        private Node<T> egungoElementua = last;
        
        @Override
        public boolean hasNext() {
            return (egungoElementua != null);
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T t = egungoElementua.data;
            egungoElementua = egungoElementua.prev;
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
    return "SimpleLinkedList " + result;
    }
    
    public void reverseAdabegiakInprimatu() {
        System.out.println(this.reverseToString());
    }
    
    public String reverseToString() {
        String result = new String();
        Iterator<T> it = reverseIterator();
        while (it.hasNext()) {
            T elem = it.next();
            result = result + "[" + elem.toString() + "] \n";
        }    
    return "SimpleLinkedList " + result;
    }
}