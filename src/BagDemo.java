/*
 * Implement the following:
 * 
 * 1) Resizing the array when the number of items exceeds the size of the array (no linked lists allowed - yet)
 * 
 * 
 * */


public class BagDemo {

	public static void main(String[] args) {
		
		
		// Bag of Integers
		
		Bag<Integer> bag_of_integers = new Bag<Integer>(Integer.class);
		
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
		System.out.println("Size of bag of strings = " + bag_of_integers.getSize());

		Object[] integer_array = bag_of_integers.toArray();
		Object[] integer_selection = bag_of_integers.selectionSort(true);
		Object[] integer_merge = bag_of_integers.mergeSort(true);

		displayArray("Original",integer_array);
		displayArray("Selection Sort",integer_selection);
		displayArray("Merge Sort",integer_merge);

				
		// Bag of Strings
	
		Bag<String> bag_of_strings = new Bag<String>(String.class);
		
		bag_of_strings.add("Bubble Boy");
		bag_of_strings.add("Anchorman");
		bag_of_strings.add("Interstellar");
		bag_of_strings.add("Ghostbusters");
		bag_of_strings.add("Pulp Fiction");
		bag_of_strings.add("Ex Machina");
		System.out.println("Size of bag of strings = " + bag_of_strings.getSize());

		
		Object[] string_array = bag_of_strings.toArray();
		Object[] string_selection = bag_of_strings.selectionSort(true);
		Object[] string_merge = bag_of_strings.mergeSort(true);

		displayArray("Original",string_array);
		displayArray("Selection Sort",string_selection);
		displayArray("Merge Sort",string_merge);
						
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