package Learning.Arrays.interview;

import java.util.HashSet;

public class Pr1 {

//	QUESTION : Check if there exist two elements in an array 
//	whose sum is equal to the sum of rest of the array
	
	public static void main(String[] args) {
//		int[] arr = {8,4,10,2};
//		int[] arr = {2, 11, 5, 1, 4, 7};
		int[] arr = {2, 4, 2, 1, 11, 15};
		Pr1 pr1 = new Pr1();
//		pr1.normal(arr);
		pr1.efficient(arr);
	}

	//	time complexity O(n)
	private void efficient(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if(sum%2 != 0) {
			System.out.println("Elements do not exist");
			return;
		}
		sum = sum/2;
		HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < arr.length; i++) 
        { 
            int val = sum - arr[i]; 
  
            // If element exist than return the pair 
            if (s.contains(val) &&  
                val == (int) s.toArray()[s.size() - 1])  
            { 
                System.out.printf("Pair elements are %d and %d\n", 
                        arr[i], val); 
            } 
            s.add(arr[i]); 
        } 
	}

	// time complexity O(n3)
	private void normal(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(j>i) {
					int sum = arr[i] + arr[j];
					int innerSum = 0;
					for (int z = 0; z < arr.length; z++) {
						if(z !=j && z !=i) {
							innerSum += arr[z];
						}
					}
					if(sum == innerSum) {
						System.out.println("Elements are "+arr[i]+" and "+arr[j]);
					}
				}
			}	
		}
	}
}
