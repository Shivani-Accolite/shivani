package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class OICQuestionnaire extends Base {

	public static WebElement OICQuestionnaireText (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("OICQuestionnaireText")));
		return user;
	}
	
	public static WebElement Age_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Age_TB")));
		return user;
	}
	
	public static WebElement MarriageStatus_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("MarriageStatus_TB")));
		return user;
	}
	
	public static WebElement NoOfChildren_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("NoOfChildren_TB")));
		return user;
	}
	
	public static WebElement Education_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Education_TB")));
		return user;
	}
	
	public static WebElement Occupation_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Occupation_TB")));
		return user;
	}
	
	public static WebElement DoYNeedMoney_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("DoYNeedMoney_TB")));
		return user;
	}
	
	public static WebElement Because_TB (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Because_TB")));
		return user;
	}
	
	public static WebElement insuranceOptnBtn (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("insuranceOptnBtn")));
		return user;
	}
	
	public static WebElement checkBox (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("checkBox")));
		return user;
	}
	
	public static WebElement Next (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Next")));
		return user;
	}
	
}
