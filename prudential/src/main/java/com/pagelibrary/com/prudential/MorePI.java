package com.pagelibrary.com.prudential;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class MorePI extends Base {

	public static WebElement MarStatus(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("MarStatus")));
		return user;
	}
	
	public static WebElement Nationality(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Nationality")));
		return user;
	}
	
	public static WebElement COB(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("COB")));
		return user;
	}
	
	public static WebElement IDtype(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("IDtype")));
		return user;
	}
	
	public static WebElement Address(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("Address")));
		return user;
	}
	
	public static WebElement HoseRegAdd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("HoseRegAdd")));
		return user;
	}
	
	public static WebElement WorkAdd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("WorkAdd")));
		return user;
	}
	
	public static WebElement PolMailAdd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("PolMailAdd")));
		return user;
	}
	
	public static WebElement MailAdd(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("MailAdd")));
		return user;
	}
	
	
	public static WebElement MaritalStatus(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(getlocators("MaritalStatus")));
		return user;
	}
}
