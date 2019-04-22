package exception;

public class Throw {
	public static void AvgMethod() {
		try {
			throw new ArithmeticException("Demo");
		}
	
	catch(ArithmeticException e) {
		System.out.println("Exception caught");
	}
	
	}

	public static void main(String[] args) {
		
		AvgMethod();
	}

}
