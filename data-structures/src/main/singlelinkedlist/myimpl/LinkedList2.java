package main.singlelinkedlist.myimpl;

public class LinkedList2<E> {

	Node<E> head;
	Node<E> last;
	int size;
	
	
	class Node<E>{
		E data;
		Node<E> next;
		
		Node(E data){
			this.data = data;
		}
	}
	
	public void print() {
		Node currentNode = head;
		Node prevNode = null;
		while(currentNode != null) {
			if(currentNode.next != null) {
				prevNode = currentNode;
				currentNode = currentNode.next;
			}else {
				break;
			}
		}
		System.out.println(prevNode.data);
	}
	
	public void add(E data) {
		Node newNode = new Node(data);
		++size;
		if(head == null) {
			head = newNode;
			last = newNode;
			newNode.next = null;
			return;
		}
		
		last.next = newNode;
		last = newNode;
	}
	
	public E get(int index) throws Exception {
		checkSize(index);
		return (E) getNodeByIndex(index).data;
	}
	
	public boolean checkSize(int index) throws Exception {
		if(size-1 < index) {
			throw new IndexOutOfBoundsException("Index not found : "+index);
		}
		return true;
	}
	
	public Node getNodeByIndex(int index) {
		Node currentNode = head;
		int counter = 0;
		while(counter < index) {			
			currentNode = currentNode.next;
			counter++;
		}
		return currentNode;
	}
	
	public boolean removeAt(int index) {
		Node currentNode = head;
		Node prevNode = null;
		int counter = 0;
		while(counter < index) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			counter++;
		}
		if(counter == index) {
			prevNode.next = currentNode.next;
		}
		return true;
	}
	
}
