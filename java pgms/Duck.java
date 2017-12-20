package com.demo.sample;

public class Duck {

	/*private int size=10;

public void display()

{

if (size<0)

System.out.println("incorrect size");

else if(size>10)

System.out.println("bigger duck!!!");

else if (size < 10)

System.out.println("smaller duck!!");
}
}
*/

private int size = 12;
public void setSize(int x)
{
if (x<=0);
else if(x>=25);
else
size = x;
}
public int getSize()
{
return size;
}
public void display()
{
if(size>10)
System.out.println("bigger duck!!!");
else if (size < 10)
System.out.println("smaller duck!!");
}
}