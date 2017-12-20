package com.specomm.adidas.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class AdidasHomePage {

	
	String MEGAMENU;
	String Title,Value;
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	
	
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(how = How.XPATH, using ="//span[@class='show_bk']")
	public List<WebElement> megaMenuElements;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav']/ul/li[2]/div[1]/div/ul/li/ul[*]/li[1]/div[*]/a")
	public List<WebElement> menSectionElements;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav']/ul/li[3]/div[1]/div/ul/li/ul[*]/li[1]/div[*]/a")
	public List<WebElement> womenSectionElements;

	@FindBy(how = How.XPATH, using = "//*[@id='nav']/ul/li[4]/div[1]/div/ul/li/ul[*]/li[1]/div[*]/a")
	public List<WebElement> kidsSectionElements;
	
	@FindBy(how = How.XPATH, using ="//*[@id='nav']/ul/li[6]/div[1]/div/ul/li/ul[*]/li[1]/div[*]/a")
	public List<WebElement> sportsSectionElements;
	
	@FindBy(how = How.XPATH, using = "//*[@id='nav']/ul/li[7]/div[1]/div/ul/li/ul[1]/li[1]/div[3]/a")
	public List<WebElement> brandSectionElements;
	
	@FindBy(how = How.CSS , using = "div.home-pop-up > a.close")
	public WebElement btn_popupclose;
	
	@FindBy(how = How.XPATH , using = "html/body/div[1]/div/div[1]/div/div/ul/li[2]/a/span")
	public WebElement click_enterUI ;
	
	@FindBy(how = How.CSS, using = "a.h-login-link")
	public WebElement click_Login ;
	
	@FindBy(how = How.XPATH, using = "//*[@id='login-form']/div/div[2]/div/div/div[2]/div/button")
	public WebElement click_CreateAccount;
	
	@FindBy(how = How.XPATH, using ="//*[@id='header']/div[1]/div[1]/div[1]/h1/a/i")
	public WebElement homePage;
	
	@FindBy(how = How.XPATH, using ="//*[@id='search_mini_form']/div/p")
	WebElement searchOption;
	
	@FindBy(how = How.ID, using = "search")
	public WebElement txtsearch;
	
	
	public AdidasHomePage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	public void selectCategoryRandomly(List<WebElement> sectionElemts)
			throws InterruptedException
		
	{
		try{

		System.out.println(sectionElemts.size());
		int randNum = ReusableActions.randomSelection(sectionElemts);
		
			ReusableActions.waitForElementToBeClickable(driver,
					sectionElemts.get(randNum));
			System.out.println("**********sectionelement"+sectionElemts.get(randNum));
			ReusableActions.waitForpageToLoad(driver);
			inAction.buttonClick(driver,sectionElemts.get(randNum),"Click the product");
			//sectionElemts.get(randNum).click();
	}
			catch(Exception t){
		t.printStackTrace();
	}
	}
	
	
		
		// Click Search
	public void clickSearch() {
		try{
		
		
		inAction.linkClick(driver, searchOption, "Click Search option from home page");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
	//Enter Search item
	public void enterItem(String item) {
		try{
			
		
		ReusableActions.isElementVisible(txtsearch , "Verify if search field exists");
		inAction.inputText(driver, txtsearch,item, "Enter search item: "+item );
		txtsearch.sendKeys(Keys.ENTER);
    }
	catch(Exception e){
		e.printStackTrace();
		
	}
	}
	
	
	public void popUp(){
		try{
					
			inAction.buttonClick(driver, btn_popupclose, "Click button : btn_popupclose");
			 
			 String delimiter = ":";
				Title=driver.getTitle();
		    	  // given string will be split by the argument delimiter provided. 
		    	  String [] temp = Title.split(delimiter);
		    	  // print substrings 
		    	  for(int i =0; i < temp.length ; ++i){
		    		  
		    		  Value=temp[++i];
		    		  System.out.println(Value);
		    	  }
				 Assert.assertEquals(constants.URL_LOADING_PAGE_TITLE, Value);
			}
		
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clickEnterUI() {
		try{

		inAction.buttonClick(driver, click_enterUI, "Click button : click_enterUI");
    }
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickLogin(){
		try{
		inAction.linkClick(driver, click_Login, "Click link : click_Login");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
		
	}	
		
	public void clickCreateAccount(){
		try{
		inAction.linkClick(driver, click_CreateAccount, "Click link : click_Login");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
		
	}	
		
		
		
		

	
	/*
	
	
	public void loginAsRegisteredUser(String sUserName, String sPassword) {
		try{
			
			String delimiter = ":";
			Title=driver.getTitle();
	    	  // given string will be split by the argument delimiter provided. 
	    	  String [] temp = Title.split(delimiter);
	    	  // print substrings 
	    	  for(int i =0; i < temp.length ; ++i){
	    		  
	    		  Value=temp[++i];
	    		  System.out.println(Value);
	    		  Assert.assertEquals(constants.CUSTOMER_HOME_PAGE_TITLE, Value);
		}
	    	  
		
			
			enterUserName(sUserName);
	        enterPassword(sPassword);
	        clickLoginButton();
	        Assert.assertEquals(constants.CUSTOMER_LANDING_PAGE,driver.getTitle());
	        
				
    }
	
	catch(Throwable t)
	{
		t.printStackTrace();
	}
}*/
	
	public void clickHome(){
		try{
			
		inAction.linkClick(driver, homePage, "Click link : homePage");
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}
	
	public void mainMenuRandomSelection() throws InterruptedException {
		ReusableActions.waitForpageToLoad(driver);
		clickHome();
		int menuNum = ReusableActions.randomSelection(megaMenuElements);
		System.out.println("******************before menunumber"+menuNum+"******************");
	
		ReusableActions.mouseHover(driver,megaMenuElements.get(menuNum));
		//Thread.sleep(8000);
		System.out.println("******************after menunumber"+menuNum+"******************");
		
	
		MEGAMENU = megaMenuElements.get(menuNum).getText();
		System.out.println("******************megamenu"+MEGAMENU+"******************");
		char megamenu = 'h';

		if (MEGAMENU.equalsIgnoreCase("women")) {
			megamenu = 'w';
		} else if (MEGAMENU.equalsIgnoreCase("men")) {
				megamenu = 'm';
			} else if (MEGAMENU.equalsIgnoreCase("kids")){
					megamenu = 'k';
			}
			else if(MEGAMENU.equalsIgnoreCase("sports")){
					megamenu = 's';
			}
			else if(MEGAMENU.equalsIgnoreCase("brands")){
				megamenu = 'b';
		}

		switch (megamenu) {
		case 'w':
			Thread.sleep(1000);
			selectCategoryRandomly(womenSectionElements);

			break;

		case 'm':
			Thread.sleep(1000);
			selectCategoryRandomly(menSectionElements);
			break;

		case 'k':
			Thread.sleep(1000);
			selectCategoryRandomly(kidsSectionElements);
			break;
			
		case 's':
			Thread.sleep(1000);
			selectCategoryRandomly(sportsSectionElements);
			break;
			
		case 'b':
			Thread.sleep(1000);
			selectCategoryRandomly(brandSectionElements);
			break;
			
		default:
			MEGAMENU = "Invalid Megamenu";
			break;

		}

	}
	/**
	 * Locates the WebElement and Clicks on it preventing Stale Exception
	 * @param e
	 */
	public void retryingFindClick(WebElement e) {

		int attempts = 0;
		while (attempts < 2) {
			try {
				e.click();

				break;
			} catch (StaleElementReferenceException excep) {
			}
			attempts++;
		}

	}

	
	public void retryingFindMouserHover(WebElement e) {

		int attempts = 0;
		while (attempts < 2) {
			try {
				
				Actions builder = new Actions(driver);
				
				builder.moveToElement(e).build().perform();

				break;
			} catch (StaleElementReferenceException excep) {
			}
			attempts++;
		}

	}
	
	/*public void clickRegisterMember() {
		registerMember.click();
	}
	
	public void clickHomePage() {
		homePage.click();
	}*/
	
/*public void productRandomSelection() throws InterruptedException {
		
		selectCategory(Elements);
	}*/
	
	@DataProvider
	public static Object[][] getData(){
		
		return GeneralActions.getData("RegisteredUserLoginFlow");
	}
	
	
}
