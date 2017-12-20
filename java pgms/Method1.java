package com.demo.sample;

public class Method1 {
	
	int i=10;
	public static int add(int a, int b){
		int c=a+b;
		print();
		return c;
		
	}
	public static void print(){
		System.out.println("Hello All");
	}
	public static void main(String[] args) {
		Method1 m1=new Method1();
		System.out.println("Addition of 2 numbers "+ add(10,20));
	//	print();
		System.out.println("instance variable "+m1.i);

	}

}
