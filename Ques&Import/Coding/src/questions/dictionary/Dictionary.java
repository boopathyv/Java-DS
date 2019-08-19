package questions.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array Length");
		int arrayLength = sc.nextInt();
		System.out.println("Enter Dictionary words");
		String[] dictWords =new String[arrayLength]; 
		for (int i = 0; i < arrayLength; i++) {
			dictWords[i] = sc.next();
		}
		System.out.println("Enter Word to be Searched and Splitted");
		String word = sc.next();
		test(dictWords,word);
	}

	private static void test(String[] dictWords, String word) {
		List<String> dictList = Arrays.asList(dictWords);
		for (int i = 0; i < dictList.size(); i++) {
			String dictWord = dictList.get(i);
			if(word.contains(dictWord)) {
				word = word.replaceFirst(dictWord, "");
			}
		}
		if(word.length() == 0) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
