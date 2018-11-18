package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Quotation_PayorDetails extends Base {

	public static WebElement TitleTB(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("TitleTB")));
		return user;
	}

	public static WebElement GivenName(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("GivenName")));
		return user;
	}
	
	public static WebElement FamilyName(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("FamilyName")));
		return user;
	}
	
	public static WebElement Gender(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Gender")));
		return user;
	}
	
	public static WebElement DOB(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("DOB")));
		return user;
	}
	
	public static WebElement Occupation(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Occupation")));
		return user;
	}
	
	
	public static WebElement EmailAdd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("EmailAdd")));
		return user;
	}
	
}
