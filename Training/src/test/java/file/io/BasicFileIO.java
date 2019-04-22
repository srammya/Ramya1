package file.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BasicFileIO {

	public static void main(String[] args) {
		File file=new File("test.txt");
		
//		write name name and hobby to the file
		/*try {
			PrintWriter writer=new PrintWriter(file);
			writer.println("Ramya");
			writer.println("Carrom");
			writer.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
*/
		//read from file
		try {
			Scanner scan=new Scanner(file);
			String name=scan.nextLine();
			String hobby=scan.nextLine();
			System.out.println("Name: "+name);
			System.out.println("Hobby: "+hobby);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

}
