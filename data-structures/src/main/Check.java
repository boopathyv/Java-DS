package main;

import java.util.LinkedList;
import java.util.List;

public class Check {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		list.add(0);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(120);
		list.add(130);
		list.add(1340);
		
		System.out.println(list.get(6));
	}
}
