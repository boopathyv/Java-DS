package main.Map;

import java.util.HashMap;
import java.util.Map;

public class MapImpl {

	class Key{
		String key;
		String value;
		public Key(String key) {
			this.key = key;
		}
	}
	
	public static void main(String[] args) {
		Object[] d = {9,2,3,4};
		MapImpl mapImpl = new MapImpl(); 
		Key key = mapImpl.new Key("sachin");
		System.out.println(key.hashCode());
		System.out.println(getBinary(key.hashCode()));
		
		Map<String,String> map = new HashMap<>();
		for (int i = 0; i < 1000; i++) {
			map.put("index_"+i,"index_"+i);
		}
		System.out.println(map);
	}
								   
	public static String getBinary(int value){
		String returnValue = "";
		while(value >= 2) {
			int modulo = value % 2;
			value = value/2;
			returnValue += modulo;
		}
		returnValue += value;
		return reverseString(returnValue);
	}
	
	public static String reverseString(String str){  
	    char ch[]=str.toCharArray();  
	    String rev="";  
	    for(int i=ch.length-1;i>=0;i--){  
	        rev+=ch[i];  
	    }  
	    return rev;  
	}  
}
