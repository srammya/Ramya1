
public class ComparingObjects {

	public static void main(String[] args) {
		String str1="Hello";
		String str2=str1;
		System.out.println("String1 "+ str1);
		System.out.println("String2 "+ str2);
		System.out.println("Same Objects "+str1==str2);
		str2=new String(str1);
		System.out.println("String1 "+ str1);
		System.out.println("String2 "+ str2);
		System.out.println("Same Objects "+str1==str2);
		System.out.println("Same Value "+str1.equals(str2));
		
	}

}
