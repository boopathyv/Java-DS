package questions.arrayconversion1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayConversion3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE NO OF TEST CASES");
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println("ENTER Array Length");
			int arrayLength = sc.nextInt();
			System.out.println("ENTER Array Nos");
			Integer[] newArray = new Integer[arrayLength];
			for (int j = 0; j < arrayLength; j++) {
				newArray[j] = sc.nextInt();
			}
			calculateMaxSum(newArray);
		}
	}

	private static void calculateMaxSum(Integer[] newArray) {
			List<Integer> intList = Arrays.asList(newArray);
			int max =intList.stream().mapToInt(number->number).max().getAsInt();
			int sum = intList.stream().mapToInt(number->number).sum();
			if(sum > max) {
				System.out.println("OUTPUT : "+sum);
			}else {
				System.out.println("OUTPUT : "+max);
			}
		
	}
}

//Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
//
//Output:
//Print the maximum sum of the contiguous sub-array in a separate line for each test case.
//
//Constraints:
//1 ≤ T ≤ 110
//1 ≤ N ≤ 106
//-107 ≤ A[i] <= 107
//
//Example:
//Input
//2
//5
//1 2 3 -2 5
//4
//-1 -2 -3 -4
//Output
//9
//-1
//
//Explanation:
//Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.