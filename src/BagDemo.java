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
		
		bag_of_integers.add(14);
		bag_of_integers.add(23);
		bag_of_integers.add(53);
		bag_of_integers.add(34);
		bag_of_integers.add(6);
		bag_of_integers.add(66);
		
		System.out.println("Size of bag of strings = " + bag_of_integers.getSize());
		System.out.println("Contents of bag_of_strings:");
		Object[] a = bag_of_integers.toArray();
		
		for(int i = 0; i < a.length; i++){
			System.out.printf("a(%d)=%s\n",i,a[i]);
		}
		
		// Bag of Strings
	
		Bag<String> bag_of_strings = new Bag<String>(String.class);
		
		bag_of_strings.add("Interstellar");
		bag_of_strings.add("Gladiator");
		bag_of_strings.add("Ex Machina");
		bag_of_strings.add("Ghostbusters");
		bag_of_strings.add("Pulp Fiction");
		bag_of_strings.add("Hateful 8");
		
		System.out.println("Size of bag of strings = " + bag_of_strings.getSize());
		System.out.println("Contents of bag_of_strings:");
		Object[] b = bag_of_strings.toArray();
		
		for(int i = 0; i < b.length; i++){
			System.out.printf("a(%d)=%s\n",i,b[i]);
		}		
	}

}