package Learning.Arrays.interview;

import java.util.HashSet;
import java.util.Set;

public class Pr4 {

	// QUESTION : sum of pair of element is equal to k
	public static void main(String[] args) {
		int[] arr = {0,1,4,6,10,12,8};
		int k = 16;
		Pr4 pr = new Pr4();
		pr.efficient(arr,k);
	}

	private void efficient(int[] arr,int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = k - arr[i];
			if(set.contains(temp)) {
				System.out.println("The Pairs are "+arr[i]+"and "+temp);
			}
			set.add(arr[i]);
		}
	}
	
}
