
public class reference {

	int s;
	int t;
	
	public static void swap(int a,int b)//pass by value
	{
		int temp=a;
		a=b;
		b=temp;
	}
	public static void swap(reference re)//pass by reference
	{
		int temp=re.s;
		re.s=re.t;
		re.t=temp;
	}
	public static void main(String[] args) {
	reference r=new reference();
	r.s=100;
	r.t=90;
	swap(r.s,r.t);//passby value
	System.out.println(r.s);
	System.out.println(r.t);
	
	swap(r);//pass by reference
	
	System.out.println(r.s);
	System.out.println(r.t);

	}

}
