package questions.arrayconversion1;

import java.util.Scanner;

public class ArrayConversion2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE NO OF TEST CASES");
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			System.out.println("ENTER Sum");
			int outputSum = sc.nextInt();
			System.out.println("ENTER Array Length");
			int arrayLength = sc.nextInt();
			System.out.println("ENTER Array Nos");
			int[] newArray = new int[arrayLength];
			for (int j = 0; j < arrayLength; j++) {
				newArray[j] = sc.nextInt();
			}
			getPairs(newArray,outputSum);
		}
	}

	private static void getPairs(int[] newArray,int outputSum) {
			System.out.println("OUTPUT : ");
			for (int i = 0; i < newArray.length; i++) {
				for (int j = i+1; j < newArray.length; j++) {
					if(newArray[i]+newArray[j] == outputSum) {
						System.out.println(newArray[i]+" "+newArray[j]);
					}
				}
			}
		
	}
}

//2.Given an array A[] and a number x, check for pair in A[] with sum as x.
//
//Eg : Input {1, 2, 4, 3, 5, 6}
//SUM : 5
//Output : 2 (1, 4) & (2, 3)
