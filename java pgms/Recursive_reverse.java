
public class Recursive_reverse {
	String reverse ="";
	public String reversestring(String str){
		if(str.length()==1){
			return str;
		}
		else{
			reverse+=str.charAt(str.length()-1)+reversestring(str.substring(0,str.length()-1));
			return reverse;
		}
		
	}

	public static void main(String[] args) {
		
		Recursive_reverse rr=new Recursive_reverse();
		System.out.println(rr.reversestring("Ramya"));
	}

}
