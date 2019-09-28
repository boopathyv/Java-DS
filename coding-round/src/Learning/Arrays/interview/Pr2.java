package Learning.Arrays.interview;

import java.util.HashSet;
import java.util.Set;

public class Pr2 {

	//Check if the array has an element which is equal to sum of all the remaining elements
	public static void main(String[] args) {
		int[] arr = {5,2,2,1};
		efficient(arr);
	}

	private static void efficient(int[] arr) {
		Set<Integer> set= new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			sum += arr[i];
		}
		if(sum%2 != 0) {
			System.out.println("No Element");
			return;
		}
		sum = sum/2;
		if(set.contains(sum)) {
			System.out.println("The Element is : "+sum);
		}
	}
}
