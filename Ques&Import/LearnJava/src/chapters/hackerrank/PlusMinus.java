package chapters.hackerrank;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PlusMinus {

	public static void main(String[] args) {
		int[] arr = {-4 ,3 ,-9 ,0 ,4 ,1};
		BigDecimal posCount = BigDecimal.valueOf(0);
		BigDecimal negCount = BigDecimal.valueOf(0);
		BigDecimal zeroCount = BigDecimal.valueOf(0);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0) {
				posCount = posCount.add(BigDecimal.valueOf(1));
			}else if(arr[i]<0) {
				negCount = negCount.add(BigDecimal.valueOf(1));
			}else {
				zeroCount = zeroCount.add(BigDecimal.valueOf(1));
			}
		}
		
		System.out.println(posCount.divide(BigDecimal.valueOf(arr.length),new MathContext(5)));
		System.out.println(negCount.divide(BigDecimal.valueOf(arr.length),new MathContext(5)));
		System.out.println(zeroCount.divide(BigDecimal.valueOf(arr.length),new MathContext(5)));
	}
}
