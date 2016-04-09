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
	
	
	/* Array-Based Selection Sort 
	 * 
	 * Takes boolean argument true-descending and
	 * false-ascending.
	 * 
	 * */
	
	public void selectionSort(boolean x){
		
		for(int i = 0; i < this.numberOfEntries; i++){
			int min = i;
			
			for(int j = i+1; j < this.numberOfEntries; j++){
//				System.out.println("Position is " + i);
//				System.out.println("comparing" + this.bag_items[i] + " to " +this.bag_items[j]);
//				
				// ascending
				if(x == true){
					if(this.bag_items[i].compareTo(this.bag_items[j])>0){
						swap(i,j);
					}					
				}else{
				// descending
					if(this.bag_items[i].compareTo(this.bag_items[j])<0){
						swap(i,j);
					}							
				}
			}
		}
	}
	
	private void swap(int pos1, int pos2){
		T temp = this.bag_items[pos1];
		this.bag_items[pos1] = this.bag_items[pos2];
		this.bag_items[pos2] = temp;
	}
	
	
	public void mergeSort(boolean x){
		if(this.numberOfEntries > 1){
			
			T[] mergeArray = copyArray(this.bag_items);
			displayArray(mergeArray);
			mergeSort(mergeArray);
			displayArray(mergeArray);

		}
	}
	
	private void mergeSort(T[] a){
		
		if(a.length <=1){
//			System.out.println("reached 1");
			return;
		}else{
			
			int middle = (int)a.length / 2;
//			System.out.println("MIDDLE IS " + middle);
			
			T[] left 	= copyArray(a,0,a.length-middle);
			T[] right 	= copyArray(a,(a.length - middle), a.length);
//			System.out.println("");
//			displayArray(left);
//			System.out.println("");
//			displayArray(right);
//			System.out.println("");
//			System.out.println("");

			mergeSort(left);
			mergeSort(right);
			merge(left,right,a);			
		}	
	}
	
	private void merge(T[]left, T[]right, T[]result){
		
		int posLeft = 0;
		int posRight = 0;
		int posResult = 0;

		System.out.println("MERGING FOLLOWING SECTIONS:");
		System.out.print("Left: "); displayArray(left);
		System.out.print("Right: "); displayArray(right);
		System.out.print("Result: "); displayArray(result);

		System.out.println("======================");


		while(posLeft < left.length || posRight < right.length){
			System.out.println("posLeft " + posLeft + " / " + left.length);
			System.out.println("posRight " + posRight + " / " + right.length);


			
			// if right is completed, just pass in left
			if(posRight >= right.length){
				result[posResult] = left[posLeft];
				posLeft++;
			}
			// if left is used up, just pass in right
			else if(posLeft >= left.length){
				result[posResult] = right[posRight];
				posRight++;				
			}else{
				if((left[posLeft].compareTo(right[posRight])<0)){
					System.out.println("LEFT");
					result[posResult] = left[posLeft];
					posLeft++;
				}else{
					System.out.println("RIGHT");
					result[posResult] = right[posRight];
					posRight++;
				}
			}
			

			posResult++;
			
		}
		System.out.println("======================");
		System.out.println("RESULTING ARRAY");
		displayArray(result);
		System.out.println("**** **** **** ****");
		
	}
	@SuppressWarnings("unchecked")	
	private T[] copyArray(T[]a){
		
		int validSize = 0;
		
		for(int i = 0; i < a.length; i++){
			if(a[i] == null){
				break;
			}else{
				validSize++;
			}
		}
		T[]b = (T[]) Array.newInstance(this.clazz,validSize);

		for(int i = 0; i < validSize; i++){
			b[i] = a[i];
		}
		
		return b;
	}
	@SuppressWarnings("unchecked")
	private T[] copyArray(T[]a,int start, int end){
		
		
		T[]b = (T[]) Array.newInstance(this.clazz,end-start);
		
//		System.out.println("The input array length is " + a.length);
//		System.out.println("Start point is " + start);
//		System.out.println("End point is " + end);
//
//		System.out.println("The copy array length is " + b.length);

		if(end-start == 0){
			b[0] = a[0];
		}else{
			for(int i = 0; i < end-start; i++){
//				System.out.println("b[" + i + "] = " + b[i] + " | a[" + (start+i) + "] = " + a[i]);

				b[i] = a[start+i];
			}			
		}

		
		return b;
	}
	
	private void displayArray(T[]a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}		
		System.out.println("");
	}
	
	
}
