package number;

public class TraceNumber {

	public static void main(String[] args) {
//		int[] arr = {1,1,2,2,3,3,4,4,5};
//		int[] arr = {1,1,2,2,3,3,4};
//		int[] arr = {1,1,2,3,3,4,4};
//		int[] arr = {1,2,2,3,3,4,4};
//		int[] arr = {1,1,2,2,3,4,4,5,5};
		int[] arr = {1,12,12,43,43,44,44,65,65};
		printTheOddNumber(arr);
	}

	private static void printTheOddNumber(int[] arr) {
		int l = 0;
		int h = arr.length-1;
		findTheNumber(arr,l,h);
	}

	private static void findTheNumber(int[] arr, int l, int h) {
		if(l == h) {
			System.out.println(arr[l]);
			return;
		}
		int m = (l+h+1)/2;
		if(arr[m] == arr[m+1] && (m+1)%2!=0) {
			findTheNumber(arr, m+1+1, h);
		}else if(arr[m] == arr[m-1] && m%2!=0) {
			findTheNumber(arr, m+1, h);
		}else if(arr[m] == arr[m+1] && (m+1)%2==0) {
			findTheNumber(arr, 0, m-1);
		}else if(arr[m] == arr[m-1] && m%2==0) {
			findTheNumber(arr, 0, m-2);
		}else {
			System.out.println(arr[m]);
			return;
		}
	}
}
