
public class newarm {

	
	public static void main(String[] args) {
		int num=153;
		int n=num;
		int check=0, remainder;
				while(num>0)
				{
					remainder=num%10;
					check=check+(int)Math.pow(remainder,3);
							num=num/10;
				}

	if(check==n)
	
		System.out.println("print armsteong");
		else
			System.out.println("print not armsteong");
	
	}

}
