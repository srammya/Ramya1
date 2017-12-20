
public class methods {

	public static int a=30;
	public static int b=40;
	
	
	public static void add(){
		 int c=a+b;
		 System.out.println(c);
	}
	public static int add(int r, int s){
		int add =r+s;
		return add;
				
	}
	
	public static void main(String[] args) {
		
		add();
		int res=add(10,30);
		System.out.println(res);
	}

	
}
