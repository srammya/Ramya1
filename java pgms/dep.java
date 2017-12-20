
public class dep implements employee{

	
	public static void main(String[] args) {
//		employee e=new employee();
		employee e=new dep();
		e.salay();
		e.HR();

	}

	@Override
	public void salay() {
		System.out.println("salary granted for this month");
		
	}

	@Override
	public void HR() {
		System.out.println("HR polici	es applied");
		
	}

}
