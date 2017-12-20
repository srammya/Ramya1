//Interface
public class InterfaceTest implements MyInterfaceTest {
	
	
	public void method1()
	  {
	      System.out.println("implementation of method1");
	  }
	  public void method2()
	  {
	      System.out.println("implementation of method2");
	  }
	  public static void main(String arg[])
	  {
	      MyInterfaceTest obj = new InterfaceTest();
	      obj. method1();
	      obj.method2();
	  }

}
