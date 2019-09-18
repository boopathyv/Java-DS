package coding.lynk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemOne {

//	A String with length n. Remove 2 letters and find all the distinct possibilities
	public static void main(String[] args) {
		ProblemOne one = new ProblemOne();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word");
		String word = sc.next();
		one.findCombinations(word,word.toCharArray());
	}

	private void findCombinations(String word, char[] charArray) {
		List<String> combinations = new ArrayList<>();
//		Set<String> combinations = new HashSet<>();
		int count = 1;
		for (int index = 0; index < charArray.length; index++) {
			if(index+count < charArray.length) {
				StringBuilder str = new StringBuilder();
				for (int i = 0; i < charArray.length; i++) {
					if(i != index && i != index+count) {
						str.append(String.valueOf(charArray[i]));
					}
				}
				combinations.add(str.toString());
				index--;
				count++;
			}else {
				count = 1;
			}
		}
		System.out.println(combinations);
		System.out.println(combinations.size());
	}
}
