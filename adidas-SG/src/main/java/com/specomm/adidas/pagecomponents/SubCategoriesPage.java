package com.specomm.adidas.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.specomm.adidas.common.utils.ReusableActions;



public class SubCategoriesPage {

	WebDriver driver;

	AdidasHomePage adidasHomePage=new AdidasHomePage(driver);
	ReusableActions inActions=new ReusableActions();

	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
									
	
	@FindBy(how = How.XPATH, using ="//html/body/div[1]/div/div[4]/div/div[2]/div[2]/ul/li[*]/div/div[*]/a/img")
	public List<WebElement> subCatCount2;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public List<WebElement> subCateElements1;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public WebElement subCateE1;
	
	/*@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public WebElement subCateE2;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public WebElement subCateE3;
			
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public WebElement subCateE4;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	public WebElement subCateE5;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public List<WebElement> subCateElements2;
		
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public List<WebElement> subCateElements3;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	 public List<WebElement> subCateElements4;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	public List<WebElement> subCateElements5;*/
	
	@FindBy(how = How.XPATH, using ="//*[@id='top']/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div")
	 public WebElement noProductsAvailable;
	
	                   
	                                
	@FindBy(how = How.XPATH, using =" html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[3]/div[1]/a[2]")
	public WebElement page1;
	
	@FindBy(how = How.CLASS_NAME, using ="sbHolder")
	public WebElement page;
	
	@FindBy(how = How.XPATH, using ="//*[starts-with(@id,'image-')]")
	public List<WebElement> pElement;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div[1]/ul")
	public WebElement optSelect;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div[1]/ul")
	public List<WebElement> pageSelect;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[3]/div[3]/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div[1]/ul/li[*]/a")
	public List<WebElement> pageSelect1;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div[2]/a[2]")
	public WebElement next;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div[2]/a[1]")
	public WebElement prev;
	
	@FindBy(how = How.CLASS_NAME, using ="prevnextbuttons")
	public WebElement prevnextbuttons;
	/*@FindBy(how = How.CLASS_NAME, using ="next i-next")
	public WebElement next;
	
	@FindBy(how = How.CLASS_NAME, using ="previous om-ajax-filter i-previous")
	public WebElement prev;
*/
	// Constructor
	public SubCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void displayPagination(){
		adidasHomePage=new AdidasHomePage(driver);
		boolean status=false;
		try{//|| noProducts.contains("There are no products matching the selection."
			//String noProducts=driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div")).getText();
			if(pageSelect.isEmpty() ){
				
				System.out.println("pagination is not displayed");
				status=true;
				System.out.println(status=true);
				while(status){
					System.out.println("beginning of while");
					Thread.sleep(2000);
					adidasHomePage.mainMenuRandomSelection();
					ReusableActions.waitForpageToLoad(driver);
					
					 if(ReusableActions.displayElement(driver,page)){
						 status=false;
						System.out.println(status=false);
						displayPagination();
					}
					 
					}
				
				
			}
				else{
					System.out.println("pagination is displayed");
						int elesize=pElement.size();
						System.out.println("-------------- elesize "+pElement.size());
						page.click();
						pageSelect=optSelect.findElements(By.tagName("li"));
						page.click();
						for(int i=1;i<pageSelect.size();i++){
								
						System.out.println("size of page select"+pageSelect.size());
						if(elesize==48){

							System.out.println("48 products displayed per page "+pElement.size());
							
							if(pElement.size()<48){
								System.out.println("last page");
							
							}
							try{
							
							System.out.println("before next clicked");
							
																
									
							inActions.linkClick(driver, next, " next clicked");
								
							System.out.println("next clicked");
							
							Thread.sleep(3000);
							}
							catch(Exception e){
								e.printStackTrace();
							}
							
						}
							
												for(int j=(pageSelect.size()-1);i>=j;j--){
							
							try{
								System.out.println("prev clicked"+j);
								if(j==-1){	
									System.out.println("Previous Ends");
									break;
								}else{
									inActions.linkClick(driver, prev, " prev clicked");
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

	
	
	/**
	 * Selects Product Randomly
	 * @throws InterruptedException
	 */
	
	
	public void productRandomSelection() throws InterruptedException {
		adidasHomePage=new AdidasHomePage(driver);
		boolean status = false;
		
		
		try{
			
		
		if(ReusableActions.displayElement(driver,driver.findElement(By.className("col-main-loader")))){
			if(ReusableActions.displayElement(driver,driver.findElement(By.className("message")))){
			System.out.println("There are no products matching the selection.");
			status= true;
			while(status)
			{
				adidasHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				productRandomSelection();
				if(!ReusableActions.displayElement(driver,noProductsAvailable))
				{
					status= false;
				}
				
			}
			}
			
		
		
		
		else{
		
		
			if(ReusableActions.displayElement(driver,subCateE1)){
				ReusableActions.waitForpageToLoad(driver);
				Thread.sleep(3000);
				adidasHomePage.selectCategoryRandomly(subCateElements1);
			
			}
			
		}
		
		
		}
		}
	catch(Exception e){
		//e.printStackTrace();
	}
		
	}	
}
