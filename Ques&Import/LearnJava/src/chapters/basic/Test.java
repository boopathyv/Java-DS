package chapters.basic;

import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.testFinally();
//		Parrot parrot1 = new Parrot(1,2,3,4,5,6);
//		Parrot parrot2 = new Parrot(1,2,3,4,5,6);
//		Set set = new HashSet<>();
//		set.add(parrot1);
//		System.out.println(set.contains(parrot2));
		
//		System.out.println(parrot1.toString());
		
//		int[] arr = {1123212321,1123212321,1123212321,1123212321,1123212321,1123212321,1123212321};
//		System.out.println(Arrays.stream(arr).mapToLong(num->num).sum());
//		List<String> list = new ArrayList<>();
//		
//		String str = "qwer werte erwet erwt ewr ewrt";
//		System.out.println(str.replace("er", "AB"));
		
//		Map<String,String> map = new HashMap<>();
		
//		System.out.println(BigDecimal.valueOf(Double.parseDouble("8470634074737128636070224")).toBigInteger().toString(2));
//		BigInteger.valueOf(1234567878931233233L).toString(2);
//		System.out.print(Math.pow(2,3));
//		list.add("q");
//		list.add("qw");
//		list.add("qwe");
//		list.add("qwer");
//		list.add("qwert");
//		list.add("qwerty");
//		map.put("qwer", "qwer");
//		tea(list,map);
//		System.out.println(list);
//		System.out.println(map);
//		ar.stream().mapToInt(numb->numb).sum();
	}

	private void testFinally() {
		outerloop:
		for (int i = 2; i < 5; i++) {
			for (int j = 2; j < 5; j++) {
				System.out.println(i + " " + j);
				if (i * j > 6) {
					System.out.println("Breaking");
					break outerloop;
				}
			}
		}
		System.out.println("Done");
	}

	private static void tea(List<String> list,Map<String,String> map) {
		System.out.println(list);
		list.clear();
		map.clear();
	}
}
