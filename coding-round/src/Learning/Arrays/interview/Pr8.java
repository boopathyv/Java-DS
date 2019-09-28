package Learning.Arrays.interview;

// Efficient search in an array where difference between adjacent is 1
public class Pr8 {

// Return the index of the 
// element to be searched. 
	static int search(int arr[], int n, int x) {
		// Searching x in arr[0..n-1]
		int i = 0;
		while (i <= n - 1) {
			// Checking if element is found.
			if (arr[i] == x)
				return i;

			// Else jumping to abs(arr[i]-x).
			i += Math.abs(arr[i] - x);
		}

		return -1;
	}

// Driver code 
	public static void main(String[] args) {
		int arr[] = { 5, 4, 5, 6, 7, 6,5, 4, 3, 2 };
		int n = arr.length;
		int x = 7;

		System.out.println(search(arr, n, x));
	}
}
