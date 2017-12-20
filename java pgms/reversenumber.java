
public class reversenumber {

	public int reverseno(int number){
		int reverse=0;
		while(number!=0){
			reverse=(reverse*10)+(number%10);
					number=number/10;
		}
		return reverse;
		
	}
	public static void main(String[] args) {
		reversenumber rn=new reversenumber();
		System.out.println(rn.reverseno(789));

	}

}
