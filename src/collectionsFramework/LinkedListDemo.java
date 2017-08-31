package collectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> cars = new LinkedList<String>();
		//Adding items to the array list
		cars.add("BMW");
		cars.add("Honda");
		cars.add("Audi");
		
		//size
		int size = cars.size();
		System.out.println("The size of the list is: " + size);
		
		//Get
		System.out.println("The item on index 1 is: " + cars.get(1));
		
		//Iteration. Will print all elements with index (number)
		System.out.println("Iteration example");
		for (int i=0; i<size; i++){
			System.out.println("Item on index " + i + " is: " + cars.get(i));
		}
		
        //Will print each element in array list  
		System.out.println("\nNext for loop example");
		for (String car : cars){
			System.out.println("The item is: " + car);
		}
		
		//Remove element from array
		cars.remove(size - 1);
		System.out.println("\nNext for loop example after removing");
		for (String car : cars){
			System.out.println("The item is: " + car);
		}
		
		/**
		 * ArrayList - {0, 1, 2, 3, 4, 5,6}
		 * LinkedList - [0] > [1] > [2]
		 *                  <     <
		 * ArrayList - When you have to add the end and remove from the add getting is fast
		 * LinkedList - When you need to add the beginning and remove from the beginning                  
		 */
		
		List<Integer> aList = new ArrayList<Integer>();
		List<Integer> lList = new LinkedList<Integer>();
		
		runDuration(aList, "Array List");
		runDuration(lList, "Linked List");
	}

	public static void runDuration(List<Integer> list, String listType){
		System.out.println("\nBeginning of the duration method for " + listType);
		
		long startTime = System.currentTimeMillis();
		for (int i=0; i<100000; i++){
			list.add(i);
		}
//		int size = list.size();
//		int elementToAdd = size + 100000;
//		for (int i = size; i < elementToAdd; i++){
//			list.add(i);
//			list.add(0, i);
//		}
		for (int i=90000; i<92000; i++){
			list.remove(i);
		}
//		for (int i=0; i<100; i++){
//			list.remove(i);
//		}
//		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Durartion of the list " +listType + " is " + duration + " ms");
		
	}

	}


