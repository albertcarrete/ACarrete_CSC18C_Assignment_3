/*
 * Implement the following:
 * 
 * 1) Resizing the array when the number of items exceeds the size of the array (no linked lists allowed - yet)
 * 
 * 
 * */


public class BagDemo {

	public static void main(String[] args) {
		
		Bag<String> bag_of_strings = new Bag();
		
		bag_of_strings.add("Hello");
		bag_of_strings.add("World");
		bag_of_strings.add("Structures");
		bag_of_strings.add("Data");
		bag_of_strings.add("Structures2");
		bag_of_strings.add("Structures1");
		
		System.out.println("Size of bag of strings = " + bag_of_strings.getSize());
		System.out.println("Contents of bag_of_strings:");
		Object[] a = bag_of_strings.toArray();
		
		for(int i = 0; i < a.length; i++){
			System.out.printf("a(%d)=%s\n",i,a[i]);
		}
	}

}
