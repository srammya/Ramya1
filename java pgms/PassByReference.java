
public class PassByReference {
	
	public static void test(int [] j){
		for(int i=0;i<j.length;i++){
			j[i]=i+50;
		}
		
	}

	public static void main(String[] args) {
		int ages[]={10,20,30};
		for(int i=0;i<ages.length;i++){
			System.out.println(ages[i]);
		}
		
		test(ages);
		for(int i=0;i<ages.length;i++){
			System.out.println(ages[i]);
		}
	}

}
