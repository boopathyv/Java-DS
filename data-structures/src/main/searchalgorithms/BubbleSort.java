package main.searchalgorithms;

public class BubbleSort {  
 
	public static void main(String[] args) {  
		int[] a = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23,104};  
		for(int i=0;i<11;i++)  {  
			printArray(a);
			for (int j=0;j<11;j++)  {  
				if(a[i] < a[j])  {  
					int temp = a[i];  
					a[i]=a[j];  
					a[j] = temp;   
				}  
			}  
		}  
		System.out.println("");
		System.out.println("Printing Sorted List ...");  
		printArray(a);  
	}

	private static void printArray(int[] a) {
		System.out.println("");
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k]+",");
		}
	}  
}  