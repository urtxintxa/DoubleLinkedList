package org.minakdev.DoubleLinkedList;

public class PruebaOrderedDoubleLinkedList {	
		
		public static void main(String[] args)  {
			
			OrderedDoubleLinkedList<Integer> l = new OrderedDoubleLinkedList<Integer>();
			l.add(1);
			l.add(3);
			l.add(6);
			l.add(7);
			l.add(9);
			l.add(0);
			l.add(20);
			l.remove(new Integer(7));

			
			System.out.print(" Lista ...............");
			l.visualizarNodos();
			System.out.println(" Elementu-kopurua: " + l.size());
					
			
			System.out.println("Proba Find ...............");
			System.out.println("20? " + l.find(20));
			System.out.println("9? " + l.find(9));
			System.out.println("9? " + l.find(9));
			System.out.println("0? " + l.find(0));
			System.out.println("7? " + l.find(7));
			
			
			
			OrderedDoubleLinkedList<Pertsona> l2 = new OrderedDoubleLinkedList<Pertsona>();
			l2.add(new Pertsona("jon", "1111"));
			l2.add(new Pertsona("ana", "7777"));
			l2.add(new Pertsona("amaia", "3333"));
			l2.add(new Pertsona("unai", "8888"));
			l2.add(new Pertsona("pedro", "2222"));
			l2.add(new Pertsona("olatz", "5555"));

			l2.remove(new Pertsona("", "8888"));

			
			System.out.print(" Lista ...............");
			l2.visualizarNodos();
			System.out.println(" Elementu-kopurua: " + l2.size());
					
			
			System.out.println("Proba Find ...............");
			System.out.println("2222? " + l2.find(new Pertsona("", "2222")));
			System.out.println("5555? " + l2.find(new Pertsona("", "5555")));
			System.out.println("7777? " + l2.find(new Pertsona("", "7777")));	
			System.out.println("8888? " + l2.find(new Pertsona("", "8888")));	
			
			
	}
	}

