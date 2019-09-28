package Learning.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Flatten a Stream of Arrays in Java using forEach loop
public class pr2 {

	public static void main(String[] args) {
		 Integer[][] arr = { 
		            { 1, 2 }, 
		            { 3, 4, 5, 6 }, 
		            { 7, 8, 9 } 
		        }; 
		  
		        // Flatten the Stream 
		        Integer[] flatArray = flattenStream(arr) 
		                                  .toArray(Integer[] ::new); 
		  
		        // Print the flattened array 
		        System.out.println(Arrays.toString(flatArray)); 
	}
	
	public static <T> Stream<T> flattenStream(T[][] arrays) 
    { 
  
        // Create an empty list to collect the stream 
        List<T> list = new ArrayList<>(); 
  
        // Using forEach loop 
        // convert the array into stream 
        // and add the stream into list 
        for (T[] array : arrays) { 
            Arrays.stream(array) 
                .forEach(list::add); 
        } 
  
        // Convert the list into Stream and return it 
        return list.stream(); 
    } 
}
