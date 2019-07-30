package main.searchalgorithms.myimpl;

import java.util.Arrays;

public class HeapSort {
	public void sort(int[] arr) {
		
		doHeapSort(arr,arr.length-1);
		
		// Web Code
		// HeapWebCode heapWebCode = new HeapWebCode();
		// heapWebCode.sort(arr);
	}
	
	private void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}

	private void doHeapSort(int[] arr, int lastIndex) {
		
		for (int j = (lastIndex/2)-1; j >= 0; j--) {
			doHeap(arr,j);
		}
		
		printArray(arr);
		
		int[] newArr = new int[arr.length];
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			newArr[i] = arr[0];
			
			arr[0] = arr[arr.length-1];
			arr = Arrays.copyOf(arr, arr.length-1);
			if(arr.length == 1) {
				newArr[i+1] = arr[0];
				break;
			}
			doHeap(arr, (arr.length/2)-1);
			
			printArray(arr);
		}
		System.out.println("Sorted Array...");
		printArray(newArr);
	}

	private void doHeap(int[] arr, int index) {
		int nodeIndex = index;
		int lChildIndex = 2*index+1;
		int rChildIndex = (2*index)+2;
		int temporary = 0;
		if(arr.length > lChildIndex && arr[nodeIndex] > arr[lChildIndex]) {
			temporary = arr[nodeIndex];
			arr[nodeIndex] = arr[lChildIndex];
			arr[lChildIndex] = temporary;
		}
		
		if(arr.length > rChildIndex && arr[nodeIndex] > arr[rChildIndex]) {
			temporary = arr[nodeIndex];
			arr[nodeIndex] = arr[rChildIndex];
			arr[rChildIndex] = temporary;
		}
		if(index > 0 ) {
			doHeap(arr, --index);
		}
	}
}

class HeapWebCode{
	
	//to swap two numbers
	private void swap(int[] arr, int a, int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}

	private void heapify(int arr[], int n, int i){
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		// if left child is larger than root
		if (l < n && arr[l] > arr[largest])
			largest = l;
 
		// if right child is larger than largest so far
		if (r < n && arr[r] > arr[largest])
			largest = r;
 
		// if largest is not root
		if (largest != i){
			swap(arr,i, largest);
 
        // recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	private void heapSort(int arr[], int n){
		// build heap (rearrange array)
		printArray(arr, n);
		System.out.println("on rearranging");
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			printArray(arr, n);
		}
		System.out.println("sort");
		// one by one extract an element from heap
		for (int i=n-1; i>=0; i--){
			// move current root to end
			swap(arr,0, i);
 
        // call max heapify on the reduced heap
			heapify(arr, i, 0);
			printArray(arr, n);
		}
	}
 
	/* function to print array of size n */
	private void printArray(int arr[], int n){
		for (int i = 0; i < n; i++){
			System.out.print(arr[i]+",");
		}
		System.out.println("");
	}
 

	public void sort(int[] arr){
//		int arr[] = {121, 10, 130, 57, 36, 17};
		int n = arr.length;
		
		heapSort(arr, n);
		
		System.out.println("Sorted array is \n");
		printArray(arr, n);
	}
}