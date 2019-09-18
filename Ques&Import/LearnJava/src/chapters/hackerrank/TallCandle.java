package chapters.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class TallCandle {

	public static void main(String[] args) {
		int[] arr = {5,4,5,1,5};
		List<Integer> list = Arrays.asList(5,4,5,1,5);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println(list);
		int max = IntStream.of(arr).max().getAsInt();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == max) {
				count++;
			}
		}
		System.out.println(count);
	}
}
