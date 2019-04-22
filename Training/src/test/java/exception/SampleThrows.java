package exception;

public class SampleThrows {

	
		public static void AvgMethod() throws ArithmeticException
		{
			
				System.out.println("Inside Avg Method");
				throw new ArithmeticException("Demo");
			
		
		}

		public static void main(String[] args) {
			try {
			AvgMethod();
			
			
			}

		
		finally{
			System.out.println("Finally Executed");
		}
		}

}
