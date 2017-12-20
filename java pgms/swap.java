
public class swap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int a=10;
		int b=30;
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);;
		System.out.println(b);*/
	
////////////////
		int num = 153;

		int n = num; //use to check at last time

		int check=0,remainder;

		while(num > 0){

		remainder = num % 10;

		check = check + (int)Math.pow(remainder,3);

		num = num / 10;

		}

		if(check == n)

		System.out.println(n+" is an Armstrong Number");

		else

		System.out.println(n+" is not a Armstrong Number");

		}




	}


