package chapters.Map;

public class HashMap {

	int size = 16;
	int keyCount = 0;
	Node[] root;
	
	public void put(Object key,Object value) {
		int index = key.hashCode() & (size-1);
		Node node = root[index];
		if(node == null) {
			root[index] = getNewNode(key.hashCode(),key,value,null);
			keyCount++;
			return;
		}
		while(node != null) {
			if(node.key.equals(key)) {
				node.value = value;
				break;
			}else if(node.next != null){
				node = node.next;
			}else {
				node.next = getNewNode(key.hashCode(),key,value,null);
				keyCount++;
				break;
			}
		}

	}
	
	public Node getNewNode(int hashCode, Object key, Object value, Node object) {
		return new Node(hashCode, key, value, object);
	}

	public Object[] keySet(){
		Object[] objArr= new Object[keyCount];
		int keys = 0;
		for (int i = 0; i < size; i++) {
			Node node = root[i];
			if(node != null) {
				while(node != null) {
					objArr[keys] = node.key;
					keys++;
					if(node.next != null){
						node = node.next;
					}else {
						node = null;
					}
				}
			}
		}
		return objArr;
	}
	
	public HashMap() {
		root = new Node[16];
	}

	public Object get(Object key) {
		int index = key.hashCode() & (size-1);
		Node node = root[index];
		
		while(node != null) {
			if(node.key.equals(key)) {
				return node.value;
			}else if(node.next != null){
				node = node.next;
			}else {
				return null;
			}
		}
		return null;
	}
	
}

