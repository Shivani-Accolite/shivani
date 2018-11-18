package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class Login extends Base {
	
	public static WebElement UsernameTB (WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("UsernameTB")));
		return user;
	}
	
public static WebElement EnglishOptn (WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("EnglishOptn")));
		return user;
	}
	
public static WebElement pwdTB (WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("pwdTB")));
		return user;
	}

public static WebElement login_btn (WebDriver driver) {
	
	WebDriverWait wait = new WebDriverWait(driver, 80);
	WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("login_btn")));
	return user;
}
}
