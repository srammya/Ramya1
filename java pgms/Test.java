package com.demo.sample;

public class Test {

	public static void main(String[] args) {
		Duck d = new Duck();
		
		/*d.size= 45;
		
		d.display();*/
		
		d.setSize(6);
		System.out.println("the encapsulated size" + d.getSize());
		d.display();
	}

}
