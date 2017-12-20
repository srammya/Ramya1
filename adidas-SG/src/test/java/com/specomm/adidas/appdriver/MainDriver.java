package com.specomm.adidas.appdriver;

import org.testng.TestNG;



import com.specomm.adidas.pagecomponents.AdidasLoginPage;



public class MainDriver {

		TestNG testng = new TestNG();
		public static void main(String[] args) {

			TestNG testng = new TestNG();

			testng.setTestClasses(new Class[] { AdidasLoginPage.class });
			testng.run();

		testng.run();
	}
}
