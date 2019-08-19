package chapters.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import chapters.models.Bike;
import chapters.models.Mike;

public class Reflection {

	public static void main(String[] args) {
		Reflection reflection = new Reflection();
//		reflection.newInstanceWithArguments();
		reflection.setParams();
	}
	
	private void setParams() {
		try {
			Class<?> bikeClass = Class.forName(Bike.class.getName());
			System.out.println(bikeClass);
			Bike bike = (Bike) bikeClass.newInstance();
			Field[] declaredFields = bikeClass.getDeclaredFields();
			
			for (int i = 0; i < declaredFields.length; i++) {
				Field field = declaredFields[i];
				field.setAccessible(true);
				field.set(bike, field.getName()+"Twister"+i);
				
				System.out.println(field.getName()+"....."+field.get(bike));
			}
			
			bikeClass.getCanonicalName();
			Method[] methods = bikeClass.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if(method.getGenericParameterTypes().length == 0) {					
					System.out.println(method.invoke(bike));
				}else {
					method.invoke(bike,method.getName()+"_METHOD_"+i);
				}
				method.setAccessible(true);
			}
			bikeClass.getModifiers();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public synchronized void newInstanceWithArguments(){
		System.out.println(Mike.class);
		Class<?> mikeClass = Mike.class;
		// get new Instance
		
		
		String name = "HEMAN";
		Integer modelNo = 2009;
		Long weight = 30000L;
		List<String> nos = Arrays.asList("the","me","she");
		Object[] args = {name,modelNo,weight,nos};
		try {
			Mike mike = (Mike) mikeClass.getConstructor(String.class,Integer.class,Long.class,List.class).newInstance(args);
			System.out.println(mike.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
