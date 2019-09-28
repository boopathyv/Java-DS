package main.singlelinkedlist.myimpl;

public class Test {

	public static void main(String[] args) throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
//		System.out.println(list);
//		System.out.println(list.get(3));
//		System.out.println(list.removeAt(3));
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
		
		LinkedList2<Integer> list2 = new LinkedList2<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		list2.add(40);
		list2.add(50);
		
		list2.print();
	}
}
