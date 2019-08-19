package questions.pattern;

import java.util.Scanner;

public class Pattern {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number");
		int number = sc.nextInt();
		int noOfLine = number*2-1;
		int space = number-1;
		for (int i = 1; i <= (noOfLine/2)+1; i++,space--) {
			String upDown = "";
			for (int j = 1; j <= space; j++) {
				upDown += " ";
			}
			for (int j = 1; j <= (i*2)-1; j++) {
				upDown += "*";
			}
			System.out.println(upDown);
		}
		
		space = 1;
		for (int i = (noOfLine/2); i >= 1; i--,space++) {
			String downUp = "";
			for (int j = 1; j <= space; j++) {
				downUp += " ";
			}
			for (int j = 1; j <= (i*2)-1; j++) {
				downUp += "*";
			}
			System.out.println(downUp);
		}
	}

}


//6.Diamond pattern : for given input size -> Here 3
//
//  *
// ***
//*****
// ***
//  *