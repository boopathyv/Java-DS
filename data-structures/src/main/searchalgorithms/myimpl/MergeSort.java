package main.searchalgorithms.myimpl;

public class MergeSort {

	public void sort(int arr[]) {
		MergeSort mergeSort = new MergeSort();
		mergeSort.sortIt(arr,0,arr.length-1);
		
		//webcode
//		WebCode webCode = new  WebCode();
//		webCode.sort(arr);
	}

	private void sortIt(int[] arr, int p, int r) {
		int q = (p+r)/2;
		if(p<r) {
			sortIt(arr,p,q);
			sortIt(arr,q+1,r);
			mergeIt(arr,p,q,r);
		}
		System.out.println("");
		System.out.println("p,q,r="+p+","+q+","+r);
		printArray(arr);
	}
	
	private void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}

	private void mergeIt(int[] arr, int p, int q, int r) {
		int intArr[] = new int[arr.length];
		int k = 0;
		int startIndex = p;
		int nextIndex = q+1;
		
		while(startIndex <= q && nextIndex <= r) {
			if(arr[startIndex] < arr[nextIndex]) {
				intArr[k++] = arr[startIndex++];
			}else {
				intArr[k++] = arr[nextIndex++];
			}
		}
		
		while(startIndex <= q) {
			intArr[k++] = arr[startIndex++];
		}
		
		while(nextIndex <= r) {
			intArr[k++] = arr[nextIndex++];
		}
		
		for (int i = r; i >= p ; i--) {
			arr[i] = intArr[--k];
		}
		
	}
	
	
}

class WebCode{
	// lets take a[5] = {32, 45, 67, 2, 7} as the array to be sorted.

	// merge sort function
	private void mergeSort(int a[], int p, int r)
	{
	    int q;
	    if(p < r)
	    {
	        q = (p + r) / 2;
	        System.out.println("p."+p+"..q.."+q+"..r.."+r);
	        mergeSort(a, p, q);
	        mergeSort(a, q+1, r);
	        merge(a, p, q, r);
	    }
	}

	// function to merge the subarrays
	private void merge(int a[], int p, int q, int r)
	{
	    int b[] = new int[a.length];   //same size of a[]
	    int i, j, k;
	    k = 0;
	    i = p;
	    j = q + 1;
	    while(i <= q && j <= r)
	    {
	        if(a[i] < a[j])
	        {
	            b[k++] = a[i++];    // same as b[k]=a[i]; k++; i++;
	        }
	        else
	        {
	            b[k++] = a[j++];
	        }
	    }
	  
	    while(i <= q)
	    {
	        b[k++] = a[i++];
	    }
	  
	    while(j <= r)
	    {
	        b[k++] = a[j++];
	    }
	  
	    for(i=r; i >= p; i--)
	    {
	        a[i] = b[--k];  // copying back the sorted list to a[]
	    } 
	}

	// function to print the array
	private void printArray(int a[], int size)
	{
	    int i;
	    for (i=0; i < size; i++)
	    {
	        System.out.print(a[i]+"-");
	    }
	    System.out.println("\n");
	}
	 
	public int sort(int arr[]){
//	    int arr[] = {32, 45, 67, 2, 7};
	    int len = arr.length;
	 
	    System.out.println("Given array: \n");
	    printArray(arr, len);
	    
	    // calling merge sort
	    mergeSort(arr, 0, len - 1);
	 
	    System.out.println("\nSorted array: \n");
	    printArray(arr, len);
	    return 0;
	}
}
