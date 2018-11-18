package com.pagelibrary.com.prudential;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.Base;

public class Generic extends Base {

	public static void dropdown_handle(By prop,By option,String data) {

		Actions a = new Actions(driver);
		
		  WebElement optionage= driver.findElement(prop);

		  a.moveToElement(optionage).click().perform();
		  
		 List<WebElement> options= driver.findElements(option);
		 
		 for(WebElement op:options)
		 {
			 String x=op.getText();
			 System.out.println(x);
			 
			 if(x.contains(data))
			 {
				 op.click();
				 break;
			 }
		 }
		/*a.moveToElement(e).click(e).perform();
		sleep();
		a.sendKeys(Keys.DOWN).perform();
		sleep();
		a.sendKeys(Keys.ENTER).perform();*/

		 //
		// 
		// "20-40 year old"
		 // 
	}
	
	public static void dropdown_handle(WebDriver driver, WebElement e, String value) {

		Actions a = new Actions(driver);

		a.moveToElement(e).click(e).perform();
		sleep();
		a.sendKeys(Keys.DOWN).perform();
		sleep();
		a.sendKeys(Keys.ENTER).perform();

	}

	public static void sleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static boolean flag = false;

	public static void DOB(WebDriver driver, WebElement ele, String expdate) {

		WebElement table = ele;
		List<WebElement> rows = table.findElements(By.tagName("div"));
		for (WebElement r : rows) {
			List<WebElement> columns = r.findElements(By.tagName("div"));

			for (WebElement c : rows) {

				if (c.getText().contains(expdate)) {
					c.click();
					flag = true;
					break;

				}
			}
			if (flag == true) {

				break;
			}
		}

	}

	public static void dp_handle(Select age, String exp) {

		Select s = new Select((WebElement) age);
		List<WebElement> options = s.getOptions();
		for (WebElement op : options) {
			String text = op.getText();
			if (text.contains(exp)) {
				s.selectByVisibleText(exp);
				break;
			}
		}
	}
}
