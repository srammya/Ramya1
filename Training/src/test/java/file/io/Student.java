package file.io;

import java.io.Serializable;

public class Student implements Serializable{

	private String sName;
	private int sNo;
	
	public Student(String sName,int sNo) {
		
		this.sName=sName;
		this.sNo=sNo;
		
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	
	
	
}
