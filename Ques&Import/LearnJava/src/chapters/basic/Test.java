package chapters.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Map<String,String> map = new HashMap<>();
		list.add("q");
		list.add("qw");
		list.add("qwe");
		list.add("qwer");
		list.add("qwert");
		list.add("qwerty");
		map.put("qwer", "qwer");
		tea(list,map);
		System.out.println(list);
		System.out.println(map);
	}

	private static void tea(List<String> list,Map<String,String> map) {
		System.out.println(list);
		list.clear();
		map.clear();
	}
}
