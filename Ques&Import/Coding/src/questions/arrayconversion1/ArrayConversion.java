package questions.arrayconversion1;

import java.util.Scanner;

public class ArrayConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER No. OF TEST CASES");
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println("TEST CASE "+i);
			System.out.println("Enter Array Length");
			int arrLength = sc.nextInt();
			System.out.println("Array Length : "+arrLength);
			int[] intArray = new int[arrLength];
			for (int j = 0; j < arrLength; j++) {
				intArray[j] = sc.nextInt();
			}
			test(intArray);
		}
	}

	private static void test(int[] intArray) {
		for (int i = 0; i < intArray.length-1; i++) {
			int first = intArray[i];
			if(intArray[i] == intArray[i+1]) {
				intArray[i] = 2*first;
				intArray[i+1] = 0;
			}
		}
		int[] newArray = new int[intArray.length];
		int count = 0;
		for (int i = 0; i < intArray.length; i++) {
			if(intArray[i] != 0) {
				newArray[count] = intArray[i];
				count++;
			}
		}
		System.out.print("OUTPUT : "); 
		for (int i = 0; i < newArray.length; i++) {
			
			System.out.print(newArray[i]+" ");
		}
	}
	
}


//2. Given an array of integers of size n. 
//Convert the array in such a way that if next valid number is same as current number,
//double its value and replace the next number with 0. After the modification, 
//rearrange the array such that all 0’s are shifted to the end.
//
//Input : arr[] = {2, 2, 0, 4, 0, 8}
//Output : 4 4 8 0 0 0
//
//Input : arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8}
//Output : 4 2 12 8 0 0 0 0 0 0
