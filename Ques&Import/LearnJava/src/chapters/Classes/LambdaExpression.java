package chapters.Classes;

interface FuncInterface 
{ 
    // An abstract function 
//    void abstractFun(int x);
    
    void sum(int w,int x,int y,int z); 
  
    // A non-abstract (or default) function 
    default void normalFun() 
    { 
       System.out.println("Hello"); 
    } 
} 
  
public class LambdaExpression 
{ 
    public static void main(String args[]) 
    { 
        // lambda expression to implement above 
        // functional interface. This interface 
        // by default implements abstractFun() 
//        FuncInterface fobj = (int x)->System.out.println(2*x);
        
        FuncInterface sum = (int w,int x,int y,int z)->System.out.println(w+x+y+z);
  
        // This calls above lambda expression and prints 10. 
//        fobj.abstractFun(5); 
        sum.sum(1, 2, 3, 4);
    } 
} 
