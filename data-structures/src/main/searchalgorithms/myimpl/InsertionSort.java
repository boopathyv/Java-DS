package main.searchalgorithms.myimpl;

public class InsertionSort {

	public void sort(int[] arr) {
		printArray(arr);
		for (int i = 1; i < arr.length; i++) {
			int currentIndex = i;
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] > arr[currentIndex]) {
					int tmp = arr[currentIndex];
					arr[currentIndex] = arr[j];
					arr[j] = tmp;
					currentIndex = j;
				}
			}
			printArray(arr);
		}
	}
	
	private void printArray(int[] arr) {
		System.out.println("");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
}
