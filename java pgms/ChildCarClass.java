//Inheritance
public class ChildCarClass extends ParentVehicleClass {
	 int CC;
	   int gears;
	   void attributescar() {
	      // The subclass refers to the members of the superclass
	      System.out.println("Color of Car : " + color);
	      System.out.println("Speed of Car : " + speed);
	      System.out.println("Size of Car : " + size);
	      System.out.println("CC of Car : " + CC);
	      System.out.println("No of gears of Car : " + gears);
	   }
	
	
	   public static void main(String args[]) {
		   ChildCarClass b1 = new ChildCarClass();
	      b1.color = "Blue";
	      b1.speed = 200 ;
	      b1.size = 22;
	      b1.CC = 1000;
	      b1.gears = 5;
	      b1.attributescar();
	   }
}
