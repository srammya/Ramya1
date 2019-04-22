package oops;

public class AbstractTest extends AbstractDemo {

	   public void anotherMethod() { 
	        System.out.println("Abstract method"); 
	   }
	   
	   public void myMethod(){
		  
		      System.out.println("Welcome All");
		   }
		   
	   public static void main(String args[])
	   { 
		   AbstractTest at=new AbstractTest();
		   at.anotherMethod();
		   at.myMethod();
	    
	      
	   }
	}