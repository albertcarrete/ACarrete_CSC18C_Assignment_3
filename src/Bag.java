import java.lang.reflect.Array;


public class Bag<T extends Comparable<T>> implements BagInterface<T>{
	
	private T[] bag_items;
	private int numberOfEntries;	
	Class <T> clazz;
	
	// Parameter-less constructor not allowed, omitted
	
	// Single parameter instructor that takes in the type 
	@SuppressWarnings("unchecked")
	public Bag(Class<T> clazz){
		this.clazz = clazz;
		bag_items = (T[]) Array.newInstance(this.clazz, 10);
		
	}
	// Two parameter constructor that takes in the type
	// and the starting size of the array. 
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
	
	public T[] selectionSort(boolean x){
		T[] selectionArray = copyArray(this.bag_items);
		selectionSort(selectionArray,x);
		return selectionArray;
	}
	private void selectionSort(T[]a, boolean x){
		
		for(int i = 0; i < a.length - 1; i++){
			// Store minimum index iterator
			int min = i;	
			for(int j = i+1; j < a.length; j++){
				// ascending
				if(x){
					if(a[j].compareTo(a[min])<0){
						min = j;
					}					
				}else{
				// descending
					if(a[j].compareTo(a[min])>0){
						min = j;
					}							
				}
			}
			// after loop swap values
			if(min != i){
				swap(a,i,min);
			}
		}
	}
	
	/* Array-Based Merge Sort 
	 * 
	 * Takes boolean argument true-ascending and
	 * false-descending.
	 * 
	 * */	
	public T[] mergeSort(boolean x){
		if(this.numberOfEntries > 1){
			T[] mergeArray = copyArray(this.bag_items);
			mergeSort(mergeArray,x);
			return mergeArray;
		}
		return this.bag_items;
	}
	
	private void mergeSort(T[] a,boolean x){
		
		if(a.length <=1){
			return;
		}else{
			
			int middle = (int)a.length / 2;
			
			T[] left 	= copyArray(a,0,a.length-middle);
			T[] right 	= copyArray(a,(a.length - middle), a.length);

			mergeSort(left,x);
			mergeSort(right,x);
			merge(left,right,a,x);			
		}	
	}
	
	private void merge(T[]left, T[]right, T[]result,boolean x){
		
		int posLeft = 0;
		int posRight = 0;
		int posResult = 0;

//		System.out.println("MERGING FOLLOWING SECTIONS:");
//		System.out.print("Left: "); displayArray(left);
//		System.out.print("Right: "); displayArray(right);
//		System.out.print("Result: "); displayArray(result);
//
//		System.out.println("======================");


		while(posLeft < left.length || posRight < right.length){
			
			// if right is used up, just pass in left
			if(posRight >= right.length){
				result[posResult] = left[posLeft];
				posLeft++;
			}
			// if left is used up, just pass in right
			else if(posLeft >= left.length){
				result[posResult] = right[posRight];
				posRight++;				
			}else{
				// Ascending, descending selector
				if(x){
					if((left[posLeft].compareTo(right[posRight])<0)){
						result[posResult] = left[posLeft];
						posLeft++;
					}else{
						result[posResult] = right[posRight];
						posRight++;
					}					
				}else{
					if((left[posLeft].compareTo(right[posRight])>0)){
						result[posResult] = left[posLeft];
						posLeft++;
					}else{
						result[posResult] = right[posRight];
						posRight++;
					}					
				}

			}
			

			posResult++;
			
		}
//		System.out.println("======================");
//		System.out.println("RESULTING ARRAY");
//		displayArray(result);
//		System.out.println("**** **** **** ****");
		
	}
	/* Array-Based Bubble Sort 
	 * 
	 * Takes boolean argument true-ascending and
	 * false-descending.
	 * 
	 * */	
	public T[] bubbleSort(boolean x){
		if(this.numberOfEntries > 1){
			T[] bubbleArray = copyArray(this.bag_items);
			bubbleSort(bubbleArray,x);
			return bubbleArray;
		}
		return this.bag_items;
	}
	
	public void bubbleSort(T[]a, boolean x){
		
		boolean progress = true;
		
		// Run through this while loop until no swaps are performed
		while(progress){
			progress=false;
			// Loop through array
			for(int i = 0; i < a.length-1; i++){
				
				if(x){
					// swap if greater than
					if(a[i].compareTo(a[i+1])>0){
						swap(a,i,i+1);
						progress = true;
					}					
				}else{
					// swap if less than
					if(a[i].compareTo(a[i+1])<0){
						swap(a,i,i+1);
						progress = true;
					}						
				}	
			}	
		}	
	}
	
	/* Swap function that takes in an array and two positions
	 * and swaps the two positions. */
	
	private void swap(T[]a, int pos1, int pos2){
		T temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
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
