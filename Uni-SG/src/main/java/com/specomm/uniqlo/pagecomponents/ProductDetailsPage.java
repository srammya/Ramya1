package com.specomm.uniqlo.pagecomponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.specomm.uniqlo.common.utils.Constants;
import com.specomm.uniqlo.common.utils.GeneralActions;
import com.specomm.uniqlo.common.utils.ReusableActions;

public class ProductDetailsPage {

	WebDriver driver;
	String Value,Value1,Value2,Value3,pCount;
	int total,count,tpCount;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
	CategoryPage categoryPage=new CategoryPage(driver);
	ShoppingBucketPage shoppingBucketPage=new ShoppingBucketPage(driver);
	
	@FindBy(xpath = "//*[@id='listChipColor']/li[*]/a")
	List<WebElement> colorList;

	@FindBy(xpath = "//*[@id='listChipSize']/li[2]/a")
	List<WebElement> sizeList;

	@FindBy(xpath = "//*[@id='qty']/option")
	List<WebElement> quanList;

	@FindBy(xpath = "//*[@id='intoCartOn']/button")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@id='msgAddedCart']/p[@class='msg']")
	WebElement statusMsg;

	@FindBy(xpath = "//*[@id='navHeader']/li[10]/a")
	WebElement shoppingBag;
	
	/*@FindBy(xpath = "//li[@class='lightnav shop_bag']/a")
	WebElement shoppingBag;
	*/
	@FindBy(className = "no-options-avail-overlay")
	WebElement notAvailable;
	
	@FindBy(xpath = "//div[@id='msgErrorSelectSize']")
	WebElement errorSize;	
	
	@FindBy(xpath = "html/body/div[1]/div/header/div/div/a/h1/img")
	public WebElement imgUniqlo;
	
	@FindBy(how = How.CSS, using ="#lightboxSignupClose")
	WebElement popUp;
	
	public ProductDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	
	/*public void verifyProuctSearch(){
		String search=searchProduct.getText();
		String prodctCount=productCounts.getText();
		
		  String [] temp = prodctCount.split(Pattern.quote("("));
	    	
    	  for(int i =0; i < temp.length ; ++i){
    		  
    		   Value=temp[i];
    	  }
    	  String [] temp1 = Value.split(Pattern.quote(")"));
    	  for(int i =0; i < temp1.length ; ++i){
    		  
    		  
    		  pCount=temp1[i];
    		 
    	  }
    	  System.out.println("pCount: "+pCount);
    	  System.out.println(productCounts.getText());
    	  Assert.assertEquals(search,"Shirts");
    	  Assert.assertEquals(productCounts.getText(),"("+pCount+")");
	}
	*/
	/*public void searchCount(){
		
			adidasHomePage=new AdidasHomePage(driver);
			boolean status=false;
			String delimiter1 = "shirts";
			String delimiter2 ="p";
			String delimiter3="\\(";
			String search=searchProduct.getText();
			System.out.println(search);
			
			try{
				
				 String [] temp = search.split(delimiter1);
		    	  
		    	  for(int i =0; i < temp.length ; ++i){
		    		  
		    		  Value1=temp[++i];
		    		  System.out.println(Value1);
		    	  }
		    	  
		    	  String [] temp1 = Value1.split(delimiter2);
		    	  
		    	  for(int i =0; i < temp.length ; i++){
		    		  
		    		  Value2=temp1[i++];
		    		
		    		  System.out.println(Value2);
		    	  }
		    	  
		    	  String [] temp2 = Value2.split(delimiter3);
		    	  
		    	  for(int i =0; i < temp.length ; ++i){
		    		  
		    		  Value3=temp2[++i];
		    		  System.out.println(Value3);
		    		 
		    		  
		    	  }
				
				if(pageSelect.isEmpty()){
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
							searchCount();
						}
						 
						}
					
					}
					else{
						System.out.println("pagination is displayed");
							int elesize=pElement.size();
							System.out.println("-------------- elesize "+pElement.size());
							page.click();
							pageSelect=optSelect.findElements(By.tagName("li"));
							total=pageSelect.size();
							count=(total-1)*48;
							System.out.println("product count"+count);
							for(int i=0;i<pageSelect.size();i++){
													
							
							if(elesize==48){

								
								
								System.out.println("Products displayed per page are "+pElement.size());
								
								if(pElement.size()<48){
									System.out.println("last page");
									tpCount=count+pElement.size();
									System.out.println("Searched product count is"+tpCount);
									String Value4=Value3.replaceAll("\\s+","");
										if(Value4.equalsIgnoreCase(String.valueOf(tpCount))){
											System.out.println("Value4 and tpCount are equal");
											Assert.assertEquals(Value4,String.valueOf(tpCount));
										}		
									break;
								}
								next.click();
								System.out.println("next clicked");
								
								Thread.sleep(2000);
								
							}
							
							
							
							}
							
							
					}
				
				
				
				
			}
				
				
			catch(Exception e){
				
			}
		}*/
		
	
	
	
	
	/*public void selectProductToCart() throws InterruptedException
	{
		try{
		//	boolean cartbtn=false;
		adidasHomePage = new AdidasHomePage(driver);
		subCategoriesPage = new SubCategoriesPage(driver);
		ReusableActions.waitForpageToLoad(driver);
//		Thread.sleep(7000);
		inAction.buttonClick(driver, imageSlider, "Click Image Slider");
		if(ReusableActions.displayElement(driver,Available))
		
		{
			try{
				System.out.println("colorL");
				if(ReusableActions.displayElement(driver, colorL))		
				{
					System.out.println("Printing Colour Size : "+colorList.size());
					adidasHomePage.selectCategoryRandomly(colorList);
					if(ReusableActions.displayElement(driver, sold_out)){
						adidasHomePage.selectCategoryRandomly(colorList);
					}
					
					
				}else{
					Reporter.log("No Color for this Product");
			    }
			}catch(Exception e){
				System.out.println("Color List in err:"+e.getStackTrace());
			}
			
			
	
			try{
				System.out.println("sizeL");
				if(ReusableActions.displayElement(driver, sizeL))		
				{
					
					inAction.buttonClick(driver, sizeL, "click size list");
					adidasHomePage.selectCategoryRandomly(sizeList);
					System.out.println("Printing size size : "+sizeList.size());
					try{
						Alert alert=driver.switchTo().alert();
						alert.accept();
					
						
					}
					catch(Exception se){
						
					
					}
				}else{
					Reporter.log("No Size for this Product");
			    }
			}catch(Exception e){
				System.out.println("Size L in Error :"+e.getStackTrace());
			}
			
			
			Thread.sleep(1000);
			try{
				System.out.println("quanL");
				if(ReusableActions.displayElement(driver, quanL))		
				{
					ReusableActions.dropdownSelectByText(driver, quanList, "1");
					try{
						Alert alert=driver.switchTo().alert();
						alert.accept();
					
						
					}
					catch(Exception qe){
						
					}
				}else{
					Reporter.log("No quantity for this Product");
			    }
			}catch(Exception e){
				System.out.println("Qun list in err:"+e.getStackTrace());
			}
			
			
			try{
				System.out.println("addToCartBtn");
				if(ReusableActions.displayElement(driver, addToCartBtn)){
					inAction.buttonClick(driver,addToCartBtn,"Click Add to cart button");
					Thread.sleep(5000);
					try{
						Alert alert=driver.switchTo().alert();
						alert.accept();					
					}
					catch(Exception e){
						
					
					}
				}
			}catch(Exception e){
				System.out.println("addToCartBtn in err:"+e.getStackTrace());
			}

		}
		else if(driver.findElement(By.xpath("html/body/h1")).getText().contains("Forbidden")){
			 ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
			 adidasHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				subCategoriesPage.productRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				Thread.sleep(5000);
				if(ReusableActions.displayElement(driver,Available))
					
				{
					
					if(ReusableActions.displayElement(driver, colorL))		
					{
						
						System.out.println("Printing Colour Size : "+colorList.size());
						adidasHomePage.selectCategoryRandomly(colorList);
						if(ReusableActions.displayElement(driver, sold_out)){
							adidasHomePage.selectCategoryRandomly(colorList);
						}
						
						
								
					}else{
						Reporter.log("No Color for this Product");
				    }
					
					
					if(ReusableActions.displayElement(driver, sizeL))		
					{
						
						inAction.buttonClick(driver, sizeL, "click size list");
						
						adidasHomePage.selectCategoryRandomly(sizeList);
						
						System.out.println("Printing size size : "+sizeList.size());
						try{
							Alert alert=driver.switchTo().alert();
							alert.accept();
						
						 }
					catch(Exception se){
						
						
						}
					
						
					}else{
						Reporter.log("No Size for this Product");  
						}
		
					
					
					
					
					if(ReusableActions.displayElement(driver, quanL))		
					{
						
						ReusableActions.dropdownSelectByText(driver, quanList, "1");
						try{
							Alert alert=driver.switchTo().alert();
							alert.accept();
						
							
						}
						catch(Exception qe){
							
						
						}
						
					}else{
						Reporter.log("No Size for this Product");
				    }
					
					
					if(ReusableActions.displayElement(driver, addToCartBtn)){
						
						Thread.sleep(4000);
					inAction.buttonClick(driver,addToCartBtn,"Click Add to cart button");
					try{
					Alert alert=driver.switchTo().alert();
					alert.accept();
					
						
					}
					
					catch(Exception e){
						
					}
				
			}
		
		}
		}
			else{
				System.out.println("Product is Out of Stock/Not available");
				
					
				adidasHomePage.mainMenuRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				subCategoriesPage.productRandomSelection();
				ReusableActions.waitForpageToLoad(driver);
				Thread.sleep(5000);
				if(ReusableActions.displayElement(driver,Available))
					
				{
					
					if(ReusableActions.displayElement(driver, colorL))		
					{
						
						System.out.println("Printing Colour Size : "+colorList.size());
						adidasHomePage.selectCategoryRandomly(colorList);
						if(ReusableActions.displayElement(driver, sold_out)){
							adidasHomePage.selectCategoryRandomly(colorList);
						}
						
						
								
					}else{
						Reporter.log("No Color for this Product");
				    }
					
					
					if(ReusableActions.displayElement(driver, sizeL))		
					{
						
						inAction.buttonClick(driver, sizeL, "click size list");
						
						adidasHomePage.selectCategoryRandomly(sizeList);
						
						System.out.println("Printing size size : "+sizeList.size());
						try{
							Alert alert=driver.switchTo().alert();
							alert.accept();
						
						 }
					catch(Exception se){
						
						
						}
					
						
					}else{
						Reporter.log("No Size for this Product");  
						}
		
					
					
					
					
					if(ReusableActions.displayElement(driver, quanL))		
					{
						
						ReusableActions.dropdownSelectByText(driver, quanList, "1");
						try{
							Alert alert=driver.switchTo().alert();
							alert.accept();
						
							
						}
						catch(Exception qe){
							
						
						}
						
					}else{
						Reporter.log("No Size for this Product");
				    }
					
					
					if(ReusableActions.displayElement(driver, addToCartBtn)){
						
						
					inAction.buttonClick(driver,addToCartBtn,"Click Add to cart button");
					Thread.sleep(4000);
					try{
					Alert alert=driver.switchTo().alert();
					alert.accept();
					
						
					}
					
					catch(Exception e){
						
					}
				
			}
		
		}
		
			}
		}
		catch(Exception e){
			
			//e.printStackTrace();
		}
		
		}
		
		
	*/
		
		
	
	public void selectProductToCart() throws InterruptedException, IOException
	{
		UniqloHomePage uniqloHomePage=new UniqloHomePage(driver);
		CategoryPage categoryPage=new CategoryPage(driver);
		ReusableActions.waitForpageToLoad(driver);
		
		if(ReusableActions.displayElement(driver,notAvailable))

		{
			System.out.println("Product is NOT Available");
			
			uniqloHomePage.mainMenuRandomSelection();
			ReusableActions.waitForpageToLoad(driver);
			categoryPage.productRandomSelection();
			
			if(!colorList.isEmpty()){
				uniqloHomePage.selectProductsRandomly(colorList);
			}else{
				Reporter.log("No Color for this Product");
		    }
			ReusableActions.waitForpageToLoad(driver);
			Thread.sleep(10000);		
			uniqloHomePage.selectProductsRandomly(sizeList);
			ReusableActions.waitForpageToLoad(driver);
			ReusableActions.dropdownSelectByText(driver, quanList, "1");
			ReusableActions.waitForElementToBeClickable(driver, addToCartBtn);
			ReusableActions.click(addToCartBtn);
			ReusableActions.waitForpageToLoad(driver);
			if(!errorSize.getAttribute("style").equals("display: none;")){
				uniqloHomePage.selectProductsRandomly(colorList);
				uniqloHomePage.selectProductsRandomly(sizeList);
				ReusableActions.click(addToCartBtn);
			}else{
				Reporter.log("Size is present ");
			}
			Thread.sleep(4000);
			ReusableActions.waitForpageToLoad(driver);
			
			Thread.sleep(2000);
			ReusableActions.click(shoppingBag);
			
		}else 
		{
			
		if(!colorList.isEmpty()){
			uniqloHomePage.selectProductsRandomly(colorList);
		}else{
			Reporter.log("No Color for this Product");
	    }
		ReusableActions.waitForpageToLoad(driver);
		Thread.sleep(10000);		
		uniqloHomePage.selectProductsRandomly(sizeList);
		ReusableActions.waitForpageToLoad(driver);
		ReusableActions.dropdownSelectByText(driver, quanList, "1");
		ReusableActions.waitForElementToBeClickable(driver, addToCartBtn);
		ReusableActions.click(addToCartBtn);
		ReusableActions.waitForpageToLoad(driver);
		if(!errorSize.getAttribute("style").equals("display: none;")){
			uniqloHomePage.selectProductsRandomly(colorList);
			uniqloHomePage.selectProductsRandomly(sizeList);
			ReusableActions.click(addToCartBtn);
		}else{
			Reporter.log("Size is present ");
		}
		Thread.sleep(4000);
		ReusableActions.waitForpageToLoad(driver);
		
		Thread.sleep(2000);
		ReusableActions.click(shoppingBag);
		}
    }
	
	
		
 
	
	/*public void clickShoppingBag() throws InterruptedException{
		inAction.buttonClick(driver, cartbag, "click shopping bag");
		
		try{
			
			inAction.buttonClick(driver, cartbagdrop, "click drop shopping bag");
			
		}
		catch(Exception e){
//			inAction.buttonClick(driver, cartbagdrop, "click drop shopping bag");
		}
		
	}
	*/



}
