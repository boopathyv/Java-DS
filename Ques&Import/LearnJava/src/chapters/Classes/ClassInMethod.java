package chapters.Classes;

public class ClassInMethod {
	  public static void main(String[] args) { 
		  OuterClass x = new OuterClass(); 
	        x.outerMethod(); 
	    }
}

	class OuterClass {
	    void outerMethod() { 
	        System.out.println("inside outerMethod"); 
	        // Inner class is local to outerMethod() 
	        class Inner { 
	            void innerMethod() { 
	                System.out.println("inside innerMethod"); 
	            } 
	        } 
	        Inner y = new Inner(); 
	        y.innerMethod(); 
	    } 
	}  
	  