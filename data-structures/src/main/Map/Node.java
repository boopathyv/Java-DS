package main.Map;

public class Node {
	public Node(int hashCode, Object key, Object value, Node next) {
		this.hash = hashCode;
		this.key = key;
		this.value = value;
		this.next = next;
	}
	int hash;
	Object key;
	Object value;
	Node next;
}
