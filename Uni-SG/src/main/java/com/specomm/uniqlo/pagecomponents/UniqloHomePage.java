package com.specomm.uniqlo.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class UniqloHomePage {
	String MAINMENU;
	
	String Title,Value;
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	@FindBy(how = How.CSS, using ="#lightboxSignupClose")
	WebElement popUp;
	
	@FindBy(how = How.XPATH, using ="//*[@id='navHeader']/li[8]/a")
	WebElement register;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div[1]/header/div/div/div[1]/div[1]/form/div/input")
	WebElement txtSearch;
	
	@FindBy(xpath = "//span[@class='show_bk']")
	List<WebElement> mainMenuElements;

	@FindBy(xpath = "//*[@class='megamenu']/li[1]/div//td[*]//a")
	List<WebElement> womenSectionElements;

	@FindBy(xpath = "//*[@class='megamenu']/li[2]/div//td[*]//a")
	List<WebElement> menSectionElements;

	@FindBy(xpath = "//*[@class='megamenu']/li[3]/div//td[*]//a")
	List<WebElement> kidsSectionElements;
	
	@FindBy(xpath = "html/body/div[1]/div/header/div/div/a/h1/img")
	public WebElement imgUniqlo;
	
	@FindBy(xpath = "//*[@id='navHeader']/li[9]/a")
	public WebElement logout;
	
	
	
	
	public UniqloHomePage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	public void selectProductsRandomly(List<WebElement> sectionElemts)
			throws InterruptedException
		
	{
		try{

		
		int randNum = ReusableActions.randomSelection(sectionElemts);
		
			ReusableActions.waitForElementToBeClickable(driver,
					sectionElemts.get(randNum));
			
			inAction.buttonClick(driver,sectionElemts.get(randNum),"Click the product");
			
	}
			catch(Exception t){
		t.printStackTrace();
	}
	}
	
	
	public void clickImg(){
		try{
			inAction.buttonClick(driver, imgUniqlo, "Click image logo");
			closePopup();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void mainMenuRandomSelection() throws InterruptedException  {

		int menuNum = ReusableActions.randomSelection(mainMenuElements);
		
		ReusableActions.mouseHover(driver,mainMenuElements.get(menuNum));

		MAINMENU = mainMenuElements.get(menuNum).getText();

		char mainMenu = 'Z';

		if (MAINMENU.equalsIgnoreCase("WOMEN")) {
			mainMenu = 'W';
		} else if (MAINMENU.equalsIgnoreCase("MEN")) {
			mainMenu = 'M';
			} else if (MAINMENU.equalsIgnoreCase("KIDS & BABIES")){
				mainMenu = 'K';
			}
			
			


		switch (mainMenu) {
		case 'W':
			Thread.sleep(1000);
			selectProductsRandomly(womenSectionElements);

			break;

		case 'M':
			Thread.sleep(1000);
			selectProductsRandomly(menSectionElements);
			break;

		case 'K':
			Thread.sleep(1000);
			selectProductsRandomly(kidsSectionElements);
			break;

		default:
			MAINMENU = "Invalid MAINMENU";
			break;

		}

	}
	
	public void closePopup(){
		
		try{
			
			inAction.buttonClick(driver, popUp, "Click to Close PopUp");
			
		}
		catch(Exception e){
		//e.printStackTrace();	
		}
	}
	
   public void clickRegister(){
		
		try{
			
			inAction.buttonClick(driver, register, "Click register");
			
		}
		catch(Exception e){
		e.printStackTrace();	
		}
	}
	
	public void clickValidSearch(String srch){
		try{
			inAction.inputText(driver, txtSearch, srch, "Enter Valid search item");
			txtSearch.sendKeys(Keys.ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public void clicInValidSearch(String srch){
		try{
			inAction.inputText(driver, txtSearch, srch, "Enter inValid search item");
			txtSearch.sendKeys(Keys.ENTER);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void clickLogout(){
		try{
			inAction.linkClick(driver, logout, "Cick logout");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
