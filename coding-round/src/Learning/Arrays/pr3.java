package Learning.Arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

//Java Program to convert Character Array to IntStream
public class pr3 {

	public static void main(String[] args) {
		// Get the Character Array to be converted 
        Character charArray[] = { 'G', 'e', 'e', 'k', 's' }; 
  
        // Convert charArray to IntStream 
        IntStream 
            intStream 
            = Arrays.stream(charArray) 
                  .flatMapToInt(IntStream::of); 
  
        // Print the elements of the IntStream 
        System.out.println("IntStream:"); 
        intStream.forEach(System.out::println); 
	}
}
