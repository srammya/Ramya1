
public class OuterClass {
   int outdata=5;
	class Inside{
		int data2=100;
		
		void meth(){
			outdata=10;
			System.out.println("data2"+data2);
		}
		
	}
	public static void main(String[] args) {
	
			OuterClass inclass=new OuterClass();
			Inside inside= inclass.new Inside();
			
			System.out.println(inclass.outdata);
			System.out.println(inside.data2);
			
}
	

}


