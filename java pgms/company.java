
public class company {

	
	public static void main(String[] args) {
		
		department d=new department();
		d.dcount=1000;
		d.dname="Sales";
		d.dno=90;
		
		d.adddepartment();
		d.changedepartment();
		System.out.println(d.dno);
		System.out.println(d.dname);
		System.out.println(d.dcount);
		
	
	}

}
