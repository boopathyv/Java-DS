package coding.hackerrank;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int d = 9;
		int endIndex = d-1;
		int startIndex = d;
		int[] newarr = new int[arr.length];
		for(int i = 0;i< arr.length;i++) {
			if(startIndex >= arr.length) {
				startIndex = 0;
			}
			newarr[i] = arr[startIndex];
			startIndex++;
		}
		System.out.println(newarr);
	}
}
