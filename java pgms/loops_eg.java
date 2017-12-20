public class loops_eg {

	
	public static void main(String[] args) {


	
		int i,table;
		for (table=1;table<=10;table++){
			System.out.println("Print Table No"+table);
			
			for(i=1;i<=10;i++){
				System.out.println(table+"*"+i+"="+table*i);
			}
				if(table==6){
					break;
					}
		}

	}

}
