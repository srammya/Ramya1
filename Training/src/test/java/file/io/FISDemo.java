package file.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		FileInputStream fis=new FileInputStream("test.txt");
		int data =fis.read();  //read 1 byte at a time
		System.out.println(data);
		
		//type cast to character
		System.out.println((char)data);
	}

}

