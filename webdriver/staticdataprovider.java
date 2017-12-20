

import org.testng.annotations.DataProvider;

public class staticdataprovider {

	/**
	 * @param args
	 */
	
	

		@DataProvider(name = "test1")  

		public Object[][] createData1() {  

		 return new Object[][] {  

		   { "user1","password1"},  

		   { "user2","password2"},
		   { "user3","password3"},
		   { "user4","password4"}
		   

		 };  
		}
	

	}

