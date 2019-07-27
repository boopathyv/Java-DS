package main.tree.binarytree.myimpl.avltrees.myimpl;

public class Test {

	
	public static void main(String[] args) {
		AVLTree avlTree = new AVLTree();
		avlTree.add(20);
		avlTree.add(30);
		avlTree.add(25);
		avlTree.add(24);
		avlTree.add(50);
		avlTree.add(18);
		avlTree.add(15);
		avlTree.add(17);
		avlTree.add(22);
		System.out.println("InOrder");
		avlTree.inOrderTraversal(avlTree.root);
		System.out.println("PreOrder");
		avlTree.preOrderTraversal(avlTree.root);
		System.out.println("PostOrder");
		avlTree.postOrderTraversal(avlTree.root);
	}
}
