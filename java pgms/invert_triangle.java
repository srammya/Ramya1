public class invert_triangle{
	
	public static void main(String args[]){
		
		int num = 5;
		while(num > 0){
			for(int j=1;j<=num;j++){
				System.out.print(" "+num+" ");
			}
			System.out.print("\n");
			num--;
			/*output
			 5  5  5  5  5 
			 4  4  4  4 
			 3  3  3 
			 2  2 
			 1 */
		}
	}
}
