/** * IndexedListADT defines the interface to an indexed list collection. Elements * are referenced by contiguous numeric indexes.
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */
package org.minakdev.DoubleLinkedList;public interface IndexedListADT<T> extends ListADT<T>{   /**  
    * Inserts the specified element at the specified index. 
    * 
    * @param index   the index into the array to which the element is to be
    *                inserted.
    * @param element the element to be inserted into the array   
    */   public void add (int index, T element);   /**  
    * Sets the element at the specified index. 
    *
    * @param index   the index into the array to which the element is to be set
    * @param element the element to be set into the list
    */   public void set (int index, T element);   /**  
    * Adds the specified element to the rear of this list. 
    *
    * @param element  the element to be added to the rear of the list    
    */   public void add (T element);   /**  
    * Returns a reference to the element at the specified index. 
    *
    * @param index  the index to which the reference is to be retrieved from
    * @return       the element at the specified index    
    */   public T get (int index);   /**  
    * Returns the index of the specified element. 
    *
    * @param element  the element for the index is to be retrieved
    * @return         the integer index for this element    
    */   public int indexOf (T element);   /**  Removes and returns the element at the specified index. */   public T remove (int index);}
