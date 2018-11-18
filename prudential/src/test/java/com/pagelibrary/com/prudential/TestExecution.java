package com.pagelibrary.com.prudential;

import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestExecution extends Repository {
	
	@Test(priority=0)
	public void valid_launch() throws InterruptedException {
		launch();
	}

	@Test(priority=1)
	public void verify_login() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException {
		Login();
	}
	/*@Test(priority=1 ,dataProvider="Login")
	public void verify_Login(String Username,String Password) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException
	{
		Login(Username,Password);
	}
	@DataProvider(name="Login")
	public Object[][] verify_excel_Login()
	{
		return excelcontent("TestData.xls", "sh1");
	}*/

	@Test(priority=2)
	public void verify_HomePage() throws InterruptedException, AWTException, atu.testrecorder.exceptions.ATUTestRecorderException{
		HomePage(); 
	}
	
	@Test(priority= 3,dataProvider="OICQuestionnaire")
	public void verify_OICQuestionnaire(String DOB,String Marriage_status ,String Number_of_children ,String education,String occupation,String Do_you_need_this_money_for_daily_life, String Because) throws Exception
	{
		OICQuestionnaire(DOB,Marriage_status,Number_of_children,education,occupation,Do_you_need_this_money_for_daily_life, Because);
	}
	@DataProvider(name="OICQuestionnaire") 
	public Object[][] verify_excel_OICQuestionnaire()
	{
		return excelcontent("TestData.xls", "sh2");
	}

/*	
   @Test(priority=3)
    public void verify_OICQuestionnaire() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{
    	OICQuestionnaire();
	}
   
   @Test(priority=4)
   public void verify_Quotation_PI() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{
	   Quotation_PI();
   }
   
   @Test(priority=5)
   public void verify_Quotation_PayorDetails() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException, AWTException{
	   Quotation_PayorDetails();
   }*/
   
	   
 /*  @Test(priority=4, dataProvider="Quotation_PI")
    public void verify_Quotation_PI(String Title, String Given_name, String Family_name, String Occupation) throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException
	  {
	   Quotation_PI(Title,Given_name,Family_name,Occupation);
	  }
   @DataProvider(name="Quotation_PI") 
   public Object[][] verify_excel_Quotation_PI()
	{
		return excelcontent("TestData.xls", "sh3");
	}*/
    	
	
    
  /*  @Test(priority=5, dataProvider="Quotation_PayorDetails")
    public void verify_Quotation_PayorDetails(String Title, String Given_Name, String Family_Name) throws InterruptedException, AWTException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	Quotation_PayorDetails(Title,Given_Name,Family_Name);
	}
    @DataProvider(name="Quotation_PayorDetails") 
    public Object[][] verify_excel_Quotation_PayorDetails()
 	{
 		return excelcontent("TestData.xls", "sh4");
 	}*/
    
 /*   @Test(priority=6)
    public void verify_InsurancePlan() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	InsurancePlan();
    }
    
    @Test(priority=7)
    public void verify_MorePI() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	MorePI();
    }
    
    @Test(priority=8)
    public void verify_MorePayorInfo() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	MorePayorInfo();
    }*/
/*
    @Test(priority=7, dataProvider="MorePI")
    public void verify_MorePI(String Marital_status,String Nationality,String Country_of_Birth,String ID_Type,int ID_Number,int number,String Address, int Mobilephone,String House_Registration_Address, String Working_Address, String Policy_Mailing_Address,String Mailing_Address,String duty, int Annual_Income) throws InterruptedException{
    	MorePI(Marital_status,Nationality,Country_of_Birth,ID_Type,ID_Number,number,Address,Mobilephone,House_Registration_Address,Working_Address,Policy_Mailing_Address,Mailing_Address,duty,Annual_Income);
    }
    @DataProvider(name="MorePI") 
    public Object[][] verify_excel_MorePI()
 	{
 		return excelcontent("TestData.xls", "sh5");
 	}
    @Test(priority=8, dataProvider="MorePayorInfo")
    public void verify_MorePayorInfo(String Relatonship,String Nationality,String AddressType, int MobilePhone, String Occupation, String Duty) throws InterruptedException{
    	MorePayorInfo(Relatonship,Nationality,Nationality,MobilePhone,Occupation,Duty);
    }
    @DataProvider(name="MorePayorInfo") 
    public Object[][] verify_excel_MorePayorInfo()
 	{
 		return excelcontent("TestData.xls", "sh6");
 	}
    */
  /*  @Test(priority=9)
    public void verify_Beneficiary() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	Beneficiary();
    }
    
    @Test(priority=10)
    public void verify_Lifestyle() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
    	Lifestyle();
    }
    
   @Test(priority=11)
    public void verify_FATCA() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	 FATCA();	
   }
 
   @Test(priority=12)
   public void verify_KYC() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	 KYC();
	}
   
   @Test(priority=13)
   public void verify_UOB_Info() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	   UOB_Info();
   }
   
   @Test(priority=14)
   public void verify_Payment_Info() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	   Payment_Info();
   }
   
   @Test(priority=15)
   public void verify_Documents() throws InterruptedException, atu.testrecorder.exceptions.ATUTestRecorderException{
	   Documents();
   }*/
}


	
	
   


