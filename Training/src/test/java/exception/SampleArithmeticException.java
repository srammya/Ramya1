package exception;

public class SampleArithmeticException {

	public static void main(String[] args) {
		try {
		try {
			int a=10;
			int b= 0;
			int c=a/b;
		System.out.println("Result: "+c);

	}
		
		catch(ArithmeticException e) {
			System.out.println("Can't divide number by zero");
			
		}
		
		try {
			int n=Integer.parseInt("Test");
			
			System.out.println("n");
		}
		catch(NumberFormatException e) {
			System.out.println("NumberFormat Exception");
		}
		
		try {
			int a[]=new int[5];
			a[7]=10;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index Out Of Bounds Exception");
		}
		
		System.out.println("Other Statemet");
		}
		catch(Exception e) {
			System.out.println("Handled and Recovered");
		}
	}

}
