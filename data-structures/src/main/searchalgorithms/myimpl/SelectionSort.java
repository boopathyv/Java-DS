package main.searchalgorithms.myimpl;

public class SelectionSort {

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			printArray(arr);
			int smallest = arr[i];
			int smallestIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j] < smallest) {
					smallest = arr[j];
					smallestIndex = j;
				}
			}
			arr[smallestIndex] = arr[i];
			arr[i] = smallest;
		}
		printArray(arr);
	}
	
	private void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
}
