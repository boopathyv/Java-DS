package chapters.Map;

public class Test {

	
	public static void main(String[] args) {
//		HashMap map = new HashMap();
		LinkedHashMap map = new LinkedHashMap();
		map.put(23, "SIVA");
		map.put(23234, "SELVA");
		map.put(12, "MEEN");
		map.put(9, "NAMVEEN");
		map.put(124, "BOOPATHY");
		map.put(7120, "SAM");
		map.put(8712, "KUMAR");
		map.put(23, "RAM");
		map.put(23, "DEEPAK");
		System.out.println(map.get(23));
		System.out.println(map.get(124));
		System.out.println(map.get("BOBBY"));
		System.out.println(map.keySet().toString());
		
	}
}
