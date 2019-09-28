package Learning.Arrays.interview;

public class Pr3 {
	//Check if the array has an element which is equal to multiple of all the remaining elements
	public static void main(String[] args) {
		int arr[] = {1, 2, 12, 3, 2};
		efficient(arr);
	}

	private static void efficient(int[] arr) {
		int product = 1;
		for (int i = 0; i < arr.length; i++) {
			product *= arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
			if((product / number) == number) {
				System.out.println("The Element is "+number);
			}
		}
	}
}
