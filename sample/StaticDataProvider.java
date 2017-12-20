package com.paypal.test.gops.admin.MaestroEnablement;

import org.testng.annotations.DataProvider;

import com.paypal.test.bluefin.platform.grid.WebTest;
import com.paypal.test.jaws.ppo.Country;
import com.paypal.test.jaws.ppo.CreditCardFactory;
import com.paypal.test.jaws.ppo.CreditCardType;
import com.paypal.test.jaws.ppo.PPAccountType;
import com.paypal.test.jaws.ppo.PPUserFactory;
import com.paypal.test.jaws.ppo.impl.exception.PayPalUserCreationFailedException;
import com.paypal.types.Currency.Info;

// TODO: Auto-generated Javadoc
/**
 * This static class StaticDataProvider will provide the different sets of data to the.
 *
 * @Test annotation wherever you have used your test scripts in your class file.  For eg.
 * @DataProvider(name=" createBuyerAndCreditCard") which will provide the different set of data to your
 * test cases where you name it as @Test(dataProvider = "createBuyerSellerAndCreditCard", dataProviderClass = StaticDataProvider.class)
 * You need to specify the dataprovider name in your @Test method
 * @author pream
 */

public  class StaticDataProvider {
		
		/**
		 * In the below dataprovider, it sends three parameters as objects to the test method
		 * You can send even 'n' of parameters to the @Test method
		 * From the below dataprovider, first parameter creates buyer, second parameter adds a credit card
		 * third parameter creates seller.Three of these parameters will be passed to @Test method as
		 * Objects
		 *
		 * @return the object[][]
		 * @throws PayPalUserCreationFailedException 
		 */
		@DataProvider(name = "createBuyerAndCreditCard")
	  public static Object[][] createData() throws PayPalUserCreationFailedException {
	    return new Object[][] {
	    		

	    		{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.BE, Info.Euro),CreditCardFactory.generateAddCCRequest(
	    				CreditCardType.MAESTRO, Country.BE, Info.Euro, false)},
	    	    			
	 	   	{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.FR, Info.Euro),CreditCardFactory.generateAddCCRequest(
	    	     		CreditCardType.MAESTRO, Country.FR, Info.Euro, false)},
	    	     				
	   	/*    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.ES, Info.Euro),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.ES, Info.Euro)},
	    	       			       				
	    	       				
	    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.IT, Info.Euro),CreditCardFactory.createCreditCard(
	    	    		CreditCardType.MAESTRO, Country.IT, Info.Euro)},
	    	    	    	    			
	    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.TR, Currency.TURKISH_LIRA),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.TR, Currency.TURKISH_LIRA)},
	    	    	    	     				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PT, Info.Euro),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.PT, Info.Euro)},
	    	    				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PL, Currency.POLISH_ZLOTY),CreditCardFactory.createCreditCard(
	    	    		 CreditCardType.MAESTRO, Country.PL, Currency.POLISH_ZLOTY)},       				
	    	    		    	    	    	    			
	    	     	    	    		    	    	    	     				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.SK, Info.Euro),CreditCardFactory.createCreditCard(
	  	       		CreditCardType.MAESTRO, Country.SK, Info.Euro)}, 
	    		{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT)},*/
	  };
	  }
		
		/**
		 * Creates the buyer.
		 *
		 * @return the object[][]
		 * @throws PayPalUserCreationFailedException 
		 */
		@DataProvider(name = "addTwoCreditCards")
		  public static Object[][] createBuyer() throws PayPalUserCreationFailedException {
		    return new Object[][] {
		    		  		{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.BE, Info.Euro),CreditCardFactory.generateAddCCRequest(
		    				CreditCardType.MAESTRO, Country.BE, Info.Euro, false),CreditCardFactory.generateAddCCRequest(
				    				CreditCardType.MAESTRO, Country.BE, Info.Euro, false)},
		    	    			
				    				 /* 				 	   	{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.FR, Info.Euro),CreditCardFactory.createCreditCard(
		    	     		CreditCardType.MAESTRO, Country.FR, Info.Euro),CreditCardFactory.createCreditCard(
				    	     		CreditCardType.MAESTRO, Country.FR, Info.Euro)},
		    	     				
		    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.ES, Info.Euro),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.ES, Info.Euro),CreditCardFactory.createCreditCard(
				    	       		CreditCardType.MAESTRO, Country.ES, Info.Euro)},
		    	       				
		    	       				
		    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.IT, Info.Euro),CreditCardFactory.createCreditCard(
		    	    		CreditCardType.MAESTRO, Country.IT, Info.Euro),CreditCardFactory.createCreditCard(
				    	    		CreditCardType.MAESTRO, Country.IT, Info.Euro)},
		    	    	    	    			
		    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.TR, Currency.TURKISH_LIRA),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.TR, Currency.TURKISH_LIRA),CreditCardFactory.createCreditCard(
				    	       		CreditCardType.MAESTRO, Country.TR, Currency.TURKISH_LIRA)},
		    	    	    	     				
		    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PT, Info.Euro),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.PT, Info.Euro),CreditCardFactory.createCreditCard(
				    	       		CreditCardType.MAESTRO, Country.PT, Info.Euro)},
		    	    				
		    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PL, Currency.POLISH_ZLOTY),CreditCardFactory.createCreditCard(
		    	    		 CreditCardType.MAESTRO, Country.PL, Currency.POLISH_ZLOTY),CreditCardFactory.createCreditCard(
				    	    		 CreditCardType.MAESTRO, Country.PL, Currency.POLISH_ZLOTY)},       				
		    	    		    	    	    	    			
		    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
				    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT)},
		    	    		    	    	    	     				
		    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.SK, Info.Euro),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.SK, Info.Euro),CreditCardFactory.createCreditCard(
				    	       		CreditCardType.MAESTRO, Country.SK, Info.Euro)},		
		    		 {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
			    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
					    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT)},
		 */   	       			
		    	    
		  };
		  }
	  
		/**
		 * Creates the buyer seller and credit card.
		 *
		 * @return the object[][]
		 * @throws PayPalUserCreationFailedException 
		 */
		@WebTest
		@DataProvider(name = "createBuyerSellerAndCreditCard")
	  public static Object[][] createBuyerSellerAndCreditCard() throws PayPalUserCreationFailedException {
	    return new Object[][] {
	    	
	    	    				{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.BE, Info.Euro),CreditCardFactory.generateAddCCRequest(
	    		CreditCardType.MAESTRO, Country.BE, Info.Euro, false),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.BE, Info.Euro),CreditCardFactory.generateAddCCRequest(
	    	    				CreditCardType.MAESTRO, Country.BE, Info.Euro, false),"EUR"},
	    	    			
	    	    				 /*  	{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.FR, Info.Euro),CreditCardFactory.createCreditCard(
	    	     		CreditCardType.MAESTRO, Country.FR, Info.Euro),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.FR, Info.Euro),CreditCardFactory.createCreditCard(
	    	     				CreditCardType.MAESTRO, Country.FR, Info.Euro),"EUR"},
	    	     				
	 	      {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.ES, Info.Euro),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.ES, Info.Euro),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.ES, Info.Euro),CreditCardFactory.createCreditCard(
	    	       				CreditCardType.MAESTRO, Country.ES, Info.Euro),"EUR"},
	    	       				
	    	       				
	    	   	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.IT, Info.Euro),CreditCardFactory.createCreditCard(
	    	    		CreditCardType.MAESTRO, Country.IT, Info.Euro),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.IT, Info.Euro),CreditCardFactory.createCreditCard(
	    	       				CreditCardType.MAESTRO, Country.IT, Info.Euro),"EUR"},
	    	    	    	    			
	    	    {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.TR, Currency.TURKISH_LIRA),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.TR, Currency.TURKISH_LIRA),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.TR, Currency.TURKISH_LIRA),CreditCardFactory.createCreditCard(
	    	       				CreditCardType.MAESTRO, Country.TR, Currency.TURKISH_LIRA),"TRY"},
	    	    	    	     				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PT, Info.Euro),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.PT, Info.Euro),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.PT, Info.Euro),CreditCardFactory.createCreditCard(
	    	    				CreditCardType.MAESTRO, Country.PT, Info.Euro),"EUR"},
	    	    				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.PL, Currency.POLISH_ZLOTY),CreditCardFactory.createCreditCard(
	    	    		 CreditCardType.MAESTRO, Country.PL, Currency.POLISH_ZLOTY),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.PL, Currency.POLISH_ZLOTY),CreditCardFactory.createCreditCard(
	    	    				 CreditCardType.MAESTRO, Country.PL, Currency.POLISH_ZLOTY),"PLN"},       				
	    	    		    	    	    	    			
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
	    	    				CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),"HUF"},
	    	    		    	    	    	     				
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.SK, Info.Euro),CreditCardFactory.createCreditCard(
	    	       		CreditCardType.MAESTRO, Country.SK, Info.Euro),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.SK, Info.Euro),CreditCardFactory.createCreditCard(
	    	 	    				CreditCardType.MAESTRO, Country.SK, Info.Euro),"EUR"},
	    	 	    				{PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.RU, Info.US_Dollar),CreditCardFactory.createCreditCard(
	    	 	   	    	       		CreditCardType.MAESTRO, Country.RU, Info.US_Dollar),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.RU, Info.US_Dollar),CreditCardFactory.createCreditCard(
	    	 	   	    	 	    				CreditCardType.MAESTRO, Country.RU, Info.US_Dollar),"USD"},
	     		
	  			    	    	    	    			
	    	     {PPUserFactory.createPayPalUser(PPAccountType.PERSONAL,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
		    	       		CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),PPUserFactory.createPayPalUser(PPAccountType.BUSINESS,Country.HU, Currency.HUNGARIAN_FORINT),CreditCardFactory.createCreditCard(
		    	    				CreditCardType.MAESTRO, Country.HU, Currency.HUNGARIAN_FORINT),"HUF"},
	  */  		};
	  }
	  
	  
	  
	  
	}
