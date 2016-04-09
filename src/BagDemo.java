/*
 * Project: 	CSC-18C Assignment 3
 * Developer: 	Albert Carrete
 * Course: 		CSC-18C-42847
 * 
 * Implement in your Bag class, the Selection Sort and Merge Sort.
 * In all of the sorting algorithms you implement, make sure to
 * have them pass a boolean parameter that dictates the sorting
 * order. Provide a main program, that is a test driver, 
 * demonstrating the sorting algorithms working for Bags of Strings,
 * Integers, and Floats.
 * 
 * */


public class BagDemo {

	public static void main(String[] args) {
		
		
		// Bag of Integers
		Bag<Integer> bag_of_integers = new Bag<Integer>(Integer.class);
		
		// Add integers to bag
		bag_of_integers.add(45);
		bag_of_integers.add(23);
		bag_of_integers.add(53);
		bag_of_integers.add(34);
		bag_of_integers.add(6);
		bag_of_integers.add(66);
		bag_of_integers.add(21);
		bag_of_integers.add(44);
		bag_of_integers.add(78);
		bag_of_integers.add(4);
		
		// Get bag size;
		System.out.println("Size of bag of strings = " + bag_of_integers.getSize());

		// run sorts 
		Object[] integer_array = bag_of_integers.toArray();
		Object[] integer_selection = bag_of_integers.selectionSort(true);
		Object[] integer_merge = bag_of_integers.mergeSort(true);
		Object[] integer_bubble = bag_of_integers.bubbleSort(true);

		// display arrays
		displayArray("Original",integer_array);
		displayArray("Selection Sort",integer_selection);
		displayArray("Merge Sort",integer_merge);
		displayArray("Bubble Sort",integer_bubble);

				
		// Bag of Strings
		Bag<String> bag_of_strings = new Bag<String>(String.class);
		
		// Add strings to bag
		bag_of_strings.add("Bubble Boy");
		bag_of_strings.add("Anchorman");
		bag_of_strings.add("Interstellar");
		bag_of_strings.add("Ghostbusters");
		bag_of_strings.add("Pulp Fiction");
		bag_of_strings.add("Ex Machina");
		
		// Size of String Bag
		System.out.println("Size of bag of strings = " + bag_of_strings.getSize());

		// run sorts
		Object[] string_array = bag_of_strings.toArray();
		Object[] string_selection = bag_of_strings.selectionSort(true);
		Object[] string_merge = bag_of_strings.mergeSort(true);
		Object[] string_bubble = bag_of_strings.bubbleSort(true);
		
		// Display string arrays
		displayArray("Original",string_array);
		displayArray("Selection Sort",string_selection);
		displayArray("Merge Sort",string_merge);
		displayArray("Bubble Sort",string_bubble);

		
		// Bag of Floats
		Bag<Float> bag_of_floats = new Bag<Float>(Float.class);
	
		// add floats
		bag_of_floats.add(0.4f);
		bag_of_floats.add(23.1f);
		bag_of_floats.add(55.3f);
		bag_of_floats.add(9.3f);
		bag_of_floats.add(11.2f);
		bag_of_floats.add(3.3f);
		
		// Size of float array
		System.out.println("Size of bag of floats = " + bag_of_floats.getSize());

		// run sorts
		Object[] float_array = bag_of_floats.toArray();
		Object[] float_selection = bag_of_floats.selectionSort(true);
		Object[] float_merge = bag_of_floats.mergeSort(true);
		Object[] float_bubble = bag_of_floats.bubbleSort(true);

		// Display float arrays
		displayArray("Original",float_array);
		displayArray("Selection Sort",float_selection);
		displayArray("Merge Sort",float_merge);
		displayArray("Bubble Sort",float_bubble);

	}
	
	public static void displayArray(Object[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}
	public static void displayArray(String title, Object[] a){
		System.out.println(title + ": ");
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println("");
	}

}