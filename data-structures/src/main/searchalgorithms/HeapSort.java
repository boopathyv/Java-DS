package main.searchalgorithms;

public class HeapSort {
 
	int temp;
	
	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int arr[] = {1, 10, 50, 30, 4, 8, 23, 100, 23, 72};
		int i;
		int size = arr.length;

		heapSort.heapSort(arr, size);

		System.out.println("printing sorted elements\n");
		for (i=0; i<size; ++i) {
			System.out.print(arr[i]+",");
		}
	}

	private void heapify(int arr[], int size, int i)  {  
		int largest = i;
		int left = 2*i + 1;    
		int right = 2*i + 2;

		if (left < size && arr[left] >arr[largest])  
			largest = left;
		
		if (right < size && arr[right] > arr[largest])  
			largest = right;
		
		if (largest != i)  {
			temp = arr[i];
			arr[i]= arr[largest];
			arr[largest] = temp;
			heapify(arr, size, largest);
		}
	}

	private void heapSort(int arr[], int size)  {
		int i;
		for (i = size / 2 - 1; i >= 0; i--)
			heapify(arr, size, i);
		
		for (i=size-1; i>=0; i--)  {  
			temp = arr[0];  
			arr[0]= arr[i];   
			arr[i] = temp;  
			heapify(arr, i, 0);  
		}  
	}  

}