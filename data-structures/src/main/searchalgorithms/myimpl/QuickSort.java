package main.searchalgorithms.myimpl;

public class QuickSort {
	public void sort(int[] arr) {

		//web code
		QuickWebCode quickWebCode = new QuickWebCode();
		quickWebCode.sort(arr);
	}
}

class QuickWebCode{
	//to swap two numbers
	private void swap(int[] arr, int a, int b){
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}

	/*  
 	a[] is the array, p is starting index, that is 0, 
 	and r is the last index of array.  
	 */
	private void quicksort(int[] a, int p, int r)    {
		if(p < r){
			int q;
			q = partition(a, p, r);
			quicksort(a, p, q);
			quicksort(a, q+1, r);
		}
	}

	private int partition (int[] arr, int low, int high){
		int pivot = arr[high];  // selecting last element as pivot
		int i = (low - 1);  // index of smaller element

		for (int j = low; j <= high- 1; j++){
			// If current element is smaller than or equal to pivot
			if (arr[j] <= pivot){
				i++;    // increment index of smaller element
				swap(arr,i, j);
			}
		}
		swap(arr,i + 1, high);
		return i;
	}

//function to print the array
	private void printArray(int a[], int size){
		int i;
		for (i=0; i < size; i++){
			System.out.print(a[i]+",");
		}
		System.out.println("");
	}

	public int sort(int[] arr){
		// int arr[] = {9, 7, 5, 11, 12, 2, 14, 3, 10, 6};
		int n = arr.length;
 
		// call quickSort function
		quicksort(arr, 0, n-1);
 
		System.out.println("Sorted array: n");
		printArray(arr, n);
		return 0;
	}
}