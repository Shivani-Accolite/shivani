package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class HomePage extends Base {

	public static WebElement New (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("New")));
		return user;
	}
	

		public static WebElement History (WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 80);
			WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("History")));
			return user;
		}
		
		
}
