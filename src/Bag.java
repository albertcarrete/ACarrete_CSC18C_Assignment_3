public class Bag<T> implements BagInterface<T>{
	
	private T[] bag_items;
	private int numberOfEntries;
	
	@SuppressWarnings("unchecked")
	public Bag(){
		bag_items = (T[])new Object[10]; // default 10 item bag
		this.numberOfEntries = 0;
		
	}
	
	@SuppressWarnings("unchecked")
	public Bag(int startSize){
		bag_items = (T[])new Object[startSize];
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
	public T[] toArray(){
		T[] arr = (T[]) new Object[this.numberOfEntries];
		for(int i = 0; i<this.numberOfEntries;i++){
			arr[i] = this.bag_items[i];
		}
		return arr;
	}
	
}
