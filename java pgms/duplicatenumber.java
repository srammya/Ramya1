import java.util.List;
import java.util.ArrayList;



public class duplicatenumber {

	public int duplicate(List<Integer> numbers){
		int highest=numbers.size()-1;
		int total=getsum(numbers);
		int duplicate=total-(highest*(highest+1)/2);
		return duplicate;
		
	}
	public int getsum(List<Integer> numbers){
		int sum=0;
		for(int num:numbers){
			sum=sum+num;
			
		}
		return sum;
	}
	public static void main(String[] args) {
		List<Integer> numbers=new ArrayList<Integer>();
		for(int i=1;i<30;i++){
			numbers.add(i);
			
		}
		numbers.add(22);
		duplicatenumber dp=new duplicatenumber();
		System.out.println(dp.duplicate(numbers));
	}

}
