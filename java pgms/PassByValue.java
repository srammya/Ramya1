
public class PassByValue {

	
	public static void test(int m){
		m=80;
	}
	public static void main(String[] args) {
		int i=56;
		test(i);
		System.out.print(i);

	}

}
