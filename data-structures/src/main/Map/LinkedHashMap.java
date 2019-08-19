package main.Map;

public class LinkedHashMap extends HashMap{
	LinkedMapNode head;
	LinkedMapNode tail;
	
	@Override
	public Node getNewNode(int hashCode, Object key, Object value, Node object) {
		LinkedMapNode node = new LinkedMapNode(hashCode, key, value, object);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			tail.after = node;
			node.before = tail;
			tail = node;
		}
		return node;
	}
	
	@Override
	public Object[] keySet(){
		Object[] objArr= new Object[keyCount];
		int keys = 0;
		LinkedMapNode node = head;
		int count = 0;
		while(node != null) {
			objArr[count] = node.key;
			count++;
			node = node.after;
		}
		return objArr;
	}
	
}
