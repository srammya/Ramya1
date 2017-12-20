
public class swapnum {

	int t;
	int s;
	public static void swap(int a,int b){//pass by value
		int temp;
		temp=a;
		a=b;
		b=temp;
		
	}
	public void swap(swapnum sw){
		int temp=sw.s;
		sw.s=sw.t;
		sw.t=temp;
		
		
		
	}
	public static void main(String[] args) {
		swapnum sn=new swapnum();
		

	}

}
