package Learning.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//convert-set-of-string-to-array-of-string-in-java
public class Pr1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		Object[] arr = set.toArray();
		String[] stringArray = set.toArray(new String[set.size()]);
		String[] string2Array = Arrays.copyOf(set.toArray(), set.size(),String[].class);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(stringArray));
		System.out.println(Arrays.toString(string2Array));
	}
}
