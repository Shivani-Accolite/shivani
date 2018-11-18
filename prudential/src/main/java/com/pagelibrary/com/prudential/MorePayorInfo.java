package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class MorePayorInfo extends Base {
	
	public static WebElement MarStatus(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("MarStatus")));
		return user;
	}
	
	public static WebElement Relationship(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Relationship")));
		return user;
	}
	
	public static WebElement Nationality_Payor(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Nationality_Payor")));
		return user;
	}

}
