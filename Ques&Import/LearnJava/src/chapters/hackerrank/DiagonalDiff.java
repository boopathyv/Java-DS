package chapters.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDiff {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(Arrays.asList(5,1,4));
		lists.add(Arrays.asList(5,7,2));
		lists.add(Arrays.asList(9,1,3));
		
		getDiff(lists);
	}

	private static void getDiff(List<List<Integer>> lists) {
		int forWardSum = 0;
		int backWardSum = 0;
		int forWardCount = 0;
		int backWardCount = lists.size()-1;
		for (int i = 0; i < lists.size() && forWardCount<lists.size() && backWardCount >= 0 
				; i++,forWardCount++,backWardCount--) {
			List<Integer> list = lists.get(i);
			forWardSum += list.get(forWardCount);
			backWardSum += list.get(backWardCount);
		}
		System.out.println(Math.abs(forWardSum-backWardSum));
	}
}
