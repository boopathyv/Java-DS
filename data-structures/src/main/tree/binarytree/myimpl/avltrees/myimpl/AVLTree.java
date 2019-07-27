package main.tree.binarytree.myimpl.avltrees.myimpl;

public class AVLTree {

	Node root;
	
	public void add(int data) {
		root = insert(root,data);
	}
	
	private Node insert(Node node,int data) {
		
		//recurse
		if(node == null) {
			return new Node(data);
		}else if(data < node.data) {
			node.left = insert(node.left,data);
		}else if(data > node.data) {
			node.right = insert(node.right,data);
		}else {
			return node;
		}
		
		//update height of the node
		node.height = 1 + max(height(node.left),height(node.right));
		
		//update the balance of the node
		int balance = getBalance(node);
		
		//check for rotation if there is no proper balance
		if(balance < -1 && data > node.right.data) {
			return leftRotate(node);
		}
		if(balance < -1 && data < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		if(balance > 1 && data < node.left.data) {
			return rightRotate(node);	
		}
		if(balance > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		return node;
	}
	
	private Node leftRotate(Node node) {
		Node rotatedNode = node.right;
		Node tmpNode = rotatedNode.left;
		
		rotatedNode.left = node;
		node.right = tmpNode;
		
		
		node.height = max(height(node.left),height(node.right)) + 1;
		rotatedNode.height = max(height(rotatedNode.left),height(rotatedNode.right)) + 1;
		
		return rotatedNode;
	}
	
	private Node rightRotate(Node node) {
		Node rotatedNode = node.left;
		Node tmpNode = rotatedNode.right;
		
		rotatedNode.right = node;
		node.left = tmpNode;
		
		node.height = max(height(node.left),height(node.right)) + 1;
		rotatedNode.height = max(height(rotatedNode.left),height(rotatedNode.right)) + 1;
		
		return rotatedNode;
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	private int getBalance(Node node) {
		if(node == null) {
			return 0;
		}
		return height(node.left)-height(node.right);
	}
	
	private int max(int a,int b) {
		return a>b ? a:b;
	}
	
	public void postOrderTraversal(Node node) {
		if(node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.data);
		}
	}
	
	public void preOrderTraversal(Node node) {
		if(node != null) {
			System.out.println(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void inOrderTraversal(Node node) {
		if(node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.data);
			inOrderTraversal(node.right);
		}
	}
	
	public int minValue() {
		Node currentNode = root;
		while(currentNode != null) {
			currentNode = currentNode.left;
		}
		return currentNode.data;
	}
	
	public int maxValue() {
		Node currentNode = root;
		while(currentNode != null) {
			currentNode = currentNode.right;
		}
		return currentNode.data;
	}
	
}

class Node{
	int data;
	int height;
	Node left;
	Node right;
	
	 Node(int d) { 
	     data = d; 
	     height = 1; 
	 } 
}
