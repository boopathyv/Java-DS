package main.tree.binarytree.myimpl;

public class Tree<E> {
	Node<E> head = null;
	int nodeCount = 0;
	
	private void printPostorder(Node<E> node,E[] array,int count) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        printPostorder(node.leftLeaf,array,count); 
  
        // then recur on right subtree 
        printPostorder(node.rightLeaf,array,count); 
  
        // now deal with the node 
        System.out.print(node.data + " ");
        array[count] = node.data;
        count++;
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
	private void printInorder(Node<E> node,E[] array,int count) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.leftLeaf,array,count); 
  
        /* then print the data of node */
        System.out.print(node.data + " "); 
        array[count] = node.data;
        count++;
        /* now recur on right child */
        printInorder(node.rightLeaf,array,count); 
    } 
  
	private void printPreorder(Node<E> node,E[] array,int count) 
    { 
        if (node == null) 
            return; 
  
        System.out.print(node.data + " ");
        array[count] = node.data;
        count++;
  
        printPreorder(node.leftLeaf,array,count); 
  
        printPreorder(node.rightLeaf,array,count); 
    }
    
    public E[] getPostOrder() {
    	E[] array = (E[]) new Object[nodeCount];
    	printPostorder(head,array,0);
    	return array;
    }
    
    public E[] getPreOrder() {
    	E[] array = (E[]) new Object[nodeCount];
    	printPreorder(head,array,0);
    	return array;
    }
    
    public E[] getInOrder() {
    	E[] array = (E[]) new Object[nodeCount];
    	printInorder(head,array,0);
    	return array;
    }

	public boolean autoBalance() {
		Node<E> currentNode = head;
		if(currentNode.leftLeaf != null && currentNode.rightLeaf != null) {
			
		}
		return true;
	}
	
	
	public E minValue() {
		Node<E> currentNode = head;
		while(currentNode.leftLeaf != null) {
			currentNode = currentNode.leftLeaf;
		}
		return (E)currentNode.data;
	}
	
	public E maxValue() {
		Node<E> currentNode = head;
		while(currentNode.rightLeaf != null) {
			currentNode = currentNode.rightLeaf;
		}
		return (E)currentNode.data;
	}
	
	public void push(E data) {
		Node<E> newNode = new Node<E>(data);
		if(head == null) {
			head = newNode;
		}else {
			Node<E> currentNode = head;
			while(currentNode != null) {
				if(lte(data,currentNode.data)) {
					if(currentNode.leftLeaf != null) {
						currentNode = currentNode.leftLeaf;
					}else {
						currentNode.leftLeaf = newNode;
						break;
					}
				}else if(gte(data,currentNode.data)){
					if(currentNode.rightLeaf != null) {
						currentNode = currentNode.rightLeaf; 
					}else {
						currentNode.rightLeaf = newNode;
						break;
					}
				}
			}
		}
		nodeCount++;
	}
	
	private boolean gte(E data, E data2) {
		if(data instanceof Integer) {
			return (Integer)data > (Integer)data2;
		}else if(data instanceof Long) {
			return (Long)data > (Long)data2;
		}else if(data instanceof Double) {
			return (Double)data > (Double)data2;
		}else if(data instanceof Float) {
			return (Float)data > (Float)data2;
		}else {
			return false;
		}
	}

	private boolean lte(E data, E data2) {
		if(data instanceof Integer) {
			return (Integer)data < (Integer)data2;
		}else if(data instanceof Long) {
			return (Long)data < (Long)data2;
		}else if(data instanceof Double) {
			return (Double)data < (Double)data2;
		}else if(data instanceof Float) {
			return (Float)data < (Float)data2;
		}else {
			return false;
		}
	}
	
	private void printArray(E ints[], int len)  
    { 
        int i; 
        for (i = 0; i < len; i++)  
            System.out.print(ints[i] + " "); 
        System.out.println(""); 
    } 
	
	public void printAllPaths() {
		E[] path = (E[]) new Object[nodeCount];
		printAllPossiblePaths(head,path,0);
	}
	
	private void printAllPossiblePaths(Node<E> node, E path[], int pathLen)  
	    { 
	        if (node == null) 
	            return; 
	   
	        /* append this node to the path array */
	        path[pathLen] = node.data; 
	        pathLen++; 
	   
	        /* it's a leaf, so print the path that led to here */
	        if (node.leftLeaf == null && node.rightLeaf == null) 
	            printArray(path, pathLen); 
	        else
	            {  
	            /* otherwise try both subtrees */
	        	printAllPossiblePaths(node.leftLeaf, path, pathLen); 
	            printAllPossiblePaths(node.rightLeaf, path, pathLen); 
	        } 
	    } 
	
	public void remove(E data) {
		this.head = removeNode(data, this.head);
	}
	public Node removeNode(E data,Node<E> node){
		if(node == null){
			return node;
		}else if(node.data == data){
			if(node.leftLeaf == null && node.rightLeaf == null){
				node = null;
			}else if(node.leftLeaf == null){
				node = node.rightLeaf;
			}else if(node.rightLeaf == null){
				node = node.leftLeaf;
			}else{
				if(node.rightLeaf != null){
					node.data = getMinValue(node.rightLeaf);
					node.rightLeaf = removeNode(node.data,node.rightLeaf);
				}
				// else if(node.left != null){
				// 	node.data = this.getMaxValue(node.left);
				// 	node.left = this.removeNode(node.data,node.left);
				// }
			}
		}else if((int)node.data < (int)data){
			node.rightLeaf = this.removeNode(data,node.rightLeaf);
		}else if((int)node.data > (int)data){
			node.leftLeaf = this.removeNode(data,node.leftLeaf);
		}
		return node;
	}
	
	public E getMinValue(Node<E> currentNode) {
		while(currentNode.leftLeaf != null) {
			currentNode = currentNode.leftLeaf;
		}
		return (E)currentNode.data;
	}
}

class Node<E>{
	Node<E> leftLeaf;
	Node<E> rightLeaf;
	E data;
	
	Node(E data){
		this.data = data;
	}
}