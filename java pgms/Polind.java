
public class Polind {
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
		
		Polindrome rr=new Polindrome();
		String input="Welcome to Encore";
		String output=rr.reversestring(input);
		System.out.println(output);
		/*if(input.equalsIgnoreCase(output)){
			System.out.println("polindrome");
		}else{
				System.out.println("Not Polindrom");
		}*/
		}
		
		
	}

