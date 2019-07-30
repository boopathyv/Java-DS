package main.searchalgorithms.myimpl;

public class BubbleSort {


		public void sort(int[] arr) {
			printArray(arr);
			bubbleIt(arr,arr.length);
			
			// webcode
//			bubbleSort(arr,arr.length);
		}

		private void bubbleIt(int[] arr, int endIndex) {
			for (int i = 0; i < endIndex; i++) {
				if((i+1) < endIndex && arr[i] > arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
				}
			}
			printArray(arr);
			if(endIndex > 0) {
				bubbleIt(arr, endIndex-1);
			}
		}

		private void printArray(int[] arr) {
			System.out.println("");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+",");
			}
		}
		
		void bubbleSort(int arr[], int n)
		{
		    int i, j, temp;
		    for(i = 0; i < n; i++)
		    {
		        for(j = 0; j < n-i-1; j++)
		        {
		            if( arr[j] > arr[j+1])
		            {
		                // swap the elements
		                temp = arr[j];
		                arr[j] = arr[j+1];
		                arr[j+1] = temp;
		            } 
		        }
		        printArray(arr);
		    }
		    
		    // print the sorted array
		    System.out.println("Sorted Array: ");
		    printArray(arr);
		}
		
}