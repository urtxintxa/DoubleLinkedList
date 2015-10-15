package org.minakdev.DoubleLinkedList;

import java.util.Iterator;

public interface ListADT<T> {


public void setDeskr(String izena); // Listaren izena eguneratzen du

public String getDeskr(); // Listaren izena bueltatzen du


public T removeFirst(); // listako lehen elementua kendu da

public T removeLast(); // listako azken elementua kendu da

public T remove(T elem); // Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia bueltatuko du (null ez baldin badago)

public T first(); // listako lehen elementua ematen du

public T last(); // listako azken elementua ematen du

public boolean contains(T elem); // Egiazkoa bueltatuko du aurkituz gero, eta false bestela

public T find(T elem); // Elementua bueltatuko du aurkituz gero, eta null bestela

public boolean isEmpty(); // hutsa den esango du

public int size(); // Listako elementu-kopurua

public Iterator<T> iterator(); // Listako elementuen iteradorea


}
