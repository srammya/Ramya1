public class reverse_message
{
	 static void Doreverse(String str)
	 {
	 	if(str==null || str.length()==0)
	 	System.out.println(" ");
	 	String arr[]=str.split(" ");
	 	StringBuilder sb=new StringBuilder();
	 	for(int i=arr.length-1;i>=0;i--)
	 	{
	 	if(!arr[i].equals(" "))
	 	sb.append(arr[i]).append(" ");
	 	}
	 	if(sb.length()==0)
	 	System.out.println(" ");
	 	else
	 	System.out.println(sb.substring(0,sb.length()-1));
	 }
	public static void main (String[] args) throws java.lang.Exception
	{
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		String str=br.readLine();
		String str="Hello world I am here";
		Doreverse(str);
		//output - here am I world Hello
	}
}

