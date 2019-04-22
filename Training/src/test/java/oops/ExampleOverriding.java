package oops;

public class ExampleOverriding extends ExampleOverriding1 {
	
	 public void disp(){
		 
	      System.out.println("disp() method of Child class");
	   }
	   public void xyz(){
	      System.out.println("xyz() method of Child class");
	   }
	   public static void main( String args[]) {
	      //Parent class reference to child class object
		   ExampleOverriding1 obj = new ExampleOverriding1();
		   ExampleOverriding obj1=new ExampleOverriding();
	      obj.disp();
	      obj.abc();
	      obj1.xyz();
	      obj1.disp();
	   }
	
}