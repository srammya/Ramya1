package exception;

public class MultiCatch {
	public static void main(String[] args) {
	try {
		int a=10;
		int b= 0;
		int c=a/b;
	System.out.println("Result: "+c);

}
	
	catch(ArithmeticException e) {
		System.out.println("Can't divide number by zero");
		
	}
	
	
	catch(Exception e) {
		System.out.println("Exception");
	}

	System.out.println("Handled exceptions");

}
}