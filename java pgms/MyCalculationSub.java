
public class MyCalculationSub extends CaluclationSuper {
	public void multiplication(int x, int y) {
	      z = x * y;
	      System.out.println("The multiplication of the given numbers:"+z);
	   }
	public static void main(String[] args) {
		
		int a = 20, b = 10;
		MyCalculationSub demo = new MyCalculationSub();
	      demo.addition(a, b);
	      demo.Subtraction(a, b);
	      demo.multiplication(a, b);
	}

}
