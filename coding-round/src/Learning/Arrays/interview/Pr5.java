package Learning.Arrays.interview;

public class Pr5 {

	// QUESTION : 
	// Function that returns true if the array 
	// contains an element which is equal to 
	// the XOR of the remaining elements 
	public static void main(String[] args) {
		
		int arr[] = { 8, 2, 1,4, 15,6,6}; 
//		int arr[] = {4, 2, 3};
	    if (containsElement(arr)) 
	        System.out.println("Yes"); 
	    else
	    	System.out.println("No"); 
	  
	}
	
	public static boolean containsElement(int arr[]) 
	{ 
	    // To store the XOR of all 
	    // the array elements 
	    int xorArr = 0; 
	    for (int i = 0; i < arr.length; ++i) 
	        xorArr ^= arr[i]; 
	  
	    // For every element of the array 
	    boolean result = false;
	    for (int i = 0; i < arr.length; ++i) { 
	  
	        // Take the XOR after excluding 
	        // the current element 
	        int x = xorArr ^ arr[i]; 
	  
	        // If the XOR of the remaining elements 
	        // is equal to the current element 
	        if (arr[i] == x) { 
	            System.out.println("The Element is :"+x);
	            result = true;
	        }
	    } 
	  
	    // If no such element is found 
	    return result; 
	} 
}
