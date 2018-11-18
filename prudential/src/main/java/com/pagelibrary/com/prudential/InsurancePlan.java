package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class InsurancePlan extends Base {

	public static WebElement AddPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("AddPlan")));
		return user;
	}
	
	public static WebElement SelectPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("SelectPlan")));
		return user;
	}
	
	public static WebElement OkBtn(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("OkBtn")));
		return user;
	}
	
	public static WebElement AddRider(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("AddRider")));
		return user;
	}
	
	public static WebElement RiderCheckBox(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("RiderCheckBox")));
		return user;
	}
	
	public static WebElement Okbtn_AddRider(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Okbtn_AddRider")));
		return user;
	}
	
	public static WebElement PaymentMode(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("PaymentMode")));
		return user;
	}
	
	public static WebElement SumAssured(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("SumAssured")));
		return user;
	}
	
	public static WebElement BenefitIllustration(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("BenefitIllustration")));
		return user;
	}

	public static Actions nextQuotation(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("nextQuotation")));
		return null;
	
	}
	
}
