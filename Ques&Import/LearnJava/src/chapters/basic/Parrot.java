package chapters.basic;

import java.lang.reflect.Field;
import java.util.Iterator;

public class Parrot {

	private Integer are;
	private Integer you;
	private Integer ready;
	private Integer welcome;
	private Integer man;
	private Integer buddy;
	
	public Parrot(int are,int you,int ready,int welcome,int man,int buddy) {
		this.are = are;
		this.you = you;
		this.ready = ready;
		this.welcome = welcome;
		this.man = man;
		this.buddy = buddy;
	}
	
	@Override
	public int hashCode() {
		return are.hashCode() + you.hashCode()+ready.hashCode()+welcome.hashCode()
			+man.hashCode()+buddy.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("{");
		Field[] fields = this.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				String fieldName = field.getName();
				field.setAccessible(true);
				Object value = field.get(this);
				if(result.toString().equals("{")) {					
					result.append("\"").append(fieldName).append("\"=").append(value);
				}else {
					result.append(",").append("\"").append(fieldName).append("\"=").append(value);
				}
			}
			result.append("}");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Parrot parrot = (Parrot)obj;
		if(this.are == parrot.are && this.you == parrot.you
				&& this.ready == parrot.ready && this.welcome == parrot.welcome
				&& this.man == parrot.man && this.buddy == parrot.buddy) {
			return true;
		}
		return false;
	}
}
