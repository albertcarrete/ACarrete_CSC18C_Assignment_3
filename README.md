# CSC-18C Assignment #3
##### Albert Carrete


This project builds Bags of comparable items and sorts them using three different sorting algorithms which are listed below:

  - Selection Sort
  - Merge Sort
  - Bubble Sort

This project is based on the Bag class designed in Assignment 1. The following are the instructions provided for this assignment

>Implement in your Bag class, the Selection Sort and Merge Sort ( 10 points extra credit - implement a third sorting algorithm of your choice ). In all of the sorting algorithms you implement, make sure to have them pass a boolean parameter that dictates the sorting order ( true - sort in ascending order from smallest to largest, false - sort in descending order from largest to smallest ).

>Provide a main program, that is a test driver, demonstrating the sorting algorithms working for Bags of String, Integers, and Float ( primitive types such as int and float, you need to use the their respective wrapper classes Integer and Float ).

There were a few modifications to the original Class that needed to be made in order to have the functionality specified in the project details. The first changes were made in the way the constructor creates new arrays, previously we instantiated new arrays through the following code snippet:

```
		T[] bag_items = (T[])new Object[10]; 
```

However this generated errors when trying to compare values to each other inside the sorting algorithms because Object doesn't have any comparable methods. To fix this we made two changes, the first to the generic definition at the start of the Bag Class...

```
public class Bag<T> implements BagInterface<T>{...
```
was changed to 

```
public class Bag<T extends Comparable<T>> implements BagInterface<T>{
```

This allowed the bag class to accept generic types that were comparable. These type definitions are defined through the new single parameter constructor:

```
	public Bag(Class<T> clazz){
		this.clazz = clazz;
		bag_items = (T[]) Array.newInstance(this.clazz, 10);
	}
```

This constructor takes a Class<T> clazz parameter which essentially sets the type of values the Class will be receiving and what type of arrays it will need to create to store that data. Here is an example of this constructor being used:

```
	Bag<Integer> bag_of_integers = new Bag<Integer>(Integer.class);
```
Where Integer.class is the Class<T> clazz paramater required for type defintion. This is an important piece of code because it's the only way the program is able to delineate which type to accept, otherwise comparable generics inside arrays would be impossible and some other utility like Lists would need to be used. 

The last and final change to this logic would be in the actual creation of the array in the constructor and is shown here:
```
	bag_items = (T[]) Array.newInstance(this.clazz, 10);
```

The three sorting algorithms followed the same pattern of using overloadeded functions to create a wrapper function so the function could perform a copy before running through the actual sorting process. Here are examples taken from the selectionSort and mergeSort code:

```
	public T[] selectionSort(boolean x){
		T[] selectionArray = copyArray(this.bag_items);
		selectionSort(selectionArray,x);
		return selectionArray;
	}
```
```
	public T[] mergeSort(boolean x){
			T[] mergeArray = copyArray(this.bag_items);
			mergeSort(mergeArray,x);
			return mergeArray;
	}
```

In order to create a non-destructive process that maintains the original array we use a copyArray function to save a new array which is then used in the sorting algorithm. This array is then returned through the function so that it can be printed out in the programs driver through a static function or the like. 
