package com.specomm.adidas.pagecomponents;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

public class ProductDetailsPage {

	WebDriver driver;
	String Value,Value1,Value2,Value3,pCount;
	int total,count,tpCount;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	AdidasHomePage adidasHomePage;
	SubCategoriesPage subCategoriesPage;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='article-out-of-stock']/span")
	public WebElement sold_out;
	
	@FindBy(how = How.XPATH, using ="//*[@id='thumb-slider']/li[1]/a/img")
	public WebElement imageSlider;
	
	@FindBy(how = How.XPATH, using ="//*[@id='value_sizesearchvalue']/div[2]")
	public WebElement Available;
		
	@FindBy(how = How.XPATH, using ="//div[@id='value_sizesearchvalue']/div[2]/div/div/a")
	 public WebElement click_sizelist;
	
	@FindBy(how = How.XPATH, using = "//*[@id='value_articlecolor']/ul/li[*]/a")
	 public List<WebElement> colorList;
	
	@FindBy(how = How.XPATH, using = "//*[@id='value_articlecolor']/ul/li[1]/a")
	 public WebElement colorL;

	@FindBy(how = How.XPATH, using ="//*[@id='value_sizesearchvalue']/div[2]/div/div/a")
	 public WebElement sizeL;
	
	@FindBy(how = How.XPATH, using ="//*[@id='value_sizesearchvalue']/div[2]/div/div/div/div[2]/div/ul/li[*]")
	 public List<WebElement> sizeList;

	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'sbSelector_')]")
	 public WebElement quanL;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'sbSelector_')]")
	 public List<WebElement> quanList;

	@FindBy(how = How.XPATH, using = "id('product_addtocart_form')/div[1]/div[9]/div/button")
	 public WebElement addToCartBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='functionUI']/li[1]/a")
	public WebElement cartbag;
	
	@FindBy(how = How.XPATH, using = "//*[@id='cart_sidebar_header']/a[2]/span")
	public WebElement cartbagdrop;
	
	@FindBy(how = How.CLASS_NAME, using = "checkout-links")
	public WebElement shoppingcheck;

	@FindBy(xpath = "//*[@id='cartCount']")
	public WebElement cart;
	
	@FindBy(xpath = "//*[@id='label_articlecolor']/div/label")
	WebElement colorLabel;
	
	//search product
	
	@FindBy(xpath ="//*[@id='top']/body/div[1]/div/div[3]/div[1]/div[1]/ul/li[3]/a")
	WebElement searchProduct;
	
	@FindBy(xpath ="//*[@id='top']/body/div[1]/div/div[3]/div[1]/ul/li/h1")
	WebElement productCounts;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[4]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/a[2]")
	public WebElement page;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[4]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/ul")
	public WebElement optSelect;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[4]/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/ul")
	public List<WebElement> pageSelect;
	
	@FindBy(how = How.XPATH, using ="html/body/div[1]/div/div[4]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/a[2]")
	public WebElement next;
	
	@FindBy(how = How.XPATH, using ="//html/body/div[1]/div/div[4]/div/div[2]/div[2]/ul/li[*]")
	public List<WebElement> pElement;
	
	
	
	
	public ProductDetailsPage(WebDriver driver){ 
	    this.driver = driver; 
	    PageFactory.initElements(driver, this);
	}
	
	
	public void verifyProuctSearch(){
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
	
	public void searchCount(){
		
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
		}
		
	
	public void selectProductToCart() throws InterruptedException
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
		
		
	
		
		
		
 
	
	public void clickShoppingBag() throws InterruptedException{
		inAction.buttonClick(driver, cartbag, "click shopping bag");
		
		try{
			
			inAction.buttonClick(driver, cartbagdrop, "click drop shopping bag");
			
		}
		catch(Exception e){
//			inAction.buttonClick(driver, cartbagdrop, "click drop shopping bag");
		}
		
	}
	
}
