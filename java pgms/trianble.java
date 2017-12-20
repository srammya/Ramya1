public class trianble{
	
	public static void main(String args[]){
		
		int num = 5;   //Integer.parseInt(args[0]);
		for(int i=1;i<=num;i++){
			for(int j=1;j<=i;j++){
				System.out.print(" "+i+" ");
			}
			System.out.print("\n");
		}
	}
}