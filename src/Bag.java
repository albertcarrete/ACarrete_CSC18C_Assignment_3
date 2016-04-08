import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Bag<T extends Comparable<T>> implements BagInterface<T>{
	
	private T[] bag_items;
	private int numberOfEntries;	
	private List<T> list;
	private T[] arrCopy;
	Class <T> clazz;
	
	// Parameter-less constructor not allowed
	@SuppressWarnings("unchecked")
	public Bag(){
		
//		bag_items = (T[])Array.newInstance(clazz,10);
		// Arrays are covariant, they retain the type of their elements at runtime
		// while Java's generics do not. In order to work around this issue we can
		// use either Array.newInstance() or make use of Lists. 
		
		bag_items = (T[])new Object[10]; // default 10 item bag
		list = new ArrayList<T> (10);
		System.out.println(Bag.class);
		
		this.numberOfEntries = 0;
		
//		@SuppressWarnings("unchecked")
////		arrCopy = (T[]) Array.newInstance(bag_items.getClass().getComponentType(), 10);
		
	}
	@SuppressWarnings("unchecked")
	public Bag(Class<T> clazz){
		this.clazz = clazz;
		bag_items = (T[]) Array.newInstance(this.clazz, 10);
		
	}
	@SuppressWarnings("unchecked")
	public Bag(Class<T> clazz, int startSize){
		this.clazz = clazz;
		bag_items = (T[]) Array.newInstance(this.clazz, startSize);
		this.numberOfEntries = 0;
	}
	
	public int getSize(){
		return this.numberOfEntries;
	}
	
	public boolean isEmpty(){
		return this.numberOfEntries == 0;
	}
	
	public boolean add(T item){
		if(this.numberOfEntries >= bag_items.length) return false; // cannot add more items
		bag_items[numberOfEntries++] = item;
		
		return true;
	}
	
	public boolean remove(T item){
		for(int i=0; i<this.numberOfEntries; i++){
			if(this.bag_items[i] == item){
				for(int j=i+1; j<this.numberOfEntries;j++){
					this.bag_items[j-1] = this.bag_items[j];
				}
				this.numberOfEntries--;
				return true;
			}
		}
		return false;
	}
	
	public void clear(){
		this.numberOfEntries = 0; // just reset numberOfentries to zero and overwrite the old data when
	}
	
	public boolean contains(T item){
		for(int i = 0; i<this.numberOfEntries;i++){
			if(bag_items[i]==item){
				return true;
			}
		}
		return false;
	}
	
	// TODO: fix so that you can't run out of memory
	@SuppressWarnings("unchecked")
	public T[] toArray(){
		T[] arr = (T[]) Array.newInstance(this.clazz, this.numberOfEntries);
		for(int i = 0; i<this.numberOfEntries;i++){
			arr[i] = this.bag_items[i];
		}
		return arr;
	}
	
	
	// TODO complete selectionSort code
	public void selectionSort(boolean x){
		
		for(int i = 0; i < this.numberOfEntries; i++){
			int min = i;
			
			for(int j = i+1; j < this.numberOfEntries; j++){
				System.out.println("comparing" + this.bag_items[i] + " to " +this.bag_items[j]);
				this.bag_items[j].compareTo(this.bag_items[i]);
				
			}
			
		}
	}
	
	// Function that compares first two values, just a tester
	public void selectionSort(){
		
		
		if(bag_items[0].compareTo(bag_items[1])>0){
			System.out.println("Entry [0]:" + arrCopy[0] + " is greater than " + "Entry[1]:" + arrCopy[1]);
		}
		

	}
	
	

	

	
	
//	public <T extends Comparable<T>> void sortAscending(T[] values){
//		
//	}
//	public <T extends Comparable<T>> void sortDescending(T[] values){
//		
//	}
	
	
	


}
