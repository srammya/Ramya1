package com.specomm.uniqlo.pagecomponents;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class CategoryPage {

	String delimiter = " ";

	
	String MEGAMENU;
	String title,Value;
	WebDriver driver;
	
	ReusableActions inActions = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage;
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='top']/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div")
	public WebElement noProductsAvailable;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div[1]/div/div[2]/div[1]/div")
	WebElement msgInvalidSearch;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/div/p/strong")
	WebElement itemCount;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/ul/li[*]/a/span/img")
	WebElement itemList;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/ul/li[*]/a/span/img")
	List<WebElement> itemTotalList;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/div[1]/div/div/div[1]/ol/li[*]")
	public List<WebElement> pageSelect;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/div[1]/div/div/div[1]/ol/li[*]")    
	WebElement pageitemList;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/div[1]/div/div/div[1]/ol/li[*]")    
	List<WebElement> pageitemTotalList;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div[1]/div/div/div/p/span")
	WebElement noProducts;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/div[1]/div/div/div[1]")
	WebElement navPanel;
	
	@FindBy(how = How.XPATH, using ="//*[@id='loadhere']/div[1]/div/div/div[1]/ol/li[1]")
	WebElement navPrev;
	
	@FindBy(how = How.LINK_TEXT, using ="NEXT")
	WebElement navNext;
	
	@FindBy(how = How.CSS, using ="a.next.i-next.om-ajax-filter.firepath-matching-node")
	WebElement navNextcss;
	
	public CategoryPage(WebDriver driver){ 
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	} 
	
	
	public void validateInvalidITemMessage(){
		
		try{
			if(msgInvalidSearch.getText().contains(constants.INVALID_SEARCH)){
				Reporter.log("PASS");
			}
			else{
				Reporter.log("FAIL");
			}
			
		}
		catch(Exception e){
}
}
	public void validateItem(){
		try{
	      title=itemCount.getText();
	  // given string will be split by the argument delimiter provided. 
	  String [] temp = title.split(delimiter);
	  // print substrings 
	  for(int i =0; i < temp.length ; ++i){
		  
		  Value=temp[++i];
		  System.out.println(Value);
	  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	public void displayPagination(){
		
		boolean status=false;
		try{
			if(!navPanel.isDisplayed()){
				
				System.out.println("pagination is not displayed");
				status=true;
				System.out.println(status=true);
				while(status){
					//System.out.println("beginning of while");
					Thread.sleep(2000);
				//	adidasHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					
					 if(ReusableActions.displayElement(driver,navPanel)){
						 status=false;
						//System.out.println(status=false);
						displayPagination();
					}
					 
					}
				
				
		}
				else{
					System.out.println("pagination is displayed");
						int elesize=pageitemTotalList.size();
					//	System.out.println("-------------- elesize "+pageitemTotalList.size());
//						page.click();
						pageSelect=navPanel.findElements(By.tagName("li"));
					
						for(int i=1;i<pageSelect.size();i++){
								
					//	System.out.println("size of page select"+pageSelect.size());
						
						if(elesize==12){

					//		System.out.println("12 products displayed per page "+pageitemTotalList.size());
							
							if(pageitemTotalList.size()< 12){
						//		System.out.println("last page");
							
							}
							try{
							
							//System.out.println("before next clicked");
							
																
									
							inActions.linkClick(driver, navNext, " next clicked");
								
						//	System.out.println("next clicked");
							
							Thread.sleep(3000);
							}
							catch(Exception e){
								e.printStackTrace();
							}
							
						}
							
												for(int j=(pageSelect.size()-1);i>=j;j--){
							
							try{
								//System.out.println("prev clicked"+j);
								if(j==-1){	
								//	System.out.println("Previous Ends");
									break;
								}else{
									inActions.linkClick(driver, navPrev, " prev clicked");
								}
								
							}
								
							catch(Exception e){
								e.printStackTrace();
							}							
						}
						
						}
				}
						
						
		
			
			
		}
			
			
		catch(Exception e){
			e.printStackTrace();
		}
	}

	
	
	public void productRandomSelection() throws InterruptedException {
		uniqloHomePage=new UniqloHomePage(driver);
		boolean status = false;
		ReusableActions.waitForpageToLoad(driver);
		
		try{
			if(ReusableActions.displayElement(driver,noProducts)){
				
				System.out.println("There are no products matching the selection.");
				status= true;
				while(status)
				{
					uniqloHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					productRandomSelection();
					if(!ReusableActions.displayElement(driver,noProducts))
					{
						status= false;
					}
					
				}
				}
			
				else{
			/*if(ReusableActions.displayElement(driver,driver.findElement(By.className("lazy")))){
			if(ReusableActions.displayElement(driver,itemList)){
//				ReusableActions.waitForpageToLoad(driver);
				Thread.sleep(3000);*/
				uniqloHomePage.selectProductsRandomly(itemTotalList);
			
			//}
			//}
		}
			//	}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	/*boolean status = false;
	 if(ReusableActions.displayElement(driver,driver.findElement(By.className("lazy")))){
			if(ReusableActions.displayElement(driver,driver.findElement(By.className("lazy")))){
			//System.out.println("There are no products matching the selection.");
			status= true;
			while(status)
			{
				uniqloHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				productRandomSelection();
				if(!ReusableActions.displayElement(driver,noProductsAvailable))
				{
					status= false;
				}
				
			}
			}
			
		
		
		
		else{
		
		
			if(ReusableActions.displayElement(driver,itemList)){
				ReusableActions.waitForpageToLoad(driver);
				Thread.sleep(3000);
				uniqloHomePage.selectProductsRandomly(itemTotalList);
			
			}
			
		}
		
		
		//}
		}
	catch(Exception e){
		//e.printStackTrace();
	}
		*/
	
}

	
}