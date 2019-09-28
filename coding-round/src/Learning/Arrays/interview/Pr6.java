package Learning.Arrays.interview;

import java.util.HashMap;
import java.util.Set;

public class Pr6 {


	  /* Driver program to test above function */
    public static void main(String[] args)  
    { 
  
//          int a[] = { 1, 2, 3, 4 };
//          int a[] = { 4, 2, 4, 4};
    		int a[] = { 1, 2, 3, 4 };
//          int b[] = { 2, 3, 4, 5, 8 };
//          int b[] = { 2, 3, 4};
            int b[] = { 5, 6, 7 };
            int n = a.length; 
            int m = b.length; 
           
            System.out.println(minRemove(a, b, n, m)); 
              
    }
    
    // To find no elements to remove 
    // so no common element exist 
    public static int minRemove(int a[], int b[], int n,  
                                                 int m) 
    { 
        // To store count of array element 
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>(); 
        HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>(); 
       
        // Count elements of a 
        for (int i = 0; i < n; i++){ 
           if (countA.containsKey(a[i])) 
                countA.put(a[i], countA.get(a[i]) + 1); 
             
           else countA.put(a[i], 1); 
                 
        } 
          
        // Count elements of b 
        for (int i = 0; i < m; i++){ 
             if (countB.containsKey(b[i])) 
                    countB.put(b[i], countB.get(b[i]) + 1); 
                 
               else countB.put(b[i], 1); 
        } 
          
        // Traverse through all common element, and 
        // pick minimum occurrence from two arrays 
        int res = 0; 
          
        Set<Integer> s = countA.keySet(); 
          
        for (int x : s) 
            if(countB.containsKey(x)) 
                res += Math.min(countB.get(x),  
                               countA.get(x)); 
       
        // To return count of minimum elements 
        return res; 
    } 
      
   
} 
