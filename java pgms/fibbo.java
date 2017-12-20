import java.util.Scanner;


public class fibbo {
	public static void main(String args[])
	{		
	int prev,next,sum,n;
	prev=next=1;
	for (n=1;n<=10;n++){
		System.out.println(prev);
		sum=prev+next;
		prev=next;
		next=sum;
	}
		/*int febcount=15;
		int [] feb= new int[febcount];
		feb[0]=0;
		feb[1]=1;
		for(int i=2;i<febcount;i++)
		{
			feb[i]=feb[i-1]+feb[i-2];
		
		}
		for(int i=0;i<febcount;i++){
			System.out.println(feb[i]);
	}*/
	
	
//	int prev, next, sum, n;
//	prev=next=1;
//	for(n=1;n<=10;n++)
//	{
//		System.out.println(prev);
//		sum=prev+next;
//		prev=next;
//		next=sum;
//	}
}
}