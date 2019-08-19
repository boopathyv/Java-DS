package main.Map;

public class LinkedMapNode extends Node{
	LinkedMapNode before;
	LinkedMapNode after;
	
	public LinkedMapNode(int hashCode, Object key, Object value, Node next) {
		super(hashCode, key, value, next);
	}
		
}