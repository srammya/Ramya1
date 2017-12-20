
public class construtor {
	int age;
	String name;
	
	public construtor()//default contructor
	{
		System.out.println("Hello");
	}
//	public construtor(String name,int age)///overloading constructor
//	{
//		this.age=age;
//		this.name =name;
//		
//	}
	public static void main(String[] args) {
	construtor c1=new construtor();
	c1.age =10;
	c1.name="Ramya";
	//overloading constructor
/*//	construtor c2=new construtor("Harvesh",2);
	System.out.println("Name:"+c2.name);
	System.out.println(("Age:"+c2.age));*/
	
	
	}

}
