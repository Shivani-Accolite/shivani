package com.pagelibrary.com.prudential;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;




import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Exceldata.Excel_class;
import atu.testrecorder.ATUTestRecorder;
import base.Base;
import utility.Library;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class Repository extends Base {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static SoftAssert asert = new SoftAssert();

	
	public static String driverpath = "C:\\Users\\shivani\\eclipse-workspace\\prudential\\drivers\\chromedriver.exe";
			WebDriver driver;
			
			public static void ATUTestRecorderException() throws atu.testrecorder.exceptions.ATUTestRecorderException {
				 ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop","myrecording",false);
			}
			
			@BeforeTest
			public  void extentreport()
			{
				extent = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReport\\report.html",true);
				//extent=new ExtentReports(".\\ExtentReport\\report.html",true);
			
			}
			@BeforeMethod
			public  void before(Method method)
			{
				test = extent.startTest((this.getClass().getSimpleName()+ " :: " + method.getName()));
				test.assignAuthor("Author is: Shivani");
				test.assignCategory("Category is : Smoke");
			}
			
			@AfterSuite
			public void endReport(){
				extent.flush();
				
				
			}
			long starttime = System.currentTimeMillis();	
			
	public void launch() throws InterruptedException {

		
		switch(config("browser")) {
		
		case"chrome":
			
			System.setProperty(config("chromedrivername"), config("chromedriverpath"));
			
			driver = new ChromeDriver();
			break;
			
		}
		
		driver.get(config("URL"));
		driver.manage().window().maximize();
		String acttitle = driver.getTitle();
		
		String exptitle= "Prudential-Thai";
		if (acttitle.contains(exptitle)) {

			test.log(LogStatus.PASS,"actual logo is matched with "  +acttitle+  " expected title of webpage is "+exptitle);
			
			test.log(LogStatus.INFO, "URL launched successfully");
			
		}
		else {
			test.log(LogStatus.FAIL, "actual logo is matched with" +acttitle+ " expected logo of webpage is "+exptitle+" "+Library.capturescreenshot1(driver, "Launch failed"));
	}
		
	}
	
	//public void Login(String Username,String Password) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{
		//loginCreateApp(0);
		
	public void Login() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{	
		
		/* ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Login",false);
		 recorder.start();*/
	
		//long starttime = System.currentTimeMillis(); 
		Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(By.xpath("(//div)[11]"))).click().perform();
		//Login.EnglishOptn(driver).click();
		//Thread.sleep(1000);
		//Login.UsernameTB(driver).sendKeys(config("UN"));
		driver.findElement(By.xpath("//input[@placeholder='Please enter user name']")).sendKeys("UOB100133");
	    //driver.findElement(By.xpath("//input[@placeholder='Please enter user name']")).sendKeys(Username);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Please enter password']")).sendKeys("Welcome@1");
	    //driver.findElement(By.xpath("//input[@placeholder='Please enter password']")).sendKeys(Password);
	     //Thread.sleep(2000);
	     
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(9000);
		String acttext = driver.findElement(By.xpath("//div[text()='Prudential Thailand ePOS']")).getText();
		String exptext= "Prudential Thailand ePOS";
		long endTime = System.currentTimeMillis();
		Long diffValue = endTime - starttime;
		test.log(LogStatus.INFO,"LoginTime : "+ diffValue);
		if (acttext.contains(exptext)) {
			test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
			test.log(LogStatus.INFO, "Login success");
			
		}
		else {
			
			test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Login failed"));
		}
		//recorder.stop();
		}
	
//		boolean status = false;
//		int counter = 0;
//		while (counter!=20) {
//			try {
//				status = validateLogin();
//				break;
//			}catch (Exception e) {
//				Thread.sleep(200);
//				counter =+1;
//			}
//		}
		//Login.login_btn(driver).click();
		/*String acttext = driver.findElement(By.xpath("//span[text()='Sign in']")).getText();
		String exptext= "Sign in";*/
		/*long endTime = System.currentTimeMillis();
		Long diffValue = endTime - starttime;
		test.log(LogStatus.INFO,"LoginTime : "+ diffValue);*/
		/*if (acttext.contains(exptext)) {
			test.log(LogStatus.PASS,"actual text is matched with "+acttext+  " expected text of webpage is "+exptext);
			test.log(LogStatus.INFO, "login is success");
		}
		else {
			test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Login is failed"));
		}*/
	
	//recorder.stop();



	
	public boolean validateLogin() throws Exception {
		boolean status = false;
		String identifier = driver.findElement(By.xpath("//div[@class='rightBox___27-ZU']")).getText();
		String eval= "Sign Off";
		
		if (identifier.contains(eval)) {
			test.log(LogStatus.PASS,"Login Pass");//  +acttitle+  "expected text of webpage is "+exptitle);
			status = true;
		}else {
			test.log(LogStatus.FAIL,"Login Failed");
			throw new Exception();
		}
		return status;
	}
	
	
	public void HomePage() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{
		/* ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","HomePage",false);
		 recorder.start();*/
		long starttime = System.currentTimeMillis(); 
		Thread.sleep(4000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='quotation___2d5W9']")).click();
		String acttext = driver.findElement(By.xpath("//a[@class='gohome___2LcQM']")).getText();
		String exptext="Home";
		long endTime = System.currentTimeMillis();
		Long diffValue = endTime - starttime;
		test.log(LogStatus.INFO,"HomePage : "+ diffValue);
		if (acttext.contains(exptext)) {
			test.log(LogStatus.PASS, "äctual text is matched with " +acttext+ " expected text of webpage is "+exptext);
			test.log(LogStatus.INFO, "Home Page success");
			
		}
		else {
			
			test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Home page failed"));
	}
		//recorder.stop();
	}
	
	
		/*homePageCreateApp(0);
		}
		
			
			
		
	private void homePageCreateApp(int counterRetry) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException {
		 ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","HomePage",false);
			 recorder.start();
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);*/
			
			//				Thread.sleep(4000);
			/*JavascriptExecutor jse1 =(JavascriptExecutor)driver;
				jse1.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			 r.keyPress(KeyEvent.VK_PAGE_DOWN);
				r.keyRelease(KeyEvent.VK_PAGE_DOWN);
Thread.sleep(3000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("(//li)[13]"))).click().perform();

			//HomePage.New(driver).click();
			//driver.findElement(By.xpath("(//li)[13]")).click();
			//					Thread.sleep(4000);
		}catch(Exception e){
			test.log(LogStatus.FAIL, "HomePage load fail");
			if(counterRetry > 3) {
				Thread.sleep(3000);
			}
			homePageCreateApp(counterRetry--);
		}
	}*/
			//recorder.stop();

	//public void OICQuestionnaire(String Age,String Marriage_status,String Number_of_children,String education,String occupation,String Do_you_need_this_money_for_daily_life, String Because) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException {
	public void OICQuestionnaire(String DOB,String Marriage_status ,String Number_of_children ,String education,String occupation,String Do_you_need_this_money_for_daily_life, String Because) throws Exception{
		/* ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","OICQuestionnaire",false);
		 recorder.start();*/
		long starttime = System.currentTimeMillis();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//li[@class='ant-select-dropdown-menu-item ant-select-dropdown-menu-item-selected'])[1]")).click();
		/*Select dropdown = new Select(driver.findElement(By.xpath("(//div[@class='ant-select-selection-selected-value'])[1]")));
		dropdown.selectByVisibleText(Age);*/
		
		//driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[1]"));
		
		driver.findElement(By.xpath("//input[@class='ant-calendar-picker-input ant-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys(DOB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='ant-calendar-date'])[16]")).click();
		Thread.sleep(2000);
		Generic.dropdown_handle(By.xpath("(//div[text()='Please Select'])[2]"), By.xpath("/html/body/div[3]/div/div/div/ul/li[2]"), Marriage_status);
		Thread.sleep(2000);
		//Generic.dropdown_handle(By.xpath("(//div[text()='Please Select'])[1]"), By.xpath("(//ul)[5]/li"), age);
		  
		 /* WebElement age = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[1]"));
		//Select age = new Select(driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[1]")));
		  Generic.dropdown_handle(driver, age);*/
		  //driver.findElement(By.xpath("(//li[@class='ant-select-dropdown-menu-item ant-select-dropdown-menu-item-selected'])[1]")).click();
		//Generic.dp_handle(age, Age);
	
		/*Thread.sleep(2000);
		Select dropdown1 = new Select(driver.findElement(By.xpath("(//div[@class='ant-select-selection-selected-value'])[2]")));
		dropdown1.selectByVisibleText(Marriage_status);*/
		
		/*WebElement MarStatus = driver.findElement(By.xpath("(//span)[19]"));
		Generic.dropdown_handle(driver, MarStatus);
		Thread.sleep(2000);
		WebElement noOfchild = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[3]"));
		Generic.dropdown_handle(driver, noOfchild);
		Thread.sleep(3000);
		WebElement edu = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[4]"));
		Generic.dropdown_handle(driver, edu);
		Thread.sleep(2000);
		 WebElement occup = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[5]"));
		Generic.dropdown_handle(driver, occup);
		Thread.sleep(2000);
		WebElement DYN = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[6]"));
		Generic.dropdown_handle(driver, DYN);*/
		/*Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='Please Enter']")).sendKeys("xyz");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[@class='ant-radio-button-wrapper'])[2]")).click();
		Thread.sleep(2000);
		//jse1.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("(//input)[3]")).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		String acttext=driver.findElement(By.xpath("(//span[text()='Personal Information'])[2]")).getText();
		String exptext= "Personal Information";
		long endTime = System.currentTimeMillis();
		Long diffValue = endTime - starttime;
		test.log(LogStatus.INFO,"OIC_Questionnaire : "+ diffValue);
		if (acttext.contains(exptext)) {

			test.log(LogStatus.PASS,"actual text is matched with "  +acttext+  " expected text of webpage is "+exptext);
			
			test.log(LogStatus.INFO, "OICQuestionnaire successful");
			
		}
		else {
			test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "OICQuestionnaire failed"));
		}*/
		}
		//recorder.stop();
	
			
	
	//public void Quotation_PI(String Title, String Given_name, String Family_name, String Occupation) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	public void Quotation_PI() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{	
	long starttime = System.currentTimeMillis();
	 ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Quotation_PI",false);
	 recorder.start();
		
		Thread.sleep(4000);
	   WebElement title = driver.findElement(By.xpath("(//span)[15]"));
	   //Generic.dp_handle(title, Title);
		//WebElement TaxRate = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[2]"));
		
		
		//Generic.dropdown_handle(driver, title);
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("(//input[@type='input'])[1]")).sendKeys("Kazuhiro");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='input'])[2]")).sendKeys("Kubota");
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@class='ant-calendar-picker-input ant-input']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("05-10-2000");
		 //driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("08-01-2522");
		 Thread.sleep(2000);
		 //driver.findElement(By.xpath("(//div[@class='ant-calendar-date'])[5]")).click();
		 driver.findElement(By.xpath("(//div[@class='ant-calendar-date'])[9]")).click();
		 Thread.sleep(2000);
		 
		 //WebElement table = driver.findElement(By.xpath(" //div[@class='ant-calendar-body']"));
		 
       //  WebElement date = table.findElement(By.xpath(" (//div[@class='ant-calendar-date'])[4]"));
		 
		 //driver.findElement(By.xpath("//td[@title='October 5, 2018']")).click();
		 Thread.sleep(4000);
		/*for (WebElement cell : column) {
			if (cell.getText().equals(date)) {
				cell.click();
				break;
				
			}
			
		}*/
		/* boolean flag=false;
			while(true)
			{
				driver.findElement(By.xpath("(//a)[3]")).click();
				String year = driver.findElement(By.xpath("(//a)[6]")).getText();
				Thread.sleep(4000);
				if (year.contains("1990")) {
					WebElement table = driver.findElement(By.xpath("(//div)[109]"));
					List<WebElement> rows = table.findElements(By.tagName("tr"));
					for (WebElement r : rows) {
						List<WebElement> columns = r.findElements(By.tagName("td"));
						for (WebElement c : columns) {
							String text = c.getText();
							if (text.contains("4")) {
								c.click();
								flag= true;
								break;
							}*/
		/* Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("(//input)[7]"))).click().perform();*/
							driver.findElement(By.xpath("(//input)[7]")).click();
							Thread.sleep(4000);
							//driver.findElement(By.xpath("(//input)[10]")).sendKeys("Office employee / Administrative staff");
							
							//Thread.sleep(2000);
							
							//driver.findElement(By.xpath("(//input[@placeholder='Please enter'])[1]")).sendKeys("Child under school age");
							
							driver.findElement(By.xpath("(//span)[51]")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//input[@type='input'])[4]")).sendKeys("20000000");
							Thread.sleep(2000);
							driver.findElement(By.xpath("(//button)[2]")).click();
							Thread.sleep(3000);
							String acttext=driver.findElement(By.xpath("//div[@class='commonHeaderTitle___2jNYh']")).getText();
							String exptext= "Payor Details";
							long endTime = System.currentTimeMillis();
							Long diffValue = endTime - starttime;
							test.log(LogStatus.INFO,"Quotation_PI : "+ diffValue);
							if (acttext.contains(exptext)) {

								test.log(LogStatus.PASS,"actual text is matched with "  +acttext+  " expected text of webpage is "+exptext);
								
								test.log(LogStatus.INFO, "Quotation_PI successful");
								
							}
							else {
								test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Quotation_PI failed"));
							recorder.stop();
						}
	}
				
			
		
				
		 
	

	
		//private void Select() {
		// TODO Auto-generated method stub
		
	

		/*	driver.findElement(By.xpath("//input[@placeholder='Please enter annual income']")).sendKeys("2000000");
			Thread.sleep(2000);
			Generic.dropdown_handle(driver, TaxRate);
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys("shivani@accoliteindia.com");
			Thread.sleep(2000);*/
			

	
			
		//public void Quotation_PayorDetails(String Title, String Given_Name, String Family_Name) throws InterruptedException, AWTException, atu.testrecorder.exceptions.ATUTestRecorderException{
		public void Quotation_PayorDetails() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{	
		long starttime = System.currentTimeMillis();
			 ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Quotation_PayorDetails",false);
			 recorder.start();
		
			Thread.sleep(4000);
	
		/*WebElement TitleTB= driver.findElement(By.xpath("//div[@unselectable='on']"));
		Generic.dropdown_handle(driver, TitleTB);
		Thread.sleep(4000);
		driver.findElement(By.id("givenName")).sendKeys("Kazuhiro");
		Thread.sleep(2000);
		driver.findElement(By.id("familyName")).sendKeys("Kubota");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label)[6]")).click();
		driver.findElement(By.xpath("//input[@class='ant-calendar-picker-input ant-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("10-10-1990");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='10'])[1]")).click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input)[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span)[45]")).click();
		Thread.sleep(2000);*/
		driver.findElement(By.xpath("(//button)[2]")).click();
		Thread.sleep(4000);
		String acttext=driver.findElement(By.xpath("//div[text()='Quotation']")).getText();
		String exptext= "Quotation";
		long endTime = System.currentTimeMillis();
		Long diffValue = endTime - starttime;
		test.log(LogStatus.INFO,"Quotation_PayorDetails : "+ diffValue);
		if (acttext.contains(exptext)) {

			test.log(LogStatus.PASS,"actual text is matched with "  +acttext+  " expected text of webpage is "+exptext);
			
			test.log(LogStatus.INFO, "Quotation_PayorDetails successful");
			
		}
		else {
			test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Quotation_PayorDetails failed"));
	}
		recorder.stop();
	
		}
		
			public void InsurancePlan() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
				long starttime = System.currentTimeMillis();
				ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","InsurancePlan",false);
				 recorder.start();
				Thread.sleep(3000);
			//	WebElement PaymentMode = driver.findElement(By.xpath("//div[@class='ant-select-selection__rendered']"));
				
				/*Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("(//span)[14]"))).click().perform();*/
				driver.findElement(By.xpath("//button[@class='ant-btn addMainPlanBtn___cANZp ant-btn-primary ant-btn-background-ghost']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input)[1]")).click();
				Thread.sleep(5000);
				/*JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/
				driver.findElement(By.xpath("(//button)[6]")).click();
				//Generic.dropdown_handle(driver, PaymentMode);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("250000");
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button)[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button)[2]")).click();
				Thread.sleep(9000);
				driver.findElement(By.xpath("(//button)[6]")).click();
				//Thread.sleep(2000);
				String acttext= driver.findElement(By.xpath("(//div[@class='commonHeaderTitle___2jNYh'])[1]")).getText();
				String exptext= "PERSONAL INFORMATION";
				long endTime = System.currentTimeMillis();
				Long diffValue = endTime - starttime;
				test.log(LogStatus.INFO,"InsurancePlan : "+ diffValue);
				if (acttext.contains(exptext)) {

					test.log(LogStatus.PASS,"actual text is matched with "  +acttext+  " expected text of webpage is "+exptext);
					
					test.log(LogStatus.INFO, "InsurancePlan successful");
					
				}
				else {
					test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "InsurancePlan failed"));
			}
				recorder.stop();
				
			}
			
		//public void MorePI(String Marital_status,String Nationality,String Country_of_Birth,String ID_Type,int ID_Number,int number,String Address, int Mobilephone,String House_Registration_Address, String Working_Address, String Policy_Mailing_Address,String Mailing_Address,String duty, int Annual_Income) throws InterruptedException{
			public void MorePI() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","MorePI",false);
			 recorder.start();
			Thread.sleep(7000);
			WebElement marstatus = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[3]"));
			//Generic.dropdown_handle(driver, marstatus);
			Thread.sleep(2000);
			WebElement Nationality = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[5]"));
			//Generic.dropdown_handle(driver, Nationality);
			Thread.sleep(2000);
			WebElement COB = driver.findElement(By.xpath("(//span)[51]"));
		//	Generic.dropdown_handle(driver, COB);
			Thread.sleep(2000);
			WebElement IDtype = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[7]"));
			//Generic.dropdown_handle(driver, IDtype);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Passport Number']")).sendKeys("@#$%^^&**())))))))");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Select date'])[2]")).click();
			driver.findElement(By.xpath("//input[@class='ant-calendar-input ']")).sendKeys("16-10-2019");
			driver.findElement(By.xpath("(//div[@class='ant-calendar-date'])[18]")).click();
			driver.findElement(By.xpath("(//span)[62]")).click();
			driver.findElement(By.id("currentAddressNumber")).sendKeys("107");
		   Thread.sleep(3000);
			WebElement Address = driver.findElement(By.xpath("//span[@class='ant-cascader-picker-label']"));
			//Generic.dropdown_handle(driver, Address);
			Actions act = new Actions(driver);
			//act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.RIGHT).perform();
			act.sendKeys(Keys.RIGHT).perform();
			act.sendKeys(Keys.RIGHT).perform();
		    driver.findElement(By.xpath("//li[@class='ant-cascader-menu-item']")).click();
		   driver.findElement(By.xpath("//input[@placeholder='Please enter mobile phone']")).sendKeys("0838124266");
			WebElement HoseRegAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[9]"));
		//	Generic.dropdown_handle(driver, HoseRegAdd);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter number'])[2]")).sendKeys("123");
			Thread.sleep(2000);
			WebElement country = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[10]"));
		//	Generic.dropdown_handle(driver, country);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//textarea[@placeholder='Please enter address']")).sendKeys("xyz");
			Thread.sleep(2000);
			WebElement WorkAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[11]"));
			//Generic.dropdown_handle(driver, WorkAdd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter number'])[3]")).sendKeys("765");
			WebElement country1 = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[12]"));
		//	Generic.dropdown_handle(driver, country1);
			driver.findElement(By.xpath("(//textarea[@placeholder='Please enter address'])[2]")).sendKeys("dfgh");
			WebElement PolMailAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[13]"));
		//	Generic.dropdown_handle(driver, PolMailAdd);
			Thread.sleep(2000);
			WebElement MailAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[14]"));
		//	Generic.dropdown_handle(driver, MailAdd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter duty']")).sendKeys("sdfghj");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button)[2]")).click();
			
			/*WebElement Add = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[9]"));
			Generic.dropdown_handle(driver, Add);*/
			/*driver.findElement(By.xpath("//textarea[@placeholder='Please enter address']")).sendKeys("abc007");
			Thread.sleep(3000);
			WebElement WorkAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[10]"));
			Generic.dropdown_handle(driver, WorkAdd);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter number'])[3]")).sendKeys("987");
			WebElement country = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[11]"));
			Generic.dropdown_handle(driver, country);
			driver.findElement(By.xpath("(//textarea[@placeholder='Please enter address'])[2]")).sendKeys("007");
			
			WebElement PolMailAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[12]"));
			Generic.dropdown_handle(driver, PolMailAdd);
			WebElement MailAdd = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[13]"));
			Generic.dropdown_handle(driver, MailAdd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter annual income']")).sendKeys("20000000");
			WebElement FatherTitle = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[15]"));
			Generic.dropdown_handle(driver, FatherTitle);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter given name'])[3]")).sendKeys("S");
			driver.findElement(By.xpath("(//input[@placeholder='Please enter family name'])[3]")).sendKeys("SS");
			WebElement MotherTitle = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[16]"));
			Generic.dropdown_handle(driver, MotherTitle);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter given name'])[4]")).sendKeys("PS");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter family name'])[4]")).sendKeys("SSS");
			Thread.sleep(1000);*/
			//driver.findElement(By.xpath("(//button)[2]")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("(//div[@class='commonHeaderTitle___2jNYh'])[1]")).getText();
			String exptext= "PAYOR DETAILS";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"Application_PI : "+ diffValue);
			if (acttext.contains(exptext)) {

				test.log(LogStatus.PASS,"actual text is matched with "  +acttext+  " expected text of webpage is "+exptext);
				
				test.log(LogStatus.INFO, "Application_PI successful");
				
			}
			else {
				test.log(LogStatus.FAIL, "actual text is matched with" +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Application_PI failed"));
		}
			recorder.stop();
		}
				

		//public void MorePayorInfo(String Relatonship,String Nationality,String AddressType, int MobilePhone, String Occupation, String Duty ) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			public void MorePayorInfo() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","MorePayorInfo",false);
			 recorder.start();
			Thread.sleep(7000);
			driver.findElement(By.xpath("(//span)[21]")).click();
			WebElement Relation = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[1]"));
			//Generic.dropdown_handle(driver, Relation);
			Thread.sleep(4000);
			WebElement Nation_Payor = driver.findElement(By.xpath("(//div[text()='Please select'])[3]"));
		//	Generic.dropdown_handle(driver, Nation_Payor);
			Thread.sleep(2000);
			WebElement addtype = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[4]"));
		//	Generic.dropdown_handle(driver, addtype);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter number']")).sendKeys("103");
			Thread.sleep(2000);
			WebElement country = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[5]"));
		//	Generic.dropdown_handle(driver, country);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//textarea[@placeholder='Please enter address']")).sendKeys("fghj");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter mobile phone']")).sendKeys("0838124266");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter duty']")).sendKeys("fghj");
			Thread.sleep(2000);
			WebElement Consent_title = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[6]"));
			//Generic.dropdown_handle(driver, Consent_title);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter given name'])[2]")).sendKeys("sssssss");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter family name'])[2]")).sendKeys("kkkkkk");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button)[2]")).click();
			/*WebElement COB_Payor = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[5]"));
			Generic.dropdown_handle(driver, COB_Payor);
			WebElement ID_type = driver.findElement(By.xpath("(//span)[48]"));
			Generic.dropdown_handle(driver, ID_type);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Passport Number']")).sendKeys("@#$%^&");
			driver.findElement(By.xpath("(//span[@class='ant-calendar-picker-icon'])[2]")).click();
			driver.findElement(By.xpath("(//input[@class='ant-calendar-input '])")).sendKeys("15-11-2019");
			driver.findElement(By.xpath("(//div[@class='ant-calendar-date'])[20]")).click();
			driver.findElement(By.xpath("(//label[@class='ant-radio-button-wrapper'])[1]")).click();
			WebElement AddType = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[7]"));
			Generic.dropdown_handle(driver, AddType);
			driver.findElement(By.xpath("//input[@placeholder='Please enter number']")).sendKeys("890");
			WebElement country = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[8]"));
			Generic.dropdown_handle(driver, country);
			driver.findElement(By.id("currentAddressDetail")).sendKeys("abc123");
			driver.findElement(By.xpath("//input[@placeholder='Please enter mobile phone']")).sendKeys("0838124266");
			driver.findElement(By.xpath("//input[@placeholder='Please enter annual income']")).sendKeys("99999999");
			Thread.sleep(2000);
			WebElement Consent_title = driver.findElement(By.xpath("(//span[@class='ant-select-arrow'])[10]"));
			Generic.dropdown_handle(driver, Consent_title);
			driver.findElement(By.xpath("(//input[@placeholder='Please enter given name'])[2]")).sendKeys("sssssss");
			driver.findElement(By.xpath("(//input[@placeholder='Please enter family name'])[2]")).sendKeys("kkkkkk");*/
			//driver.findElement(By.xpath("(//button)[2]")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("//div[@class='commonHeaderTitle___2jNYh']")).getText();
			String exptext= "Beneficiary";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"Application_Payor : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "Application_Payor successful");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with" +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Application_Payor failed"));
			}
			recorder.stop();
		}
		
		public void Beneficiary() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Beneficiary",false);
			 recorder.start();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("isPayor")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter ratio']")).sendKeys("100");
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//button)[3]")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("//div[text()='Application']")).getText();
			String exptext= "Application";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"Beneficiary : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "Beneficiary successful");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with" +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Beneficiary failed"));
			}
			recorder.stop();
			}
		
			public void Lifestyle() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
				long starttime = System.currentTimeMillis();
				ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Lifestyle",false);
				 recorder.start();	
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[22]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[30]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[38]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[46]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[57]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[68]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[76]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please Enter'])[1]")).sendKeys("155");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@placeholder='Please Enter'])[2]")).sendKeys("70");
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//label)[21]")).click();
			/*Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Enter Weight']")).sendKeys("3175");*/
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button)[2]")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("(//h3)[1]")).getText();
			String exptext = "Confirmation on status and statement of consent on information disclosure about U.S. Indicia under Foreign Account Tax Complaince Act (FATCA)";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"Lifestyle : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "Lifestyle Successfull");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Lifestyle failed"));
			}
			recorder.stop();
			}
			
			public void FATCA() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
				long starttime = System.currentTimeMillis();
				ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","FATCA",false);
				 recorder.start();
				Thread.sleep(4000);
				driver.findElement(By.xpath("(//span)[22]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//span)[29]")).click();
				Thread.sleep(4000);
				driver.findElement(By.xpath("(//span)[38]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class='ant-btn nextBtn ant-btn-primary']")).click();
				Thread.sleep(2000);
				String acttext= driver.findElement(By.xpath("(//p)[1]")).getText();
				String exptext = "Are you Politically Exposed Persons (PEPs) or related domestic or international PEPs?";
				long endTime = System.currentTimeMillis();
				Long diffValue = endTime - starttime;
				test.log(LogStatus.INFO,"FATCA : "+ diffValue);
				if (acttext.contains(exptext)) {
					test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
					test.log(LogStatus.INFO, "FATCA successful");
					
				}
				else {
					
					test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "FATCA failed"));
				}
				recorder.stop();
				}
				
			
			
		public void KYC() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","KYC",false);
			 recorder.start();
			Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[@class='ant-radio-button-wrapper'])[2]")).click();
		Thread.sleep(2000);
		WebElement Obj = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[1]"));
			//Generic.dropdown_handle(driver, Obj);
			Thread.sleep(2000);
			WebElement MajOcc = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[2]"));
		//	Generic.dropdown_handle(driver, MajOcc);
			Thread.sleep(2000);
			WebElement CurrAnnIncome = driver.findElement(By.xpath("(//div[@class='ant-select-selection__placeholder'])[3]"));
			//Generic.dropdown_handle(driver, CurrAnnIncome);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//span)[38]")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//button)[3]")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("(//span)[15]")).getText();
			String exptext= "UOB Information";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"KYC : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "KYC successful");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "KYC failed"));
			}
			recorder.stop();
			}
		
		public void UOB_Info() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","UOB_Info",false);
			 recorder.start();
			Thread.sleep(4000);
			WebElement branchCode = driver.findElement(By.xpath("//div[@class='ant-select-selection__rendered']"));
		//	Generic.dropdown_handle(driver, branchCode);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Refer Staff Code 1']")).sendKeys("00700707");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Refer Staff Name 1']")).sendKeys("sssss");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Refer Staff Code 2']")).sendKeys("00100101");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@placeholder='Please enter Refer Staff Name 2']")).sendKeys("abc");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='ant-btn nextBtn___1YHOF ant-btn-primary']")).click();
			Thread.sleep(2000);
			String acttext= driver.findElement(By.xpath("//div[@class='wrapper___xFAtG']")).getText();
			String exptext= "Application";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"UOB : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "UOB successful");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "UOB failed"));
			}
			recorder.stop();
		}
		
		public void Payment_Info() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
			long starttime = System.currentTimeMillis();
			ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Payment_Info",false);
			 recorder.start();
			Thread.sleep(2000);
			WebElement PayMethod = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[1]"));
		//	Generic.dropdown_handle(driver, PayMethod);
			Thread.sleep(2000);
			WebElement DiviOption = driver.findElement(By.xpath("(//div[@class='ant-select-selection__rendered'])[2]"));
		//	Generic.dropdown_handle(driver, DiviOption);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='ant-btn nextBtn___8f5LI ant-btn-primary']")).click();
			Thread.sleep(9000);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
			Thread.sleep(6000);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
			Thread.sleep(4000);
			String acttext= driver.findElement(By.xpath("(//span)[15]")).getText();
			String exptext = "Document";
			long endTime = System.currentTimeMillis();
			Long diffValue = endTime - starttime;
			test.log(LogStatus.INFO,"Payment_Info : "+ diffValue);
			if (acttext.contains(exptext)) {
				test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
				test.log(LogStatus.INFO, "Payment_Info successful");
				
			}
			else {
				
				test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Payment_Info failed"));
			}
			recorder.stop();
			}
		
	
			
			public void Documents() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
				long starttime = System.currentTimeMillis();
				ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\shivani\\Desktop\\ScriptVideos","Documents",false);
				 recorder.start();
				Thread.sleep(4000);
				driver.findElement(By.xpath("(//button[@class='ant-btn signBtn___t5pgB ant-btn-default'])[2]")).click();
				Thread.sleep(4000);
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath("(//div)[257]"))).click().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-primary'])[1]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//button[@class='ant-btn signBtn___t5pgB ant-btn-default'])[3]")).click();
				Thread.sleep(4000);
				WebElement witness = driver.findElement(By.xpath("//div[@class='ant-select-selection__placeholder']"));
			//	Generic.dropdown_handle(driver, witness);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter given name']")).sendKeys("poi");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@placeholder='Please enter family name']")).sendKeys("loi");
				Thread.sleep(4000);
				act.moveToElement(driver.findElement(By.xpath("//div[@class='signature-pad--body___1KLlF']"))).click().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-primary'])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@class='ant-btn signBtn___t5pgB ant-btn-default'])[2]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
				Thread.sleep(2000);
				act.moveToElement(driver.findElement(By.xpath("//div[@class='signature-pad--body___1KLlF']"))).click().perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button)[39]")).click();
				//driver.findElement(By.xpath("(//span)[72]")).click();
				Thread.sleep(2000);
				//driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-primary'])[1]")).click();
				//driver.findElement(By.xpath("//button[@class='ant-btn nextBtn___BsbX0 ant-btn-primary']")).click();
				String acttext= driver.findElement(By.xpath("(//span)[15]")).getText();
				String exptext = "Document";
				long endTime = System.currentTimeMillis();
				Long diffValue = endTime - starttime;
				test.log(LogStatus.INFO,"Documents : "+ diffValue);
				if (acttext.contains(exptext)) {
					test.log(LogStatus.PASS, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext);
					test.log(LogStatus.INFO, "Successfully directed to document page");
					
				}
				else {
					
					test.log(LogStatus.FAIL, "actual text is matched with " +acttext+ " expected text of webpage is "+exptext+" "+Library.capturescreenshot1(driver, "Unable to traverse to document page"));
				}
				recorder.stop();
				}
				
				
			
	
			public Object[][] excelcontent(String filename,String sheetname)
			{
				Excel_class.excelconnection(filename, sheetname);
				int rc = Excel_class.rcount();
				int cc = Excel_class.ccount();
				String [][] data = new String [rc-1][cc];
				for(int r=1;r<rc;r++)
				{
					for(int c =0;c<cc;c++)
					{
						data[r-1][c]=Excel_class.readData(c, r);
					}
				}
				return data;
			}
			
				
				
				
			}
	

