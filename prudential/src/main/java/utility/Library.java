package utility;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import org.openqa.selenium.WebDriver;

public class Library {

	public static String capturescreenshot1(WebDriver driver, String Snapshotname) {
		
		try {
			
			Robot r = new Robot();
			r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		 return Snapshotname;
	}
}
