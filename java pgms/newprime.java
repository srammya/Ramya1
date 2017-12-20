import java.util.Scanner;


public class newprime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n,res,i;
		boolean flag=true;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		for(i=2;i<=n;i++)
		{
			res=n%i;
			if(res==0)
				flag=false;
			break;
		}
		if(flag)
		
			System.out.println("Prime");
		else
			System.out.println("not prime");
	}

}
