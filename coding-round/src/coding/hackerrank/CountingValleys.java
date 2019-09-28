package coding.hackerrank;

import java.util.Stack;

public class CountingValleys {

	
	public static void main(String[] args) {
		String a = "UDDDUDUU";
//		String a = "DDUUUUDD";
		Stack<String> stack = new Stack<String>();
		int valleyCount = 0;
		String current = "";
		for (int i = 0; i < a.toCharArray().length; i++) {
			String character = String.valueOf(a.charAt(i));
			if(current.isEmpty()) {
				current = character;
			}
			if(stack.size() == 0 && character.equals("D")) {
				valleyCount++;
			}
			if(!current.isEmpty() && !current.equals(character)) {
				stack.pop();
			}else {
				stack.push(character);
			}
			if(stack.size() == 0) {
				current = "";
			}
		}
		System.out.println(valleyCount);
	}
}
