package coding.chargebee.question;

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int arrayOneLength = sc.nextInt();
        int arrayTwoLength = sc.nextInt();
        int[] arrayOne = new int[arrayOneLength];
        int[] arrayTwo = new int[arrayTwoLength];
        for (int i = 0; i < arrayOneLength; i++) {
			arrayOne[i] = sc.nextInt();
		}
        for (int i = 0; i < arrayTwoLength; i++) {
        	arrayTwo[i] = sc.nextInt();
		}
        int indexTwo = 0;
        int compareNum = arrayTwo[indexTwo];
        for (int i = 0; i < arrayOne.length; i++) {
			if(arrayOne[i] == compareNum) {
				arrayTwo[indexTwo] = Integer.MAX_VALUE;
				if(++indexTwo < arrayTwo.length) {
					compareNum = arrayTwo[indexTwo];
				}
			}
		}
        boolean result = true;
        for (int i = 0; i < arrayTwo.length; i++) {
        	if(arrayTwo[i] != Integer.MAX_VALUE) {
        		result = false;
        	}
		}
        System.out.println(result);
    }
}
