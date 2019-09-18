package chapters.paypal.questions;


import java.util.Scanner;

public class Test {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int i=0 ; i< testCases; i++){
		    String value = sc.next();
		    int length = sc.nextInt();
		    int pyramid = sc.nextInt();
		    if(pyramid == 1) {
    			normalPyramid(value,length);
		    }else {
    			inversePyramid(value,length);
		    }
		}
	}

	private static void inversePyramid(String value, int length) {
		char[] array = value.toCharArray();
		boolean toggle = false;
		int space = 0;
		int current = 0;
		int max = array.length-1;
		for (int i = length-1; i >= 0; i--,space++) {
			int charCount = i*2+1;
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			StringBuilder builder = new StringBuilder();
			for (int z = 0; z < charCount; z++) {
				builder.append(array[current]);
				current++;
				if(current > max) {
					current = 0;
				}
			}
			if(toggle) {
				System.out.print(builder.reverse().toString());
			}else {
				System.out.print(builder.toString());
			}
			toggle = !toggle;
			System.out.println();
		}
	}

	private static void normalPyramid(String value, int length) {
		char[] array = value.toCharArray();
		boolean toggle = false;
		int space = length-1;
		int current = 0;
		int max = array.length-1;
		for (int i = 0; i < length; i++,space--) {
			int charCount = i*2+1;
			for (int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			StringBuilder builder = new StringBuilder();
			for (int z = 0; z < charCount; z++) {
				builder.append(array[current]);
				current++;
				if(current > max) {
					current = 0;
				}
			}
			if(toggle) {
				System.out.print(builder.reverse().toString());
			}else {
				System.out.print(builder.toString());
			}
			toggle = !toggle;
			System.out.println();
		}
	}
}
