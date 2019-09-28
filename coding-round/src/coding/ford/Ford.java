package coding.ford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ford {

	public static void main(String[] args) {
		float a = (float) 2.4;
				float b = (float) 4.2;
				float sum = a+b;
				int newSum = (int)sum;
//				System.out.println(newSum);
				List<Integer> numbers = new ArrayList<Integer>();
				numbers.add(1);
				numbers.add(1);
				numbers.add(2);
				numbers.add(2);
				numbers.add(3);
				numbers.add(3);
				countPairs(numbers, 1);
				List<List<String>> items = new ArrayList<List<String>>();
				
				List<String> item = new ArrayList<String>();
				item.add("p2");
				item.add("2");
				item.add("3");
				items.add(item);
				item = new ArrayList<String>();
				item.add("p1");
				item.add("22");
				item.add("2");
				items.add(item);
				item = new ArrayList<String>();
				item.add("p7");
				item.add("20");
				item.add("1");
				items.add(item);
				item = new ArrayList<String>();
				item.add("p5");
				item.add("3");
				item.add("0");
				items.add(item);
//				sort(items,2);
	}
	
	public static void sort(List<List<String>> items,int sortParameter) {
		items = items.stream().sorted(Comparator.comparing(list -> ((List<String>) list).get(sortParameter)).reversed()).collect(Collectors.toList());
		List<UINI> lsit = new ArrayList<Ford.UINI>();
		lsit.stream().sorted(Comparator.comparing(UINI::getA).reversed()).collect(Collectors.toList());
		System.out.println(items);
	}
	
	class UINI{
		String a;
		String b;
		String c;
		
		public String getA() {
			return a;
		}
		public String getB() {
			return b;
		}
		public String getC() {
			return c;
		}
	}
	
	public static int countPairs(List<Integer> numbers, int k) {
		 Collections.sort(numbers);
		 int count = 0;
		 int l = 0;
		 int r = 0;
	     Set<String> set = new HashSet<>();
	     int n = numbers.size();
	     int loopCount = 0;
//	     1,1,2,2,3,3
	     while(r<n) {
	    	 loopCount++;
	    	 if(numbers.get(r) - numbers.get(l) == k) {
	    		 String value = String.valueOf(numbers.get(l))+","+String.valueOf(numbers.get(r));
	    		 if(!set.contains(value)) {
	    			 set.add(value);
	    			 count++;
	    		 }
	    		 l++;
	    		 r++;
	    	 }else if(numbers.get(r) - numbers.get(l) > k) {
	    		 l++;
	    	 }else {
	    		 r++;
	    	 }
	     }
	     System.out.println("loopCount.."+loopCount);
		 System.out.println(count);
	     return count;
	}
	
	public static int sumofSubsets(List<Integer> numbers,int sum) {
		 Collections.sort(numbers);
		 int count = 0;
		 int l = 0;
		 int r = 0;
	     Set<String> set = new HashSet<>();
	     int n = numbers.size();
	     int loopCount = 0;
	     while(r<n) {
	    	 loopCount++;
	    	 if(numbers.contains(1)) {
	    		 String value = String.valueOf(numbers.get(l))+","+String.valueOf(numbers.get(r));
	    		 if(!set.contains(value)) {
	    			 set.add(value);
	    			 count++;
	    		 }
	    		 l++;
	    		 r++;
	    	 } else {
	    		 r++;
	    	 }
	     }
	     System.out.println("loopCount.."+loopCount);
		 System.out.println(count);
	     return count;
	}
	
	public static int AplusB(List<Integer> numbers) {
		 Collections.sort(numbers);
		 int count = 0;
		 int l = 0;
		 int r = 0;
	     Set<String> set = new HashSet<>();
	     int n = numbers.size();
	     int loopCount = 0;
//	     1,1,2,2,3,3
	     while(r<n) {
	    	 loopCount++;
	    	 int diff = numbers.get(r) - numbers.get(l);
	    	 if(numbers.contains(diff)) {
	    		 String value = String.valueOf(numbers.get(l))+","+String.valueOf(numbers.get(r));
	    		 if(!set.contains(value)) {
	    			 set.add(value);
	    			 count++;
	    		 }
	    		 l++;
	    		 r++;
	    	 } else {
	    		 r++;
	    	 }
	     }
	     System.out.println("loopCount.."+loopCount);
		 System.out.println(count);
	     return count;
	}
}
