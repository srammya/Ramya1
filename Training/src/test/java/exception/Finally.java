package exception;

public class Finally {
	
	public static void main(String[] args) {
		try {
			int a=10;
			int b= 0;
			int c=a/b;
		System.out.println("Result: "+c);

	}
		
		finally {
			System.out.println("Finally Block will be executed");
		}

}
}