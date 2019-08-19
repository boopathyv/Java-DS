package chapters.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import chapters.models.Mike;

public class Streams {

	public static void main(String[] args) {
				
		Streams stream = new Streams();
		List<Mike> mikeList = new ArrayList<>();
		mikeList.add(new Mike("MIKE1",2009,389232L,new ArrayList<>()));
		mikeList.add(new Mike("MEAE1",2012,385452L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2087,383212L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2132,334522L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2029,389342L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2209,376532L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2549,345652L,new ArrayList<>()));
		mikeList.add(new Mike("MIKE1",2469,398762L,new ArrayList<>()));
//		stream.collections();
//		stream.streams(mikeList);
		stream.aggregate(mikeList);
	}

	private void collections() {
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 5,2,3,32);
		System.out.println(list);
		
		System.out.println(Collections.binarySearch(list, 32));
		Collections.reverse(list);
		System.out.println(list);
	}
	
	private void aggregate(List<Mike> mikeList) {
		int sum = mikeList.stream().mapToInt(mike->mike.getModelNo()).sum();
		Double average = mikeList.stream().mapToInt(mike->mike.getModelNo()).average().getAsDouble();
		int max = mikeList.stream().mapToInt(mike->mike.getModelNo()).max().getAsInt();
		int min = mikeList.stream().mapToInt(mike->mike.getModelNo()).min().getAsInt();
		System.out.println("sum.."+sum);
		System.out.println("average.."+average);
		System.out.println("max.."+max);
		System.out.println("min.."+min);
//		mikeList.stream().collect(Collectors.toMap(mike->mike.getModelNo(), 
//				mike->mike, maxBy(Comparator.comparing(Mike:getModelNo).)));
	}
	
	@SuppressWarnings("unused")
	private void streams(List<Mike> mikeList) {
		
		Collections.sort(mikeList, Comparator.comparing(mike->mike.getWeight()));
		
		System.out.println("ALL MATCH.."+mikeList.stream().allMatch(mike->mike.getName().startsWith("MIKE")));
		System.out.println("ANY MATCH.."+mikeList.parallelStream().anyMatch(mike->mike.getName().startsWith("ME")));
		List<Mike> subList = mikeList.subList(1, 4);
		
		mikeList.removeIf(mike->mike.getModelNo()== 2009);
		
		mikeList.stream().findAny().get();
		mikeList.stream().findFirst().get();
		
		// toList
		mikeList.stream().collect(Collectors.toList());
		
		// toSet
		mikeList.stream().collect(Collectors.toSet());
		
		// sorting modelNo ASC, Weight Desc
		mikeList.stream().sorted(
				Comparator.comparing(Mike::getModelNo).reversed().
				thenComparing(Mike::getWeight)).collect(Collectors.toList());
		
		// count
		System.out.println("count..."+mikeList.stream().collect(Collectors.counting()).intValue());
		
		// toMap
		Map<Object, Object> mikeMap = mikeList.stream().collect(Collectors.toMap(mike->mike.getWeight(), mike->mike));
		System.out.println(mikeMap);
		
		// to Map<key,List<Object>>
		Map<Object, List<Object>> mikeListMap = mikeList.stream().collect(Collectors.groupingBy(mike->mike.getWeight(), Collectors.mapping(mike->mike, Collectors.toList())));
		
		// to Map<key,Set<Object>>
		Map<Object, Set<Object>> mikeSetMap = mikeList.stream().collect(Collectors.groupingBy(mike->mike.getWeight(), Collectors.mapping(mike->mike, Collectors.toSet())));
	}
}
