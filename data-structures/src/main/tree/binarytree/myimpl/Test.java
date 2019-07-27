package main.tree.binarytree.myimpl;

public class Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
		Tree tree = new Tree<Integer>();
		tree.push(50);
		tree.push(40);
		tree.push(45);
		tree.push(60);
		tree.push(30);
		tree.push(55);
		tree.push(35);
		tree.push(65);
		tree.push(20);
		System.out.println(tree);
		System.out.println(tree.minValue());
		System.out.println(tree.maxValue());
		System.out.println(tree.getInOrder());
		System.out.println(tree.getPostOrder());
		System.out.println(tree.getPreOrder());
		
		System.out.println("All Paths");
		tree.printAllPaths();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
