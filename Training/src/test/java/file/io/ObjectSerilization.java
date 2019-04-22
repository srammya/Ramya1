package file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerilization {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		File file=new File("Student.txt");
		ArrayList<Student> students=new ArrayList<Student>();
		students.add(new Student("Tom",100));
		students.add(new Student("Dave",101));
		
		//serialize the collection of student
		
		FileOutputStream fos=new FileOutputStream(file);
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(students);
		oos.close();
		fos.close();
		
		//deserialize the file back into the collection
		
		FileInputStream fis=new FileInputStream(file);
		ObjectInputStream ois=new ObjectInputStream(fis);
//		Students s=
		
		
	}

}
