package com.specomm.adidas.pagecomponents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.specomm.adidas.common.utils.Constants;
import com.specomm.adidas.common.utils.FileWriterThread;
import com.specomm.adidas.common.utils.GeneralActions;
import com.specomm.adidas.common.utils.ReusableActions;

/***
 * Camparing the csv file values such as price and special prices from with the
 * UI Product details page.The report will be generated in csv format with below
 * values
 * ARTICLE_NO,PRICE,SPECIAL_PRICE,UI_Price,UI_Special_Price,ADD_TO_BAG,STATUS
 * ,RELEASE_DATE,URL
 */

public class PriceValidationPage {
	
	public Logger logger = Logger.getLogger(PriceValidationPage.class);
	// Declarations
	/*String csvPath = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources"
			+ File.separator + "adidas_sg" + File.separator + "price.csv";
	String outputcsv = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources"
			+ File.separator + "adidas_sg" + File.separator
			+ "priceValidation_report.csv";*/

	String FILE_HEADER = "ARTICLE_NO,PRICE,SPECIAL_PRICE,UI_PRICE,UI_SPECIAL_PRICE,STATUS,RELEASE_DATE,URL,IMAGE,ERROR";
	String separator = System.getProperty("line.separator");
	String line, SoldProduct, url, SearchKey, count, Title, Value, currency,
			specialSymbol, priceSymbol, oldPriceSymbol, statusMsg,
			productNotAvl, dat, img, imageurl, size, status, date1,dateCSV,
			newDir,value1,value2;
	String [] art;
	int ar;
	WebElement jpg;
	String src,src1,src2,src3,src4,src5,src6,com1,com2,com3,pcom,scom,rpcom;
	int plength,slength;
	String ImageDest,upper;
	String specialPrice = "";
	String price = "";
	String oldPrice = "";
	String soldOut = "";
	FileWriter writer;
	StringBuffer csvFile;
	String[] csvImg = null;
	String[] csvPrdSize=null;
	String[] uiImg=null;
	String[] uiPrdSize=null;
	
	String status_img="";
	String status_prdsize="";
	String CsvStatus,artno;
	StringBuffer uiImg_url=new StringBuffer("");
	String status_date="";
	Set<String> set1;
	Set<String> set2;
	Set<String> set3;
	Set<String> set4;
	//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	
	Date date, datecsv, datecurr,date2;
	String csv_price, csv_sprice, csv_date, csv_image, csv_size, csv_status;
	StringBuffer errmsg=new StringBuffer("");
	boolean sold_cantFound = false;
	boolean product;
	BufferedReader br = null;
	String[] comma, space, imgpipe, sizepipe = null;
	WebDriver driver;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants = new Constants();
	FileWriterThread file_Wrt;

	public static String cdir = System.getProperty("user.dir");
	public static String fsep = System.getProperty("file.separator");

	@FindBy(xpath = "html/body/div[2]/div/div[2]/div[5]/span[2]")
	public WebElement categorySearch;
		
	@FindBy(xpath = "html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/a")
	public WebElement productDetails;
	
	@FindBy(xpath = "//*[@id='thumbnails']/ul/li[*]/a/img")
	public WebElement positionImg;
	
	@FindBy(xpath = "//*[@id='thumbnails']/ul/li[*]/a/img")
	public List<WebElement> positionList;

	@FindBy(how = How.XPATH, using = "//*[@id='thumbnails']/ul/li[*]/a/img")
	public WebElement positionL;
	////*[starts-with(@id,'image-')]
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div/div[2]/div[7]/ul/li[1]/div/div[1]/div[1]/a[1]/img")
	public WebElement selectProduct1;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[4]/div/div[2]/div[2]/ul/li/div/div[4]/a/img")
	public WebElement selectProduct2;
	
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div/div[2]/div[7]/ul/li[1]/div/div[1]/div[1]/a[1]/img")
	public List<WebElement> selectProd1;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[4]/div/div[2]/div[2]/ul/li/div/div[*]/a/img")
	public List<WebElement> selectProd2;
	
	@FindBy(how = How.XPATH, using = "//*[starts-with(@id,'popup-subcription-closes-icon-')]")
	public WebElement btn_popupclose;

	@FindBy(how = How.XPATH, using = "//*[@id='search_mini_form']/div/p")
	WebElement searchOption;

	@FindBy(how = How.ID, using = "q")
	public WebElement txtsearch;
	
	@FindBy(how = How.ID, using = "goSearch")
	public WebElement clickSearch;
	
									  
	/*@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[2]/div/div/div/div[1]/h3[2]")
	public WebElement productNotAvailalbe;*/
		
	/*@FindBy(how = How.XPATH, using = "//*[@id='article-out-of-stock']/span")
	public WebElement soldout;*/
	
	@FindBy(how = How.CLASS_NAME, using = "page-head-alt")
	public WebElement productNotAvailalbe;
	
	@FindBy(how = How.ID, using = "article-out-of-stock")
	public WebElement soldout;

	@FindBy(how = How.XPATH, using = "html/body/div[1]/div/div[4]/div/div[1]/div/ul/li[3]")
	public WebElement searchResultsFor;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/div[2]/div/div/header/div/div[1]/ul/li[1]/ul/li/span")
	public WebElement hongKong;
	
	@FindBy(how = How.XPATH, using = "html/body/div[1]/a")
	public WebElement backToTOP;
									   
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/ul/li[2]/div/ul/li[*]/a")
	public WebElement sizeL;

	@FindBy(how = How.XPATH, using = "//form/div[2]/div[6]/dl/dd[2]/div[2]/div[2]/div/div/div/div[2]/div/ul/li[*]/a")
	public WebElement sizeList2;
	                                   
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/ul/li[2]/div/ul/li[*]/a")
	public WebElement sizeList1;
									  
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/ul/li[2]/div/ul/li[*]/a")
	public List<WebElement> sizeList;

	@FindBy(how = How.XPATH, using = "//form/div[2]/div[2]/div[2]/div/div/div[3]")
	public WebElement positionArrow;  
	
	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/span[2]/span")
	public WebElement articleNo;
	
	
	public PriceValidationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void closePopUp() {
		try {

			inAction.buttonClick(driver, btn_popupclose,
					"Click button : btn_popupclose");

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Click Search
	/*public void clickSearch() {
		try {

			inAction.linkClick(driver, searchOption,
					"Click Search option from home page");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
*/
	// Enter the item to be searched

	public boolean enterSearchItem(String item) {
		boolean noFound = false;
		
		try {
			
			ReusableActions.isElementVisible(txtsearch,
					"Verify if search field exists");
			
			inAction.inputText(driver, txtsearch, item, "Enter search item: " 
					+ item);
//			txtsearch.sendKeys(Keys.ENTER);
			inAction.buttonClick(driver, clickSearch,"Click search magnifier");
			ReusableActions.waitForpageToLoad(driver);
			
			value1 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/p")).getText();
		//	value2=driver.findElement(By.xpath("//*[@id='top']/body/div[1]/div/div[3]/div[1]/div[2]/div[2]/div/div/div")).getText();
		
		System.out.println(value1);	
			
			if (value1.contains("WE'RE SORRY, NO PRODUCTS WERE FOUND FOR SEARCH TERM")){//|| value2.contains("There are no products matching the selection.") ) {
				noFound = true;
			}
			
			

		}
		catch (Exception e) {
			//e.printStackTrace();
			noFound = false;

		}
		return noFound;
	}

	// Selecting the searched product

	public void selectProduct(List<WebElement> sectionElemts)
			throws InterruptedException

	{
		try {

			logger.info(sectionElemts.size());
			int randNum = ReusableActions.productSelection(sectionElemts);
			inAction.waitForElementToBeClickable(driver,sectionElemts.get(randNum));
					sectionElemts.get(randNum).click();
			
		}

		catch (Exception t) {
			//t.printStackTrace();
		}
	}

	// Screenshot Dir Creation

	public void dirCreate() throws IOException {
		
		newDir = ReusableActions.getPropFileValues("screenShot");

		}



	// Capture screenshot

	public void captureScreenshot(String name) throws IOException {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(name + ".jpeg"));

	}

	// Get the current system time

	public static String getCurrentTimeStamp() {
		SimpleDateFormat CurrentDate = new SimpleDateFormat("MM-dd-yyyy" + "_"
				+ "HH-mm-ss");
		Date now = new Date();
		String CDate = CurrentDate.format(now);
		return CDate;
	}

	
	// Check for product not available

	

		public boolean productNotAvail() throws Exception {
			System.out.println("START TIME " +getCurrentTimeStamp());
			
			By sold=By.id("article-out-of-stock");
			By pna=By.className("page-head-alt");

			
			
			int var1 = driver.findElements(By.id("article-out-of-stock")).size();
			System.out.println("var1 "+var1+""+getCurrentTimeStamp());
			int var2 = driver.findElements(By.xpath("html/body/div[1]/div/div[2]/div/div/div/div[1]/h3[2]")).size();
			System.out.println("var2 "+var2+""+getCurrentTimeStamp());
			if (var1 != 0 && var2 == 0 ) {
			   soldOut = soldout.getText();
			   productNotAvl = "";
			  } else if (var1 == 0 && var2 != 0 ) {
			   soldOut = "";
			   productNotAvl = productNotAvailalbe.getText();

			  } else {
			   soldOut = "";
			   productNotAvl = "";
			
			
			  }
			
			try {
//				System.out.println(" try START TIME " +getCurrentTimeStamp());
				if (productNotAvl
						.contains("We are sorry, but the page you are looking for cannot be found.")) {
					url = driver.getCurrentUrl();
					if (comma.length <= 8) {
						statusMsg="Failure";
						errmsg=new StringBuffer("");
						errmsg.append("PDP URL broken").append("|");
						csvFile = new StringBuffer("");

						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append("").append(",");
						csvFile.append("").append(",");
						csvFile.append(statusMsg).append(",");
						csvFile.append(dat).append(",");
						csvFile.append("").append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						sold_cantFound = true;
					} else {
						statusMsg="Success";
						pdpValidation();
						csvFile = new StringBuffer("");
						errmsg.append("");
						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append(oldPriceSymbol).append(",");
						csvFile.append(specialSymbol).append(",");
						if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
								){
							csvFile.append("Success").append(",");
						}else{
							csvFile.append("Failure").append(",");
						}
						csvFile.append(dat).append(",");
						csvFile.append(url).append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						sold_cantFound = true;

					}
				} else if (soldOut.equalsIgnoreCase("SOLD OUT")) {
					if (comma.length <= 8) {
						pdpValidation();					
						errmsg.append("SOLD OUT").append("|");
						csvFile = new StringBuffer("");

						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append("").append(",");
						csvFile.append("").append(",");
						if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
								){
							csvFile.append("Success").append(",");
						}else{
							csvFile.append("Failure").append(",");
						}
						csvFile.append(dat).append(",");
						csvFile.append("").append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						sold_cantFound = true;

					} else {
						pdpValidation();
						
						csvFile = new StringBuffer("");

						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append("").append(",");
						csvFile.append("").append(",");
						if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
								status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
								&& statusMsg.equalsIgnoreCase("success")){
							csvFile.append("Success").append(",");
						}else{
							csvFile.append("Failure").append(",");
						}
						csvFile.append(dat).append(",");
						csvFile.append("").append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						sold_cantFound = true;

					}

				} else {
					sold_cantFound = false;
				}

			}

			catch (Exception e) {
				//e.printStackTrace();
			}
			return sold_cantFound;
		}
		

	// Validating the price and special price in product details page

	public void productPriceValidation() throws InterruptedException,
			IOException {
		currency = ReusableActions.getPropFileValues("prSymbol");

		try {
			
			ReusableActions.waitForpageToLoad(driver);
			upper=SearchKey.toUpperCase();
			System.out.println(upper);
			if(ReusableActions.displayElement(driver, categorySearch)){
			
			String cs=driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[5]/span[2]")).getText();
			System.out.println(cs);
			  if(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[5]/span[2]")).getText().contains(upper)){
				  
			  captureScreenshot(newDir+fsep+SearchKey+"-cs"); } 
			  
			  else
			  {
			  logger.info("Searched Product is NOT Matching in cs"); }
			 
			

			if(ReusableActions.displayElement(driver, selectProduct1)){
				
				selectProduct(selectProd1);
			}
			}
			
			
			
			

			if (productNotAvail() == false) {

			//	ReusableActions.waitForpageToLoad(driver);
		
				// capture screenshot
				
//				System.out.println("END TIME " +getCurrentTimeStamp());
				
				logger.info("searched Key: " + upper);
				
				artno=articleNo.getText().substring(6,9);
				
				System.out.println("article no"+artno);
				if (driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/span[2]/span")).getText().toUpperCase().contains(upper)) {
					
					captureScreenshot(newDir + fsep + SearchKey	+ "-pdp");
				} else {
					
				}
				String prd_path1 = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[1]/span[";
				String prd_path2 = "]";
				
				/*try{
					if(logger.isInfoEnabled()){
					logger.info(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[1]/div/ul/li[3]")).getText());
					}
					
				}
				catch(Exception eh){
					eh.printStackTrace();
				}*/
				
				// //Taking Position list
				hongKong.click();
				hongKong.click();
				
				/*JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");*/
				
				if (ReusableActions.displayElement(driver, positionL)) {
					uiImg=new String[positionList.size()];
					
					try{
						for (int j = 0; j <= positionList.size(); j++) {
							String ppath1 = "//*[@id='thumbnails']/ul/li[";
							String ppath2 = "]/a/img";
							
						
							logger.info("positionList size :"+ positionList.size());
							if(j>=5){
								inAction.buttonClick(driver, positionArrow, "Position click");
								jpg = driver.findElement(By.xpath(ppath1
										+ (j+1) + ppath2));
								
								src = jpg.getAttribute("src") ;
								System.out.println("src ");
								logger.info("Image url: " + src);
								Thread.sleep(2000);
								
								inAction.buttonClick(driver, jpg, "Position click");
								
							    uiImg[j] =jpg.getAttribute("src").toString();
							    if(j==positionList.size()){
							    	uiImg_url.append(jpg.getAttribute("src").toString());
							    }else{
							    	uiImg_url.append(jpg.getAttribute("src").toString()).append("|");
							    }
							    
							}else{
								jpg = driver.findElement(By.xpath(ppath1
										+ (j+1) + ppath2));
								
								src = jpg.getAttribute("src");
								System.out.println("src "+src);
								logger.info("Image url: " + src);
								Thread.sleep(2000);
								
								inAction.buttonClick(driver, jpg, "Position click");
								
							    uiImg[j] =jpg.getAttribute("src").toString();
							    if(j==positionList.size()){
							    	uiImg_url.append(jpg.getAttribute("src").toString());
							    }else{
							    	uiImg_url.append(jpg.getAttribute("src").toString()).append("|");
							    }
						
							}
							
						}	
					}
				
				
						
					catch (Exception eposition){
						
					}
					
				}
				
				
				
				
				backToTOP.click();
				
				if (ReusableActions.displayElement(driver, sizeL)) {
					System.out.println(sizeList.size());
					inAction.buttonClick(driver, sizeL, "size click");
					uiPrdSize=new String[sizeList.size()];
					
					try{
					
						for (int i = 0; i <= sizeList.size();i++ ) {
							
							String spath3 = "html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[3]/ul/li[2]/div/ul/li[";
							String spath4 = "]/a";
							
							

							
							if (ReusableActions.displayElement(driver, sizeList1)) {
								logger.info("SizeList size :"+ sizeList.size());
								WebElement size = driver.findElement(By.xpath(spath3 + (i+1) + spath4));
							
								logger.info("size : " + size.getText());
								uiPrdSize[i]=size.getText().toString();
								
							}else {
								logger.info("SizeList NOT Displayed");
								
							}
							
						}
					}catch(Exception esize){
//						esize.printStackTrace();
					}
					}
				//Special & Old Price validation

					if (ReusableActions.displayElement(driver,driver.findElement(By.xpath("//*[@id='product-content']/div[1]/div[1]/span[1]")))&& ReusableActions.displayElement(driver,driver.findElement(By.xpath("//*[@id='product-content']/div[1]/div[1]/span[2]")))) {
								url = driver.getCurrentUrl();
								logger.info("special price: " + url);
								price = new String(driver.findElement(
										By.xpath(prd_path1 + 1 + prd_path2))
										.getText());   
								priceSymbol = price.substring(4);
								plength=priceSymbol.length();
								System.out.println("plength "+plength);
								if(plength>6){
								String [] tem1 = priceSymbol.split(Pattern.quote(","));
								 for( int e =0; e < tem1.length ;e++){
						   		  pcom=tem1[e]+tem1[++e];
//						   		  com1=pcom;
						   		 System.out.print("com1 "+pcom);
								 }
								}
								
								specialPrice = new String(driver.findElement(
										By.xpath(prd_path1 + 2 + prd_path2))
										.getText());
								specialSymbol = specialPrice.substring(4);
								slength=specialSymbol.length();
								System.out.println("slength "+slength);
								
								if(slength>6){
								String [] tem2 = specialSymbol.split(Pattern.quote(","));
								 for( int f =0; f < tem2.length ; f++){
						   		  scom=tem2[f]+tem2[++f];
//						   		  com2=scom;
						   		 System.out.println("com2 "+scom);
								 }
								}
								
								
								System.out.println("out");
								logger.info("Product Special price "
										+ " " + specialPrice + " " + price);
								
								//regular validation

								if (driver.findElement(By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/span[2]/span")).getText().toUpperCase().contains(upper))
										 {
									
									//both less than 
									if(slength<=6 && plength<=6){
										
										if (Double.parseDouble(csv_price) == Double
												.parseDouble(priceSymbol)
												&& Double.parseDouble(csv_sprice) == Double
														.parseDouble(specialSymbol)
												)
										
										{
											pdpValidation();
											statusMsg="success";
											
													
											
											
											csvFile = new StringBuffer("");

											csvFile.append(SearchKey).append(",");
											csvFile.append(csv_price).append(",");						
											csvFile.append(csv_sprice).append(",");
											csvFile.append(priceSymbol).append(",");
											csvFile.append(specialSymbol).append(",");
											if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
													status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
													&& statusMsg.equalsIgnoreCase("success")){
												csvFile.append("Success").append(",");
											}else{
												if(CsvStatus.equalsIgnoreCase("Failure")){
													csvFile.append("Issue").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
											}
											
											csvFile.append(dat).append(",");
											csvFile.append(url).append(",");
											csvFile.append(uiImg_url.toString()).append(",");				
											csvFile.append(errmsg.toString()).append(separator);			
											
											writer.write(csvFile.toString());
											csvFile = new StringBuffer("");
											writer.flush();
											

										}
											
										
										
									else if (Double.parseDouble(csv_sprice) == Double
												.parseDouble(specialSymbol)
												&& Double.parseDouble(csv_price) != Double
														.parseDouble(priceSymbol)) {
											
											pdpValidation();
											statusMsg = "Failure";
											errmsg.append("Price MisMatching").append("|");
											csvFile = new StringBuffer("");

											csvFile.append(SearchKey).append(",");
											csvFile.append(csv_price).append(",");						
											csvFile.append(csv_sprice).append(",");
											csvFile.append(priceSymbol).append(",");
											csvFile.append(specialSymbol).append(",");
											if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
													status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
													&& statusMsg.equalsIgnoreCase("success")){
												csvFile.append("Success").append(",");
											}else{
												csvFile.append("Failure").append(",");
											}
											
											csvFile.append(dat).append(",");
											csvFile.append(url).append(",");
											csvFile.append(uiImg_url.toString()).append(",");				
											csvFile.append(errmsg.toString()).append(separator);			
											
											writer.write(csvFile.toString());
											csvFile = new StringBuffer("");
											writer.flush();
											

										} else if (Double.parseDouble(csv_sprice) != Double
												.parseDouble(specialSymbol)
												&& Double.parseDouble(csv_price) == Double
														.parseDouble(priceSymbol)) {
											
											
											pdpValidation();
											statusMsg = "Failure";
											errmsg.append("Special Price MisMatching").append("|");
											csvFile = new StringBuffer("");

											csvFile.append(SearchKey).append(",");
											csvFile.append(csv_price).append(",");						
											csvFile.append(csv_sprice).append(",");
											csvFile.append(priceSymbol).append(",");
											csvFile.append(specialSymbol).append(",");
											if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
													status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
													&& statusMsg.equalsIgnoreCase("success")){
												csvFile.append("Success").append(",");
											}else{
												csvFile.append("Failure").append(",");
											}
											
											csvFile.append(dat).append(",");
											csvFile.append(url).append(",");
											csvFile.append(uiImg_url.toString()).append(",");				
											csvFile.append(errmsg.toString()).append(separator);			
											
											writer.write(csvFile.toString());
											csvFile = new StringBuffer("");
											writer.flush();
											
										} else if (Double.parseDouble(csv_sprice) != Double
												.parseDouble(specialSymbol)
												&& Double.parseDouble(csv_price) != Double
														.parseDouble(priceSymbol)) {
											
											
											pdpValidation();
											statusMsg = "Failure";
											errmsg.append("Price & Special Price MisMatching").append("|");
											csvFile = new StringBuffer("");

											csvFile.append(SearchKey).append(",");
											csvFile.append(csv_price).append(",");						
											csvFile.append(csv_sprice).append(",");
											csvFile.append(priceSymbol).append(",");
											csvFile.append(specialSymbol).append(",");
											if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
													status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
													&& statusMsg.equalsIgnoreCase("success")){
												csvFile.append("Success").append(",");
											}else{
												csvFile.append("Failure").append(",");
											}
											
											csvFile.append(dat).append(",");
											csvFile.append(url).append(",");
											csvFile.append(uiImg_url.toString()).append(",");				
											csvFile.append(errmsg.toString()).append(separator);			
											
											writer.write(csvFile.toString());
											csvFile = new StringBuffer("");
											writer.flush();
										}
										//new
										else{
											pdpValidation();
											statusMsg="Failure";
											
											
											csvFile = new StringBuffer("");

											csvFile.append(SearchKey).append(",");
											csvFile.append(csv_price).append(",");						
											csvFile.append(csv_sprice).append(",");
											csvFile.append(oldPriceSymbol).append(",");
											csvFile.append(specialSymbol).append(",");
											if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
													status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
													&& statusMsg.equalsIgnoreCase("success")){
												csvFile.append("Success").append(",");
											}
											else{
												if(CsvStatus.equalsIgnoreCase("Failure") && status_date.equalsIgnoreCase("Failure")){
													csvFile.append("Issue").append(",");
												}else{
												csvFile.append("Failure").append(",");
											}
											}
											csvFile.append(dat).append(",");
											csvFile.append(url).append(",");
											csvFile.append(uiImg_url.toString()).append(",");				
											csvFile.append(errmsg.toString()).append(separator);			
											
											writer.write(csvFile.toString());
											csvFile = new StringBuffer("");
											writer.flush();
											
										}
									}
											
								
									
									
										if(slength<=6 && plength>6){
											if (Double.parseDouble(csv_price) == Double
													.parseDouble(pcom)
													&& Double.parseDouble(csv_sprice) == Double
															.parseDouble(specialSymbol)
													)
											
											{
												
												pdpValidation();
												statusMsg="success";
												
														
												
												
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													if(CsvStatus.equalsIgnoreCase("Failure")){
														csvFile.append("Issue").append(",");
													}else{
														csvFile.append("Failure").append(",");
													}
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												

											}
												
											
											
											
											
											else if (Double.parseDouble(csv_sprice) == Double
													.parseDouble(specialSymbol)
													&& Double.parseDouble(csv_price) != Double
															.parseDouble(pcom)) {
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												

											} else if (Double.parseDouble(csv_sprice) != Double
													.parseDouble(specialSymbol)
													&& Double.parseDouble(csv_price) == Double
															.parseDouble(pcom)) {
												
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Special Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												
											} else if (Double.parseDouble(csv_sprice) != Double
													.parseDouble(specialSymbol)
													&& Double.parseDouble(csv_price) != Double
															.parseDouble(pcom)) {
												
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Price & Special Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
											}
											//new
											else{
												pdpValidation();
												statusMsg="Failure";
												
												
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(oldPriceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}
												else{
													if(CsvStatus.equalsIgnoreCase("Failure") && status_date.equalsIgnoreCase("Failure")){
														csvFile.append("Issue").append(",");
													}else{
													csvFile.append("Failure").append(",");
												}
												}
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												
											}
											
										}
										
									if(slength>6 && plength>6){
										
											if (Double.parseDouble(csv_price) == Double
													.parseDouble(pcom)
													&& Double.parseDouble(csv_sprice) == Double
															.parseDouble(scom)
													)
											
											{

												pdpValidation();
												statusMsg="success";
												
														
												
												
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													if(CsvStatus.equalsIgnoreCase("Failure")){
														csvFile.append("Issue").append(",");
													}else{
														csvFile.append("Failure").append(",");
													}
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												

											}
												
											else if (Double.parseDouble(csv_sprice) == Double
													.parseDouble(scom)
													&& Double.parseDouble(csv_price) != Double
															.parseDouble(pcom)) {
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												

											} else if (Double.parseDouble(csv_sprice) != Double
													.parseDouble(scom)
													&& Double.parseDouble(csv_price) == Double
															.parseDouble(pcom)) {
												
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Special Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												
											} else if (Double.parseDouble(csv_sprice) != Double
													.parseDouble(scom)
													&& Double.parseDouble(csv_price) != Double
															.parseDouble(pcom)) {
												
												
												pdpValidation();
												statusMsg = "Failure";
												errmsg.append("Price & Special Price MisMatching").append("|");
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(priceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(statusMsg.equalsIgnoreCase("success")&&status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}else{
													csvFile.append("Failure").append(",");
												}
												
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
											}
											//new
											else{
												pdpValidation();
												statusMsg="Failure";
												
												
												csvFile = new StringBuffer("");

												csvFile.append(SearchKey).append(",");
												csvFile.append(csv_price).append(",");						
												csvFile.append(csv_sprice).append(",");
												csvFile.append(oldPriceSymbol).append(",");
												csvFile.append(specialSymbol).append(",");
												if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
														status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
														&& statusMsg.equalsIgnoreCase("success")){
													csvFile.append("Success").append(",");
												}
												else{
													if(CsvStatus.equalsIgnoreCase("Failure") && status_date.equalsIgnoreCase("Failure")){
														csvFile.append("Issue").append(",");
													}else{
													csvFile.append("Failure").append(",");
												}
												}
												csvFile.append(dat).append(",");
												csvFile.append(url).append(",");
												csvFile.append(uiImg_url.toString()).append(",");				
												csvFile.append(errmsg.toString()).append(separator);			
												
												writer.write(csvFile.toString());
												csvFile = new StringBuffer("");
												writer.flush();
												
											}
											
											
											
										}
									
									
									}
								}
					}
								
								
			}
								
		
			
		catch (Exception e) {
				
				//Regular Price validation
			
			if (ReusableActions.displayElement(driver,
					driver.findElement(By.className("product-price")))) {

				url = driver.getCurrentUrl();
				logger.info("reguar-price url: " + url);
				oldPrice = new String(
						driver.findElement(
								By.xpath("//*[@id='product-content']/div[1]/div[1]/span"))
								.getText());
				oldPriceSymbol = oldPrice.substring(4);
				System.out.println("length **"+oldPriceSymbol.length()+ oldPriceSymbol);
				if(oldPriceSymbol.length()>6){
				String [] tem3 = oldPriceSymbol.split(Pattern.quote(","));
				 for( int i =0; i < tem3.length ; i++){
					  System.out.println("com3 "+tem3[i]+tem3[++i]);
					 rpcom=tem3[i]+tem3[++i];

					 if (driver
								.findElement(
										By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/span[2]/span"))
								.getText().contains(upper)
								) {
							
							
						
							if (Double.parseDouble(csv_price) == Double
									.parseDouble(rpcom)) {
								
								
								pdpValidation();
								
								statusMsg="Success";
								
								csvFile = new StringBuffer("");

								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append(oldPriceSymbol).append(",");
								csvFile.append("").append(",");
								if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
										status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
										&& statusMsg.equalsIgnoreCase("success")){
									csvFile.append("Success").append(",");
								}else{
									if(CsvStatus.equalsIgnoreCase("Failure")){
										csvFile.append("Issue").append(",");
									}else{
										csvFile.append("Failure").append(",");
									}
									
								}
								
								csvFile.append(dat).append(",");
								csvFile.append(url).append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();
								


							} 
							
							
							
							
							else if (Double.parseDouble(csv_price)!= Double
									.parseDouble(rpcom))  {
								
								pdpValidation();
								statusMsg="Failure";
								errmsg.append("Price Mismatching").append("|");
								
								csvFile = new StringBuffer("");

								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append(oldPriceSymbol).append(",");
								csvFile.append(specialSymbol).append(",");
								if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
										status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
										&& statusMsg.equalsIgnoreCase("success")){
									csvFile.append("Success").append(",");
								}
								else{
									if(CsvStatus.equalsIgnoreCase("Failure") && status_date.equalsIgnoreCase("Failure")){
										csvFile.append("Issue").append(",");
									}else{
									csvFile.append("Failure").append(",");
								}
								}
								csvFile.append(dat).append(",");
								csvFile.append(url).append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();
								

							}
						
							
							
							

						}
					 ////
				 }
				}
				
				System.out.println("out");
				logger.info("Old Price of the Product :"
						+ oldPriceSymbol);
				if (driver
						.findElement(
								By.xpath("html/body/div[2]/div[2]/div[2]/div[2]/div[2]/div/span[2]/span"))
						.getText().contains(upper)
						) {
					
					
				
					if (Double.parseDouble(csv_price) == Double
							.parseDouble(oldPriceSymbol)) {
						
						pdpValidation();
						
						
						statusMsg="Success";
						
						csvFile = new StringBuffer("");

						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append(oldPriceSymbol).append(",");
						csvFile.append("").append(",");
						if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
								status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
								&& statusMsg.equalsIgnoreCase("success")){
							csvFile.append("Success").append(",");
						}else{
							if(CsvStatus.equalsIgnoreCase("Failure")){
								csvFile.append("Issue").append(",");
							}else{
								csvFile.append("Failure").append(",");
							}
							
						}
						
						csvFile.append(dat).append(",");
						csvFile.append(url).append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						


					} 
					
					
					
					
					else if (Double.parseDouble(csv_price)!= Double
							.parseDouble(oldPriceSymbol))  {
						
						pdpValidation();
						statusMsg="Failure";
						errmsg.append("Price Mismatching").append("|");
						
						csvFile = new StringBuffer("");

						csvFile.append(SearchKey).append(",");
						csvFile.append(csv_price).append(",");						
						csvFile.append(csv_sprice).append(",");
						csvFile.append(oldPriceSymbol).append(",");
						csvFile.append("").append(",");
						if(status_date.equalsIgnoreCase("success") && status_img.equalsIgnoreCase("Success") &&
								status_prdsize.equalsIgnoreCase("success") && CsvStatus.equalsIgnoreCase("success")
								&& statusMsg.equalsIgnoreCase("success")){
							csvFile.append("Success").append(",");
						}
						else{
							if(CsvStatus.equalsIgnoreCase("Failure") && status_date.equalsIgnoreCase("Failure")){
								csvFile.append("Issue").append(",");
							}else{
							csvFile.append("Failure").append(",");
						}
						}
						csvFile.append(dat).append(",");
						csvFile.append(url).append(",");
						csvFile.append(uiImg_url.toString()).append(",");				
						csvFile.append(errmsg.toString()).append(separator);			
						
						writer.write(csvFile.toString());
						csvFile = new StringBuffer("");
						writer.flush();
						

					}
				
					
					

				}
			}
				
		}
				
			}
		

	

		// Reading the values from CSV file

	public void csvFileReading() throws IOException {

		
		 String csvPath =ReusableActions.getPropCsvFilePath("inputCsv");
		 String outputcsv=ReusableActions.getPropFileValues("outputCsv");
		 

		try {

			br = new BufferedReader(new FileReader(csvPath));

			csvFile = new StringBuffer();
			csvFile.append(FILE_HEADER.toString());
			csvFile.append(separator);
			csvFile.append(separator);

			writer = new FileWriter(outputcsv);
			writer.write(csvFile.toString());
			writer.flush();
			int linecount = 0;
			while ((line = br.readLine()) != null) {
				logger.info("line" + line.toString());
			
				linecount++;
				if (linecount > 1) {
					try {
						comma = line.split(",");
						SearchKey = comma[0].toString().replace("\"", " ")
								.trim();
						csv_price = comma[1].toString().replace("\"", " ")
								.trim();
						csv_sprice = comma[2].toString().replace("\"", " ")
								.trim();
						csv_date = comma[3].toString().replace("\"", " ")
								.trim();
						
						csv_image = comma[5].toString().replace("\"", " ")
								.trim();
						csv_size = comma[6].toString().replace("\"", " ")
								.trim();
						csv_status = comma[7].toString().replace("\"", " ")
								.trim();

						imgpipe = csv_image.split(Pattern.quote("|"));
						
						csvImg=new String[imgpipe.length];
						
						for (int k = 0; k < imgpipe.length; k++) {
//							
							csvImg[k] = "http://demandware.edgesuite.net/sits_pod35/dw/image/v2/ABAD_PRD/on/demandware.static/-/Sites-calvinklein-hk-master/default/images/"+ imgpipe[k].toString();
							
							System.out.println("****"+csvImg[k]);
							logger.info("Image : "+csvImg[k]);
						}

					
						sizepipe = csv_size.split(Pattern.quote("|"));
						
							csvPrdSize=new String[sizepipe.length];
							for (int L = 0; L < sizepipe.length; L++) {
								csvPrdSize[L] = sizepipe[L].toString();
								logger.info("Image : "+csvPrdSize[L]);
						}
										
						
							date = new Date();
							logger.info("DATE "+date);
							
							date1 = dateFormat.format(date);
							
							logger.info("Curr Date format :"+date1);
							datecurr=dateFormat.parse(date1);
							
							datecsv=dateFormat.parse(csv_date);
							
							

					} catch (Exception ea) {

					}

					try {
						
						if (!csv_date.isEmpty()) {

							dat = csv_date;

						} else {
							dat = "";
						}
						if (!csv_image.isEmpty()) {

							img = csv_image;

						} else {
							img = "";
						}

						if (!csv_size.isEmpty()) {

							size = csv_size;

						} else {
							size = "";
						}
						if (!csv_status.isEmpty()) {

							status = csv_status;

						} else {
							status = "";
						}
					} catch (Exception e) {
						dat = "";
						img = "";
						size = "";
						status = "";
					}


					try {

						if (enterSearchItem(SearchKey) == false) {

							//ReusableActions.waitForpageToLoad(driver);
							productPriceValidation();
						}

						else {
							url=driver.getCurrentUrl();
							if ((comma.length <= 8) && datecsv.after(datecurr)) {
								statusMsg="Success";
								errmsg=new StringBuffer("");
								errmsg.append("Product Launch Date is in Future").append("|");
								csvFile = new StringBuffer("");
								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append("").append(",");
								csvFile.append("").append(",");
								csvFile.append(statusMsg).append(",");
								csvFile.append(dat).append(",");
								csvFile.append("").append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();

								
							} else if (comma.length <= 8 && datecsv.before(datecurr)&&csv_status.equalsIgnoreCase("Disabled"))
									{
								
								statusMsg="Success";
								errmsg=new StringBuffer("");
								errmsg.append("Product Launch Date is in Past").append("|");
								csvFile = new StringBuffer("");

								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append("").append(",");
								csvFile.append("").append(",");
								csvFile.append(statusMsg).append(",");
								csvFile.append(dat).append(",");
								csvFile.append("").append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();

								
							} else if(comma.length <= 8 && datecsv.before(datecurr)&&csv_status.equalsIgnoreCase("Enabled")) {
								statusMsg="Failure";
								errmsg=new StringBuffer("");
								errmsg.append("Product Launch Date is in Past").append("|");
								errmsg.append("Enabled").append("|");
								csvFile = new StringBuffer("");
								
								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append("").append(",");
								csvFile.append("").append(",");
								csvFile.append(statusMsg).append(",");
								csvFile.append(dat).append(",");
								csvFile.append(url).append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();
								
								
							}
							else if(comma.length <= 8 && datecsv.equals(datecurr)&&csv_status.equalsIgnoreCase("Enabled")){
								statusMsg="Failure";
								errmsg=new StringBuffer("");
								errmsg.append("Product Launch Date is in Present").append("|");
								errmsg.append("Enabled").append("|");
								csvFile = new StringBuffer("");
								
								csvFile.append(SearchKey).append(",");
								csvFile.append(csv_price).append(",");						
								csvFile.append(csv_sprice).append(",");
								csvFile.append("").append(",");
								csvFile.append("").append(",");
								csvFile.append(statusMsg).append(",");
								csvFile.append(dat).append(",");
								csvFile.append(url).append(",");
								csvFile.append(uiImg_url.toString()).append(",");				
								csvFile.append(errmsg.toString()).append(separator);			
								writer.write(csvFile.toString());
								csvFile = new StringBuffer("");
								writer.flush();
							}
							
							
						}
					} catch (Exception e) {
						//e.printStackTrace();
					}

				}

			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	public void pdpValidation(){
		try{
		errmsg=new StringBuffer("");
		

		status_date="";
		if(datecsv.before(datecurr)){
			status_date="Success";
			errmsg.append(" ").append("|");
		}
		else if(datecsv.after(datecurr)){
			status_date="Failure";
			errmsg.append("Product Launch date is in future").append("|");
		}
		else{
			status_date="Failure";
		}
		
		// Image Validation
		status_img ="";
		
	
		

			set1 = new HashSet<String>();
			for(int g=0;g<uiImg.length;g++){
				
				if(uiImg[g]!=null){
					
					
						
				set1.add(uiImg[g].toString());
				
				
				
				}
				
				 String [] temp1 = src.split(Pattern.quote("?"));
				 for(int l =0;l < temp1.length ; l++){
		   		  
		   		  src1=temp1[l];
				}
			
			}

			set2 = new HashSet<String>();
			
			for(int g=0;g<csvImg.length;g++){
			String [] tem4 = uiImg[g].split(Pattern.quote("default/"));
			 for( int i =0; i < tem4.length ; i++){
	   		  src2=tem4[i];
			 }
			
				
				 String [] temp2 = src2.split(Pattern.quote("/images"));
				 for(int k =0; k < temp2.length ; k--){
		   		  
		   		  src4=temp2[0];
				 }
				 
				 String [] temp3 = csvImg[g].split(Pattern.quote("images"));
				 for(int j =0; j < temp3.length ; j++){
					src3=temp3[0];
					src5=temp3[1];
				 }
			
			 
			 

				/*System.out.println("src1 "+src1 );
				System.out.println("src3 "+src3 );
				System.out.println("src4 "+src4);
				System.out.println("src5 "+src5);*/
				set2.add(src3+src4+"/images"+src5+"?"+src1);
				System.out.println("csv**&&** "+src3+src4+"/images"+src5+"?"+src1);
		}
	
		
			
		
		
		
			 
				
			if(set2.equals(set1)){
				status_img = "Success";
			}
			else{
				set1.removeAll(set2);
				errmsg.append("Image URL broken").append("|");
				status_img = "Failure";
				for (String diffElement : set2) {
					System.out.println("Diff Element"+diffElement.toString());
					logger.info("Diff Element"+diffElement.toString());
					status_img = "Failure";
					
				}
				
				
		
		}
		//Prod Image size validation
		status_prdsize="";
			
			
				set3 = new HashSet<String>();
				for(int p=0;p<csvPrdSize.length;p++){
					set3.add(csvPrdSize[p].toString());
				}
				

				set4 = new HashSet<String>();
				for(int s=0;s<uiPrdSize.length;s++){
					set4.add(uiPrdSize[s].toString());
				}
				
				if(set3.equals(set4)){
					status_prdsize = "Success";
				}
				else{
				set4.removeAll(set3);
				status_prdsize = "Failure";
				errmsg.append("Product Size Mismatching").append("|");
				for (String diffSize : set4) {
					logger.info("Diff Size"+diffSize.toString());
	
					
				}
				}
				
			
		
			CsvStatus="";
		
		if(csv_status.equalsIgnoreCase("Enabled")){
			CsvStatus="Success";
		}
		else{
			CsvStatus="Failure";
			errmsg.append("Disabled").append("|");
		}
		
		
	}		
	catch(Exception e){
		
	}

	}

	
}
